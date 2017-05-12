package Notepad;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditEvent;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.Document;
import javax.swing.undo.UndoManager;

public class NotePad implements ActionListener {
	JFrame app=new JFrame();                    //主框架
	
	JMenu file=new JMenu("File");               //菜单区
	JMenu edit=new JMenu("Edit");
	JMenu format=new JMenu("Format");
	JMenu check=new JMenu("Check");
	JMenu help=new JMenu("Help");           
	JMenuBar menu=new JMenuBar();                //菜单条
	JPopupMenu pop=new JPopupMenu();             //弹出菜单
	
	UndoManager undo=null;
	Document doc = null;
	JTextArea textZone=new JTextArea(70,70);         //文本区	
	JScrollPane jsp=new JScrollPane(textZone);       //滚动条
	
	String copy;
	
	int count=1;                       //查找第几个
	String s="";                          //查找框里的内容
	String direction="up";
	boolean caseSen=false;              //记录状态    
	    
	boolean copyed=false;
	boolean autoLinefeed=false;                     //是否自动换行
	Font font=new Font("宋体",Font.PLAIN,24);         //字体
	
	JPanel state=new JPanel();                  //状态区
	boolean if_state=true;
	JLabel row_column=new JLabel("Position:               " + "   row of " +  '1'+ "   ,   "    +   "   column of " +   '1');
	
	boolean saved=true;                        //文本是否被保存
	File currentFile=null;                     //当前打开的文件
	String filename="f";
		
