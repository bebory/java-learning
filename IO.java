package 实验一;
import java.util.*;
import java.io.*;
public class IO {
	public static void main(String[] args) throws IOException
	{
		
        //way1：use Scanner to input
		Scanner  input=new Scanner(System.in);
		System.out.print("输入一个字符串和数字:");
		String a=input.next();
		int number=input.nextInt();
		
		//way2:use BufferedReader and System.in to input
		System.out.print("输入一个字符串和数字:");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String b;
		b=br.readLine();
		int s;
		s =Integer.parseInt(br.readLine());
		
		
		//two ways to output
		System.out.print(a);
		System.out.println(number);
		System.out.print(b);
		System.out.println(s);
//		PrintStream out = new PrintStream( new BufferedOutputStream(System.out)); 
//		out.print(s);
		
		
		//题目二
		String s1,s2;
		s1=s2=null;
		int num1,num2;
		
		System.out.print("Please input two number:");
		s1=br.readLine();
		s2=br.readLine();
		if(s1.length()==0||s2.length()==0) 
		{
			System.out.print("erro!");
			return;
		}                                               //有空字符串报错	
		for(int i=0;i<s1.length();i++)
		{
			if(s1.charAt(i)>'9'||s1.charAt(i)<'0')
			{
				System.out.print("erro!");
				return;
			}
		}
		for(int i=0;i<s2.length();i++)
		{
			if(s2.charAt(i)>'9'||s2.charAt(i)<'0')
			{
				System.out.print("erro!");
				return;
			}
		}                                               //只要s1,s2中有非数字的字符就报错退出
		num1=Integer.parseInt(s1);
		num2=Integer.parseInt(s2);                      //若没问题，则转为数字
		System.out.print("The average of the two numbers is: ");
		System.out.print((num1+num2)/2);
	}

}
