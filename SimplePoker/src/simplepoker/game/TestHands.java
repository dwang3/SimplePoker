package simplepoker.game;
import junit.framework.*;

public class TestHands extends TestCase {
	public TestHands(String name) {
		super(name);
	}
	private Round r;
	private Player p;
	private Player p2;
	
	public void setUp() {
		r = new Round();
	}
	
	public void testNumberOfCards () {
		r.addPlayer(1,"AceSpades KingSpades QueenSpades JackSpades TenSpades");
		for (Player p : r.getPlayers()) {
			assertEquals("each player has 5 cards",5, p.getCards().size());
		}
	}
	
	/*
	 * each test adds 0.14 to the ranking which represents an ace high of that scoring hand
	 * there may be some rounding errors
	 */
	
	public void testPair () {
		p = new Player(1,"AceSpades AceSpades QueenHearts TenDiamonds TwoHearts");
		assertEquals(1.14,p.getRanking());
	}
	
	public void testTwoPair () {
		p = new Player(1,"AceSpades AceSpades QueenHearts TenDiamonds TenHearts");
		assertEquals(2.14,p.getRanking());
	}
	
	public void testTrips () {
		p = new Player(1,"AceSpades AceHearts AceDiamonds TenDiamonds TwoHearts");
		assertEquals(3.14,p.getRanking());
	}	
	
	public void testStraight () {
		p = new Player(1,"KingHearts QueenDiamonds JackSpades AceSpades TenHearts");
		assertEquals(4.14,p.getRanking());
	}	
	
	public void testFlush () {
		p = new Player(1,"AceSpades TenSpades FourSpades SevenSpades TwoSpades");
		assertEquals(5.14,p.getRanking());
	}	
	
	public void testFullHouse () {
		p = new Player(1,"AceSpades AceHearts TwoClubs TwoHearts AceDiamonds");
		assertEquals(6.14,p.getRanking());
	}	
	
	public void testQuads () {
		p = new Player(1,"AceSpades AceHearts AceDiamonds AceClubs TwoHearts");
		assertEquals(7.14,p.getRanking());
	}
	
	public void testStraightFlush () {
		p = new Player(1,"AceSpades KingSpades QueenSpades JackSpades TenSpades");
		assertEquals(8.14,p.getRanking());
	}
	
	public void testRoyalFlush () {
		p = new Player(1,"AceSpades KingSpades QueenSpades JackSpades TenSpades");
		assertEquals(8.14,p.getRanking());
	}
	
	public void testWinningHand () {
		p = new Player(1,"AceSpades AceHearts AceDiamonds AceClubs TwoHearts");
		p2 = new Player(2,"AceSpades KingSpades QueenSpades JackSpades TenSpades");
		assertTrue(p.getRanking() < p2.getRanking());
	}
	
	public void testTwoWinningHands () {
		p = new Player(1,"AceSpades KingSpades QueenSpades JackSpades TenSpades");
		p2 = new Player(2,"AceHearts KingHearts QueenHearts JackHearts TenHearts");
		assertEquals(p.getRanking(), p2.getRanking());
	}
	
}
