package Paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Line2D;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.JPanel;

public class MyPanel extends JPanel{

	LinkedList<Picture> p=new LinkedList<Picture>();            //存储着画出的图形
	Picture temp=new Picture();                                             //暂时的
	public void set(int a,int b,int c,int d,String e)
	{
		Picture x=new Picture();
		x.x1=a;
		x.y1=b;
		x.x2=c;
		x.y2=d;
		x.type=e;
		p.add(x);                                              //加进去一个新的类
	}
	public void settemp(int a,int b,int c,int d,String e)
	{
		temp.x1=a;
		temp.y1=b;
		temp.x2=c;
		temp.y2=d;
		temp.type=e;
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Random R = new Random();
		setBackground(Color.WHITE);
		for(Picture each:p)
		{
			Color MYCOLOR = new Color(each.color1,each.color2,each.color3);
			g.setColor(MYCOLOR);
			if(each.type.equals("Oval")) g.fillOval(min(each.x1, each.x2),min(each.y1,each.y2), Math.abs(each.x1-each.x2), Math.abs(each.y1-each.y2));
			if(each.type.equals("Rect")) g.fillRect(min(each.x1, each.x2),min(each.y1,each.y2), Math.abs(each.x1-each.x2), Math.abs(each.y1-each.y2));
			if(each.type.equals("Line")) g.drawLine(each.x1, each.y1, each.x2,each.y2);
		}
		System.out.println(temp.type);
		Color MYCOLOR = new Color(temp.color1,temp.color2,temp.color3);
		g.setColor(MYCOLOR);
		if(temp.type.length()<2) return ;
		if(temp.type.equals("Oval")) g.fillOval(min(temp.x1, temp.x2),min(temp.y1,temp.y2), Math.abs(temp.x1-temp.x2), Math.abs(temp.y1-temp.y2));
		if(temp.type.equals("Rect")) g.fillRect(min(temp.x1, temp.x2),min(temp.y1,temp.y2), Math.abs(temp.x1-temp.x2), Math.abs(temp.y1-temp.y2));
		if(temp.type.equals("Line")) g.drawLine(temp.x1, temp.y1, temp.x2, temp.y2);//g.draw(new Line2D.Double(x1,y1,x2,y2));//
	}
	public int min(int a,int b)
	{
		if(a>b) return b;
		else return a;
	}
}
