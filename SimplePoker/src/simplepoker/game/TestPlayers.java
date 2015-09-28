package simplepoker.game;
import junit.framework.*;

public class TestPlayers extends TestCase {
	public TestPlayers (String name) {
		super(name);
	}
	
	private Round r;
	private Player p;
	
	public void setUp() {
		r = new Round();
	}
	
	/* test for valid number of players 2-4 */
	public void testNoPlayers () {
		assertFalse("not enough players to start!", r.isValidRound());
	}
	
	public void testTooManyPlayers () {
		r.addPlayer();
		r.addPlayer();
		r.addPlayer();
		r.addPlayer();
		r.addPlayer();
		assertFalse("too many players to start!", r.isValidRound());
	}
	
	public void testEnoughPlayers () {
		r.addPlayer();
		r.addPlayer();
		r.addPlayer();
		assertTrue("enough players to start", r.isValidRound());
	}
	
	public void testPlayerIDs () {
		r.addPlayer();
		r.addPlayer();
		r.addPlayer();
		r.addPlayer();
		
		/* when adding "default" players, player ids are incremented */
		for (Player p : r.getPlayers()) {
			assertTrue(p.getID() >= 0 && p.getID() <= r.getNumPlayers());
		}
	}
	
	public void testDuplicateIDs1 () {
		r.addPlayer(1,"AceSpades KingSpades QueenSpades JackSpades TenSpades");
		r.addPlayer(1,"AceHearts KingHearts QueenHearts JackHearts TenHearts");
		assertTrue(r.areDuplicateIDs());
	}
	
	public void testDuplicateIDs2 () {
		r.addPlayer(1,"AceSpades KingSpades QueenSpades JackSpades TenSpades");
		r.addPlayer(2,"AceHearts KingHearts QueenHearts JackHearts TenHearts");
		assertFalse(r.areDuplicateIDs());
	}
	
	public void testHasValidHand () {
		p = new Player(1,"AceSpades KingSpades QueenSpades JackSpades TenSpades");
		assertTrue(p.hasValidHand());
	}
	
	public void testPlayerIDisFirst () {
		p = new Player(1,"AceSpades KingSpades QueenSpades JackSpades TenSpades");
		int id = Character.getNumericValue(p.printPlayer().charAt(0));
		assertTrue(id == p.getID());
	}
	
	public void testDuplicateCardsinHand () {
		p = new Player(1,"AceSpades KingSpades QueenSpades JackSpades JackSpades");
		assertTrue(p.hasDuplicateCards());
	}
	
	public void testDuplicateCardsinRound () {
		r.addPlayer(1,"AceSpades KingSpades QueenSpades JackSpades TenSpades");
		r.addPlayer(2,"AceSpades KingSpades QueenSpades JackSpades TenSpades");
		assertTrue(r.areDuplicateCards());
	}
	
}