	public NotePad()
	{
		undo = new UndoManager(){
			   private static final long serialVersionUID = -5960092671497318496L;
			   public void undoableEditHappened(UndoableEditEvent e) {
			   this.addEdit(e.getEdit());
			   }
			   };
		doc = textZone.getDocument();
		doc.addUndoableEditListener(undo);                                                //撤销监听
		
		//设置框
		app.setSize(800, 700);                    //设置JFrame
		app.setLocation(300, 0);
		app.setLayout(new BorderLayout());		
		app.setTitle("NotePad");
		app.setBackground(Color.white);		
		app.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				
		JMenuItem item;
		JCheckBoxMenuItem cbitem;
		
		//文件菜单
		file.add(item=new JMenuItem("New(N)..."));  item.addActionListener(this);
		item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
		file.add(item=new JMenuItem("Open(O)..."));  item.addActionListener(this);
		item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.CTRL_MASK));
		file.add(item=new JMenuItem("Save(s)"));  item.addActionListener(this);
		item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
		file.add(item=new JMenuItem("SaveAs(A)..."));  item.addActionListener(this);
		item.setMnemonic(KeyEvent.VK_A);
		
		file.addSeparator();
		file.add(item=new JMenuItem("PageSet(U)..."));  item.addActionListener(this);
		item.setMnemonic(KeyEvent.VK_U);
		file.add(item=new JMenuItem("Print(P)..."));  item.addActionListener(this);
		item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.CTRL_MASK));
		file.addSeparator();
		file.add(item=new JMenuItem("Quit(X)"));  item.addActionListener(this);
		item.setMnemonic(KeyEvent.VK_X);
		
		//编辑菜单
		edit.add(item=new JMenuItem("Revoke(U)"));  item.addActionListener(this);
		item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,ActionEvent.CTRL_MASK));
		edit.addSeparator();
		edit.add(item=new JMenuItem("Shear(T)"));  item.addActionListener(this);
		item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));
		edit.add(item=new JMenuItem("Copy(C)"));  item.addActionListener(this);
		item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
		edit.add(item=new JMenuItem("Paste(P)"));  item.addActionListener(this);
		item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,ActionEvent.CTRL_MASK));
		edit.add(item=new JMenuItem("Delete(L)"));  item.addActionListener(this);
		item.setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_DELETE,0));
		edit.addSeparator();
		
		edit.add(item=new JMenuItem("Find(F)..."));  item.addActionListener(this);
		item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F,ActionEvent.CTRL_MASK));
		edit.add(item=new JMenuItem("FindNext(N)"));  item.addActionListener(this);
		item.setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_F3,0));
		edit.add(item=new JMenuItem("Replace(R)..."));  item.addActionListener(this);
		item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H,ActionEvent.CTRL_MASK));
		edit.add(item=new JMenuItem("GoTo(G)..."));  item.addActionListener(this);
		item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,ActionEvent.CTRL_MASK));
		edit.addSeparator();
		edit.add(item=new JMenuItem("SelectAll(A)"));     item.addActionListener(this);
		item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));
		edit.add(item=new JMenuItem("Time/Date(D)"));     item.addActionListener(this);
		item.setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_F5,0));
		
		
		//格式菜单
		format.add(cbitem=new JCheckBoxMenuItem("AutoLinefeed(W)"));  cbitem.addActionListener(this);
		cbitem.setMnemonic(KeyEvent.VK_W);
		format.add(item=new JMenuItem("Font(F)"));  item.addActionListener(this);
		item.setMnemonic(KeyEvent.VK_F);
		format.add(item=new JMenuItem("Color(C)"));  item.addActionListener(this);
		item.setMnemonic(KeyEvent.VK_C);
		
		//查看菜单
		cbitem=new JCheckBoxMenuItem("state(S)");
		check.add(cbitem);    cbitem.addActionListener(this);
		item.setMnemonic(KeyEvent.VK_S);
		
		//帮助菜单
		help.add(item=new JMenuItem("About(A)"));   item.addActionListener(this);
		item.setMnemonic(KeyEvent.VK_A);
		help.add(item=new JMenuItem("Help(H)"));    item.addActionListener(this);	
		item.setMnemonic(KeyEvent.VK_H);
		
		menu.add(file);
		menu.add(edit);
		menu.add(format);
		menu.add(check);
		menu.add(help);	
		app.setJMenuBar(menu);
		
		//右击事件
		pop.add(item=new JMenuItem("Revoke(U)"));     item.addActionListener(this);
		item.setMnemonic(KeyEvent.VK_U);
		pop.addSeparator();
		pop.add(item=new JMenuItem("Shear(T)"));     item.addActionListener(this);
		item.setMnemonic(KeyEvent.VK_T);
		pop.add(item=new JMenuItem("Copy(C)"));     item.addActionListener(this);
		item.setMnemonic(KeyEvent.VK_C);
		pop.add(item=new JMenuItem("Paste(P)"));     item.addActionListener(this);
		item.setMnemonic(KeyEvent.VK_P);
		pop.add(item=new JMenuItem("Delete(D)"));     item.addActionListener(this);
		item.setMnemonic(KeyEvent.VK_D);
		pop.addSeparator();
		pop.add(item=new JMenuItem("SelectAll(A)"));     item.addActionListener(this);
		item.setMnemonic(KeyEvent.VK_A);
		textZone.setComponentPopupMenu(pop);
		textZone.setFont(font);
		
		jsp.setViewportView(textZone);
		app.add(jsp,BorderLayout.CENTER);						
		
		app.setVisible(true);
		
		event();
	}
	public void event()
	{
		 textZone.addCaretListener(new   CaretListener() 
         { 
             public   void   caretUpdate(CaretEvent   e) 
             { 
                 try 
                 { 
                       int   pos   =   textZone.getCaretPosition(); 
                         //获取行数 
                       int   lineOfC   =   textZone.getLineOfOffset(pos)   +   1; 
                         //获取列数 
                       int   col   =   pos   -   textZone.getLineStartOffset(lineOfC   -   1)   +   1; 
                       row_column.setText( "Position:               " + "   row of " +  lineOfC+ "   ,   "    +   "   column of " +   col ); 
                   } 
                   catch(Exception   ex) 
                   { 
                	   row_column.setText( "             fail to get the position "); 
                   } 
                 app.setVisible(true);
             } 
         }); 
		 textZone.getDocument().addDocumentListener(new DocumentListener(){
	            public void changedUpdate(DocumentEvent arg0) {
	                saved=false;
	            }
	            public void insertUpdate(DocumentEvent arg0) {
	                saved=false;
	            }
	            public void removeUpdate(DocumentEvent arg0) {
	                saved=false;
	            }	             
	        });
		 app.addWindowListener(new WindowAdapter(){                          //点退出窗口时弹出选项
			 public void windowClosing(WindowEvent e) {
			 if(askSave()==0)
	                return;
	         else
	                System.exit(0);
			 }});
	}
	//event end
	
	@Override
	public void actionPerformed(ActionEvent e) {                      //菜单事件
	
		String command=e.getActionCommand();
		System.out.println(command);
		
		//文件
		 if(command.equals("New(N)..."))
		 {
			 if(!saved) askSave();
			 textZone.setText("");
		 }
		 if(command.equals("Open(O)...")){//open...
	            if(askSave()==0){
	                return;
	            }
	            JFileChooser jfc=new JFileChooser();
	            jfc.setFileFilter(new FileNameExtensionFilter("文本文档(*.txt)","txt"));
	            jfc.showOpenDialog(app);
	            File f=jfc.getSelectedFile();
	            if(f!=null){
	                openFile(f);
	                currentFile=f;
	            }
	            return;
	        }
		 if(command.equals("Save(s)"))
		 {
			 save();
		 }
		 if(command.equals("SaveAs(A)..."))
		 {
			 saveAs();
		 }
		 if(command.equals("Quit(X)")){//Quit 
	            if(askSave()==0)
	                return;
	            else
	                System.exit(0);
	        }
		 
		 
		 //编辑
		 if(command.equals("Revoke(U)"))
		 {
			 undo.undo();
		 }
		 if(command.equals("Shear(T)"))
		 {
			 textZone.cut();
//			 int starte=textZone.getSelectionStart();          //拷贝完选定的部分，再把选定的部分去掉
//			 int end=textZone.getSelectionEnd();
//			 System.out.println(starte);
//			 System.out.println(end);
//			 String temp=textZone.getText();
//			 String s=temp.replace(temp.substring(starte, end), "");
//			 textZone.setText(s);
		 }
		 if(command.equals("Copy(C)"))
		 {
			 textZone.copy();
		 }
		 if(command.equals("Paste(P)"))
		 {
			 textZone.paste();
		 }
		 if(command.equals("Delete(D)"))
		 {
			 int starte=textZone.getSelectionStart();          //拷贝完选定的部分，再把选定的部分去掉
			 int end=textZone.getSelectionEnd();
			 String temp=textZone.getText();
			 String s=temp.replace(temp.substring(starte, end), "");
			 textZone.setText(s);
		 }
		 if(command.equals("Find(F)..."))
		 {
//			    String direction="up";
//			    boolean caseSen;
				new Find();
		 }
		 if(command.equals("FindNext(N)"))
		 {
			 if(s.equals("")){ JOptionPane.showMessageDialog(null,
						"Input content！", "404", JOptionPane.PLAIN_MESSAGE);return ;}
			 String text=textZone.getText();
			 if(!caseSen) {s=s.toLowerCase(); text=text.toLowerCase();}
				
				if(!text.matches(".*"+s+".*")) {JOptionPane.showMessageDialog(null,
						"Not Found！", "404", JOptionPane.PLAIN_MESSAGE);count=1;return;}
				
						        	 		        		
	        	int i=0;                                          //位置
	        	try{
	        		if(direction.equals("up")) count-=2;
	        		if(count<1)
	        		{
		        		JOptionPane.showMessageDialog(null,
								"Not Found！", "404", JOptionPane.PLAIN_MESSAGE);
		        		count=1;
		        		return;
		        	}
     			 Pattern pattern = Pattern.compile(s); 
	        		 Matcher findMatcher = pattern.matcher(text);  
	        	     int number = 0;  
	        	     while(findMatcher.find()) {  
	        	            number++;  
	        	           if(number == count){
	        	              break;  
	        	           }  
	        	        }  
     	        i = findMatcher.start();
	        		       		   	        
	        		 textZone.setSelectionStart(i);  //setCaretPosition(i+1);
	        		 textZone.setSelectionEnd(i+s.length());
	        		 count++;
	        	}
	        	catch(Exception e1)
	        	{
	        		JOptionPane.showMessageDialog(null,
							"Not Found！", "404", JOptionPane.PLAIN_MESSAGE);
	        		count=1;
	        		return;
	        	}
		 }
		 if(command.equals("Replace(R)..."))
		 {
			 new Replace();
		 }
		 if(command.equals("GoTo(G)..."))                                        //匹配"\n"
		 {
			 
			 int totalLineCount = textZone.getLineCount();
			 if(totalLineCount <= 1){
			 return ;
			 }		 		 
//			 Object[] options = {"GoTo", "Cancel"};
			 String s="";
	         s=JOptionPane.showInputDialog("Row Number: ");
	         if(!s.equals(""))
	         {
	        	
	        	 try
				 {
	        		 int intLine=Integer.parseInt(s);
	        		 if(intLine> totalLineCount){
	        			 return;
	        			 }
	        		//JTextArea起始行号是0，所以此处做减一处理
	        		 int selectionStart = textZone.getLineStartOffset(intLine-1);
//	        		 int selectionEnd = textZone.getLineEndOffset(intLine-1);
	        		 //如果是不是最后一行，selectionEnd做减一处理，是为了使光标与选中行在同一行
//	        		 if(intLine != totalLineCount){
//	        		 selectionEnd--;
//	        		 }
	        		  textZone.requestFocus(); //获得焦点
	        		  textZone.setSelectionStart(selectionStart);
	        		  textZone.setSelectionEnd(selectionStart);
	        		 	        		 
//	        		 int i=-1;
	        		 
//	        		 if(rowNum>1)
//	        		 {
//	        			 Pattern pattern = Pattern.compile("\n"); 
//		        		 Matcher findMatcher = pattern.matcher(textZone.getText());  
//		        	     int number = 0;  
//		        	     while(findMatcher.find()) {  
//		        	            number++;  
//		        	           if(number == rowNum-1){//当“A”第二次出现时停止  
//		        	              break;  
//		        	           }  
//		        	        }  
//		        	        i = findMatcher.start();//“A”第二次出现的位置
//	        		 }	        		   	        
//	        		 textZone.setCaretPosition(i+1);
				 }
	        	 catch(Exception e1)
	        	 {
//	        		 e1.printStackTrace();
	        	 }
	         }
		 }
		 
		 if(command.equals("SelectAll(A)"))
		 {
			 textZone.selectAll();
		 }
		 if(command.equals("Time/Date(D)"))
		 {			 
			 Calendar now = Calendar.getInstance();
			 String s=textZone.getText()+" "+now.getTime();
			 textZone.setText(s);
		 }
		 
		 //格式
		 if(command.equals("AutoLinefeed(W)"))
		 {
			 if(!autoLinefeed)
			 {
				 autoLinefeed=true;
				 textZone.setLineWrap(true);        //激活自动换行功能 
				 textZone.setWrapStyleWord(true);            // 激活断行不断字功能
			 }
			 else
			 {
				 autoLinefeed=false;
				 textZone.setLineWrap(false);        //激活自动换行功能 
				 textZone.setWrapStyleWord(false);            // 激活断行不断字功能
			 }
		 }
		 if(command.equals("Font(F)"))
		 {
			 MQFontChooser fontChooser = new MQFontChooser(textZone.getFont()); 
			 int returnValue = fontChooser.showFontDialog(app);  
             // 如果按下的是确定按钮  
             if (returnValue == MQFontChooser.APPROVE_OPTION) {  
                 // 获取选择的字体  
                 font = fontChooser.getSelectFont();  
                 // 将字体设置到JTextArea中  
                 textZone.setFont(font);  
             }  
		 }
		 if(command.equals("Color(C)"))
		 {
			 Color c=JColorChooser.showDialog(null,"请选择文字颜色",Color.BLACK);
	         textZone.setForeground(c);
	         return;
		 }
		 
		 //查看
		if(command.equals("state(S)")&&if_state) 
			{			
			state.add(row_column);
			app.add(state,BorderLayout.SOUTH);
			}
		if(command.equals("state(S)")&&!if_state) app.remove(state);
		if(command.equals("state(S)")) if_state=!if_state;
		
		//帮助
		if(command.equals("Help(H)"))   JOptionPane.showMessageDialog(null,
				"\n                       版权归作者所有\n                   如有侵权，不胜荣幸！", "Help", JOptionPane.PLAIN_MESSAGE);
		if(command.equals("About(A)"))   JOptionPane.showMessageDialog(null,
				"@author: Johnny zhou\n@Version:  1.0\n@ReleaseTime:  2017.5.10", "About", JOptionPane.PLAIN_MESSAGE);
		app.setVisible(true);
	}
	
	public void openFile(File f){                             //打开文件
        FileReader fr=null;
        BufferedReader br=null;
        textZone.setText("");
        try {
            fr=new FileReader(f);
            br=new BufferedReader(fr);
            String str=null;
            while((str=br.readLine())!=null){
            	textZone.append(str+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally{
            try {
                Thread.sleep(200);
            } catch (InterruptedException e1) {
                 
            }
            saved=true;
            if(br!=null)try{br.close();}catch(IOException e){}
            if(fr!=null)try{fr.close();}catch(IOException e){}
        }
    }
	
	public void saveFile(File f){                                    //保存到相应的文件
        FileWriter fw=null;
        try {
            fw=new FileWriter(f);
            String text=textZone.getText();
            String[] texts=text.split("\n");
            for(String s:texts)
            { 
            	fw.write(s+"\r\n");          	
            	fw.flush();
            	} 
//            fw.flush();
            saved=true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally{
            if(fw!=null)try {fw.close();} catch (IOException e) {}
        }
    }
	
	/**
     * 该方法在执行退出操作时或打开新文件时询问用户是否保存现有文件。
     * 该方法会判断当前文件内容是否改变后未保存，
     * 若是，则弹出询问对话框。
     * @return
     */
	public int askSave(){                                              //是否保存
        if(!saved ){//如果没有保存
        	Object[] options = {"Save", "Not Save", "Cancel" };
            int choice=JOptionPane.showOptionDialog(null,"Save File?","Prompt？",JOptionPane.PLAIN_MESSAGE,
                        JOptionPane.YES_NO_CANCEL_OPTION, null,options,options[0]);
            switch(choice){
                case JOptionPane.OK_OPTION : //要求保存文件
                           save();
                           return 1;
                case JOptionPane.NO_OPTION : return 1;//不保存文件
                case JOptionPane.CANCEL_OPTION : return 0;//取消
            }
        }
        return -1;
    }   
	public void save()                              //保存文件
	{
		if(currentFile==null)//如果是新建文件            
			saveAs();      
        else//如果是打开的旧文件
            saveFile(currentFile);      
	}
	public void saveAs()
	{
		JFileChooser jfc=new JFileChooser();
        jfc.setFileFilter(new FileNameExtensionFilter("文本文档(*.txt)","txt"));
        jfc.showSaveDialog(app);
        File f=jfc.getSelectedFile();
        String fname = jfc.getName(f);   //从文件名输入框中获取文件名  
        
        //假如用户填写的文件名不带我们制定的后缀名，那么我们给它添上后缀  
        if(!fname.endsWith(".txt")){  
            f=new File(jfc.getCurrentDirectory(),fname+".txt");   
        }  
        if(f!=null){
            saveFile(f);
            currentFile=f; 
        }
	}
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException
	{
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		new NotePad();
	}
	
	public class Find {
//		String s;
		JLabel findContent=new JLabel("          The Content:");
		JTextField content=new JTextField(14);
		JLabel direct=new JLabel("Direction");
		JCheckBox caseSense=new JCheckBox("Case sensitive");
		JRadioButton up=new JRadioButton("up");
	    JRadioButton down=new JRadioButton("down");
	    ButtonGroup bgroup=new ButtonGroup();
		JButton findNext=new JButton("Find the next");
		JButton cancel=new JButton("Cancel");
		
		JFrame find=new JFrame();
		JPanel fir=new JPanel();
		JPanel sec=new JPanel();
		JPanel thi=new JPanel();
		
//		String direction="up";
//		boolean caseSen=false;              //记录状态
//		int count=1;                       //查找第几个
//		String s="";                          //查找框里的内容
		public Find()
		{
			fir.setLayout(new FlowLayout());
			fir.add(findContent);
			fir.add(caseSense);
			
			sec.setLayout(new FlowLayout()); //GridLayout(2,1)
			sec.add(content);
			bgroup.add(up);
			bgroup.add(down);
			sec.add(up);
			sec.add(down);
			
			thi.setLayout(new FlowLayout());
			thi.add(findNext);
			thi.add(cancel);

			find.setTitle("Find");	
			find.setSize(400, 100);
			find.setLayout(new GridLayout());
			find.setLocation(300, 200);
			find.add(fir);
			find.add(sec);
			find.add(thi);
			find.setBackground(Color.WHITE);
			find.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			find.setVisible(true);
			event();
			}
		public void event()
		{
			caseSense.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if(caseSen) caseSen=false;
					else caseSen=true;
					return;
				}});
			up.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					direction="up";
					return;
				}});
			down.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					direction="down";
					return;
				}});
			findNext.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					String temp=content.getText();
					if(!s.equals(temp))                                //查找值改变时从新开始找
					{
						s=temp;
						count=1;
					}
					if(s.equals("")) return;
					
					String text=textZone.getText();					
					if(!caseSen) {s=s.toLowerCase(); text=text.toLowerCase();}
					
