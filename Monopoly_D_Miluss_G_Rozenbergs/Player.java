package model;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.util.Pair;
import main.Main;

public class Player {
	private int playerID;
	private static int playerCounter = 0;
	private String name;
	private ImageView boardPiece;
	private int money;
	private double x_onBoard;
	private double y_onBoard;
	private int rollCounter;
	private boolean isJailed;
	private int jailFreeCard;
	private int brownP;
	private int cyanP;
	private int magentaP;
	private int orangeP;
	private int redP;
	private int yellowP;
	private int greenP;
	private int blueP;
	private int transportP;
	private int utilityP;
	private ArrayList<Property> propertiesOwned = new ArrayList<>();
	private ArrayList<Utility> utilitiesOwned = new ArrayList<Utility>();
	private ArrayList<Transport> transportOwned = new ArrayList<>();
	private int housesOwned;
	private int hotelsOwned;
	
	
	public Player() {
		super();
	}
	
	
	
	public Player(String name, ImageView boardPiece) {
		super();
		setName(name);
		setBoardPiece(boardPiece);
		setMoney(1500);
		setX_onBoard(1385);
		setY_onBoard(700);
		setRollCounter(0);
		setJailed(false);
		setJailFreeCard(0);
		setBrownP(0);
		setCyanP(0);
		setMagentaP(0);
		setOrangeP(0);
		setRedP(0);
		setYellowP(0);
		setGreenP(0);
		setBlueP(0);
		setTransportP(0);
		setUtilityP(0);
		setHousesOwned(0);
		setHotelsOwned(0);
		setPropertiesOwned(propertiesOwned);
		setUtilitiesOwned(utilitiesOwned);
		setTransportOwned(transportOwned);
		playerCounter++;
		playerID = playerCounter;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ImageView getBoardPiece() {
		return boardPiece;
	}
	public void setBoardPiece(ImageView boardPiece) {
		this.boardPiece = boardPiece;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public double getX_onBoard() {
		return x_onBoard;
	}
	public void setX_onBoard(double x_onBoard) {
		this.x_onBoard = x_onBoard;
	}
	public double getY_onBoard() {
		return y_onBoard;
	}
	public void setY_onBoard(double y_onBoard) {
		this.y_onBoard = y_onBoard;
	}
	public int getRollCounter() {
		return rollCounter;
	}
	public void setRollCounter(int rollCounter) {
		this.rollCounter = rollCounter;
	}
	public boolean isJailed() {
		return isJailed;
	}
	public void setJailed(boolean isJailed) {
		this.isJailed = isJailed;
	}
	public int getBrownP() {
		return brownP;
	}
	public void setBrownP(int brownP) {
		this.brownP = brownP;
	}
	public int getCyanP() {
		return cyanP;
	}
	public void setCyanP(int cyanP) {
		this.cyanP = cyanP;
	}
	public int getMagentaP() {
		return magentaP;
	}
	public void setMagentaP(int magentaP) {
		this.magentaP = magentaP;
	}
	public int getOrangeP() {
		return orangeP;
	}
	public void setOrangeP(int orangeP) {
		this.orangeP = orangeP;
	}
	public int getRedP() {
		return redP;
	}
	public void setRedP(int redP) {
		this.redP = redP;
	}
	public int getYellowP() {
		return yellowP;
	}
	public void setYellowP(int yellowP) {
		this.yellowP = yellowP;
	}
	public int getGreenP() {
		return greenP;
	}
	public void setGreenP(int greenP) {
		this.greenP = greenP;
	}
	public int getBlueP() {
		return blueP;
	}
	public void setBlueP(int blueP) {
		this.blueP = blueP;
	}
	public int getTransportP() {
		return transportP;
	}
	public void setTransportP(int transportP) {
		this.transportP = transportP;
	}
	public int getUtilityP() {
		return utilityP;
	}
	public void setUtilityP(int utilityP) {
		this.utilityP = utilityP;
	}

	public int getPlayerID() {
		return playerID;
	}

	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}

	public ArrayList<Property> getPropertiesOwned() {
		return propertiesOwned;
	}

	public void setPropertiesOwned(ArrayList<Property> propertiesOwned) {
		this.propertiesOwned = propertiesOwned;
	}

	public ArrayList<Utility> getUtilitiesOwned() {
		return utilitiesOwned;
	}

	public void setUtilitiesOwned(ArrayList<Utility> utilitiesOwned) {
		this.utilitiesOwned = utilitiesOwned;
	}

	public ArrayList<Transport> getTransportOwned() {
		return transportOwned;
	}

	public void setTransportOwned(ArrayList<Transport> transportOwned) {
		this.transportOwned = transportOwned;
	}
	
	public int getJailFreeCard() {
		return jailFreeCard;
	}
	
	public void setJailFreeCard(int JailFreeCard) {
		this.jailFreeCard = JailFreeCard;
	}
	
	public int getHousesOwned() {
		return housesOwned;
	}

	public void setHousesOwned(int housesOwned) {
		this.housesOwned = housesOwned;
	}

	public int getHotelsOwned() {
		return hotelsOwned;
	}

	public void setHotelsOwned(int hotelsOwned) {
		this.hotelsOwned = hotelsOwned;
	}



	
	@Override
	public String toString() {
		return "Player"+playerID + ": " + name;
	}



	public void isInJail (Player player) {

		int getOutOfJailFine = 50;
		
		//For Java 9 and up... Possible way to stop exiting full screen
		//List<Window> open = Stage.getWindowOwner().filtered(window -> window.isShowing());
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		
		alert.setTitle("Jail");
		alert.setHeaderText("You can choose one of the options to get out of jail!");
		alert.setContentText("Choose your option.");
		alert.getModality();
		alert.getOwner();
		alert.initModality(Modality.WINDOW_MODAL);
		System.out.println(alert.getOwner());
		
	
		
			
		ButtonType buttonTypeOne = new ButtonType("Pay 50 Ventus");
		ButtonType buttonTypeTwo = new ButtonType("Use 'Get Out Of Jail' card");
		ButtonType buttonTypeThree = new ButtonType("Roll Dice", ButtonData.CANCEL_CLOSE);
		
	
		
		alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeThree);
		
		
	
		
		
		if (player.getJailFreeCard() == 0) {
			alert.getDialogPane().lookupButton(buttonTypeTwo).setDisable(true);
		}

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == buttonTypeOne){
		    // ... user chose "One"
			player.setMoney(player.getMoney() - getOutOfJailFine);
			player.setJailed(false);
			System.out.println(player.getName() + " money: " + player.getMoney());
		} else if (result.get() == buttonTypeTwo) {
		    // ... user chose "Two"
			if (player.getJailFreeCard() >= 1) {
				player.setJailFreeCard(player.getJailFreeCard() - 1);
				player.setJailed(false);
			}
			
		
		}

	}
	
	public void sellProperty(Player player, ArrayList<Property> allProperties, ArrayList<Utility> allUtilities, ArrayList<Transport> allTransport) {

		Dialog dialog = new Dialog<>();
		dialog.setTitle("Property Overview");
		dialog.setHeaderText("Manage your properties here!");
		
		ButtonType sellButton = new ButtonType("Sell.");
		ComboBox chooseProperty = new ComboBox<>();
		Label l1 = new Label("Choose one of your property.");
		
		HBox hbox = new HBox(chooseProperty);
		
		
		for (int i = 0; i < player.getPropertiesOwned().size(); i++) {
			chooseProperty.getItems().add(player.getPropertiesOwned().get(i).getName());
		}
		for (int i = 0; i < player.getUtilitiesOwned().size(); i++) {
			chooseProperty.getItems().add(player.getUtilitiesOwned().get(i).getName());
		}
		for (int i = 0; i < player.getTransportOwned().size(); i++) {
			chooseProperty.getItems().add(player.getTransportOwned().get(i).getName());
		}
		
		dialog.getDialogPane().getButtonTypes().addAll(sellButton, ButtonType.CANCEL);
		
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(100, 150, 10, 10));
		
		grid.getChildren().add(hbox);
		grid.getChildren().add(l1);
		hbox.setTranslateX(120);
		hbox.setTranslateY(-50);
		l1.setTranslateX(120);
		l1.setTranslateY(-90);
		
		dialog.getDialogPane().setContent(grid);
		
		Optional result = dialog.showAndWait();
		
		if (result.get() == sellButton){
		    
			System.out.println(chooseProperty.getSelectionModel().getSelectedItem());
			
			for (Property property : player.getPropertiesOwned()) {
				if (chooseProperty.getSelectionModel().getSelectedItem() == property.getName()) {
					
					player.getPropertiesOwned().remove(property);
					player.setMoney(player.getMoney() + property.getSellingPrice());
					if (property.getPropertyColor() == model.Color.Brown) {
						player.setBrownP(player.getBrownP() - 1);
					}
					else if (property.getPropertyColor() == model.Color.Cyan) {
						player.setCyanP(player.getCyanP() - 1);
					}
					else if (property.getPropertyColor() == model.Color.Magenta) {
						player.setMagentaP(player.getMagentaP() - 1);
					}
					else if (property.getPropertyColor() == model.Color.Orange) {
						player.setOrangeP(player.getOrangeP() - 1);
					}
					else if (property.getPropertyColor() == model.Color.Red) {
						player.setRedP(player.getRedP() - 1);
					}
					else if (property.getPropertyColor() == model.Color.Yellow) {
						player.setYellowP(player.getYellowP() - 1);
					}
					else if (property.getPropertyColor() == model.Color.Green) {
						player.setGreenP(player.getGreenP() - 1);
					}
					else if (property.getPropertyColor() == model.Color.Blue) {
						player.setBlueP(player.getBlueP() - 1);
					}
					
					
					allProperties.get(allProperties.indexOf(property)).setOwned(false);
					System.out.println("You sold " + property.getName() + " for " + property.getSellingPrice() +  " Venti");
					
					break;
				}
			
				
			}
			for (Utility utility : player.getUtilitiesOwned()) {
				if (chooseProperty.getSelectionModel().getSelectedItem() == utility.getName()) {
					
					player.getUtilitiesOwned().remove(utility);
					player.setMoney(player.getMoney() + utility.getSellingPrice());
					player.setUtilityP(player.getUtilityP() - 1);
					
					allUtilities.get(allUtilities.indexOf(utility)).setOwned(false);
					System.out.println("You sold " + utility.getName() + " for " + utility.getSellingPrice() +  " Venti");
					
					break;
				}
			
				
			}
			for (Transport transport : player.getTransportOwned()) {
				if (chooseProperty.getSelectionModel().getSelectedItem() == transport.getName()) {
					
					player.getTransportOwned().remove(transport);
					player.setMoney(player.getMoney() + transport.getSellingPrice());
					player.setTransportP(player.getTransportP() - 1);
					
					allTransport.get(allTransport.indexOf(transport)).setOwned(false);
					System.out.println("You sold " + transport.getName() + " for " + transport.getSellingPrice() +  " Venti");
					
					break;
				}
			
				
			}
			
			
		} 
	}
	public boolean payRent (Player player, ArrayList<Player> allPlayerList, Property property, Utility utility, Transport transport, int diceResult) {
		if (utility == null && transport == null) {
			for (int i = 0; i < allPlayerList.size(); i++) {
				if (allPlayerList.get(i).getPlayerID() == property.getOwnedPlayerID()) {
					if (property.isMonopolised()) {
					
						if (player.getMoney() - property.getRentPrice() * 2 < 0) {
							System.out.println("You don't have enough money!");
							
							return false;
						}
						else {
							player.setMoney(player.getMoney() - property.getRentPrice() * 2);
							allPlayerList.get(i).setMoney(allPlayerList.get(i).getMoney() + property.getRentPrice() * 2);
							System.out.println("You paid " + property.getRentPrice() * 2 + " to " + allPlayerList.get(i).getName());
							return true;
						}
					}
					else {
					
						if (player.getMoney() - property.getRentPrice() < 0) {
							System.out.println("You don't have enough money to pay rent!");
							if (player.Bankruptcy(player, property.getRentPrice())) {
								allPlayerList.remove(player);
							}
							return false;
						}
						else {
							allPlayerList.get(i).setMoney(allPlayerList.get(i).getMoney() + property.getRentPrice());
							player.setMoney(player.getMoney() - property.getRentPrice());
							System.out.println("You paid " + property.getRentPrice() + " Ventus to " + allPlayerList.get(i).getName());
							return true;
						}
					}
				}
			}
		}
		if (property == null && transport == null) {
			for (int i = 0; i < allPlayerList.size(); i++) {
				if (allPlayerList.get(i).getPlayerID() == utility.getOwnedPlayerID()) {
				
					if (allPlayerList.get(i).getUtilityP() == 1) {
						
						if (player.getMoney() - diceResult * 4 < 0) {
							System.out.println("You don't have enough money to pay rent!");
							return false;
						}
						else {
							allPlayerList.get(i).setMoney(allPlayerList.get(i).getMoney() + diceResult * 4);
							player.setMoney(player.getMoney() - diceResult * 4);
							System.out.println("You paid " + diceResult * 4 + " Ventus to " + allPlayerList.get(i).getName());
							return true;
						}
						
						
					}
					else  {
						if (player.getMoney() - diceResult * 10 < 0) {
							System.out.println("You don't have enough money to pay rent!");
							return false;
						}
						else {
							allPlayerList.get(i).setMoney(allPlayerList.get(i).getMoney() + diceResult * 10);
							player.setMoney(player.getMoney() - diceResult * 10);
							System.out.println("You paid " + diceResult * 10 + " Ventus to " + allPlayerList.get(i).getName());
							return true;
						}
					}
					
					
				}
			}
		}
		if ( property == null && utility == null) {
			for (int i = 0; i < allPlayerList.size(); i++) {
				if (allPlayerList.get(i).getPlayerID() == transport.getOwnedPlayerID()) {
					if (allPlayerList.get(i).getTransportP() == 1) {
						
						if (player.getMoney() - transport.getRent1P() < 0) {
							System.out.println("You don't have enough money to pay rent!");
							return false;
						}
						else {
							allPlayerList.get(i).setMoney(allPlayerList.get(i).getMoney() + transport.getRent1P());
							player.setMoney(player.getMoney() - transport.getRent1P());
							System.out.println("You paid " + transport.getRent1P() + " Ventus to " + allPlayerList.get(i).getName());
							return true;
						}
					}
					else if (allPlayerList.get(i).getTransportP() == 2) {
						
						if (player.getMoney() - transport.getRent2P() < 0) {
							System.out.println("You don't have enough money to pay rent!");
							return false;
						}
						else {
							allPlayerList.get(i).setMoney(allPlayerList.get(i).getMoney() + transport.getRent2P());
							player.setMoney(player.getMoney() - transport.getRent2P());
							System.out.println("You paid " + transport.getRent2P() + " Ventus to " + allPlayerList.get(i).getName());
							return true;
						}
					}
					else if (allPlayerList.get(i).getTransportP() == 3) {
						
						if (player.getMoney() - transport.getRent3P() < 0) {
							System.out.println("You don't have enough money to pay rent!");
							return false;
						}
						else {
							allPlayerList.get(i).setMoney(allPlayerList.get(i).getMoney() + transport.getRent3P());
							player.setMoney(player.getMoney() - transport.getRent3P());
							System.out.println("You paid " + transport.getRent3P() + " Ventus to " + allPlayerList.get(i).getName());
							return true;
						}
					}
					else if (allPlayerList.get(i).getTransportP() == 4) {
						
						if (player.getMoney() - transport.getRent4P() < 0) {
							System.out.println("You don't have enough money to pay rent!");
							return false;
						}
						else {
							allPlayerList.get(i).setMoney(allPlayerList.get(i).getMoney() + transport.getRent4P());
							player.setMoney(player.getMoney() - transport.getRent4P());
							System.out.println("You paid " + transport.getRent4P() + " Ventus to " + allPlayerList.get(i).getName());
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	public boolean Bankruptcy (Player player, int rentPrice) {
		if (player.getMoney() - rentPrice <= 0 && player.getPropertiesOwned().size() == 0 && player.getUtilitiesOwned().size() == 0 && player.getTransportOwned().size() == 0) {
			
			return true;
		}
		else {
			return false;
		}
	}
}
