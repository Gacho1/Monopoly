package model;

import java.util.ArrayList;

public class CommunityAndChance {
	private String name;
	private String description;
	private int money;
	private boolean receiveMoney;
	private boolean payMoney;
	private boolean isGoToJail;
	private boolean isJailFreeCard;
	private boolean moveSpaces;
	private boolean houseHotelRent;
	private int communityAndChanceID;
	private static int communityAndChanceCounter = 0;
	
	
	
	public CommunityAndChance() {
		super();
	}
	
	public CommunityAndChance(String name, String description, int money, boolean receiveMoney, boolean payMoney,
			boolean isGoToJail, boolean isJailFreeCard, boolean moveSpaces, boolean houseHotelRent) {
		setName(name);
		setDescription(description);
		setMoney(money);
		setReceiveMoney(receiveMoney);
		setPayMoney(payMoney);
		setGoToJail(isGoToJail);
		setJailFreeCard(isJailFreeCard);
		setMoveSpaces(moveSpaces);
		setHouseHotelRent(houseHotelRent);
		communityAndChanceCounter++;
		setCommunityAndChanceID(communityAndChanceCounter);
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public boolean isReceiveMoney() {
		return receiveMoney;
	}

	public void setReceiveMoney(boolean receiveMoney) {
		this.receiveMoney = receiveMoney;
	}

	public boolean isPayMoney() {
		return payMoney;
	}

	public void setPayMoney(boolean payMoney) {
		this.payMoney = payMoney;
	}

	public boolean isGoToJail() {
		return isGoToJail;
	}

	public void setGoToJail(boolean isGoToJail) {
		this.isGoToJail = isGoToJail;
	}

	public boolean isJailFreeCard() {
		return isJailFreeCard;
	}

	public void setJailFreeCard(boolean isJailFreeCard) {
		this.isJailFreeCard = isJailFreeCard;
	}

	public boolean isMoveSpaces() {
		return moveSpaces;
	}

	public void setMoveSpaces(boolean moveSpaces) {
		this.moveSpaces = moveSpaces;
	}
	
	public boolean isHouseHotelRent() {
		return houseHotelRent;
	}

	public void setHouseHotelRent(boolean houseHotelRent) {
		this.houseHotelRent = houseHotelRent;
	}

	public int getCommunityAndChanceID() {
		return communityAndChanceID;
	}

	public void setCommunityAndChanceID(int communityAndChanceID) {
		this.communityAndChanceID = communityAndChanceID;
	}

	
	
	@Override
	public String toString() {
		return "CommunityAndChance [name=" + name + ", description=" + description + ", money=" + money
				+ ", receiveMoney=" + receiveMoney + ", payMoney=" + payMoney + ", isGoToJail=" + isGoToJail
				+ ", isJailFreeCard=" + isJailFreeCard + ", moveSpaces=" + moveSpaces + ", houseHotelRent="
				+ houseHotelRent + ", communityAndChanceID=" + communityAndChanceID + "]";
	}

	public void receiveMoney (Player player, int amountOfMoney) {
		player.setMoney(player.getMoney() + amountOfMoney);
		//System.out.println(player.getName() + " money: " +player.getMoney());
	}
	
	public void payMoney (Player player, int amountofMoney) {
		player.setMoney(player.getMoney() - amountofMoney);
		System.out.println(player.getName() + " money: " +player.getMoney());
	}
	public void receiveMoneyFromEveryone (Player player, ArrayList<Player> allPlayers, int amountOfMoney) {
		player.setMoney(player.getMoney() + amountOfMoney * (allPlayers.size() - 1));
		System.out.println(player.getName() + " money: " +player.getMoney());
		
		for (int i = 0; i < allPlayers.size(); i++) {
			if (allPlayers.get(i).getPlayerID() != player.getPlayerID()) {
				allPlayers.get(i).setMoney(allPlayers.get(i).getMoney() - amountOfMoney);
				System.out.println(allPlayers.get(i).getName() + " money: " + allPlayers.get(i).getMoney());
			}
		}
	}
	public void goToStart (Player player) {
		player.setRollCounter(0);
		player.setMoney(player.getMoney() + 200);
		System.out.println(player.getName() + " money: " +player.getMoney());
	}
	public void goToJail (Player player) {
		player.setRollCounter(10);
		player.setJailed(true);
	}
	public void jailFreeCard (Player player) {
		player.setJailFreeCard(player.getJailFreeCard() + 1);
	}
	public void streetRepairs (Player player, int housePrice) {
		int hotelPrice = (housePrice * 3) - 5;
		player.setMoney(player.getMoney() - housePrice * player.getHousesOwned() - hotelPrice * player.getHotelsOwned());
	}
	
	public void payEveryOneMoney (Player player, ArrayList<Player> allPlayers, int amountOfMoney) {
		player.setMoney(player.getMoney() - amountOfMoney * (allPlayers.size() - 1));
		System.out.println(player.getName() + " money: " +player.getMoney());
		
		for (int i = 0; i < allPlayers.size(); i++) {
			if (allPlayers.get(i).getPlayerID() != player.getPlayerID()) {
				allPlayers.get(i).setMoney(allPlayers.get(i).getMoney() + amountOfMoney);
				System.out.println(allPlayers.get(i).getName() + " money: " + allPlayers.get(i).getMoney());
			}
		}
	}
	/*public void advanceToUtility (Player player, ArrayList<Utility> allUtilities, ArrayList<Player> allPlayers) {
		if (player.getRollCounter() == 22) {
			for (Utility utility : allUtilities) {
				if (utility.getUtilityID() > player.getRollCounter()) {
					player.setRollCounter(utility.getUtilityID());
					if (utility.isOwned() == true) {
						for (int i = 0; i < allPlayers.size(); i++) {
							for (int j = 0; j < allPlayers.get(i).getUtilitiesOwned().size(); j++) {
								if (allPlayers.get(i).getUtilitiesOwned().get(j).getUtilityID() == utility.getUtilityID()) {
									
								}
							}
						}
					}
				}
			}
		}
	}*/
	public void goBack3Fields (Player player) {
		player.setRollCounter(player.getRollCounter() - 3);
	}
}