//					if(!text.matches(".*"+s+".*")) {JOptionPane.showMessageDialog(null,             //有个bug，有换行时匹配不到。。。。醉醉的，不过不影响
//							"Not Found！", "404", JOptionPane.PLAIN_MESSAGE);count=1;return;}        //没找到
					
							        	 		        		
		        	int i=0;                                                              //位置
		        	try{
		        		if(direction.equals("up")) count-=2;
		        		if(count<1)
		        		{
			        		JOptionPane.showMessageDialog(null,
									"Not Found！", "404", JOptionPane.PLAIN_MESSAGE);
			        		count=1;
			        		return;
			        	}
	        			 Pattern pattern = Pattern.compile(s); 
		        		 Matcher findMatcher = pattern.matcher(text);  
		        	     int number = 0;  
		        	     while(findMatcher.find()) {  
		        	            number++;  
		        	           if(number == count) break;  		        	          
		        	        }  
	        	        i = findMatcher.start();
		        		       		   	        
		        		 textZone.setSelectionStart(i);  //setCaretPosition(i+1);
		        		 textZone.setSelectionEnd(i+s.length());
		        		 count++;
		        	}
		        	catch(Exception e1)
		        	{
		        		JOptionPane.showMessageDialog(null,
								"Not Found！", "404", JOptionPane.PLAIN_MESSAGE);
		        		count=1;
		        		return;
		        	}
				}});
			cancel.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					find.dispose();
				}});
		}

	}
	public class Replace
	{
		JLabel checkContent=new JLabel("CheckContent");
		JTextField check= new JTextField(6);
		JLabel replaceTo=new JLabel("ReplaceTo   ");
		JTextField replace= new JTextField(6);
		JCheckBox caseSense=new JCheckBox("Case sensitive");
		JButton ok=new JButton("OK");
		JButton cancel=new JButton("Cancel");
		
		JFrame re=new JFrame();
		JPanel left=new JPanel();
		JPanel right=new JPanel();
		JPanel fir=new JPanel();
		JPanel sec=new JPanel();
		JPanel thi=new JPanel();
		
		String old="";
		String news="";
		boolean sense=false;
		public Replace()
		{
			fir.add(checkContent);
			fir.add(check);
			sec.add(replaceTo);
			sec.add(replace);
			thi.add(caseSense);
			
			left.setLayout(new GridLayout(3,1));
			left.add(fir);
			left.add(sec);
			left.add(thi);
			
			right.setLayout(new FlowLayout());
			right.add(ok);
			right.add(cancel);
						
			re.setTitle("Replace");	
			re.setSize(350, 120);
			re.setLayout(new GridLayout());
			re.setLocation(300, 200);
			re.add(left);
			re.add(right);
			re.setBackground(Color.WHITE);
			re.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			re.setVisible(true);
			event();
		}
		public void event()
		{
			caseSense.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					sense=!sense;
				}});
			ok.addActionListener(new  ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					old=check.getText();
					if(old.equals("")) {JOptionPane.showMessageDialog(null,
							"checkBox should't be empty!", "404", JOptionPane.PLAIN_MESSAGE);count=1;return;}					
					news=replace.getText();
					String source=textZone.getText();
					String result;
					if(sense)
					{
						Matcher m1 = Pattern.compile(old, Pattern.CANON_EQ).matcher(source);   
						  
					   result=m1.replaceAll(news); 
					}
					else
					{
						Matcher m = Pattern.compile(old, Pattern.CASE_INSENSITIVE).matcher(source);   
						  
						result=m.replaceAll(news);
					}
					textZone.setText(result);
				}});
			cancel.addActionListener(new  ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					re.dispose();
				}});
		}
	}
}
 
