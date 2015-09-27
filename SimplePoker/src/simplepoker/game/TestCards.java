package simplepoker.game;
import junit.framework.*;

public class TestCards extends TestCase {
	public TestCards(String name) {
		super(name);
	}
	
	private Round r;
	
	public void setUp() {
		r = new Round();
		r.addPlayer( );
		r.addPlayer();
		r.addPlayer();
		r.addPlayer();
	}
	
	//test for valid cards for random cards, added by rank and suit
	public void testValidCards() {
		for (Player p : r.getPlayers()) {
			for (Card c : p.getCards()) {
				assertTrue(c.isValidCard());
			}
		}
	}
	
	//test for valid cards for cards added by a string separated by spaces
	public void testValidCards2() {
		
	}
}
