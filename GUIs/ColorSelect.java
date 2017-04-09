package GUIs;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Choice;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ColorSelect {
	Choice c=new Choice();
	Checkbox back=new Checkbox("BackGround");
	Checkbox fore=new Checkbox("ForeGround");
	JButton ok=new JButton("    OK    ");
	JButton cancel=new JButton("Cancel");
	public ColorSelect()
	{
		c.add("RED");
		c.add("BLUE");
		c.add("YELLOW");
		c.add("GREEN");
		c.add("BLACK");
		c.add("ORANGE");
		JPanel b=new JPanel();
		b.add(back);
		b.add(fore);
		JPanel d=new JPanel();
		d.add(ok);
		d.add(cancel);
		
		JFrame a=new JFrame();
		a.setTitle("ColorSelect");
		a.setLocation(500, 200);
		a.setLayout(new BorderLayout());
		a.add(c,BorderLayout.NORTH);
		a.add(b,BorderLayout.CENTER);
		a.add(d,BorderLayout.SOUTH);
		a.setVisible(true);
		a.setSize(300, 150);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ColorSelect();

	}

}
