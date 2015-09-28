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
	
	public void addPlayer(int id, String hand) {
		this.players.add(new Player(id, hand));
		numPlayers ++;
	}
	
	public void addPlayer() {
		this.players.add(new Player(numPlayers ++));
	}
	
	public boolean isValidRound() {
		return numPlayers >= 2 && numPlayers <= 4;
	}
	
	public static void main (String args[]) {
		
	}
	
}
