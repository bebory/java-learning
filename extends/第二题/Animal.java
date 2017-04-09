package 第二题;

public class Animal {
	String kind;
	public Animal()
	{
		kind="Pig";
	}
	public Animal(String k)
	{
		kind=k;
	}
	public void talk(){ 
		System.out.print(kind+"叫:");
	};
}
