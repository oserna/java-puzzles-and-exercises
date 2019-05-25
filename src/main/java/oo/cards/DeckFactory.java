package oo.cards;

public interface DeckFactory<T extends Deck> {

	T createDeck();
	
}
