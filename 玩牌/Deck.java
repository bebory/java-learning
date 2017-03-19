package 玩牌;
import 玩牌.Card.Suit;
import java.util.Random;
public class Deck {
	Card[] cards=new Card[52];
	public void creatCards()   //閸掓稓鐝涙稉锟介崜顖滃
	{
		for(int i=0;i<52;i++)
		{
			cards[i]=new Card();
			cards[i].face=i%13+1;
			switch(i%4)
			{
			case 0:cards[i].suit=Suit.Heart;break;
			case 1:cards[i].suit=Suit.Dimaonds;break;
			case 2:cards[i].suit=Suit.Clubs;break;
			case 3:cards[i].suit=Suit.Spades;
			}
		}
	}
	public void shuffle()              //洗牌
	{
		Random ran=new Random();
		int swap;                       //随机位置
		int temp1;
		Suit temp2;
		for(int i=0;i<52;i++)
		{
			
			swap=Math.abs(ran.nextInt())%(52-i)+i;
			temp1=cards[i].face;
			cards[i].face=cards[swap].face;
			cards[swap].face=temp1;
			temp2=cards[i].suit;
			cards[i].suit=cards[swap].suit;
			cards[swap].suit=temp2;
		}
	}
	public void exchange(Card[] s,int x,int y)     //    用于交换两个位置
	{
		int temp1;
		Suit temp2;
		temp1=s[x].face;
		s[x].face=s[y].face;
		s[y].face=temp1;
		temp2=s[x].suit;
		s[x].suit=s[y].suit;
		s[y].suit=temp2;
	}
	public int jud(Card[] cards)                 //鐎甸�涚炊鏉╂稑骞撻惃鍕安瀵姷澧濇潻娑滎攽閸掋倕鍨�
	{
		int reNum=-1;                 //重复次数最多的数字
		int repeat=-1;               //表示前repeat个是重复的
		int[] countface=new int[14];
		int[] countsuit=new int[5];
		for(int i=0;i<5;i++)
		{
			countface[cards[i].face]++;
			switch(cards[i].suit)
			{
			case Heart: countsuit[1]++;break;
			case Dimaonds:countsuit[2]++;break;
			case Clubs:countsuit[3]++;break;
			case Spades:countsuit[4]++;break;
			}
		}			
		for(int i=1;i<14;i++)
			if(countface[i]>=countface[0]) {countface[0]=countface[i];reNum=i;}
		for(int i=1;i<=4;i++)
			if(countsuit[0]<countsuit[i]) countsuit[0]=countsuit[i]; 
		for(int i=0;i<5;i++)                                         //把重复的数字放到前面
		{
			if(i==0&&cards[0].face==reNum) repeat++;
			else if(i>0&&cards[i].face==reNum) {repeat++;exchange(cards,i,repeat);}
		}
		
		int[] judge=new int[7];                              //閻€劋绨崚銈嗘焽娴滄柨绱堕悧灞炬Ц闁絿顫掗悧锟�
		if(countface[0]==4) 
			{
			judge[3]=1;
			
			}
		if(countface[0]==3)
		{
			boolean j=false;
			for(int i=1;i<14;i++) 
				if(countface[i]==2) j=true;
			if(j) {
				judge[6]=1;
				
			}
			else 
				{
				judge[2]=1;
				
				}
		}
		int s=2;
		while(s<=10)
		{
			if(countface[s]==1&&countface[s+1]==1&&countface[s+2]==1&&countface[s+3]==1)
				{
				if(s==10&&countface[1]==1) {judge[5]=1; break;}
				else if(s<10&&countface[s+4]==1) {judge[5]=1; break;}
				}
			s++;
		}
		if(countsuit[0]==1) judge[4]=1;
		if(countface[0]==2) judge[1]=1;
		if(countface[0]==1&&judge[5]==0) judge[0]=1;
		s=6;
		while(s>=0)
		{
			if(judge[s]==1) { return s+1;/*System.out.printf("%d",s);break;*/}
			s--;
		}
		return -1;
	}
	public void show(Card[] s)
	{
		for(int i=0;i<5;++i)
			System.out.print(s[i]+"  ");
		System.out.println();
	}
	

}
