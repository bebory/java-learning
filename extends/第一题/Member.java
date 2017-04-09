package 第一题;
//学校成员
public class Member {
	public enum Gender {man, woman}
	String name;
	Gender gender;
	public Member()
	{
		name="";
		gender=Gender.man;
	}
	public Member(String n,Gender d)
	{
		name=n;
		gender=d;
	}
	public String getName()
	{
		return name;
	}

}
