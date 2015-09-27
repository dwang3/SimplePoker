package simplepoker.game;
import junit.framework.*;

public class TestPlayers extends TestCase {
	
	/* test for valid number of players 2-4 */
	public void testNoPlayers () {
		Round r = new Round();
		assertFalse("not enough players!", r.isValidRound());
	}
	
	public void testTooManyPlayers () {
		Round r = new Round();
		r.addPlayer();
		r.addPlayer();
		r.addPlayer();
		r.addPlayer();
		r.addPlayer();
		assertFalse("too many players!", r.isValidRound());
	}
	
	public void testEnoughPlayers () {
		Round r = new Round();
		r.addPlayer();
		r.addPlayer();
		assertTrue("enough players to start", r.isValidRound());
	}

	public void testInvalidID() {
		
	}
	
	public void testValidPlayerIDs () {
		Round r = new Round();
		r.addPlayer();
		r.addPlayer();
		r.addPlayer();
		r.addPlayer();
		
		/* each player ID must correspond to when they were added
		 * if any player ID is greater or less than number of players,
		 * this test will fail
		 */
		for (int i=0; i<r.getNumPlayers(); i++) {
			assertEquals(i, r.getPlayers().get(i).getID());
		}
	}
}
