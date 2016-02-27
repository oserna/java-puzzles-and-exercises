package oo.cards;


public interface Deck<T extends Card> {

	int getNumberOfCards();
	
	T [] getCards();
	
	String getName();
}
