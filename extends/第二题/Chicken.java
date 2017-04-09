package 第二题;

public class Chicken extends Animal{
	final String talk="咯咯咯";
	public Chicken()
	{
		kind="Chicken";
	}
	public void talk()
	{
		super.talk();
		System.out.println(talk);
	}

}
