package µÚ¶şÌâ;

import java.awt.Graphics;

public class MyOval extends MyShape{
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.fillOval(x1, y1, x2, y2);
		
	}

}
