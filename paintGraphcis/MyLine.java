package 第二题;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;

public class MyLine extends MyShape{
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawLine(x1, y1, x2, y2);
		
	}
	

}
