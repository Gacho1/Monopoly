/**
 * A class that represents the two tax tiles on the field  
 */
package model;

public class Taxes {
	private String name;
	private int taxPrice;
	private int taxID;
	
	
	public Taxes() {
		super();
	}
	
	public Taxes(String name, int taxPrice, int taxID) {
		setName(name);
		setTaxPrice(taxPrice);
		setTaxID(taxID);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTaxPrice() {
		return taxPrice;
	}
	public void setTaxPrice(int taxPrice) {
		this.taxPrice = taxPrice;
	}
	public int getTaxID() {
		return taxID;
	}
	public void setTaxID(int taxID) {
		this.taxID = taxID;
	}
	
	@Override
	public String toString() {
		return "Taxes [name=" + name + ", taxPrice=" + taxPrice + ", taxID=" + taxID + "]";
	}
	/**
	 * A function that takes the apropriate ammount of money from player for landing on a tax field 
	 * @param player The current player whos turn it is
	 * @param taxAmount The amount that gets deducted
	 */
	public void payTax (Player player, int taxAmount) {
		player.setMoney(player.getMoney() - taxAmount);
		System.out.println("You had to pay " + taxAmount + " in tax");
		System.out.println(player.getName() + " money: " +player.getMoney());
	}
	
}
