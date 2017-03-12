package lab1;

import lab1.DrawShapes;
import javax.swing.JFrame;

public class DrawShapesTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DrawShapes panel=new DrawShapes();
		JFrame application=new JFrame();
		
		application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
		application.add(panel);
		application.setSize(800,400);
		application.setVisible(true);
	}

}
