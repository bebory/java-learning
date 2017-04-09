package GUIs;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator {
	JTextField input = new JTextField(18);
	JButton one=new JButton("1");
	JButton two=new JButton("2");
	JButton three=new JButton("3");
	JButton four=new JButton("4");
	JButton five=new JButton("5");
	JButton six=new JButton("6");
	JButton seven=new JButton("7");
	JButton eight=new JButton("8");
	JButton nine=new JButton("9");
	JButton zero=new JButton("0");
	JButton div=new JButton("/");
	JButton multi=new JButton("*");
	JButton ad=new JButton("+");
	JButton sub=new JButton("-");
	JButton dot=new JButton(" . ");
	JButton equ=new JButton("=");
	public Calculator()
	{
		JPanel x=new JPanel();
		x.add(input);
		x.setSize(200, 10);
		JFrame a=new JFrame();
		a.setTitle("Calculator");
		a.setLocation(500, 200);
		a.setLayout(new FlowLayout());
		a.add(x);//,BorderLayout.WEST);
		a.add(seven);
		a.add(eight);
		a.add(nine);
		a.add(div);
        a.add(four);
        a.add(five);
        a.add(six);
        a.add(multi);
        a.add(one);
        a.add(two);
		a.add(three);//,BorderLayout.CENTER);
		a.add(sub);
		a.add(zero);
		a.add(dot);
		a.add(equ);
		a.add(ad);
	//	a.add(three);//,BorderLayout.EAST);
		a.setVisible(true);
		a.setSize(220, 220);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Calculator();

	}

}
