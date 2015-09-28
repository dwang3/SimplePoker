package simplepoker.game;
import junit.framework.*;

public class TestRound extends TestCase {
	public TestRound (String name) {
		super (name);
	}
	
	private Round r;
	
	public void testRound1 () {
		r = new Round();
		r.addPlayer(1,"AceSpades KingSpades QueenSpades JackSpades TenSpades");
		r.addPlayer(2,"NineSpades NineHearts NineDiamonds NineClubs FourSpades");
		r.addPlayer(3,"TwoDiamonds ThreeDiamonds FourDiamonds FiveDiamonds SixDiamonds");
		r.addPlayer(4,"ThreeClubs FiveSpades FiveClubs FiveHearts FourHearts");
		System.out.println(r.roundResults());
	}
	
	public void testRoundTie () {
		r = new Round();
		r.addPlayer(1,"AceSpades KingSpades QueenSpades JackSpades TenSpades");
		r.addPlayer(2,"AceHearts KingHearts QueenHearts JackHearts TenHearts");
		r.addPlayer(3,"TwoDiamonds ThreeDiamonds FourDiamonds FiveDiamonds SixDiamonds");
		System.out.println(r.roundResults());
	}
	
	public void testRoundInvalid() {
		r = new Round();
		r.addPlayer(1,"AceSpades KingSpades QueenSpades JackSpades TenSpades");
		r.addPlayer(2,"NineSpades NineHearts NineDiamonds NineClubs FourSpades");
		r.addPlayer(3,"AceSpades KingSpades QueenSpades JackSpades TenSpades");
		System.out.println(r.roundResults());
	}
}
