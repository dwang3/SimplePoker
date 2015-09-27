package simplepoker.game;

public class Player {
	private int playerID;
	private Hand hand;
	
	public int getID() {
		return playerID;
	}
	
	/* player IDs will auto increment starting from 0
	 * valid player IDs are 0, 1, 2 or 3
	 */
	public Player (int id) {
		playerID = id;
	}
}
