//µÚÈıÌâ
package ÍæÅÆ;
public class DeckTest {
	public static void main(String[] args)
	{
		Deck d=new Deck();
		d.creatCards();
		d.shuffle();
		int result=d.jud(d.cards);
		d.show(d.cards);
		System.out.println(result);
	}

}
