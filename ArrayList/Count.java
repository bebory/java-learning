package 第八题;
import java.util.ArrayList;
import java.util.Scanner;
public class Count {
	public static void main(String[] args)
	{
		ArrayList<String> list=new ArrayList<String>();
		ArrayList count=new ArrayList();
		String s=new String();
		Scanner input=new Scanner(System.in);
		while(true)
		{
			System.out.print("请输入一个单词 ");
			s=input.next();
			if(s.equalsIgnoreCase("quit")) break;
			int i = 0;
			boolean _if=false;
			 for(;i < list.size(); i ++){
				 if(s.equalsIgnoreCase(list.get(i))) {int temp=(int) count.get(i);count.set(i,temp+1);_if=true;break;
				 }
			 }
			 if(!_if) {list.add(s); count.add(1);}
		}
		for(int i=0;i < list.size(); i ++)
			System.out.println(list.get(i)+"   "+count.get(i));
	}
}
