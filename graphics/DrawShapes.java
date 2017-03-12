package lab1;
import java.math.*;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

@SuppressWarnings("serial")
public class DrawShapes extends JPanel 
{
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);//璋冪敤鐖剁被鐨勬柟娉�
		
		setBackground(Color.WHITE);//鎶婅儗鏅壊璁句负鐧借壊
		
		Random R = new Random();
		for(int i=0;i<10;i++)
		{
			//浜х敓闅忔満鐨剅gb涓哄浘褰㈠～鍏呴鑹�
			int red = R.nextInt(256);
			int green = R.nextInt(256);
			int blue = R.nextInt(256);
			//闅忔満浜х敓鐨勫潗鏍囷紝鑼冨洿鍦╗100,400]
			int x = Math.abs(R.nextInt(100))+((i-1)%5)*100+100;
			int y = Math.abs(R.nextInt(100))+(i%2)*200;
			//闅忔満浜х敓鍐冲畾澶у皬鐨勯殢鏈烘暟锛岃寖鍥村湪[50,100]
			int w = R.nextInt(50)+50;
			int h = R.nextInt(50)+50;
			//1鐢绘き鍦嗭紝0鐢荤煩褰�
			int p = R.nextInt(2);
			
			Color MYCOLOR = new Color(red, green, blue);
			g.setColor(MYCOLOR);
			if(p==1)
			{
				g.fillOval(x, y, w, h);
			}
			else
				g.fillRect(x, y, w, h);
		}
	}
}
