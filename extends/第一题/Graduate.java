package 第一题;
//研究生
public class Graduate extends Undergraduate{
	Staff advisor;             //导师
	public Graduate(String n,Gender g,String num,String Sname,String c)
	{
		super(n,g,num,c);
		advisor=new Staff(Sname);
	}
	@Override public String toString()
	{
		return name+"　"+gender+" "+number+" "+advisor.getName()+" "+Class;
	}

}
