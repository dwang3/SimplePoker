package simplepoker.game;
import junit.framework.*;

public class TestCards extends TestCase {
	public TestCards(String name) {
		super(name);
	}
	
	private Round r;
	
	public void setUp() {
		r = new Round();
	}

	public void testValidCard () {
		r.addPlayer(1,"AceSpades KingSpades QueenSpades JackSpades TenSpades");
		for (Player p : r.getPlayers()) {
			for (Card c : p.getCards()) {
				assertTrue("all cards are valid",Card.isValidCard(c));
			}
		}
	}
	
	public void testInvalidRank () {
		r.addPlayer(1,"AceSpades KingSpades QueenSpades JackSpades FourteenSpades");
		for (Player p : r.getPlayers()) {
			assertTrue("one or more invalid cards!",p.hasInvalidCards());
		}
	}
	
	public void testInvalidSuit () {
		r.addPlayer(1,"AceSpades KingSpades QueenSpades JackSpades TenApples");
		for (Player p : r.getPlayers()) {
			assertTrue("one or more invalid cards",p.hasInvalidCards());
		}
	}
	
}
