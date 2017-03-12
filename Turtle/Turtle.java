package 第一题;
import java.util.Scanner;
public class Turtle {
	int x=0,y=0;                                 //����
	static enum Pen{up,down};
	Pen pen=Pen.up;                              //��
	int[][] room=new int[20][20];                //����
	static enum dirct{up,down,left,right}; 
	dirct dirction=dirct.right;                  //����
	public void showstatue()
	{
		System.out.println("坐标:"+x+' '+y);
		System.out.println("pen:"+pen);
		System.out.println("方向:"+dirction);
	}
	
	public void write(int n)
	{
		switch(dirction)
		{
		case left:
			for(int i=y;i>=y-n;i--)
				room[x][i]=1;break;
		case right:
			for(int i=y;i<=y+n;i++)
				room[x][i]=1;break;
		case up:
			for(int i=x;i>=x-n;i--)
				room[i][y]=1;break;
		case down:
			for(int i=x;i<=x+n;i++)
				room[i][y]=1;break;
		}
	}
	public void display()
	{
		for(int i=0;i<20;i++)
		{
			for(int j=0;j<20;j++)
			{
				if(room[i][j]==0) System.out.print(' ');
				else System.out.print('*');
			}
			System.out.println();
		}
			
	}
	public void command(int c,int n)
	{
		switch(c)
		{
		case 1:pen=Pen.up;break;
		case 2:pen=Pen.down;room[x][y]=1;break;
		case 3:dirction=dirct.right;break;
		case 4:dirction=dirct.left;break;
		case 7:dirction=dirct.up;break;
		case 8:dirction=dirct.down;break;
		case 5:
		{
			switch(dirction)
			{
			case right:{if(y>9) return; if(pen==Pen.down) write(n);y+=n;}break;
			case left:{if(y<10) return; if(pen==Pen.down) write(n);y-=n;}break;
			case up:{if(x<10) return;if(pen==Pen.down) write(n); x-=n;}break;
			case down:{if(x>9) return;if(pen==Pen.down) write(n); x+=n;}break;		
			default:
				break;
			}
		}break;
		case 6:display();break;
		case 9:	break;
		}
	}
	public void run()
	{
		System.out.println("欢迎来到\"我的乌龟\"");
		int s=0,n=0;
		Scanner s1=new Scanner(System.in);
		while(s!=9)
		{
			System.out.print("请输入命令:  ");
			s=s1.nextInt();
			if(s==5) n=s1.nextInt();
			command(s,n);
//			showstatue();
		}
		System.out.println("游戏结束");
	}
}
