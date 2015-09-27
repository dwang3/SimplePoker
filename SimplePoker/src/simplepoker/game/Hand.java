package simplepoker.game;

public class Hand {
	private Card[] cards;
	
	public Card[] getCards() {
		return cards;
	}
	
	public Hand() {
		cards = new Card[5];
	}
	
}
