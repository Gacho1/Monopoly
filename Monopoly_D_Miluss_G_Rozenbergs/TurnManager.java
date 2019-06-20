/**
 * A class used for player turn management
 */
package model;

import java.util.ArrayList;

public class TurnManager {
	private ArrayList<Player> playersList;
	private int currentPlayerID = 0;
	
	
	public TurnManager(ArrayList<Player> playersList) {
		super();
		this.playersList = playersList;
	}

	public ArrayList<Player> getPlayersList() {
		return playersList;
	}

	public void setPlayersList(ArrayList<Player> playersList) {
		this.playersList = playersList;
	}
	
	public int getCurrentPlayerID() {
		return currentPlayerID;
	}

	public void setCurrentPlayerID(int currentPlayerID) {
		this.currentPlayerID = currentPlayerID;
	}
	/**
	 * this is used to determine the active players id
	 * @return active players ID
	 */
	public Player current() {
		return playersList.get(currentPlayerID);
	}
	/**
	 * switches to the next player in the ArrayList
	 * @return active players ID
	 */
	public Player next() {
		currentPlayerID++;
		return playersList.get(currentPlayerID);
	}
	/**
	 * Goes to first player, once the last player ends his turn
	 * @return active players ID
	 */
	public Player reset() {
		
			currentPlayerID = 0;
			return playersList.get(currentPlayerID);
		}
		
	}
