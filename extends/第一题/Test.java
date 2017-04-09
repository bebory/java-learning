package 第一题;
import java.util.ArrayList;
import java.util.Scanner;

import 第一题.Member.Gender;
public class Test {
	public static void main(String args[])
	{
		Scanner input=new Scanner(System.in);
		ArrayList<Member> persons=new ArrayList<Member>();
			
		int operate=0;
		boolean continueInput=true;
		while(true)
		{
			System.out.println("请输入要执行的操作：");	
			continueInput=true;
			do                                                  //处理异常，直到输入1,2,3中的一个
			{
				try
				{
					 operate=input.nextInt();
					 if(operate>3||operate<1) throw new Exception();
					 continueInput=false;
				}
				catch(Exception exception){
					System.out.println("请从新输入：");
					
				}
			}while(continueInput);
			
			if(operate==3) break;                              //3则退出
			if(operate==1)                                     //1则输出
				for(Member each:persons)
				{
					System.out.println(each);
				}
			else                                               //2则加入
			{          //请输入要增加的人员类型（1：教工，2：本科生，3：硕士生）
				System.out.println("选择要加入的人员类型：");
				int type=0;
				continueInput=true;
				do                                                  //处理异常，直到输入1,2,3中的一个
				{
					try
					{
						 type=input.nextInt();
						 if(type>3||type<1) throw new Exception();
						 continueInput=false;
					}
					catch(Exception exception){
						System.out.println("请从新输入：");
						
					}
					
				}while(continueInput);
				String name;
				String gender1;
				Gender gender2 = null;
				if(type==1)
				{
					long num;
					String title;
					String qualify;
					System.out.print("请输入教工的姓名，性别，教工号，职称，学历:");
					name=input.next();
					gender1=input.next();
					num=input.nextLong();
					title=input.next();
					qualify=input.next();
					switch(gender1)
					{
					case "man":gender2=Gender.man;break;
					case "woman":gender2=Gender.woman;break;
					default:gender2=Gender.man;
					}
					Staff staff=new Staff(name,gender2,num,title,qualify);
					persons.add(staff);
				}
				if(type==2)
				{
					String num="";
					String Class="";
					System.out.print("请输入本科生的姓名，性别，学号，班级:");
					name=input.next();
					gender1=input.next();
					num=input.next();
					Class=input.next();
					switch(gender1)
					{
					case "man":gender2=Gender.man;break;
					case "woman":gender2=Gender.woman;break;
					default:gender2=Gender.man;
					}
					Undergraduate under=new Undergraduate(name,gender2,num,Class);
					persons.add(under);
				}
				if(type==3)
				{
					String num="";
					String Sname;
					String Class="";
					System.out.print("请输入研究生的姓名，性别，学号，导师，班级:");
					name=input.next();
					gender1=input.next();
					num=input.next();
					Sname=input.next();
					Class=input.next();
					switch(gender1)
					{
					case "man":gender2=Gender.man;break;
					case "woman":gender2=Gender.woman;break;
					default:gender2=Gender.man;
					}
					Graduate g=new Graduate(name,gender2,num,Sname,Class);
					persons.add(g);
				}
			}
			
		}
		input.close();
		
		
	}

}
