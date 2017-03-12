import javax.swing.JFrame;
public class drawTest {
	public static void main(String[] args)
	{
		draw panel=new draw();
		JFrame application = new JFrame();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.add(panel);
		application.setSize(650, 650);
		application.setVisible(true);
	}

}
