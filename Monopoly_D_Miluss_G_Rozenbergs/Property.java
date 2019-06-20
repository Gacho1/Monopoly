/**
 * A class representing all of the properties purchasable that are not Utility or Transport
 */
package model;

public class Property extends Field {
	private int propertyID;
	private boolean isHousing;
	private boolean isMonopolised;
	private Color propertyColor;
	private int rentPrice;
	private int rentP1House;
	private int rentP2House;
	private int rentP3House;
	private int rentP4House;
	private int rentPHotel;
	private int sellingPrice;
	private int housePrice;
	private int hotelPrice;
	private int housesBuiltOnProperty;
	private boolean isHotelBuilt;
	private int ownedPlayerID;
	
	public Property() {
		super();
	}
	
	public Property(String name, int price, boolean isOwned, boolean isHousing, boolean isMonopolised,
			Color propertyColor, int rentPrice, int rentP1House, int rentP2House, int rentP3House, int rentP4House,
			int rentPHotel, int housePrice, int propertyID) {
		super(name, price, isOwned);
		setHousing(false);
		setMonopolised(false);
		setPropertyColor(propertyColor);
		setRentPrice(rentPrice);
		setRentP1House(rentP1House);
		setRentP2House(rentP2House);
		setRentP3House(rentP3House);
		setRentP4House(rentP4House);
		setRentPHotel(rentPHotel);
		setSellingPrice(price/2);
		setHousePrice(housePrice);
		setHotelPrice(housePrice);
		setPropertyID(propertyID);
		setHousesBuiltOnProperty(0);
		setHotelBuilt(false);
		setOwnedPlayerID(0);
	}

	public boolean isHousing() {
		return isHousing;
	}

	public void setHousing(boolean isHousing) {
		this.isHousing = isHousing;
	}

	public boolean isMonopolised() {
		return isMonopolised;
	}

	public void setMonopolised(boolean isMonopolised) {
		this.isMonopolised = isMonopolised;
	}

	public Color getPropertyColor() {
		return propertyColor;
	}

	public void setPropertyColor(Color propertyColor) {
		this.propertyColor = propertyColor;
	}

	public int getRentPrice() {
		return rentPrice;
	}

	public void setRentPrice(int rentPrice) {
		this.rentPrice = rentPrice;
	}

	public int getRentP1House() {
		return rentP1House;
	}

	public void setRentP1House(int rentP1House) {
		this.rentP1House = rentP1House;
	}

	public int getRentP2House() {
		return rentP2House;
	}

	public void setRentP2House(int rentP2House) {
		this.rentP2House = rentP2House;
	}

	public int getRentP3House() {
		return rentP3House;
	}

	public void setRentP3House(int rentP3House) {
		this.rentP3House = rentP3House;
	}

	public int getRentP4House() {
		return rentP4House;
	}

	public void setRentP4House(int rentP4House) {
		this.rentP4House = rentP4House;
	}

	public int getRentPHotel() {
		return rentPHotel;
	}

	public void setRentPHotel(int rentPHotel) {
		this.rentPHotel = rentPHotel;
	}

	public int getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(int sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	
	public int getHousePrice() {
		return housePrice;
	}

	public void setHousePrice(int housePrice) {
		this.housePrice = housePrice;
	}

	public int getHotelPrice() {
		return hotelPrice;
	}

	public void setHotelPrice(int hotelPrice) {
		this.hotelPrice = hotelPrice;
	}
	
	public int getPropertyID() {
		return propertyID;
	}

	public void setPropertyID(int propertyID) {
		this.propertyID = propertyID;
	}
	
	public int getHousesBuiltOnProperty() {
		return housesBuiltOnProperty;
	}

	public void setHousesBuiltOnProperty(int housesBuiltOnProperty) {
		this.housesBuiltOnProperty = housesBuiltOnProperty;
	}

	public boolean isHotelBuilt() {
		return isHotelBuilt;
	}

	public void setHotelBuilt(boolean isHotelBuilt) {
		this.isHotelBuilt = isHotelBuilt;
	}
	
	public int getOwnedPlayerID() {
		return ownedPlayerID;
	}

	public void setOwnedPlayerID(int ownedPlayerID) {
		this.ownedPlayerID = ownedPlayerID;
	}

	@Override
	public String toString() {
		return "Property [propertyID=" + propertyID + ", isHousing=" + isHousing + ", isMonopolised=" + isMonopolised
				+ ", propertyColor=" + propertyColor + ", rentPrice=" + rentPrice + ", rentP1House=" + rentP1House
				+ ", rentP2House=" + rentP2House + ", rentP3House=" + rentP3House + ", rentP4House=" + rentP4House
				+ ", rentPHotel=" + rentPHotel + ", sellingPrice=" + sellingPrice + ", housePrice=" + housePrice
				+ ", hotelPrice=" + hotelPrice + ", housesBuiltOnProperty=" + housesBuiltOnProperty + ", isHotelBuilt="
				+ isHotelBuilt + ", ownedPlayerID=" + ownedPlayerID + "]";
	}

}
