package simplepoker.game;
import junit.framework.*;

public class TestHands extends TestCase {
	public TestHands(String name) {
		super(name);
	}
	private Round r;
	
	public void setUp() {
		r = new Round();
	}
	
	public void testNumberOfCards() {
		//each player should get 5 cards
		r.addPlayer(1,"AceSpades KingSpades QueenSpades JackSpades TenSpades");
		for (Player p : r.getPlayers()) {
			assertEquals(5, p.getCards().length);
		}
	}
	
	public void testValidHand() {
		//if a player has a valid hand none of the cards will return a null object
		r.addPlayer(1,"AceSpades KingSpades QueenSpades JackSpades TenSpades");
		for (Player p : r.getPlayers()) {
			for (Card c : p.getCards()) {
				assertNotNull(c);
			}
		}
	}
}
