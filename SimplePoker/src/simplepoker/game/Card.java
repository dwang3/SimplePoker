package simplepoker.game;

import java.util.StringTokenizer;

public class Card {
    private int cardRank;
    private int cardSuit;
    private String cardString;
    
    static final String[] Suit = {"","Diamonds","Clubs","Hearts","Spades"};
    static final String[] Rank = {"","","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King","Ace"};
    
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
    	cardString = "";
    }
    
    //copy constructor
    public Card (Card c) {
    	this(c.getRank(),c.getSuit());
    }

    public Card(int rank, int suit) {
        this.cardRank = rank;
        this.cardSuit = suit;
    }

    public Card(String card) {
    	this.cardRank = parseCard(card).cardRank;
    	this.cardSuit = parseCard(card).cardSuit;
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
    
    public static boolean isValidCard(Card c) {
    	return isValidSuit(c.cardSuit) && isValidRank(c.cardRank);
    }
    
    public boolean isValidCard() {
    	return isValidSuit(this.cardSuit) && isValidRank(this.cardRank);
    }

    public static String rankToString(int rank) {
        switch (rank) {
        case TWO:
            return "Two";
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
    	
    	if (card == null)
    		return null;
    	
    	Card parsedCard = new Card();
    	String rank = "";
    	String suit = "";
    	
    	for (int i=2; i<=14; i++) {
    		if (card.contains(Rank[i])) {
    			rank = Rank[i];
    			parsedCard.cardRank = i;
    		}
    	}
    	suit = card.replaceFirst(rank, "");
    	
    	for (int i=1; i<=4; i++) {
    		if (suit.equals(Suit[i]))
    			parsedCard.cardSuit = i;
    	}
    	return parsedCard;
    }
    
    public boolean equals (Card c) {
    	return this.cardRank == c.cardRank && this.cardSuit == c.cardSuit;
    }
    
    @Override public String toString() {
    	return rankToString(this.getRank()) + suitToString(this.getSuit());
    }
    
}
