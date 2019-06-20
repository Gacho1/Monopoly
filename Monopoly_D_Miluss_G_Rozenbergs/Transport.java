/**
 * A class that represents the four transport tiles on the board
 */

package model;

public class Transport extends Field {
	private int transportID;
	private int rent1P;
	private int rent2P;
	private int rent3P;
	private int rent4P;
	private int sellingPrice;
	private int ownedPlayerID;
	
	public Transport() {
		super();
	}
	public Transport(String name, int price, boolean isOwned, int rent1p, int transportID) {
		super(name, price, isOwned);
		this.transportID = transportID;
		setRent1P(rent1p);
		setRent2P(rent1p * 2);
		setRent3P(rent2P * 2);
		setRent4P(rent3P * 2);
		setSellingPrice(price / 2);
		setOwnedPlayerID(0);
	}
	public int getTransportID() {
		return transportID;
	}
	public void setTransportID(int transportID) {
		this.transportID = transportID;
	}
	public int getRent1P() {
		return rent1P;
	}
	public void setRent1P(int rent1p) {
		rent1P = rent1p;
	}
	public int getRent2P() {
		return rent2P;
	}
	public void setRent2P(int rent2p) {
		rent2P = rent2p;
	}
	public int getRent3P() {
		return rent3P;
	}
	public void setRent3P(int rent3p) {
		rent3P = rent3p;
	}
	public int getRent4P() {
		return rent4P;
	}
	public void setRent4P(int rent4p) {
		rent4P = rent4p;
	}
	public int getSellingPrice() {
		return sellingPrice;
	}
	public void setSellingPrice(int sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	
	public int getOwnedPlayerID() {
		return ownedPlayerID;
	}
	public void setOwnedPlayerID(int ownedPlayerID) {
		this.ownedPlayerID = ownedPlayerID;
	}
	
	@Override
	public String toString() {
		return "Transport [transportID=" + transportID + ", rent1P=" + rent1P + ", rent2P=" + rent2P + ", rent3P="
				+ rent3P + ", rent4P=" + rent4P + ", sellingPrice=" + sellingPrice + ", ownedPlayerID=" + ownedPlayerID
				+ "]";
	}

}
