package µÚ¶şÌâ;

import java.awt.Graphics;

public class MyRect extends MyShape{
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.fillRect(x1, y1, x2, y2);
		
	}

}
