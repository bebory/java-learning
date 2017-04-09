package GUIs;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextArea;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Printer {

	JLabel PM = new JLabel("Printer.MyPrinter");
	TextArea fir=new TextArea(1,1);
	TextArea sec=new TextArea(1,1);
	TextArea thi=new TextArea(1,1);
	Checkbox image=new Checkbox("image");
	Checkbox text=new Checkbox("Text");
	Checkbox code=new Checkbox("Code");
	CheckboxGroup cbg=new CheckboxGroup();
	Checkbox selection=new Checkbox("Selection",cbg,false);
	Checkbox all=new Checkbox("All",cbg,true);
	Checkbox applet=new Checkbox("Applet",cbg,false);
	JLabel PQ = new JLabel("Printer Quality:  ");
	Choice c=new Choice();
	Checkbox PtoF=new Checkbox("Print to File");
	
	JButton ok=new JButton("    OK    ");
	JButton cancel=new JButton("Cancel");
	JButton setup=new JButton("Setup...");
	JButton help=new JButton("  Help   ");
	public Printer()
	{
		JPanel ltop=new JPanel();
		ltop.setLayout(new FlowLayout());
		ltop.setSize(300, 20);
		ltop.add(PM);
		
		JPanel lcb=new JPanel();
		lcb.setLayout(new GridLayout(3,1));
		lcb.setSize(50, 100);
		lcb.add(image);
		lcb.add(text);
		lcb.add(code);
		
		JPanel lcbg=new JPanel();
		lcbg.setLayout(new GridLayout(3,1));
		lcbg.setSize(50, 100);
		lcbg.add(selection);
		lcbg.add(all);
		lcbg.add(applet);
		
		JPanel mid=new JPanel();
		mid.setLayout(new GridLayout());
		lcbg.setSize(300, 100);
		mid.add(fir);
		mid.add(lcb);
		mid.add(sec);
		mid.add(lcbg);
		mid.add(thi);
		
		c.add("High");
		c.add("Low");
		JPanel llow=new JPanel();
		llow.setLayout(new FlowLayout());
		llow.setSize(300, 20);
		llow.add(PQ);
		llow.add(c);
		llow.add(PtoF);
		
		JPanel left=new JPanel();
		left.setLayout(new GridLayout(3,1));
		left.setSize(300, 200);
		left.add(ltop);
		left.add(mid);
		left.add(llow);
		
		JPanel right=new JPanel();
		right.setLayout(new GridLayout(4,1));
		right.setSize(50, 200);
		JPanel one=new JPanel();
		one.setSize(50, 25);
		JPanel two=new JPanel();
		JPanel three=new JPanel();
		JPanel four=new JPanel();
		one.add(ok);
		two.add(cancel);
		three.add(setup);
		four.add(help);
		right.add(one);
		right.add(two);
		right.add(three);
		right.add(four);
		
		JFrame a=new JFrame();
		a.setTitle("Printer");
		a.setLocation(400, 200);
		a.setLayout(new FlowLayout());
		a.add(left);
		a.add(right);
		a.setVisible(true);
		a.setSize(500, 250);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Printer();
	}

}
