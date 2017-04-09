package 第二题;
import java.util.ArrayList;
import java.util.Scanner;

import 第一题.Member;
public class Test {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		int number=0; 
		ArrayList<Animal> animal=new ArrayList<Animal>();
		Scanner input=new Scanner(System.in);
		System.out.println("Please input the number animal species:");
		boolean jud=true;
		do
		{
			try
			{
				number=input.nextInt();
				jud=false;
			}
			catch(Exception exception)
			{
				System.out.println("Wrong type. Int number needed:");
			}
		}while(jud);
		System.out.println("Please inpu"+" "+number+" "+"animal's specie' names,and input 'end' to end input.");
		//String[] animals=new String[number];
		ArrayList<String> in=new ArrayList<String>();
		String ani="";
		int errortype=0;                                         //错误类型
		boolean con=true;
		do
		{
			try
			{
				while(true)                               //把end前面的字符串读进来，放到in里面
				{
					ani=input.next();
					if(ani.equals("end")) break;
					in.add(ani);
				}
				if(in.size()!=number)
				{
					errortype=1;
					throw new Exception();
				}
				for(String each:in)
					if(!each.equals("Pig")&&!each.equals("Dog")&&!each.equals("Chicken")) {errortype=2;throw new  Exception();}
				con=false;
			}
			catch(Exception exception)
			{
				if(errortype==1) System.out.println("Wrong number of String.");
				else if(errortype==2) System.out.println("creat object error.");
				in.clear();
			}
		}while(con);
		for(String each:in)
		{
			Animal a=(Animal)Class.forName("第二题."+each).newInstance();
			animal.add(a);
		}
		for(Animal each:animal)                                      //输出
			each.talk();
//		for(int i=0;i<number;++i)
//			do
//			{
//				try
//				{
//					animals[i] =input.next();
//					if(animals[i]!="Pig"&&animals[i]!="Dog"&&animals[i]!="Chicken") throw new  Exception();
//					jud=false;
//				}
//				catch(Exception exception)
//				{
//					System.out.println("Creat object error");
//				}
//			}while(jud);			
	}

}
