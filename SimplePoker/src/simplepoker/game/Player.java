package simplepoker.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Player implements Comparable<Player> {
	public final static int MAX_CARDS = 5;

	private int playerID;

	private ArrayList<Card> hand;
	private Card[] cards;

	public Player(int id) {
		playerID = id;
		hand = new ArrayList<Card>();
	}

	public Player(int id, String startingHand) {
		// separate into strings that represent individual cards
		StringTokenizer separatedCards = new StringTokenizer(startingHand);
		playerID = id;
		hand = new ArrayList<Card>();

		while (separatedCards.hasMoreTokens()) {
			String cardString = separatedCards.nextToken();
			hand.add(new Card(cardString));
		}

		Collections.sort(hand); // sort the cards so we can rank straights and
								// compare hands
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

	
	/*
	 * hands are scored from nothing 0.XX, XX being the rank of the high card, to
	 * 8.14, which is an ace high straight flush or a royal flush
	 */
	public double getRanking() {
		if (this.hasInvalidCards())
			return 0.0;
		double ranking = 0.0; //no scoring hand

		if (hasStraightFlush() > 8.0) {
			ranking = hasStraightFlush();
		} else if (hasFourOfAKind() > 7.0) {
			ranking = hasFourOfAKind();
		} else if (hasFullHouse() > 6.0) {
			ranking = hasFullHouse();
		} else if (hasFlush() > 5.0) {
			ranking = hasFlush();
		} else if (hasStraight() > 4.0) {
			ranking = hasStraight();
		} else if (hasTrips() > 3.0) {
			ranking = hasTrips();
		} else if (hasTwoPair() > 2.0) {
			ranking = hasTwoPair();
		} else if (hasPair() > 1.0) {
			ranking = hasPair();
		} else {
		}

		return ranking;
	}
	
	/*
	 * each method will either return 0.0, meaning it is not a scoring hand of that type,
	 * or a double representing the rank of the hand 1 to 8 (8 being a straight flush)
	 * the decimal point will represent the high card in the scoring portion of the hand
	 * a pair of threes with an ace kicker will be scored 1.03
	 */

	public double hasPair() {
		double result = 0.0;

		for (int i = 0; i < hand.size() - 1; i++) {
			if (hand.get(i).getRank() == hand.get(i + 1).getRank()) {
				result = 1.0 + (hand.get(i).getRank() * 0.01);
			}
		}

		return result;
	}

	public double hasTwoPair() {
		double result = 0.0;
		double value = 0.0;
		int counter = 0; 

		for (int i = 0; i < hand.size() - 1; i++) {
			if (hand.get(i).getRank() == hand.get(i + 1).getRank()) {
				counter++;
				value = hand.get(i).getRank() * 0.01;
			}
		}

		if (counter == 2) {
			result = 2.0 + value;
		}

		return result;
	}

	public double hasTrips() {
		double result = 0.0;

		for (int i = 0; i < hand.size() - 2; i++) {
			if (hand.get(i).getRank() == hand.get(i + 1).getRank()
					&& hand.get(i).getRank() == hand.get(i + 2).getRank()) {
				result = 3.0 + (hand.get(i).getRank() * 0.01);
			}
		}

		return result;
	}

	public double hasStraight() {
		double result = 0.0;

		for (int i = 0; i < hand.size() - 1; i++) {
			if (hand.get(i).getRank() == hand.get(i + 1).getRank() - 1) {
				result = 4.0 + (hand.get(i + 1).getRank() * 0.01);
			} else {
				result = 0.0;
			}
		}

		return result;
	}
	
	public double hasFlush() {
		double result = 0.0;

		int suit = hand.get(0).getSuit();

		for (int i = 0; i < hand.size(); i++) {
			result = 5.0 + (hand.get(i).getRank() * 0.01);

			if (!(hand.get(i).getSuit() == suit)) {
				return 0.0;
			}
		}

		return result;
	}
	
	public double hasFullHouse() {
		double result = 0.0;
		int tripsIndex = -1;
		boolean trips = false; //need trips and a pair
		boolean pair = false;

		for (int i = 0; i < hand.size() - 2; i++) {
			if (hand.get(i).getRank() == hand.get(i + 1).getRank()
					&& hand.get(i).getRank() == hand.get(i + 2).getRank()) {
				trips = true;
				tripsIndex = i;
			}
		}
		if (tripsIndex == 0) {
			if (hand.get(3).getRank() == hand.get(4).getRank()) {
			pair = true;
		}
		}
		else if (tripsIndex == 2) {
			if (hand.get(0).getRank() == hand.get(1).getRank()) {
				pair = true;
			}
		}
		else
			return 0.0;

		if (pair && trips) {
			result = 6.0 + (hand.get(hand.size()-1).getRank() * 0.01);
		}

		return result;
	}
	
	public double hasFourOfAKind() {
		double result = 0.0;

		for (int i = 0; i < hand.size() - 3; i++) {
			if (hand.get(i).getRank() == hand.get(i + 1).getRank() && hand.get(i).getRank() == hand.get(i + 2).getRank()
					&& hand.get(i).getRank() == hand.get(i + 3).getRank()) {
				result = 7.0 + (hand.get(i).getRank() * 0.01);
			}
		}

		return result;
	}
	
	public double hasStraightFlush() {
		double result = 0.0;

		if (hasStraight() > 4.0 && hasFlush() > 5.0) {
			result = 8.0 + hasStraight() - 4.0;
		}

		return result;
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

	public static boolean hasDuplicateCards(ArrayList<Card> cards) {
		boolean duplicateHand = false;

		for (int i = 0; i < cards.size(); i++) {
			for (int j = i + 1; j < cards.size(); j++) {
				if (i != j && cards.get(i).equals(cards.get(j)))
					duplicateHand = true;
			}
		}
		return duplicateHand;
	}

	public boolean hasValidHand() {
		return hand.size() == 5 && !hasDuplicateCards() && !hasInvalidCards();
	}

	public int compareTo(Player p) {
        int result = 0;
        
        int thisIntRank = (int)this.getRanking();
        int otherIntRank = (int)p.getRanking();
        
        double tempThisHighCard = this.getRanking() - thisIntRank;
        double tempOtherHighCard = p.getRanking() - otherIntRank;
        
        int thisHighCard = (int)tempThisHighCard;
        int otherHighCard = (int)tempOtherHighCard;
        
        if (this.getRanking() == p.getRanking() ){ 
        	result = 0;
        } else if (this.getRanking() > p.getRanking()) {
            result = 1;
        } else if (p.getRanking() > this.getRanking()) {	
            result = -1;
        } else {
            result = 0;
        }
        
        return result;
    }

	public String printPlayer() {
		StringBuilder builder = new StringBuilder();
		builder.append(this.getID() + " ");
		for (Card c : hand) {
			builder.append(c.toString() + " ");
		}
		return builder.toString();
	}

}
