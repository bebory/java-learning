package GUIs;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Align extends JFrame{
	JPanel one=new JPanel();
	JPanel two=new JPanel();
	JPanel three=new JPanel();
	Checkbox snap=new Checkbox("Snap to Crid");
	Checkbox show=new Checkbox("Show Crid");
	JLabel x = new JLabel("x:  ");
	JLabel y = new JLabel("y:  ");
	JTextField first = new JTextField(5);
	JTextField second= new JTextField(5);
	JButton ok=new JButton("    OK    ");
	JButton cancel=new JButton("Cancel");
	JButton help=new JButton("  Help   ");
	public Align()
	{
		one.setLayout(new FlowLayout());
		
		two.setLayout(new FlowLayout());
		three.setLayout(new FlowLayout());
		three.setSize(100, 50);
		
		one.add(snap);
		one.add(show);
		one.setSize(100, 50);
		two.add(x);
		two.add(first);
		two.add(y);
		two.add(second);
		three.add(ok);
		three.add(cancel);
		three.add(help);
		
		JFrame a=new JFrame();
		a.setTitle("Align");
		a.setLocation(500, 200);
		a.setLayout(new GridLayout());
		a.add(one);//,BorderLayout.WEST);
		a.add(two);//,BorderLayout.CENTER);
		a.add(three);//,BorderLayout.EAST);
		a.setVisible(true);
		a.setSize(300, 150);
	}
	public static void main(String[] args)
	{
		new Align();
	}

}
