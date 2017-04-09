package 第二题;

public class Pig extends Animal{
	final String talk="哼哼哼";
	public Pig()
	{
		kind="Pig";
	}
	public void talk()
	{
		super.talk();
		System.out.println(talk);
	}

}
