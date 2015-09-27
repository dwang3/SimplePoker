package simplepoker.game;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Player {
	private int playerID; //valid playerIDs are 0-3
	public final static int MAX_CARDS = 5;
	private Card[] cards;

	public Player (int id) {
		playerID = id;
		cards = new Card[MAX_CARDS];
	}
	
	public Player (int id, String hand) {
		StringTokenizer separatedCards = new StringTokenizer(hand);
		playerID = id;
		cards = new Card[MAX_CARDS];
		
		//try to add 5 cards, any missing cards will be null
		for (int i=0; i<MAX_CARDS; i++) {
			if(separatedCards.hasMoreTokens()) {
				String cardString = separatedCards.nextToken();
				cards[i] = new Card(cardString);
			}
		}
	}
	
	public int getID() {
		return playerID;
	}
	
	public Card[] getCards() {
		return cards;
	}
	
	public void setHand(Card[] cards) {
        this.cards = cards;
    } 
	
	public int numberOfCards() {
		return cards.length;
	}
	
	public String printPlayer () {
		StringBuilder builder = new StringBuilder();
		builder.append(this.getID() + " ");
		for (Card c : cards) {
		    builder.append(c.toString() + " ");
		}
		return builder.toString();
	}
	
	public static void main (String args[]) {
		Player p = new Player(1,"AceSpades KingSpades QueenSpades JackSpades TenSpades");
		System.out.println(p.printPlayer());
	}
	
}
