/**
 * A classed used for representing the visuals of "Credits" scene
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

public class Credits {
	
	private final Pane pane;

	public Credits() {
		
		pane = new Pane();
		BackgroundImage myBI= new BackgroundImage(new Image("file:CreditsBG.jpg",1200,900,false,true),
		        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
		          BackgroundSize.DEFAULT);
		pane.setBackground(new Background(myBI));
		
		Label l1 = new Label ("Created By: ");
		Label l2 = new Label ("With The Help Of: ");
		Label l3 = new Label ("CREDITS");
		
		l1.setFont(Font.loadFont("file:MONOPOLY_INLINE.ttf",30));
		l1.setTranslateX(300);
		l1.setTranslateY(265);
		l2.setFont(Font.loadFont("file:MONOPOLY_INLINE.ttf",30));
		l2.setTranslateX(300);
		l2.setTranslateY(565);
		l3.setFont(Font.loadFont("file:MONOPOLY_INLINE.ttf",60));
		l3.setTextFill(Color.BLACK);
		l3.setTranslateX(500);
		l3.setTranslateY(50);
		
		pane.getChildren().addAll(l1, l2, l3);
	}
	
	public Pane getPane() {
		
		return pane;
	}
}
