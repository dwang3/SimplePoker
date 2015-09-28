package simplepoker.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;

public class Round {
	private static int numPlayers;
	private ArrayList<Player> players;
	
	public Round () {
		players = new ArrayList<Player>();
		numPlayers = 0;
	}
	
	public int getNumPlayers() {
		return players.size();
	}
	
	public ArrayList<Player> getPlayers() {
		return players;
	}
	
	public void addPlayer(int id, String hand) {
		this.players.add(new Player(id, hand));
	}
	
	public void addPlayer() {
		this.players.add(new Player(players.size()));
	}
	
	public boolean isValidRound() {
		return players.size() >= 2 && players.size() <= 4 && !areDuplicateIDs() && !areDuplicateCards();
	}
	
	public boolean areDuplicateIDs() {
		boolean duplicateIDs = false;
		if (players.size() == 0) return false;
		for (int i = 0; i < players.size(); i++) {
			for (int j = i + 1; j < players.size(); j++) {
				if (i != j && players.get(i).getID() == players.get(j).getID())
					duplicateIDs = true;
			}
		}
		return duplicateIDs;
	}
	
	public boolean areDuplicateCards() {
		if (players.size() == 0) return false;
		ArrayList<Card> cardsInPlay = new ArrayList<Card>();
		for (Player p : players) {
			for (Card c : p.getCards()) {
				cardsInPlay.add(c);
			}
		}
		return Card.areDuplicateCards(cardsInPlay);
	}
	
	public String roundResults() {
		//check for all conditions for invalid rounds
		if (!isValidRound()) return "invalid round!\r\n";
		
		int rank = 1;
		int tiedRank = 0;
		
		//rank players in descending order
		Collections.sort(players);
		Collections.reverse(players); 
		
		StringBuilder results = new StringBuilder();
		ListIterator<Player> it = players.listIterator();

		for (int i=0; i<players.size(); i++) {
			results.append(players.get(i).printPlayer() + "Rank: " + rank + "\r\n");
			//check for ties
			if (i>0) {
				if (players.get(i).compareTo(players.get(i-1)) == 0)
					tiedRank++;
				else
					rank++;
			}
			rank += tiedRank;
		}
		return results.toString();
	}
	
	public static void main (String args[]) {
		Round r = new Round();
		r.addPlayer(1,"AceSpades KingSpades QueenSpades JackSpades TenSpades");
		r.addPlayer(2,"TwoDiamonds ThreeDiamonds FourDiamonds FiveDiamonds SixDiamonds");
		r.addPlayer(3,"AceHearts KingHearts QueenHearts JackHearts TenHearts");
		System.out.println(r.roundResults());
	}
	
}
