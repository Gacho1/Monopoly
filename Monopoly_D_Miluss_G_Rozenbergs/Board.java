/**
 * This is the class in which the game takes place
 */
package model;

import java.util.ArrayList;
import java.util.Random;
import org.controlsfx.control.Notifications;
import java.io.PrintStream;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextAreaBuilder;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;

@SuppressWarnings("deprecation")
public class Board {
	private PlayerCreation plcr1 = new PlayerCreation();
	private final GridPane grid;
	private Dice dice, dice2;
	private TurnManager turnManager;
	
	private ArrayList<ImageView> allFiguresOnField = new ArrayList<ImageView> ();
	
	private ArrayList<Property> boardProperties = new ArrayList<>();
	private ArrayList<Corner> allCorners = new ArrayList<Corner>();
	private ArrayList<Taxes> allTaxes = new ArrayList<Taxes>();
	private ArrayList<Transport> allTransport = new ArrayList<Transport>();
	private ArrayList<Utility> allUtilities = new ArrayList<Utility>();
	private ArrayList<CommunityAndChance> allCommunityChestCards = new ArrayList<CommunityAndChance>();
	private ArrayList<CommunityAndChance> AllChanceCards = new ArrayList<CommunityAndChance>();
	private int timesRolledInJail = 0;
	private int turnsInJail = 0;
	private int turns = 1;
	private int tresult;
	private int result;
	private int result2;
	private int xCoord[] = {1385, 1293, 1201, 1109, 1017, 925, 833, 741, 649, 557, 465, 465, 465, 465, 465, 465, 465, 465, 465, 465,  465,  557,  649,  741,  833,  925, 1017, 
							1109, 1201, 1293, 1385, 1385, 1385, 1385,  1385, 1385, 1385, 1385, 1385, 1385};
	private int yCoord[] = {700,  700,  700,  700,  700,  700, 700, 700, 700, 700, 700, 608, 516, 424, 332, 240, 148, 56, -36, -128, -220, -220, -220, -220, -220, -220, -220, 
							-220, -220, -220, -220, -128,  -36,   56,   148,  240,  332,  424,  516,  608};
	private Label playerLabel;
	private Label moneyLabel;
	private Label turnLabel; 
	private Label jailFreeLabel;
	private Label transportLabel;
	private Label utilityLabel;
	
	private Label brownLabel;
	private Label cyanLabel;
	private Label magentaLabel;
	private Label orangeLabel;
	private Label redLabel;
	private Label yellowLabel;
	private Label greenLabel;
	private Label blueLabel;
	
	public PlayerCreation getPlcr1() {
		return plcr1;
	}


