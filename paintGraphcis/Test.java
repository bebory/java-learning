package µÚ¶şÌâ;
import java.util.Random;

import javax.swing.JFrame;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random ran=new Random();
		for(int i=0;i<20;++i)
		{
			int r=ran.nextInt(3);
			switch(r)
			{
			case 0:MyLine line=new MyLine();
			line.draw();break;
			case 1:MyOval oval=new MyOval();
			oval.draw();break;
			case 2: MyRect rect=new MyRect();
			rect.draw();
			}
		}
		
	}

}
