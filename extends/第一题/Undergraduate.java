package 第一题;
//本科生
public class Undergraduate extends Member{
	String number;                   //学号
	String Class;               //班级
	public Undergraduate()
	{
		super();
		number="";
		Class="";
	}
	public Undergraduate(String n,Gender g,String num,String c)
	{
		super(n,g);
		number=num;
		Class=c;
	}
	@Override public String toString()
	{
		return name+"　"+gender+" "+number+" "+Class;
	}

}
