/**
 * This class represents the player creation window you get after pressing "New Game"
 */

package model;


import java.util.ArrayList;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class PlayerCreation {
	
	private final Pane pane;
	private ArrayList<Player> allPlayerList = new ArrayList<Player>();
	private RadioButton chosenButton = new RadioButton();
	private RadioButton chosenButton2 = new RadioButton();
	private RadioButton chosenButton3 = new RadioButton();
	
	
	
	ArrayList<Player> getAllPlayerList() {
		return allPlayerList;
	}

	public PlayerCreation() {
		
		//Visuals of PlayerCreation
		pane = new Pane();
		BackgroundImage myBI= new BackgroundImage(new Image("file:PlayCreaBG.jpg",1200,900,false,true),
		        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
		          BackgroundSize.DEFAULT);
		pane.setBackground(new Background(myBI));
		
		Label l1 = new Label("Player One :");
		Label l2 = new Label("Player Two :");
		Label l3 = new Label("Player Three :");
		Label l4 = new Label("Player Four :");
		Label l5 = new Label("PLAYER CREATION");
		Label label = new Label ("Press ENTER to start the game or ESC to go back to menu");
		
		TextField tf1 = new TextField ();
		TextField tf2 = new TextField();
		TextField tf3 = new TextField();
		TextField tf4 = new TextField();
		
		Button start1 = new Button("Create");
		Button start2 = new Button("Create");
		Button start3 = new Button("Create");
		Button start4 = new Button("Create");
		
		Image p1 = new Image("file:Figures.png");
		ImageView iv1 = new ImageView(p1);
		
		Image hatFigure = new Image("file:p3.png", 75, 75, false, false);
		ImageView figure1 = new ImageView(hatFigure);
		Image carFigure = new Image("file:p2.png", 75, 75, false, false);
		ImageView figure2 = new ImageView(carFigure);
		Image shipFigure = new Image("file:p4.png", 75, 75, false, false);
		ImageView figure3 = new ImageView(shipFigure);
		Image dogFigure = new Image("file:p1.png", 75, 75, false, false);
		ImageView figure4 = new ImageView(dogFigure);
		
		//Toggle groups for players
		final ToggleGroup g1 = new ToggleGroup();
		final ToggleGroup g2 = new ToggleGroup();
		final ToggleGroup g3 = new ToggleGroup();
		final ToggleGroup g4 = new ToggleGroup();
		
		//Player1 TG
		RadioButton rb1 = new RadioButton();
		rb1.setToggleGroup(g1);
		RadioButton rb2 = new RadioButton();
		rb2.setToggleGroup(g1);		
		RadioButton rb3 = new RadioButton();
		rb3.setToggleGroup(g1);	
		RadioButton rb4 = new RadioButton();
		rb4.setToggleGroup(g1);
		
		//Player2 TG
		RadioButton rb5 = new RadioButton();
		rb5.setToggleGroup(g2);
		RadioButton rb6 = new RadioButton();
		rb6.setToggleGroup(g2);	
		RadioButton rb7 = new RadioButton();
		rb7.setToggleGroup(g2);
		RadioButton rb8 = new RadioButton();
		rb8.setToggleGroup(g2);

		//Player3 TG
		RadioButton rb9 = new RadioButton();
		rb9.setToggleGroup(g3);		
		RadioButton rb10 = new RadioButton();
		rb10.setToggleGroup(g3);	
		RadioButton rb11 = new RadioButton();
		rb11.setToggleGroup(g3);
		RadioButton rb12 = new RadioButton();
		rb12.setToggleGroup(g3);

		//Player4 TG
		RadioButton rb13 = new RadioButton();
		rb13.setToggleGroup(g4);	
		RadioButton rb14 = new RadioButton();
		rb14.setToggleGroup(g4);	
		RadioButton rb15 = new RadioButton();
		rb15.setToggleGroup(g4);
		RadioButton rb16 = new RadioButton();
		rb16.setToggleGroup(g4);
		
		//Onscreen location of visual elements
		tf1.setTranslateX(300);
		tf1.setTranslateY(300);
		tf2.setTranslateX(300);
		tf2.setTranslateY(400);
		tf3.setTranslateX(300);
		tf3.setTranslateY(500);
		tf4.setTranslateX(300);
		tf4.setTranslateY(600);
		
		l1.setFont(Font.loadFont("file:MONOPOLY_INLINE.ttf",30));
		l1.setTranslateX(300);
		l1.setTranslateY(265);
		l2.setFont(Font.loadFont("file:MONOPOLY_INLINE.ttf",30));
		l2.setTranslateX(300);
		l2.setTranslateY(365);
		l3.setFont(Font.loadFont("file:MONOPOLY_INLINE.ttf",30));
		l3.setTranslateX(300);
		l3.setTranslateY(465);
		l4.setFont(Font.loadFont("file:MONOPOLY_INLINE.ttf",30));
		l4.setTranslateX(300);
		l4.setTranslateY(565);
		l5.setFont(Font.loadFont("file:MONOPOLY_INLINE.ttf",60));
		l5.setTextFill(Color.BLACK);
		l5.setTranslateX(400);
		l5.setTranslateY(50);
		label.setFont(Font.loadFont("file:MONOPOLY_INLINE.ttf",30));
		label.setTranslateX(300);
		label.setTranslateY(800);

		iv1.setTranslateY(30);

		rb1.setTranslateX(650);
		rb1.setTranslateY(300);
		rb2.setTranslateX(750);
		rb2.setTranslateY(300);
		rb3.setTranslateX(850);
		rb3.setTranslateY(300);
		rb4.setTranslateX(930);
		rb4.setTranslateY(300);
		
		rb5.setTranslateX(650);
		rb5.setTranslateY(410);
		rb6.setTranslateX(750);
		rb6.setTranslateY(410);
		rb7.setTranslateX(850);
		rb7.setTranslateY(410);
		rb8.setTranslateX(930);
		rb8.setTranslateY(410);
		
		rb9.setTranslateX(650);
		rb9.setTranslateY(520);
		rb10.setTranslateX(750);
		rb10.setTranslateY(520);
		rb11.setTranslateX(850);
		rb11.setTranslateY(520);
		rb12.setTranslateX(930);
		rb12.setTranslateY(520);
		
		rb13.setTranslateX(650);
		rb13.setTranslateY(630);
		rb14.setTranslateX(750);
		rb14.setTranslateY(630);
		rb15.setTranslateX(850);
		rb15.setTranslateY(630);
		rb16.setTranslateX(930);
		rb16.setTranslateY(630);
		
		start1.setTranslateX(1000);
		start1.setTranslateY(300);
		start2.setTranslateX(1000);
		start2.setTranslateY(400);
		start3.setTranslateX(1000);
		start3.setTranslateY(500);
		start4.setTranslateX(1000);
		start4.setTranslateY(600);
		
		//Disabled all the inactive buttons and text fields
		rb5.setDisable(true);
		rb6.setDisable(true);
		rb7.setDisable(true);
		rb8.setDisable(true);
		rb9.setDisable(true);
		rb10.setDisable(true);
		rb11.setDisable(true);
		rb12.setDisable(true);
		rb13.setDisable(true);
		rb14.setDisable(true);
		rb15.setDisable(true);
		rb16.setDisable(true);
		
		tf2.setDisable(true);
		tf3.setDisable(true);
		tf4.setDisable(true);
		
		start2.setDisable(true);
		start3.setDisable(true);
		start4.setDisable(true);
	
		//Listeners for all the RB for figure selection 
		g1.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {		
			@Override
			public void changed(ObservableValue<? extends Toggle> arg0, Toggle arg1, Toggle arg2) {
				// Cast object to radio button
				RadioButton chk = (RadioButton)arg2.getToggleGroup().getSelectedToggle(); 
	         
	            if (chk == rb1) {	           
	            	chosenButton = rb1;	            	
	            }
	            else if (chk == rb2) {
	            	chosenButton = rb2;
	            }
	            else if (chk == rb3) {
	            	chosenButton = rb3;
	            }
	            else if (chk == rb4) {
	            	chosenButton = rb4;
	            }
			}			
		});
				
		start1.setOnAction(e -> {
			//Checks to see if input field and radio button are not left empty/unselected
			if (tf1.getText() != null && !tf1.getText().isEmpty()&&g1.getSelectedToggle()!=null) {
				
				//Assigns a figure to the player based on their selection and enables the next set buttons and text field except the ones representing the same figure
				if (chosenButton == rb1) {
					Player player1 = new Player(tf1.getText(), figure1);
					allPlayerList.add(player1);
					System.out.println(player1);
					
					rb6.setDisable(false);
					rb7.setDisable(false);
					rb8.setDisable(false);
					tf2.setDisable(false);
					start2.setDisable(false);	
				}
				else if (chosenButton == rb2) {
					Player player1 = new Player(tf1.getText(), figure2);
					allPlayerList.add(player1);
					System.out.println(player1);
					
					rb5.setDisable(false);
					rb7.setDisable(false);
					rb8.setDisable(false);
					tf2.setDisable(false);
					start2.setDisable(false);
				}
				else if (chosenButton == rb3) {
					Player player1 = new Player(tf1.getText(), figure3);
					allPlayerList.add(player1);
					System.out.println(player1);
					
					rb5.setDisable(false);
					rb6.setDisable(false);
					rb8.setDisable(false);
					tf2.setDisable(false);
					start2.setDisable(false);
				}
				else if (chosenButton == rb4) {
					Player player1 = new Player(tf1.getText(), figure4);
					allPlayerList.add(player1);
					System.out.println(player1);
					
					rb5.setDisable(false);
					rb6.setDisable(false);
					rb7.setDisable(false);
					tf2.setDisable(false);
					start2.setDisable(false);
				}
				//Disables first input field, confirmation button and set of radio buttons			
				rb1.setDisable(true);
				rb2.setDisable(true);
				rb3.setDisable(true);
				rb4.setDisable(true);
				tf1.setDisable(true);
				start1.setDisable(true);
												
			}
		});
		
		g2.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {		
			@Override
			public void changed(ObservableValue<? extends Toggle> arg0, Toggle arg1, Toggle arg2) {
				RadioButton chk = (RadioButton)arg2.getToggleGroup().getSelectedToggle(); 
	 
	            if (chk == rb5) {	       
	            	chosenButton2 = rb5;	            	
	            }
	            else if (chk == rb6) {
	            	chosenButton2 = rb6;
	            }
	            else if (chk == rb7) {
	            	chosenButton2 = rb7;
	            }
	            else if (chk == rb8) {
	            	chosenButton2 = rb8;
	            }
			}	
		});
		
		start2.setOnAction(e -> {
			if (tf2.getText() != null && !tf2.getText().isEmpty()&&g2.getSelectedToggle()!=null){
				
				if (chosenButton2 == rb5) {
					Player player2 = new Player(tf2.getText(), figure1);
					allPlayerList.add(player2);
					System.out.println(player2);
					
					rb10.setDisable(false);
					rb11.setDisable(false);
					rb12.setDisable(false);
					tf3.setDisable(false);
					start3.setDisable(false);
					
					if(chosenButton == rb2) {
						rb10.setDisable(true);
					}
					else if(chosenButton == rb3) {
						rb11.setDisable(true);
					}
					else if(chosenButton == rb4) {
						rb12.setDisable(true);
					}
				}
				else if (chosenButton2 == rb6) {
					Player player2 = new Player(tf2.getText(), figure2);
					allPlayerList.add(player2);
					System.out.println(player2);
					
					rb9.setDisable(false);
					rb11.setDisable(false);
					rb12.setDisable(false);
					tf3.setDisable(false);
					start3.setDisable(false);
					
					if(chosenButton == rb1) {
						rb9.setDisable(true);
					}
					else if(chosenButton == rb3) {
						rb11.setDisable(true);
					}
					else if(chosenButton == rb4) {
						rb12.setDisable(true);
					}
				}
				else if (chosenButton2 == rb7) {
					Player player2 = new Player(tf2.getText(), figure3);
					allPlayerList.add(player2);
					System.out.println(player2);
					
					rb9.setDisable(false);
					rb10.setDisable(false);
					rb12.setDisable(false);
					tf3.setDisable(false);
					start3.setDisable(false);
					
					if(chosenButton == rb2) {
						rb10.setDisable(true);
					}
					else if(chosenButton == rb1) {
						rb9.setDisable(true);
					}
					else if(chosenButton == rb4) {
						rb12.setDisable(true);
					}
				}
				else if (chosenButton2 == rb8||chosenButton == rb4) {
					Player player2 = new Player(tf2.getText(), figure4);
					allPlayerList.add(player2);
					System.out.println(player2);
					
					rb9.setDisable(false);
					rb10.setDisable(false);
					rb11.setDisable(false);
					tf3.setDisable(false);
					start3.setDisable(false);
					
					if(chosenButton == rb2) {
						rb10.setDisable(true);
					}
					else if(chosenButton == rb3) {
						rb11.setDisable(true);
					}
					else if(chosenButton == rb1) {
						rb9.setDisable(true);
					}
				}
				
				rb5.setDisable(true);
				rb6.setDisable(true);
				rb7.setDisable(true);
				rb8.setDisable(true);
				tf2.setDisable(true);
				start2.setDisable(true);
				
				//After a second player has been created an animated label with instructions with how to proceed will appear 	
				FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1.0), label);
				fadeTransition.setFromValue(0.3);		
				fadeTransition.setToValue(1.0);
				fadeTransition.setAutoReverse(true);
				fadeTransition.setCycleCount(Animation.INDEFINITE);
				fadeTransition.play();
				pane.getChildren().add(label);
			}
		});	
		
		g3.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			@Override
			public void changed(ObservableValue<? extends Toggle> arg0, Toggle arg1, Toggle arg2) {
				RadioButton chk = (RadioButton)arg2.getToggleGroup().getSelectedToggle(); 
	         
	            if (chk == rb9) {
	            	chosenButton3 = rb9;    	
	            }
	            else if (chk == rb10) {
	            	chosenButton3 = rb10;
	            }
	            else if (chk == rb11) {
	            	chosenButton3 = rb11;
	            }
	            else if (chk == rb12) {
	            	chosenButton3 = rb12;
	            }	
			}
		});
		
		start3.setOnAction(e -> {
		    if (tf3.getText() != null && !tf3.getText().isEmpty()&&g3.getSelectedToggle()!=null){
		    	if (chosenButton3 == rb9) {
		    		Player player3 = new Player(tf3.getText(), figure1);
					allPlayerList.add(player3);
					System.out.println(player3);
					
					rb14.setDisable(false);
					rb15.setDisable(false);
					rb16.setDisable(false);
					tf4.setDisable(false);
					start4.setDisable(false);
					
					if(chosenButton == rb2||chosenButton2==rb6) {
						rb14.setDisable(true);
					}
					if(chosenButton == rb3||chosenButton2==rb7) {
						rb15.setDisable(true);
					}
					if(chosenButton == rb4||chosenButton2==rb8) {
						rb16.setDisable(true);
					}
					
		    	}
		    	if (chosenButton3 == rb10) {
		    		Player player3 = new Player(tf3.getText(), figure2);
					allPlayerList.add(player3);
					System.out.println(player3);
					
					rb13.setDisable(false);
					rb15.setDisable(false);
					rb16.setDisable(false);
					tf4.setDisable(false);
					start4.setDisable(false);
					
					if(chosenButton == rb1||chosenButton2==rb5) {
						rb13.setDisable(true);
					}
					if(chosenButton == rb3||chosenButton2==rb7) {
						rb15.setDisable(true);
					}
					if(chosenButton == rb4||chosenButton2==rb8) {
						rb16.setDisable(true);
					}
					
		    	}
		    	if (chosenButton3 == rb11) {
		    		Player player3 = new Player(tf3.getText(), figure3);
					allPlayerList.add(player3);
					System.out.println(player3);
					
					rb13.setDisable(false);
					rb14.setDisable(false);
					rb16.setDisable(false);
					tf4.setDisable(false);
					start4.setDisable(false);
					
					if(chosenButton == rb2||chosenButton2==rb6) {
						rb14.setDisable(true);
					}
					if(chosenButton == rb1||chosenButton2==rb5) {
						rb13.setDisable(true);
					}
					if(chosenButton == rb4||chosenButton2==rb8) {
						rb16.setDisable(true);
					}
		    	}
		    	if (chosenButton == rb12) {
		    		Player player3 = new Player(tf3.getText(), figure4);
					allPlayerList.add(player3);
					System.out.println(player3);
					
					rb13.setDisable(false);
					rb14.setDisable(false);
					rb15.setDisable(false);
					tf4.setDisable(false);
					start4.setDisable(false);
					
					if(chosenButton == rb2||chosenButton2==rb6) {
						rb14.setDisable(true);
					}
					if(chosenButton == rb3||chosenButton2==rb7) {
						rb15.setDisable(true);
					}
					if(chosenButton == rb1||chosenButton2==rb5) {
						rb13.setDisable(true);
					}
		    	}
				
				rb9.setDisable(true);
				rb10.setDisable(true);
				rb11.setDisable(true);
				rb12.setDisable(true);
				tf3.setDisable(true);
				start3.setDisable(true);
			}
		});
		
		g4.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			@Override
			public void changed(ObservableValue<? extends Toggle> arg0, Toggle arg1, Toggle arg2) {			
				RadioButton chk = (RadioButton)arg2.getToggleGroup().getSelectedToggle(); 
	          
	            if (chk == rb13) {
	            	chosenButton = rb13;
	            	
	            }
	            else if (chk == rb14) {
	            	chosenButton = rb14;
	            }
	            else if (chk == rb15) {
	            	chosenButton = rb15;
	            }
	            else if (chk == rb16) {
	            	chosenButton = rb16;
	            }
			}
		});
		
		start4.setOnAction(e -> {   
			if (tf4.getText() != null && !tf4.getText().isEmpty()&&g4.getToggles()!=null){
				if (chosenButton == rb13) {
					Player player4 = new Player(tf4.getText(), figure1);
					allPlayerList.add(player4);
					System.out.println(player4);
				}
				if (chosenButton == rb14) {
					Player player4 = new Player(tf4.getText(), figure2);
					allPlayerList.add(player4);
					System.out.println(player4);
				}
				if (chosenButton == rb15) {
					Player player4 = new Player(tf4.getText(), figure3);
					allPlayerList.add(player4);
					System.out.println(player4);
				}
				if (chosenButton == rb16) {
					Player player4 = new Player(tf4.getText(), figure4);
					allPlayerList.add(player4);
					System.out.println(player4);
				}
				
				rb13.setDisable(true);
				rb14.setDisable(true);
				rb15.setDisable(true);
				rb16.setDisable(true);
				tf4.setDisable(true);
				start4.setDisable(true);
			}
		});	
		
		pane.getChildren().addAll(l1,l2,l3,l4, tf1, tf2, tf3, tf4,iv1,
				rb1,rb2,rb3,rb4, rb5, rb6,rb7,rb8,rb9,rb10,rb11,
				rb12,rb13,rb14,rb15,rb16, l5, start1, start2, start3, start4);		
	}
	
	public Pane getPane() {
		
		return pane;
	}
}
