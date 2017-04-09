package 第二题;

public class Dog extends Animal{
	final String talk="汪汪汪";
	public Dog()
	{
		kind="Dog";
	}
	public void talk()
	{
		super.talk();
		System.out.println(talk);
	}

}
