package simplepoker.game;

import java.util.ArrayList;

public class Round {
	private static int numPlayers;
	private ArrayList<Player> players;
	
	public Round () {
		players = new ArrayList<Player>();
		numPlayers = 0;
	}
	
	public int getNumPlayers() {
		return numPlayers;
	}
	
	public ArrayList<Player> getPlayers() {
		return players;
	}
	
	public void addPlayer() {
		players.add(new Player(numPlayers++));
	}
	
	public void addPlayer(int id) {
		players.add(new Player(id));
	}
	
	public boolean isValidRound() {
		if (numPlayers >= 2 && numPlayers <= 4)
			return true;
		else
		    return false;
	}
	
	public static void main (String args[]) {
		
	}
	
}
