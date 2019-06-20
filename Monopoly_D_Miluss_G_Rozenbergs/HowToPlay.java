/**
 * A class used for the visual representation of "How To Play" window
 */

package model;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class HowToPlay {
	private final Text txt;
	private final Pane pane;


	public HowToPlay() {

		Label l1 = new Label("Game Mechanics: ");
		Label l2 = new Label("Rules: ");
		Label l3 = new Label ("HOW TO PLAY");
		Label l4 = new Label("Press start and roll");
		
		txt = new Text();
		pane = new Pane();
			
		BackgroundImage myBI= new BackgroundImage(new Image("file:HTPBG.jpg",1200,900,false,true),
		        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
		          BackgroundSize.DEFAULT);
		pane.setBackground(new Background(myBI));
		
		l1.setFont(Font.loadFont("file:MONOPOLY_INLINE.ttf",30));
		l1.setTranslateX(100);
		l1.setTranslateY(265);
		l2.setFont(Font.loadFont("file:MONOPOLY_INLINE.ttf",30));
		l2.setTranslateX(100);
		l2.setTranslateY(565);
		l3.setFont(Font.loadFont("file:MONOPOLY_INLINE.ttf",60));
		l3.setTextFill(Color.BLACK);
		l3.setTranslateX(400);
		l3.setTranslateY(50);
		l4.setFont(Font.loadFont("file:MONOPOLY_INLINE.ttf",20));
		l4.setTranslateX(100);
		l4.setTranslateY(300);
			
		pane.getChildren().addAll(l1,l2, l3, l4 );

	}
     
	public Pane getPane() {
		return pane;
	}
	
	public Text getTxt() {
		return txt;
	}
	
}
