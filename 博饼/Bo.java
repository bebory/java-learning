package 博饼;
import java.util.Random;
import java.util.Scanner;
import java.math.*;
public class Bo {
	
	

	public void grade(int[] a)//根据数字来评分
	{
		int[] count=new int[7];            //记录有几个4
		for(int i=0;i<6;i++)        //记录1到6每个数出现的次数，存在count[1]至count[6]里
		{
			++count[a[i]];
		}
		switch(count[4])           //先判断有关4的
		{
		case 1: System.out.print("一秀  ");break;
		case 2: System.out.print("二举   ");break;
		case 3: System.out.print("三红   ");break;
		case 4: 
			{
				if(count[2]==2) System.out.print("状元插金花   ");
				else System.out.print("四红  ");
			}break;
		case 5: System.out.print("五王  ");break;
		case 6: System.out.print("六勃红  ");break;
		}
		count[0]=count[1];
		for(int i=2;i<7;++i)
		{
			if(count[i]>count[0]) count[0]=count[i];
		}                             //用count[0]存放最大的数
		if(count[0]>3&&count[0]!=count[4])
		{
			switch(count[0])
			{
			case 4:System.out.print("四进");break;
			case 5:System.out.print("五子");break;
			case 6:System.out.print("六勃黑");break;
			}
		}
		if(count[0]==1) System.out.print("对堂");
		System.out.print("\n");
	}
	public void run()          //主函数
	{
		int[] num=new int[6];
		Random ran=new Random();           //随机数流
		Scanner s=new Scanner(System.in); //输入流
		while(true)
		{
			System.out.print("随机数则输入1，手动输入则输入0:");
			int jud=s.nextInt();
			if(jud==1)                      //随机数输入
			{
				for(int j=0;j<6;j++)          //6个人
				{
					System.out.print("玩家");
					System.out.print(j+1);
					System.out.print("生成的数为：");
					for(int i=0;i<6;i++)        //6个随机数
					{
						num[i]=Math.abs(ran.nextInt()%6)+1;
						System.out.printf("%d",num[i]);
					}
					System.out.printf("\n");
					grade(num);
				}
				
				
			}
			else                             //手动输入
			{
				for(int j=0;j<6;j++)
				{
					System.out.printf("第%d个玩家：\n",j+1);
					System.out.print("请输入6个1到6之间的数：");
					for(int i=0;i<6;i++)
					{
						num[i]=s.nextInt();
						if(num[i]<1||num[i]>6)
						{
							System.out.print("居然能摇到这种数字，我给满分!\n");
							break;
						}
					}
					System.out.printf("\n");
					grade(num);
				}
				
			}
			System.out.print("继续则按0，退出则按1:");
			int x=s.nextInt();
			if(x!=0) break;             //x为1时结束
		}
	}
	
}
