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
	
	public void testNumberOfCards () {
		//each player should get 5 cards
		r.addPlayer(1,"AceSpades KingSpades QueenSpades JackSpades TenSpades");
		for (Player p : r.getPlayers()) {
			assertEquals(5, p.getCards().size());
		}
	}
	
	public void testPairs () {
		r.addPlayer(1,"AceSpades AceSpades QueenHearts TenDiamonds TwoHearts");
	}
	
}
