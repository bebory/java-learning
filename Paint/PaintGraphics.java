package Paint;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.AncestorListener;

public class PaintGraphics extends JFrame //implements ActionListener, AncestorListener
{
	 public static void main(String[] args) {
	        new PaintGraphics();
	    }
	 JButton clear=new JButton("Clear");
	Choice c=new Choice();
	JFrame land=new JFrame();
	String type="Oval";
	int x1=1,x2=1,y1=100,y2=100;                           //Êó±êµÄ×ø±ê
	MyPanel p=new MyPanel();
	boolean press=false;
	public PaintGraphics()
	{
		c.add("Oval");
		c.add("Line");
		c.add("Rect");
		p.setSize(800, 700);
		p.setLayout(null);
		p.setBackground(Color.WHITE);
		
		land.setLayout(null);
		land.setTitle("»­Í¼");
		land.setLocation(100, 0);
		c.setBounds(100, 0, 60, 30);
		p.add(c);
		clear.setBounds(400, 0, 200, 30);
		p.add(clear);
	//	JPanel a=new JPanel();
		//a.setSize(800, 700);
		//land.add(a);
		land.add(p);
		land.setVisible(true);
	    land.setSize(800, 700);
	    land.setBackground(Color.WHITE);
	    land.setResizable(false);
	    land.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	    
	    event();
	}
	public void event()
	{
		clear.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				p.p.clear();
				p.repaint();
			}});
		c.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				type=(String) e.getItem();
			//	System.out.println(type);
			}});
		
		p.addMouseMotionListener(new MouseMotionListener(){

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				if(press)
				{
					int x3=e.getX();
					int y3=e.getY();
					p.settemp(x1, y1, x3, y3,type);
					p.repaint();
				}
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
			}});
		p.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				x1=e.getX();
				y1=e.getY();
				press=true;
				p.temp.type=type;
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				x2=e.getX();
				y2=e.getY();
				press=false;
				p.set(x1, y1, x2, y2, type);
				p.settemp(x1, y1, x2, y2, "n");
				p.repaint();
				
			//	land.add(p);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}});
	}
}
