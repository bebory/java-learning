package 第一题;
//教师
public class Staff extends Member{
	long number;             //教工号
	String title;            //职称
	String qualification;    //学历
	public Staff()
	{
		super();
		number=1;
		title="";
		qualification="";
	}
    public Staff(String n)             //只有名字的构造函数
    {
    	this();
    	name=n;
    }
	public Staff(String n, Gender d,long l,String s,String q) {
		super(n, d);
		// TODO Auto-generated constructor stub
		number=l;
		title=s;
		qualification=q;
	}
	
	@Override public String toString()
	{
		return name+" "+gender+" "+number+" "+title+" "+qualification;
	}
	

}
