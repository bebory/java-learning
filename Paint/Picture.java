package Paint;
import java.util.Random;
public class Picture {
	public int x1,x2,y1,y2;
	public String type="";
	int color1,color2,color3;
	public Picture()
	{
		Random ran=new Random();
		color1=ran.nextInt(256);
		color2=ran.nextInt(256);
		color2=ran.nextInt(256);
	}
}
