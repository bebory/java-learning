package ÍæÅÆ;

public class Card {
	public static enum Suit{Heart,Dimaonds,Clubs,Spades}
	public Suit suit;
	public int face; 
	public Card()
	{
		suit=Suit.Heart;
		face=0; 
	}
	public Card(Card other)
	{
		suit=other.suit;
		face=other.face;
	}
	public int getFace()
	{
		return face;
	}
	public Suit getSuit()
	{
		return suit;
		
	}
	public String toString()
	{
		return face+" " + "of" + " "+suit;
	}

}
