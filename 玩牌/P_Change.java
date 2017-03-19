//第六题
package 玩牌;
import java.util.Random;
public class P_Change {
	public static void main(String[] args)
	{ 
		Random ran=new Random();
		int wins=0;         //玩家赢的次数
		int loses=0;
		Replace r=new Replace();
		Deck d=new Deck();
		d.creatCards();
		int player1,player2;
		Card[] player_1=new Card[5];
		Card[] player_2=new Card[5];
		
		for(int j=0;j<20;j++)
		{
			d.shuffle();                               //洗牌
			for(int i=0;i<5;++i)                       //抓派
			{
				player_1[i]=new Card(d.cards[2*i]);
				player_2[i]=new Card(d.cards[2*i+1]);
			}                                     
			int end=r.evaluate(player_1);              //评估
			int[] exNum=new int[end];
			for(int i=0;i<end;++i)
			{
				exNum[i]=ran.nextInt(5);
				for(int k=0;k<i;k++)
				{
					if(exNum[k]==exNum[i]) {i--;break;}              //如果与前面重复，那么继续取随机数
				}
			}
			for(int i=0;i<end;++i)
			{
				player_1[exNum[i]].face=d.cards[10+i].face;          //换掉随机选中的end张不重复的牌
				player_1[exNum[i]].suit=d.cards[10+i].suit;
			}
			player1=d.jud(player_1);
			player2=d.jud(player_2);
			if(player1>player2) {System.out.println("玩家一获胜！恭喜玩家一！");loses++;}
			else if(player1<player2) {System.out.println("玩家二获胜！恭喜玩家二！");wins++;}
			else {
				if(player1==1||player1==2||player1==3||player2==4||player1==7) 
				{
					if(player_1[0].face>player_2[0].face) {System.out.println("玩家一获胜！恭喜玩家一！");loses++;}
					else if(player_1[0].face<player_2[0].face) {System.out.println("玩家二获胜！恭喜玩家二！");wins++;}
					else System.out.println("平局");
				}
			else  System.out.println("平局");
		}
	}
		System.out.printf("%s%d,%s%d","玩家赢的次数：",wins,"庄家赢的次数：",loses);
	}
}
