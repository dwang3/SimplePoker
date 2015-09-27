package simplepoker.game;
import junit.framework.*;

public class TestPlayers extends TestCase {
	public TestPlayers (String name) {
		super(name);
	}
	/* test for valid number of players 2-4 */
	public void testNoPlayers () {
		Round r = new Round();
		assertFalse("not enough players to start!", r.isValidRound());
	}
	
	public void testTooManyPlayers () {
		Round r = new Round();
		r.addPlayer();
		r.addPlayer();
		r.addPlayer();
		r.addPlayer();
		r.addPlayer();
		assertFalse("too many players to start!", r.isValidRound());
	}
	
	public void testEnoughPlayers () {
		Round r = new Round();
		r.addPlayer();
		r.addPlayer();
		r.addPlayer();
		assertTrue("enough players to start", r.isValidRound());
	}
	
	public void testValidPlayerIDs () {
		Round r = new Round();
		r.addPlayer();
		r.addPlayer();
		r.addPlayer();
		r.addPlayer();
		
		/* player ids must be between 0 and max number of players */
		for (Player p : r.getPlayers()) {
			assertTrue(p.getID() >= 0 && p.getID() <= r.getNumPlayers());
		}
	}
	
	public void testPlayerIDisFirstChar () {
		
	}
	
}
