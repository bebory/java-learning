package 第二题;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

 public class MyShape extends JPanel{                  //继承JPanel
	int x1,x2,y1,y2;                 //坐标
	public MyShape()
	{
		x1=1;
		y1=1;
		x2=2;
		y2=2;
	}
	public MyShape(int x_1,int y_1, int x_2, int y_2)     //初始化
	{
		x1=x_1;
		y1=y_1;
		x2=x_2;
		y2=y_2;
	}
	public void setPosition(int x_1,int y_1, int x_2, int y_2)
	{
		x1=x_1;
		y1=y_1;
		x2=x_2;
		y2=y_2;
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Random R = new Random();
		setBackground(Color.WHITE);
		Color MYCOLOR = new Color(R.nextInt(256),R.nextInt(256),R.nextInt(256));
		g.setColor(MYCOLOR);
		setPosition(R.nextInt(200),R.nextInt(200),R.nextInt(400),R.nextInt(400));
	}
	public void draw()
	{
         JFrame application=new JFrame();
		application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
		application.add(this);
		application.setSize(600,600);
		application.setVisible(true);
	}

}
