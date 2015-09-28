package simplepoker.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Player {
	private int playerID; 
	private int handValue[];
	public final static int MAX_CARDS = 5;
	private ArrayList<Card> hand;
	//private Card[] cards;

	public Player (int id) {
		playerID = id;
		handValue = new int[6];
		hand = new ArrayList<Card>();
	}
	
	public Player (int id, String startingHand) {
		StringTokenizer separatedCards = new StringTokenizer(startingHand);
		playerID = id;
		hand = new ArrayList<Card>();
		handValue = new int[6];
		
		while (separatedCards.hasMoreTokens()) {
			String cardString = separatedCards.nextToken();
			hand.add(new Card(cardString));
		}

	}
	
	public int getID() {
		return playerID;
	}
	
	public ArrayList<Card> getCards() {
		return hand;
	}
	
	public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    } 
	
	public int numberOfCards() {
		return hand.size();
	}
	
	public boolean hasInvalidCards() {
		boolean invalidHand = false;

		for (Card c : hand) {
			if (!c.isValidCard())
				invalidHand = true;
		}

		return invalidHand;
	}
	
	public boolean hasDuplicateCards() {
		boolean duplicateHand = false;
		
		for (int i = 0; i < hand.size(); i++) {
			for (int j = i + 1; j < hand.size(); j++) {
				if (i != j && hand.get(i).equals(hand.get(j)))
					duplicateHand = true;
			}
		}
		return duplicateHand;
	}
	
	public boolean isValidPlayer() {
		return false;
	}
	
	public String printPlayer () {
		StringBuilder builder = new StringBuilder();
		builder.append(this.getID() + " ");
		for (Card c : hand) {
		    builder.append(c.toString() + " ");
		}
		return builder.toString();
	}
	
	public static void main (String args[]) {
		Player p = new Player(1,"AceSpades KingSpades QueenSpades JackSpades");
		System.out.println(p.hasDuplicateCards());
	}
	
}
