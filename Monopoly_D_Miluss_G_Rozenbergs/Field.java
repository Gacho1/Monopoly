/**
 * A class representing the basic properties of purchasable fields
 */
package model;

public class Field {
	
	private String name;
	private int price;	
	private boolean isOwned;

	public Field(String name, int price, boolean isOwned) {
		setOwned(isOwned);
		setPrice(price);
		setName(name);
	}
	
	public Field() {
		super();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public boolean isOwned() {
		return isOwned;
	}
	public void setOwned(boolean isOwned) {
		this.isOwned = isOwned;
	}
	
	@Override
	public String toString() {
		return "Field [name=" + name + ", price=" + price + ", isOwned=" + isOwned + "]";
	}	
}
