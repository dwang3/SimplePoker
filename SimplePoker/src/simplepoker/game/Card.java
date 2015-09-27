package simplepoker.game;

import java.util.StringTokenizer;

public class Card {
    private int cardRank;
    private int cardSuit;
    private String cardString;
    
    static final String[] Suit = {"","Diamonds","Clubs","Hearts","Spades"};
    static final String[] Rank = {"","Ace","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King"};
    
    public final static int DIAMONDS = 1;
    public final static int CLUBS    = 2;
    public final static int HEARTS   = 3;
    public final static int SPADES   = 4;

    public final static int TWO   = 2;
    public final static int THREE = 3;
    public final static int FOUR  = 4;
    public final static int FIVE  = 5;
    public final static int SIX   = 6;
    public final static int SEVEN = 7;
    public final static int EIGHT = 8;
    public final static int NINE  = 9;
    public final static int TEN   = 10;
    public final static int JACK  = 11;
    public final static int QUEEN = 12;
    public final static int KING  = 13;
    public final static int ACE   = 14;
    
    public Card () {
    	cardRank = 0;
    	cardSuit = 0;
    }

    public Card(int rank, int suit) {
        //assert isValidRank(rank);
        //assert isValidSuit(suit);
        this.cardRank = rank;
        this.cardSuit = suit;
    }

    public Card(String card) {
    	this.cardString = card;
    }

    public int getSuit() {
        return cardSuit;
    }

    public int getRank() {
        return cardRank;
    }

    public static boolean isValidRank(int rank) {
        return TWO <= rank && rank <= ACE;
    }

    public static boolean isValidSuit(int suit) {
        return DIAMONDS <= suit && suit <= SPADES;
    }
    
    public boolean isValidCard() {
    	return isValidSuit(this.cardSuit) && isValidRank(this.cardRank);
    }

    public static String rankToString(int rank) {
        switch (rank) {
        case TWO:
            return "Deuce";
        case THREE:
            return "Three";
        case FOUR:
            return "Four";
        case FIVE:
            return "Five";
        case SIX:
            return "Six";
        case SEVEN:
            return "Seven";
        case EIGHT:
            return "Eight";
        case NINE:
            return "Nine";
        case TEN:
            return "Ten";
        case JACK:
            return "Jack";
        case QUEEN:
            return "Queen";
        case KING:
            return "King";
        case ACE:
            return "Ace";
        default:
            return null;
        }    
    }
    
    public static String suitToString(int suit) {
        switch (suit) {
        case DIAMONDS:
            return "Diamonds";
        case CLUBS:
            return "Clubs";
        case HEARTS:
            return "Hearts";
        case SPADES:
            return "Spades";
        default:
            return null;
        }    
    }
    
    public static Card parseCard(String card) { 
    	Card cardString = new Card();
    	String rank;
    	String suit = "Diamonds";
    	switch (card.substring(0, 5)) {
    	    case "Ace":
    	        rank = "14";
    	        break;
    	    case "Jack":
    	        rank = "11";
    	        break;
    	    case "Queen":
    	        rank = "12";
    	        break;
    	    case "King":
    	        rank = "13";
    	        break;
    	    default:
    	        rank = card.substring(0, 5);
    	        break;
    	}
    	if (Integer.parseInt(rank) > 13 || Integer.parseInt(rank) < 0) { 
    	    return null;
    	}
    	cardString.cardRank = Integer.parseInt(rank); 
    	switch (suit) { 
    	    case "Diamonds":
    	    	cardString.cardSuit = 1;
    	        return cardString;
    	    case "Clubs":
    	    	cardString.cardSuit = 2;
    	        break;
    	    case "Hearts":
    	    	cardString.cardSuit = 3;
    	        break;
    	    case "Spades":
    	    	cardString.cardSuit = 4;
    	        break;
    	    default: 
    	        return null;
    	}
    	return cardString;
    }
    
    @Override public String toString() {
    	return cardString;
    }
    
}
