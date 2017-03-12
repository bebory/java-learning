package 第二题;
import java.math.*;
public class EightQueens {
	int[] cheesBoard =new int[8];   
	int sum=0;
	public  void T (int count)
	{                 
		if(count==8) 
			{
			sum++;
			for(int i=0;i<8;i++)
			{
				for(int j=0;j<8;++j)
				{
					if(j==cheesBoard[i]) System.out.print('1');
					else System.out.print('0');
				}
				System.out.println();
			}
			System.out.println();
			return;
			}                                  //深入到最内层则输出，退出
		for(int i=0;i<8;++i)
		{
			Boolean jud=true;
			for(int j=0;j<count;j++)
				if(cheesBoard[j]==i||Math.abs(count-j)==Math.abs(cheesBoard[j]-i)) jud=false;//��ǰ��Ļʺ��ͻ��Ϊfalse
			if(jud)
			{
				cheesBoard[count]=i;
				T(++count);
				count--;
			}
		}
	}
	public static void main(String[] args)
	{
		EightQueens a=new EightQueens();
		a.T(0);		
		System.out.println(a.sum);
	}
}