	public Board() {
		grid = new GridPane();
		dice = new Dice();
		dice2 = new Dice();
		turnManager = new TurnManager(plcr1.getAllPlayerList());
		
		//All of the buttons
		Button roll = new Button("Roll");
		Button endTurn = new Button("End Turn");
		Button buyProperty = new Button("Buy Property");
		Button sellProperty = new Button("Manage Properties");
		Button payRent = new Button("Pay Rent");
		Button startGame = new Button ("Start Game");
		
		//Coordinates for the buttons
		roll.setTranslateX(1507);
		roll.setTranslateY(0);
		roll.setMinWidth(213);
		roll.setMinHeight(50);
		roll.setDisable(true);
		endTurn.setTranslateX(1507);
		endTurn.setTranslateY(50);
		endTurn.setMinWidth(213);
		endTurn.setMinHeight(50);
		endTurn.setDisable(true);
		buyProperty.setTranslateX(1507);
		buyProperty.setTranslateY(100);
		buyProperty.setMinWidth(213);
		buyProperty.setMinHeight(50);
		buyProperty.setDisable(true);
		sellProperty.setTranslateX(1507);
		sellProperty.setTranslateY(150);
		sellProperty.setMinWidth(213);
		sellProperty.setMinHeight(50);
		sellProperty.setDisable(true);
		payRent.setTranslateX(1507);
		payRent.setTranslateY(200);
		payRent.setMinWidth(213);
		payRent.setMinHeight(50);
		payRent.setDisable(true);
		startGame.setMinHeight(100);
		startGame.setMinWidth(200);
		startGame.setTranslateX(870);
		startGame.setTranslateY(220);
		
		//A faded looking background
		grid.setStyle(
	            "-fx-background-image: url(" +
	                    "'file:FadeBCG.jpg'" +
	                "); " +
	                "-fx-background-size: cover, auto;"	  	                
	                );
		
		grid.getChildren().add(startGame);
		//Initialization button, that brings all of the objects to the board
		startGame.setOnMouseClicked(e -> {
		//The actual background
			grid.setStyle(
	            "-fx-background-image: url(" +
	                    "'file:GameBCG.jpg'" +
	                "); " +
	                "-fx-background-size: cover, auto;"
	                );
		
		   grid.getChildren().remove(startGame);
		   
			playerLabel = new Label("Player: " + turnManager.current().getName());
			playerLabel.setFont(Font.loadFont("file:MONOPOLY_INLINE.ttf",30));
			playerLabel.setTextFill(Color.BLACK);
			playerLabel.setTranslateY(-280);
			playerLabel.setTranslateX(10);
			grid.getChildren().add(playerLabel);
			
			moneyLabel = new Label("Money: " + turnManager.current().getMoney());
			moneyLabel.setFont(Font.loadFont("file:MONOPOLY_INLINE.ttf",30));
			moneyLabel.setTextFill(Color.BLACK);
			moneyLabel.setTranslateY(-250);
			moneyLabel.setTranslateX(10);
			grid.getChildren().add(moneyLabel);
			
			turnLabel = new Label("Turn: " + turns);
			turnLabel.setFont(Font.loadFont("file:MONOPOLY_INLINE.ttf",30));
			turnLabel.setTextFill(Color.BLACK);
			turnLabel.setTranslateY(-220);
			turnLabel.setTranslateX(10);
			grid.getChildren().add(turnLabel);
			
			jailFreeLabel = new Label("GJFC: NO" );
			jailFreeLabel.setFont(Font.loadFont("file:MONOPOLY_INLINE.ttf",30));
			jailFreeLabel.setTextFill(Color.BLACK);
			jailFreeLabel.setTranslateY(-280);
			jailFreeLabel.setTranslateX(260);
			grid.getChildren().add(jailFreeLabel);
			
			transportLabel = new Label("Transport: " + turnManager.current().getTransportP() );
			transportLabel.setFont(Font.loadFont("file:MONOPOLY_INLINE.ttf",30));
			transportLabel.setTextFill(Color.BLACK);
			transportLabel.setTranslateY(-250);
			transportLabel.setTranslateX(260);
			grid.getChildren().add(transportLabel);
			
			utilityLabel = new Label("Utility: " + turnManager.current().getUtilityP() );
			utilityLabel.setFont(Font.loadFont("file:MONOPOLY_INLINE.ttf",30));
			utilityLabel.setTextFill(Color.BLACK);
			utilityLabel.setTranslateY(-220);
			utilityLabel.setTranslateX(260);
			grid.getChildren().add(utilityLabel);
			
			brownLabel = new Label("" + turnManager.current().getBrownP() );
			brownLabel.setFont(Font.loadFont("file:MONOPOLY_INLINE.ttf",60));
			brownLabel.setTextFill(Color.BLACK);
			brownLabel.setTranslateY(-40);
			brownLabel.setTranslateX(100);
			grid.getChildren().add(brownLabel);
		   
			cyanLabel = new Label("" + turnManager.current().getCyanP() );
			cyanLabel.setFont(Font.loadFont("file:MONOPOLY_INLINE.ttf",60));
			cyanLabel.setTextFill(Color.BLACK);
			cyanLabel.setTranslateY(-40);
			cyanLabel.setTranslateX(280);
			grid.getChildren().add(cyanLabel);
			
			magentaLabel = new Label("" + turnManager.current().getMagentaP() );
			magentaLabel.setFont(Font.loadFont("file:MONOPOLY_INLINE.ttf",60));
			magentaLabel.setTextFill(Color.BLACK);
			magentaLabel.setTranslateY(180);
			magentaLabel.setTranslateX(100);
			grid.getChildren().add(magentaLabel);
			
			orangeLabel = new Label("" + turnManager.current().getOrangeP() );
			orangeLabel.setFont(Font.loadFont("file:MONOPOLY_INLINE.ttf",60));
			orangeLabel.setTextFill(Color.BLACK);
			orangeLabel.setTranslateY(180);
			orangeLabel.setTranslateX(280);
			grid.getChildren().add(orangeLabel);
			
			redLabel = new Label("" + turnManager.current().getRedP());
			redLabel.setFont(Font.loadFont("file:MONOPOLY_INLINE.ttf",60));
			redLabel.setTextFill(Color.BLACK);
			redLabel.setTranslateY(400);
			redLabel.setTranslateX(100);
			grid.getChildren().add(redLabel);
			
			yellowLabel = new Label("" + turnManager.current().getYellowP());
			yellowLabel.setFont(Font.loadFont("file:MONOPOLY_INLINE.ttf",60));
			yellowLabel.setTextFill(Color.BLACK);
			yellowLabel.setTranslateY(400);
			yellowLabel.setTranslateX(280);
			grid.getChildren().add(yellowLabel);
			
			greenLabel = new Label("" + turnManager.current().getGreenP());
			greenLabel.setFont(Font.loadFont("file:MONOPOLY_INLINE.ttf",60));
			greenLabel.setTextFill(Color.BLACK);
			greenLabel.setTranslateY(620);
			greenLabel.setTranslateX(100);
			grid.getChildren().add(greenLabel);
			
			blueLabel = new Label("" + turnManager.current().getBlueP());
			blueLabel.setFont(Font.loadFont("file:MONOPOLY_INLINE.ttf",60));
			blueLabel.setTextFill(Color.BLACK);
			blueLabel.setTranslateY(620);
			blueLabel.setTranslateX(280);
			grid.getChildren().add(blueLabel);
			
			roll.setDisable(false);
			
			for (Player player : plcr1.getAllPlayerList()) {
				
				allFiguresOnField.add(player.getBoardPiece());
				player.getBoardPiece().setTranslateX(1385);
				player.getBoardPiece().setTranslateY(700);
				grid.getChildren().add(player.getBoardPiece());
				
			}
		});	

		grid.getChildren().add(roll);
		grid.getChildren().add(endTurn);
		grid.getChildren().add(buyProperty);
		grid.getChildren().add(sellProperty);
		grid.getChildren().add(payRent);
		
		
		//Every place that is the the board
		Corner c1 = new Corner(true, false, "GO", 0);
		Property p1 = new Property("Konditoreja Ventspils Karumnieks", 60, false, false, false, model.Color.Brown, 2, 10, 10, 90, 160, 250, 50, 1);
		Property p2 = new Property("Ventspils Gramatnica Gaisma", 60, false, false, false, model.Color.Brown, 4, 20, 60, 180, 320, 450, 50, 3);
		Taxes tx1 = new Taxes("Income Tax", 200, 4);
		Transport t1 = new Transport("Ventspils Mazbanitis", 200, false, 25, 5);
		
		Property p3 = new Property("Bistro Pankukas un Pelmeni", 100, false, false, false, model.Color.Cyan, 6, 30, 90, 270, 400, 550, 50, 6);
		Property p4 = new Property("Juras Brize", 100, false, false, false, model.Color.Cyan, 6, 30, 90, 270, 400, 550, 50, 8);
		Property p5 = new Property("Ventspils Biblioteka", 120, false, false, false, model.Color.Cyan, 8, 40, 100, 300, 450, 600, 50, 9);
		Corner c2 = new Corner(false, false, "Jail", 10);
		
		Property p6 = new Property("Renka Darzs", 140, false, false, false, model.Color.Magenta, 10, 50, 150, 450, 625, 750, 100, 11);
		Utility u1 = new Utility("Ventspils Siltums", 150, false, 12);
		Property p7 = new Property("Ventspils Tirgus", 140, false, false, false, model.Color.Magenta, 10, 50, 150, 450, 625, 750, 100, 13);
		Property p8 = new Property("Kino Rio", 160, false, false, false, model.Color.Magenta, 12, 60, 180, 500, 700, 900, 100, 14);
		Transport t2 = new Transport("Hercogs Jekabs", 200, false, 25, 15);
		
		Property p9 = new Property("Ventspils Piejuras Kempings", 180, false, false, false, model.Color.Orange, 14, 70, 200, 550, 750, 950, 100, 16);
		Property p10 = new Property("Ventspils Jaunrades Nams", 180, false, false, false, model.Color.Orange, 14, 70, 200, 550, 750, 950, 100, 18);
		Property p11 = new Property("Ventspils Piejuras Akvaparks", 200, false, false, false, model.Color.Orange, 16, 80, 220, 600, 800, 1000, 100, 19);
		Corner c3 = new Corner(false, false, "Free Parking", 20);
		
		Property p12 = new Property("Ventspils Kulturas Centrs", 220, false, false, false, model.Color.Red, 18, 90, 250, 700, 875, 1050, 150, 21);
		Property p13 = new Property("Ventspils Autoosta", 220, false, false, false, model.Color.Red, 18, 90, 250, 700, 875, 1050, 150, 23);
		Property p14 = new Property("Brivdabas Muzejs", 240, false, false, false, model.Color.Red, 20, 100, 300, 750, 925, 1100, 150, 24);
		Transport t3 = new Transport("Ventspils Turistu Vilcienins", 200, false, 25, 25);
		
		Property p15 = new Property("Juras Varti", 260, false, false, false, model.Color.Yellow, 22, 110, 330, 800, 975, 1150, 150, 26);
		Property p16 = new Property("Tobago T/C", 260, false, false, false, model.Color.Yellow, 22, 110, 330, 800, 975, 1150, 150, 27);
		Utility u2 = new Utility("Ventspils Udeka", 150, false, 28);
		Property p17 = new Property("Ventspils Lidosta", 280, false, false, false, model.Color.Yellow, 24, 120, 360, 850, 1025, 1200, 150, 29);
		Corner c4 = new Corner(false, true, "Go To Jail", 30);
		
		Property p18 = new Property("Livonijas ordena pils", 300, false, false, false, model.Color.Green, 26, 130, 390, 900, 1100, 1275, 200, 31);
		Property p19 = new Property("Ventspils Augstskola", 300, false, false, false, model.Color.Green, 26, 130, 390, 900, 1100, 1275, 200, 32);
		Property p20 = new Property("Olimpiskais centrs", 320, false, false, false, model.Color.Green, 28, 150, 450, 1000, 1200, 1400, 200, 34);
		Transport t4 = new Transport("Ventspils Reiss", 200, false, 25, 35);
		
		Property p21 = new Property("Lemberga Hute", 350, false, false, false, model.Color.Blue, 35, 175, 500, 1100, 1300, 1500, 200, 37);
		Taxes tx2 = new Taxes("Super Tax", 150, 38);
		Property p22 = new Property("Ventspils Osta", 400, false, false, false, model.Color.Blue, 50, 200, 600, 1400, 1700, 2000, 200, 39);
		
		boardProperties.add(p1);
		boardProperties.add(p2);
		boardProperties.add(p3);
		boardProperties.add(p4);
		boardProperties.add(p5);
		boardProperties.add(p6);
		boardProperties.add(p7);
		boardProperties.add(p8);
		boardProperties.add(p9);
		boardProperties.add(p10);
		boardProperties.add(p11);
		boardProperties.add(p12);
		boardProperties.add(p13);
		boardProperties.add(p14);
		boardProperties.add(p15);
		boardProperties.add(p16);
		boardProperties.add(p17);
		boardProperties.add(p18);
		boardProperties.add(p19);
		boardProperties.add(p20);
		boardProperties.add(p21);
		boardProperties.add(p22);
		
		allCorners.add(c1);
		allCorners.add(c2);
		allCorners.add(c3);
		allCorners.add(c4);
		
		allTaxes.add(tx1);
		allTaxes.add(tx2);
		
		allTransport.add(t1);
		allTransport.add(t2);
		allTransport.add(t3);
		allTransport.add(t4);
		
		allUtilities.add(u1);
		allUtilities.add(u2);
		
		//All of the Comunity Chest objects
		CommunityAndChance cc1 = new CommunityAndChance("Community Chest", "Go to start and collect 200 Ventus!", 200, true, false, false, false, true, false);
		CommunityAndChance cc2 = new CommunityAndChance("Community Chest", "Bank error in your favor, collect 200 Ventus!", 200, true, false, false, false, false, false);
		CommunityAndChance cc3 = new CommunityAndChance("Community Chest", "Doctor's fees. Pay 50 Ventus.", 50, false, true, false, false, false, false);
		CommunityAndChance cc4 = new CommunityAndChance("Community Chest", "From sale of stock you get 50 Ventus!", 50, true, false, false, false, false, false);
		CommunityAndChance cc5 = new CommunityAndChance("Community Chest", "Get out of Jail.", 0, false, false, false, true, false, false);
		CommunityAndChance cc6 = new CommunityAndChance("Community Chest", "Go to jail. Do not pass GO, do not collect 200 Ventus.", 0, false, false, true, false, true, false);
		CommunityAndChance cc7 = new CommunityAndChance("Community Chest", "Grand Opera night. Collect 50 Ventus from every player.", 50, true, true, false, false, false, false);
		CommunityAndChance cc8 = new CommunityAndChance("Community Chest", "Holiday Fund matures. Collect 100 Ventus.", 100, true, false, false, false, false, false);
		CommunityAndChance cc9 = new CommunityAndChance("Community Chest", "Income tax refund. Collect 20 Ventus.", 20, true, false, false, false, false, false);
		CommunityAndChance cc10 = new CommunityAndChance("Community Chest", "It's your birthday. Collect 10 Ventus from every player.", 10, true, true, false, false, false, false);
		CommunityAndChance cc11 = new CommunityAndChance("Community Chest", "Life insurance matures. Collect 100 Ventus!", 100, true, false, false, false, false, false);
		CommunityAndChance cc12 = new CommunityAndChance("Community Chest", "Hospital fees. Pay 50 Ventus.", 50, false, true, false, false, false, false);
		CommunityAndChance cc13 = new  CommunityAndChance("Community Chest", "School fees. Pay 50 Ventus.", 50, false, true, false, false, false, false);
		CommunityAndChance cc14 = new CommunityAndChance("Community Chest", "Receive 25 Ventus for consultancy fees.", 25, true, false, false, false, false, false);
		CommunityAndChance cc15 = new CommunityAndChance("Community Chest", "You are assessed for street repairs: Pay 40 Ventus per house and 115 Ventus per hotel you own.", 40, false, true, false, false, false, true);
		CommunityAndChance cc16 = new CommunityAndChance("Community Chest", "You have won second place in a beauty contest. Collect 10 Ventus!", 10, true, false, false, false, false, false);
		CommunityAndChance cc17 = new CommunityAndChance("Community Chest", "You inherit 100 Ventus.", 100, true, false, false, false, false, false);
		
		allCommunityChestCards.add(cc1);
		allCommunityChestCards.add(cc2);
		allCommunityChestCards.add(cc3);
		allCommunityChestCards.add(cc4);
		allCommunityChestCards.add(cc5);
		allCommunityChestCards.add(cc6);
		allCommunityChestCards.add(cc7);
		allCommunityChestCards.add(cc8);
		allCommunityChestCards.add(cc9);
		allCommunityChestCards.add(cc10);
		allCommunityChestCards.add(cc11);
		allCommunityChestCards.add(cc12);
		allCommunityChestCards.add(cc13);
		allCommunityChestCards.add(cc14);
		allCommunityChestCards.add(cc15);
		allCommunityChestCards.add(cc16);
		allCommunityChestCards.add(cc17);
		
		//All of the chance objects
		CommunityAndChance cc18 = new CommunityAndChance("Chance", "Advance to Go. Collect 200 Ventus.", 200, true, false, false, false, true, false);
		CommunityAndChance cc19 = new CommunityAndChance("Chance", "Advance to Kino Rio. If you pass Go collect 200 Ventus.", 200, true, false, false, false, true, false);
		CommunityAndChance cc20 = new CommunityAndChance("Chance", "Advance token to nearest Utility. If unowned, you may buy it from the Bank. If owned, throw dice and pay owner a total 10 times the amount thrown.", 0, false, true, false, false, true, false);
		CommunityAndChance cc21 = new CommunityAndChance("Chance", "Advance token to the nearest Transport and pay owner twice the rental to which he/she {he} is otherwise entitled. If Railroad is unowned, you may buy it from the Bank.", 0, false, true, false, false, true, false);
		CommunityAndChance cc22 = new CommunityAndChance("Chance", "Advance token to the nearest Transport and pay owner twice the rental to which he/she {he} is otherwise entitled. If Railroad is unowned, you may buy it from the Bank.", 0, false, true, false, false, true, false);
		CommunityAndChance cc23 = new CommunityAndChance("Chance", "Bank pays you dividend of 50 Venti.", 50, true, false, false, false, false, false);
		CommunityAndChance cc24 = new CommunityAndChance("Chance", "Get out of Jail free.", 0, false, false, false, true, false, false);
		CommunityAndChance cc25 = new CommunityAndChance("Chance", "Go back three spaces.", 0, false, false, false, false, true, false);
		CommunityAndChance cc26 = new CommunityAndChance("Chance", "Go to Jail. Do not pass GO, do not collect 200 Ventus.", 0, false, false, true, false, true, false);
		CommunityAndChance cc27 = new CommunityAndChance("Chance", "Make general repairs on all your property. For each house pay 25 Ventus, for each hotel pay 100 Ventus.", 0, false, true, false, false, false, true);
		CommunityAndChance cc28 = new CommunityAndChance("Chance", "Pay poor tax of 15 Venti.", 15, false, true, false, false, false, false);
		CommunityAndChance cc29 = new CommunityAndChance("Chance", "Take a trip to Turistu Vilcienins. If you pass Go, collect 200 Ventus.", 200, true, false, false, false, true, false);
		CommunityAndChance cc30 = new CommunityAndChance("Chance", "Take a ride on the ferry. Advance token to Ventspils Osta.", 0, false, true, false, false, true, false);
		CommunityAndChance cc31 = new CommunityAndChance("Chance", "You have been elected Chairman of the Board. Pay each player 50 Ventus.", 50, true, true, false, false, false, false);
		CommunityAndChance cc32 = new CommunityAndChance("Chance", "Your building loan matures. Receive 150 Ventus.", 150, true, false, false, false, false, false);
		CommunityAndChance cc33 = new CommunityAndChance("Chance", "You have won a crossword competition. Collect 100 Ventus!", 100, true, false, false, false, false, false);
		
		AllChanceCards.add(cc18);
		AllChanceCards.add(cc19);
		AllChanceCards.add(cc20);
		AllChanceCards.add(cc21);
		AllChanceCards.add(cc22);
		AllChanceCards.add(cc23);
		AllChanceCards.add(cc24);
		AllChanceCards.add(cc25);
		AllChanceCards.add(cc26);
		AllChanceCards.add(cc27);
		AllChanceCards.add(cc28);
		AllChanceCards.add(cc29);
		AllChanceCards.add(cc30);
		AllChanceCards.add(cc31);
		AllChanceCards.add(cc32);
		AllChanceCards.add(cc33);
		
		//All actions that happens/can happen after pressing "roll"
		roll.setOnMouseClicked(e -> {
			Property tempProperty = new Property();
			Transport tempTransport = new Transport();
			Utility tempUtility = new Utility();
		
			//Dice roll generator
			 result = 0;
			 result2 = 0;
			
			result = dice.roll();
			result2 = dice2.roll();
			tresult = result + result2;
			
			System.out.println("Dice 1 rolled: "+result);
			System.out.println("Dice 2 rolled: "+result2);
			System.out.println("Total result: " +tresult);
			dice.showDiceResult(grid, result, result2);
			

			
			/*
			 * Check if player is on Go or passed Go and collect 200 Ventus
			 */
			if (turnManager.current().getRollCounter() <= 40 && turnManager.current().isJailed() == false) {
				turnManager.current().setRollCounter(turnManager.current().getRollCounter()+tresult);
				if (turnManager.current().getRollCounter() - 39 > 0) {
					turnManager.current().setRollCounter(turnManager.current().getRollCounter() - 40);
					System.out.println(turnManager.current().getName() + ": " + turnManager.current().getRollCounter());
					System.out.println("You have passed GO collect 200 Ventus!");
					turnManager.current().setMoney(turnManager.current().getMoney() + 200);
					System.out.println(turnManager.current().getName() + ": " + turnManager.current().getMoney());
					moneyLabel.setText("Money: " + turnManager.current().getMoney());
					
				}
				else {
					System.out.println(turnManager.current().getName() + ": " + turnManager.current().getRollCounter());
				}
				
			}
			else {
				turnManager.current().setRollCounter(0);
				turnManager.current().setRollCounter(turnManager.current().getRollCounter()+tresult);
				System.out.println(turnManager.current().getRollCounter());
				
			}
			//Player Movement
			turnManager.current().getBoardPiece().setTranslateX(xCoord[turnManager.current().getRollCounter()]);
			turnManager.current().getBoardPiece().setTranslateY(yCoord[turnManager.current().getRollCounter()]);
			
			/*
			 * If player is in Jail then the player has a choice to pay 50 Ventus, use 'Get Out Of Jail' card or roll the dice 3 times to get out of Jail
			 */
			if (turnManager.current().isJailed()) {
				buyProperty.setDisable(true);
				int maxDiceRolls = 3;
				
				if (turnsInJail <= 3) {
					if (result == result2) {
						turnManager.current().setRollCounter(c2.getCornerID());
						turnManager.current().setJailed(false);
						
						System.out.println("Wohoo, you got out of Jail!");
						
					}
					else {
						System.out.println("Ahh, better luck next roll!");
						timesRolledInJail++;
							
						if (timesRolledInJail == maxDiceRolls) {
							roll.setDisable(true);
							timesRolledInJail = 0;
								
						}
					}
				}
				if (turnsInJail == 3 && timesRolledInJail == 0) {
					roll.setDisable(false);
					turnManager.current().setMoney(turnManager.current().getMoney() - 50);
					turnManager.current().setJailed(false);
					turnsInJail = 0;
					System.out.println(turnManager.current().getName() + ": " + turnManager.current().getMoney());
					moneyLabel.setText("Money: " + turnManager.current().getMoney());
				}
				
			}
			
			/*
			 * Check if player is on a Community Chest field if so draw a card from the List and calls function to complete the card rules
			 */
			if (turnManager.current().getRollCounter() == 2 || turnManager.current().getRollCounter() == 17 || turnManager.current().getRollCounter() == 33) {
				
				Random rand = new Random();
				int randomCommunity = rand.nextInt(allCommunityChestCards.size());
				CommunityAndChance tempCC = new CommunityAndChance();
				tempCC = allCommunityChestCards.get(randomCommunity);
	
				if (tempCC.isReceiveMoney() && tempCC.isMoveSpaces()) {
					tempCC.goToStart(turnManager.current());
				}
				
				else if (tempCC.isReceiveMoney() && !tempCC.isPayMoney()) {
					tempCC.receiveMoney(turnManager.current(), tempCC.getMoney());
					System.out.println(turnManager.current().getName() + " money " + turnManager.current().getMoney());
					moneyLabel.setText("Money: " + turnManager.current().getMoney());
				}
				else if (tempCC.isPayMoney() && !tempCC.isReceiveMoney()) {
					tempCC.payMoney(turnManager.current(), tempCC.getMoney());
					moneyLabel.setText("Money: " + turnManager.current().getMoney());
				}
				else if (tempCC.isReceiveMoney() && tempCC.isPayMoney()) {
					tempCC.receiveMoneyFromEveryone(turnManager.current(), plcr1.getAllPlayerList(), tempCC.getMoney());
					moneyLabel.setText("Money: " + turnManager.current().getMoney());
				}
				else if (tempCC.isGoToJail()) {
					tempCC.goToJail(turnManager.current());
					roll.setDisable(true);
					buyProperty.setDisable(true);
				}
				else if (tempCC.isJailFreeCard()) {
					tempCC.jailFreeCard(turnManager.current());
					jailFreeLabel.setText("GJFC: YES");
				}
				
				else if (tempCC.isPayMoney() && tempCC.isHouseHotelRent()) {
					tempCC.streetRepairs(turnManager.current(), tempCC.getMoney());
					moneyLabel.setText("Money: " + turnManager.current().getMoney());
				}
				

				 Notifications.create()
	              .title("Community Chest")
	              .text(tempCC.getDescription())
	              .position(Pos.CENTER)
	              .hideAfter(Duration.INDEFINITE)
	              .show();

			}
		
				
			
			/*
			 * Check if player is on a Tax field, if so player has to pay the amount of tax that the field specifies
			 */
			if (turnManager.current().getRollCounter() == tx1.getTaxID() || turnManager.current().getRollCounter() == tx2.getTaxID()) {
				
			
				
				Taxes tempTax = new Taxes();
				for (Taxes taxes : allTaxes) {
					if (taxes.getTaxID() == turnManager.current().getRollCounter()) {
						tempTax = taxes;
						break;
						}
					}
				tempTax.payTax(turnManager.current(), tempTax.getTaxPrice());
			}
			
			/*
			 * Checks if the player is on Chance field, if so draw a random Chance card from the list and calls function to complete the card rules
			 */
			if (turnManager.current().getRollCounter() == 7 || turnManager.current().getRollCounter() == 22 || turnManager.current().getRollCounter() == 36) {
				
				
				Random rand = new Random();
				int randomChance= rand.nextInt(AllChanceCards.size());
				CommunityAndChance tempC = new CommunityAndChance();
				tempC = AllChanceCards.get(randomChance);
				
				if (tempC.isReceiveMoney() && tempC.isMoveSpaces()) {
					tempC.goToStart(turnManager.current());
					moneyLabel.setText("Money: " + turnManager.current().getMoney());
				}
				
				else if (tempC.isReceiveMoney() && !tempC.isPayMoney()) {
					tempC.receiveMoney(turnManager.current(), tempC.getMoney());
					System.out.println(turnManager.current().getName() + " money " + turnManager.current().getMoney());
					moneyLabel.setText("Money: " + turnManager.current().getMoney());
				}
				else if (tempC.isReceiveMoney() && tempC.isPayMoney()) {
					tempC.payEveryOneMoney(turnManager.current(), plcr1.getAllPlayerList(), tempC.getMoney());
					moneyLabel.setText("Money: " + turnManager.current().getMoney());
				}
				
				else if (tempC.isPayMoney() && !tempC.isReceiveMoney()) {
					tempC.payMoney(turnManager.current(), tempC.getMoney());
					moneyLabel.setText("Money: " + turnManager.current().getMoney());
				}
				else if (tempC.isGoToJail()) {
					tempC.goToJail(turnManager.current());
				}
				else if (tempC.isJailFreeCard()) {
					tempC.jailFreeCard(turnManager.current());
					jailFreeLabel.setText("GJFC: YES");
				}
				 Notifications.create()
	              .title("Chance")
	              .text(tempC.getDescription())
	              .position(Pos.CENTER)
	              .hideAfter(Duration.INDEFINITE)
	              .show();
			}
			
			/*
			 * If player is on the Go To Jail field, player goes to Jail without collecting 200 Ventus and ends his turn
			 */
			if (turnManager.current().getRollCounter() == c4.getCornerID()) {
				turnManager.current().setRollCounter(c2.getCornerID());
				turnManager.current().setJailed(true);
				System.out.println(turnManager.current().getName() + " is on field " + turnManager.current().getRollCounter() + " and gets sent to jail");
				roll.setDisable(true);
				turnManager.current().getBoardPiece().setTranslateX(xCoord[c2.getCornerID()]);
				turnManager.current().getBoardPiece().setTranslateY(yCoord[c2.getCornerID()]);
			}
			
			
			if(turnManager.current().getRollCounter()==c1.getCornerID()||turnManager.current().getRollCounter()==c2.getCornerID()||turnManager.current().getRollCounter()==c3.getCornerID()
					||turnManager.current().getRollCounter()==c4.getCornerID()||turnManager.current().getRollCounter() == 7 
					|| turnManager.current().getRollCounter() == 22 || turnManager.current().getRollCounter() == 36||
					turnManager.current().getRollCounter() == tx1.getTaxID() || turnManager.current().getRollCounter() == tx2.getTaxID()||
					turnManager.current().getRollCounter() == 2 || turnManager.current().getRollCounter() == 17 || turnManager.current().getRollCounter() == 33) {
				buyProperty.setDisable(true);
			}
			else{
				buyProperty.setDisable(false);
			}
	
			
			if(result==result2&&turnManager.current().isJailed()==false) {
				endTurn.setDisable(true);
			}
			else {
				endTurn.setDisable(false);
				roll.setDisable(true);
			}
			
		
			if (turnManager.current().getRollCounter() == u1.getUtilityID() || turnManager.current().getRollCounter() == u2.getUtilityID()) {
				for (Utility utility : allUtilities) {
					if (utility.getUtilityID() == turnManager.current().getRollCounter()) {
						tempUtility = utility;
						break;
					}
				}
					if(tempUtility.isOwned()==true&&turnManager.current().getPlayerID()!=tempUtility.getOwnedPlayerID()) {
						payRent.setDisable(false);
						roll.setDisable(true);
						endTurn.setDisable(true);
					}
			}
			else if (turnManager.current().getRollCounter() == t1.getTransportID() || turnManager.current().getRollCounter() == t2.getTransportID() 
					|| turnManager.current().getRollCounter() == t3.getTransportID() || turnManager.current().getRollCounter() == t4.getTransportID()) {
				
				for (Transport transport : allTransport) {
					if (transport.getTransportID() == turnManager.current().getRollCounter()) {
						tempTransport = transport;
						break;
					}
					
				}
				if(tempTransport.isOwned()==true&&turnManager.current().getPlayerID()!=tempTransport.getOwnedPlayerID()) {
					payRent.setDisable(false);
					roll.setDisable(true);
					endTurn.setDisable(true);
				}
		}
						
			else {
				for (Property property : boardProperties) {
					if (property.getPropertyID() == turnManager.current().getRollCounter()) {
						tempProperty = property;
						break;
					}
				}
				if(tempProperty.isOwned()==true&&turnManager.current().getPlayerID()!=tempProperty.getOwnedPlayerID()) {
					payRent.setDisable(false);
					roll.setDisable(true);
					endTurn.setDisable(true);
				}
			}
			
		});
		
		//Every possible action after the "Buy Property" button has been pressed
		buyProperty.setOnMouseClicked(e -> {
			
			int tempIndex = 0;
			Property tempProperty = new Property();
			Transport tempTransport = new Transport();
			Utility tempUtility = new Utility();
			
			//Checks if its a utility field
			if (turnManager.current().getRollCounter() == u1.getUtilityID() || turnManager.current().getRollCounter() == u2.getUtilityID()) {
				for (Utility utility : allUtilities) {
					if (utility.getUtilityID() == turnManager.current().getRollCounter()) {
						tempUtility = utility;
						break;
					}
				}
				//If the field is not owned by someone or if the player has enough money it gets bough
				if (tempUtility.isOwned() == false && turnManager.current().getMoney() >= tempUtility.getPrice()) {
					turnManager.current().getUtilitiesOwned().add(tempUtility);
					turnManager.current().setMoney(turnManager.current().getMoney() - tempUtility.getPrice());
					tempIndex = allUtilities.indexOf(tempUtility);
					allUtilities.get(tempIndex).setOwned(true);
					allUtilities.get(tempIndex).setOwnedPlayerID(turnManager.current().getPlayerID());
					turnManager.current().setUtilityP(turnManager.current().getUtilityP() + 1);
					utilityLabel.setText("Utility: " + turnManager.current().getUtilityP() );
					
					System.out.println(tempUtility.getName() + " has been purchased for " + tempUtility.getPrice());
					System.out.println(turnManager.current().getName() + ": " + turnManager.current().getMoney());
					moneyLabel.setText("Money: " + turnManager.current().getMoney());
					
				}
				else {
					String utilityOwner = "";
					for (Player player : plcr1.getAllPlayerList()) {
						for (Utility utility : player.getUtilitiesOwned()) {
							if (utility.getUtilityID() == turnManager.current().getRollCounter()) {
								utilityOwner = player.getName();
							}
						}
					}
					System.out.println("This property is already owned by " + utilityOwner);
				}
			}
			//Checks if its a transport field
			else if (turnManager.current().getRollCounter() == t1.getTransportID() || turnManager.current().getRollCounter() == t2.getTransportID() 
					|| turnManager.current().getRollCounter() == t3.getTransportID() || turnManager.current().getRollCounter() == t4.getTransportID()) {
				
				for (Transport transport : allTransport) {
					if (transport.getTransportID() == turnManager.current().getRollCounter()) {
						tempTransport = transport;
						break;
					}
					
				}
				//If the field is not owned by someone or if the player has enough money it gets bough
				if (tempTransport.isOwned() == false && turnManager.current().getMoney() >= tempTransport.getPrice()) {
					turnManager.current().getTransportOwned().add(tempTransport);
					turnManager.current().setMoney(turnManager.current().getMoney() - tempTransport.getPrice());
					tempIndex = allTransport.indexOf(tempTransport);
					allTransport.get(tempIndex).setOwned(true);
					allTransport.get(tempIndex).setOwnedPlayerID(turnManager.current().getPlayerID());
					turnManager.current().setTransportP(turnManager.current().getTransportP() + 1);
					transportLabel.setText("Transport: " + turnManager.current().getTransportP() );
			
					System.out.println(tempTransport.getName() + " has been purchased for " + tempTransport.getPrice());
					System.out.println(turnManager.current().getName() + ": " + turnManager.current().getMoney());
					moneyLabel.setText("Money: " + turnManager.current().getMoney());
					sellProperty.setDisable(false);
				}
				else {
					String propertyOwner = "";
					for (Player player : plcr1.getAllPlayerList()) {
						for (Transport transport : player.getTransportOwned()) {
							if (transport.getTransportID() == turnManager.current().getRollCounter()) {
								propertyOwner = player.getName();
							}
						}
					}
					System.out.println("This property is already owned by " + propertyOwner);
				}
				
			}
			//Checks if its a regular property
			else {
				for (Property property : boardProperties) {
					if (property.getPropertyID() == turnManager.current().getRollCounter()) {
						tempProperty = property;
						break;
					}
				}
				
				//If the field is not owned by someone or if the player has enough money it gets bough
				if (tempProperty.isOwned() == false && turnManager.current().getMoney() >= tempProperty.getPrice()) {
					turnManager.current().getPropertiesOwned().add(tempProperty);
					turnManager.current().setMoney(turnManager.current().getMoney() - tempProperty.getPrice());
					moneyLabel.setText("Money: " + turnManager.current().getMoney());
					tempIndex = boardProperties.indexOf(tempProperty);
					boardProperties.get(tempIndex).setOwned(true);
					boardProperties.get(tempIndex).setOwnedPlayerID(turnManager.current().getPlayerID());
					sellProperty.setDisable(false);
					
					if (tempProperty.getPropertyColor() == model.Color.Brown) {
						turnManager.current().setBrownP(turnManager.current().getBrownP() + 1);
						brownLabel.setText("" + turnManager.current().getBrownP());
						
						if (turnManager.current().getBrownP() == 2) {
							
							for (Property playerProperty : turnManager.current().getPropertiesOwned()) {
								if (tempProperty.getPropertyColor() == model.Color.Brown) {
									playerProperty.setMonopolised(true);
								}
							}
						}
					}
					else if (tempProperty.getPropertyColor() == model.Color.Cyan) {
						turnManager.current().setCyanP(turnManager.current().getCyanP() + 1);
						cyanLabel.setText("" + turnManager.current().getCyanP());
						if (turnManager.current().getCyanP()== 3) {
							
							for (Property playerProperty : turnManager.current().getPropertiesOwned()) {
								if (tempProperty.getPropertyColor() == model.Color.Cyan) {
									playerProperty.setMonopolised(true);
								}
							}
						}
					}
					else if (tempProperty.getPropertyColor() == model.Color.Magenta) {
						turnManager.current().setMagentaP(turnManager.current().getMagentaP() + 1);
						magentaLabel.setText("" + turnManager.current().getMagentaP());
						if (turnManager.current().getMagentaP() == 3) {
							
							for (Property playerProperty : turnManager.current().getPropertiesOwned()) {
								if (tempProperty.getPropertyColor() == model.Color.Magenta) {
									playerProperty.setMonopolised(true);
								}
							}
						}
					}
					else if (tempProperty.getPropertyColor() == model.Color.Orange) {
						turnManager.current().setOrangeP(turnManager.current().getOrangeP() + 1);
						orangeLabel.setText("" + turnManager.current().getOrangeP());
						if (turnManager.current().getOrangeP() == 3) {
							
							for (Property playerProperty : turnManager.current().getPropertiesOwned()) {
								if (tempProperty.getPropertyColor() == model.Color.Orange) {
									playerProperty.setMonopolised(true);
								}
							}
						}
					}
					else if (tempProperty.getPropertyColor() == model.Color.Red) {
						turnManager.current().setRedP(turnManager.current().getRedP() + 1);
						redLabel.setText("" + turnManager.current().getRedP());
						if (turnManager.current().getRedP()== 3) {
							
							for (Property playerProperty : turnManager.current().getPropertiesOwned()) {
								if (tempProperty.getPropertyColor() == model.Color.Red) {
									playerProperty.setMonopolised(true);
								}
							}
						}
					}
					else if (tempProperty.getPropertyColor() == model.Color.Yellow) {
						turnManager.current().setYellowP(turnManager.current().getYellowP() + 1);
						yellowLabel.setText("" + turnManager.current().getYellowP());
						if (turnManager.current().getYellowP() == 3) {
							
							for (Property playerProperty : turnManager.current().getPropertiesOwned()) {
								if (tempProperty.getPropertyColor() == model.Color.Yellow) {
									playerProperty.setMonopolised(true);
								}
							}
						}
					}
					else if (tempProperty.getPropertyColor() == model.Color.Green) {
						turnManager.current().setGreenP(turnManager.current().getGreenP() + 1);
						greenLabel.setText("" + turnManager.current().getGreenP());
						if (turnManager.current().getGreenP() == 3) {
							
							for (Property playerProperty : turnManager.current().getPropertiesOwned()) {
								if (tempProperty.getPropertyColor() == model.Color.Green) {
									playerProperty.setMonopolised(true);
								}
							}
						}
					}
					else if (tempProperty.getPropertyColor() == model.Color.Blue) {
						turnManager.current().setBlueP(turnManager.current().getBlueP() + 1);
						blueLabel.setText("" + turnManager.current().getBlueP());
						if (turnManager.current().getBlueP() == 2) {
							
							for (Property playerProperty : turnManager.current().getPropertiesOwned()) {
								if (tempProperty.getPropertyColor() == model.Color.Blue) {
									playerProperty.setMonopolised(true);
								}
							}
						}
					}
					
				
					System.out.println(tempProperty.getName() + " has been purchased for " + tempProperty.getPrice());
					System.out.println(turnManager.current().getName() + ": " + turnManager.current().getMoney());
					moneyLabel.setText("Money: " + turnManager.current().getMoney());
				}
				else {
					String propertyOwner = "";
					for (Player player : plcr1.getAllPlayerList()) {
						for (Property property : player.getPropertiesOwned()) {
							if (property.getPropertyID() == turnManager.current().getRollCounter()) {
								propertyOwner = player.getName();
							}
						}
					}
					System.out.println("This property is already owned by " + propertyOwner);
				}
			}

		});
		//After pressing "Sell Property" brings up a box of all the properties the player owns
		sellProperty.setOnMouseClicked(e -> {
			turnManager.current().sellProperty(turnManager.current(), boardProperties, allUtilities, allTransport);
			utilityLabel.setText("Utility: " + turnManager.current().getUtilityP() );
			transportLabel.setText("Transport: " + turnManager.current().getTransportP());
			
			brownLabel.setText("" + turnManager.current().getBrownP());
			cyanLabel.setText("" + turnManager.current().getCyanP());
			magentaLabel.setText("" + turnManager.current().getMagentaP());
			orangeLabel.setText("" + turnManager.current().getOrangeP());
			redLabel.setText("" + turnManager.current().getRedP());
			yellowLabel.setText("" + turnManager.current().getYellowP());
			greenLabel.setText("" + turnManager.current().getGreenP());
			blueLabel.setText("" + turnManager.current().getBlueP());
			
		});
		
		//Possible scenarios after pressing "Pay Rent" button
		payRent.setOnMouseClicked(e -> {
			if (turnManager.current().getRollCounter() == u1.getUtilityID() || turnManager.current().getRollCounter() == u2.getUtilityID()) {
				Utility tempUtility = new Utility();
				for (Utility utility : allUtilities) {
					if (utility.getUtilityID() == turnManager.current().getRollCounter()) {
						tempUtility = utility;
						break;
					}
				}
				if (turnManager.current().payRent(turnManager.current(), plcr1.getAllPlayerList(), null, tempUtility, null, tresult)) {
					System.out.println(turnManager.current().getName() + ": " + turnManager.current().getMoney());
					moneyLabel.setText("Money: " + turnManager.current().getMoney());
				}
				else {
					
				}
				
				
			}
			else if (turnManager.current().getRollCounter() == t1.getTransportID() || turnManager.current().getRollCounter() == t2.getTransportID()
					|| turnManager.current().getRollCounter() == t3.getTransportID() || turnManager.current().getRollCounter() == t4.getTransportID()) {
				Transport tempTransport = new Transport();
				for (Transport transport : allTransport) {
					if (transport.getTransportID() == turnManager.current().getRollCounter()) {
						tempTransport = transport;
						break;
					}
				}
				turnManager.current().payRent(turnManager.current(), plcr1.getAllPlayerList(), null, null, tempTransport, tresult);
				System.out.println(turnManager.current().getName() + ": " + turnManager.current().getMoney());
				moneyLabel.setText("Money: " + turnManager.current().getMoney());
			}
			else {
				Property tempProperty = new Property();
				for (Property property : boardProperties) {
					if (property.getPropertyID() == turnManager.current().getRollCounter()) {
						tempProperty = property;
						break;
					}
				}
				turnManager.current().payRent(turnManager.current(), plcr1.getAllPlayerList(), tempProperty, null, null, tresult);
				System.out.println(turnManager.current().getName() + ": " + turnManager.current().getMoney());
				moneyLabel.setText("Money: " + turnManager.current().getMoney());
			}
			
			endTurn.setDisable(false);
			payRent.setDisable(true);
			if(result==result2) {
				roll.setDisable(false);
				payRent.setDisable(true);
			}
			
		});
		
		//Everything that hapens/can happen after pressing "End Turn" button
		endTurn.setOnMouseClicked(e -> {
			if (turnManager.getCurrentPlayerID() + 1  == turnManager.getPlayersList().size()) {
				System.out.println(turnManager.current().getName() + " turn has ended");
				System.out.println();
				turnManager.reset();
				
				turns++;
				turnLabel.setText("Turn: " + turns);
				
				System.out.println(turnManager.current().getName() + " turn has started");
				roll.setDisable(false);
				buyProperty.setDisable(false);
				sellProperty.setDisable(false);
				if (turnManager.current().getPropertiesOwned().size() == 0) {
					sellProperty.setDisable(true);
				}
				if (turnManager.current().isJailed() == true) {
					buyProperty.setDisable(true);
					turnsInJail++;
					
					turnManager.current().isInJail(turnManager.current());
					
				}
			}
			else {
				System.out.println(turnManager.current().getName() + "'s turn has ended");
				System.out.println();
				turnManager.next();
				System.out.println(turnManager.current().getName() + "'s turn has started");

				if (turnManager.current().getPropertiesOwned().size() == 0) {
					sellProperty.setDisable(true);
				}
				if (turnManager.current().isJailed() == true) {
					buyProperty.setDisable(true);
					turnsInJail++;
					
					turnManager.current().isInJail(turnManager.current());
					
				}
				
			}
			playerLabel.setText("Player: "+turnManager.current().getName());
			moneyLabel.setText("Money: " + turnManager.current().getMoney());
			if(turnManager.current().getJailFreeCard()>0) {
				jailFreeLabel.setText("GJFC: YES");
			}
			
			else {
				jailFreeLabel.setText("GJFC: NO");
			}
			
			utilityLabel.setText("Utility: " + turnManager.current().getUtilityP() );
			transportLabel.setText("Transport: " + turnManager.current().getTransportP());
			
			roll.setDisable(false);
			endTurn.setDisable(true);
			
			if(turnManager.current().getRollCounter()==c1.getCornerID()||turnManager.current().getRollCounter()==c2.getCornerID()||turnManager.current().getRollCounter()==c3.getCornerID()
					||turnManager.current().getRollCounter()==c4.getCornerID()||turnManager.current().getRollCounter() == 7 
					|| turnManager.current().getRollCounter() == 22 || turnManager.current().getRollCounter() == 36||
					turnManager.current().getRollCounter() == tx1.getTaxID() || turnManager.current().getRollCounter() == tx2.getTaxID()||
					turnManager.current().getRollCounter() == 2 || turnManager.current().getRollCounter() == 17 || turnManager.current().getRollCounter() == 33) {
				
				buyProperty.setDisable(true);
			}
			brownLabel.setText("" + turnManager.current().getBrownP());
			cyanLabel.setText("" + turnManager.current().getCyanP());
			magentaLabel.setText("" + turnManager.current().getMagentaP());
			orangeLabel.setText("" + turnManager.current().getOrangeP());
			redLabel.setText("" + turnManager.current().getRedP());
			yellowLabel.setText("" + turnManager.current().getYellowP());
			greenLabel.setText("" + turnManager.current().getGreenP());
			blueLabel.setText("" + turnManager.current().getBlueP());
		});

		//The log field
		TextArea ta = TextAreaBuilder.create()
			    .prefWidth(200)
			    .prefHeight(600)
			    .wrapText(true)
			    .build();

			Console console = new Console(ta);
			PrintStream ps = new PrintStream(console, true);
			System.setOut(ps);
			System.setErr(ps);
			
			
			ta.setTranslateX(1720);
			
			grid.getChildren().add(ta);
			ta.setEditable(false);
		

	}

	public GridPane getGrid() {
		return grid;
	}
	
	
	
}
