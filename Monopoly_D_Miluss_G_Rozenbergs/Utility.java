/**
 * A class that represents the two utility tiles on the board
 */

package model;

public class Utility extends Field {
	private int rent;
	private int sellingPrice;
	private int utilityID;
	private int ownedPlayerID;
	
	public Utility() {
		super();
	}

	public Utility(String name, int price, boolean isOwned, int utilityID) {
		super(name, price, isOwned);
		setSellingPrice(price / 2);
		setUtilityID(utilityID);
		setOwnedPlayerID(0);
	}

	public int getRent() {
		return rent;
	}

	public void setRent(int rent) {
		this.rent = rent;
	}

	public int getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(int sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public int getUtilityID() {
		return utilityID;
	}

	public void setUtilityID(int utilityID) {
		this.utilityID = utilityID;
	}
	
	public int getOwnedPlayerID() {
		return ownedPlayerID;
	}

	public void setOwnedPlayerID(int ownedPlayerID) {
		this.ownedPlayerID = ownedPlayerID;
	}

	@Override
	public String toString() {
		return "Utility [rent=" + rent + ", sellingPrice=" + sellingPrice + ", utilityID=" + utilityID
				+ ", ownedPlayerID=" + ownedPlayerID + "]";
	}
	
}
