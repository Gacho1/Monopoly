/**
 * A class used for handling the images and properties of dice
 */
package model;

import java.util.Random;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;


public class Dice {
	private int points;

	
	public Dice() {
		setPoints(1);
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	@Override
	public String toString() {
		return "Dice [points=" + points + "]";
	}
	
	public int roll() {
		Random rand = new Random();
		points = rand.nextInt(6) + 1;
		
		return points;
	}
	
	public void showDiceResult (GridPane grid, int result1, int result2) {
	
		//Images of dice sides
		Image i2 = new Image ("file:d1.png", 75, 75, false, false);
		Image i3 = new Image ("file:d2.png", 75, 75, false, false);
		Image i4 = new Image ("file:d3.png", 75, 75, false, false);
		Image i5 = new Image ("file:d4.png", 75, 75, false, false);
		Image i6 = new Image ("file:d5.png", 75, 75, false, false);;
		Image i7 = new Image ("file:d6.png", 75, 75, false, false);
		
		//IV for first dice
		ImageView iv2 = new ImageView(i2);
		ImageView iv3 = new ImageView(i3);
		ImageView iv4 = new ImageView(i4);
		ImageView iv5 = new ImageView(i5);
		ImageView iv6 = new ImageView(i6);
		ImageView iv7 = new ImageView(i7);
		
		//IV for second dice
		ImageView iv8 = new ImageView (i2);
		ImageView iv9 = new ImageView(i3);
		ImageView iv10 = new ImageView(i4);
		ImageView iv11 = new ImageView(i5);
		ImageView iv12 = new ImageView(i6);
		ImageView iv13 = new ImageView(i7);
		
		//First Dice locations on screen
		iv2.setTranslateX(890);
		iv2.setTranslateY(270);
		iv3.setTranslateX(890);
		iv3.setTranslateY(270);
		iv4.setTranslateX(890);
		iv4.setTranslateY(270);
		iv5.setTranslateX(890);
		iv5.setTranslateY(270);
		iv6.setTranslateX(890);
		iv6.setTranslateY(270);
		iv7.setTranslateX(890);
		iv7.setTranslateY(270);
		
		//Second Dice location on screen
		iv8.setTranslateX(970);
		iv8.setTranslateY(270);
		iv9.setTranslateX(970);
		iv9.setTranslateY(270);
		iv10.setTranslateX(970);
		iv10.setTranslateY(270);
		iv11.setTranslateX(970);
		iv11.setTranslateY(270);
		iv12.setTranslateX(970);
		iv12.setTranslateY(270);
		iv13.setTranslateX(970);
		iv13.setTranslateY(270);
		
		//You can only add the image view object once, so if you do not remove the rest possible options you will start getting error for trying to add an already existing image view
		if (result1 == 1) {
			grid.getChildren().remove(iv2);
			grid.getChildren().add(iv2);
			grid.getChildren().remove(iv3);
			grid.getChildren().remove(iv4);
			grid.getChildren().remove(iv5);
			grid.getChildren().remove(iv6);
			grid.getChildren().remove(iv7);
		}
		
		else if (result1 == 2) {
			grid.getChildren().remove(iv3);
			grid.getChildren().add(iv3);
			grid.getChildren().remove(iv2);
			grid.getChildren().remove(iv4);
			grid.getChildren().remove(iv5);
			grid.getChildren().remove(iv6);
			grid.getChildren().remove(iv7);
		}
		else if (result1 == 3) {
			grid.getChildren().remove(iv4);
			grid.getChildren().add(iv4);
			grid.getChildren().remove(iv3);
			grid.getChildren().remove(iv2);
			grid.getChildren().remove(iv5);
			grid.getChildren().remove(iv6);
			grid.getChildren().remove(iv7);
		}
		else if (result1 == 4) {
			grid.getChildren().remove(iv5);
			grid.getChildren().add(iv5);
			grid.getChildren().remove(iv3);
			grid.getChildren().remove(iv4);
			grid.getChildren().remove(iv2);
			grid.getChildren().remove(iv6);
			grid.getChildren().remove(iv7);
		}
		else if (result1 == 5) {
			grid.getChildren().remove(iv6);
			grid.getChildren().add(iv6);
			grid.getChildren().remove(iv3);
			grid.getChildren().remove(iv4);
			grid.getChildren().remove(iv5);
			grid.getChildren().remove(iv2);
			grid.getChildren().remove(iv7);
		}
		else if (result1 == 6) {
			grid.getChildren().remove(iv7);
			grid.getChildren().add(iv7);
			grid.getChildren().remove(iv3);
			grid.getChildren().remove(iv4);
			grid.getChildren().remove(iv5);
			grid.getChildren().remove(iv6);
			grid.getChildren().remove(iv2);
			
		}
		if (result2 == 1) {	
			grid.getChildren().remove(iv8);
			grid.getChildren().add(iv8);
			grid.getChildren().remove(iv9);
			grid.getChildren().remove(iv10);
			grid.getChildren().remove(iv11);
			grid.getChildren().remove(iv12);
			grid.getChildren().remove(iv13);
		}		
		else if (result2 == 2) {	
			grid.getChildren().remove(iv9);
			grid.getChildren().add(iv9);
			grid.getChildren().remove(iv8);
			grid.getChildren().remove(iv10);
			grid.getChildren().remove(iv11);
			grid.getChildren().remove(iv12);
			grid.getChildren().remove(iv13);
		}
		else if (result2 == 3) {			
			grid.getChildren().remove(iv10);
			grid.getChildren().add(iv10);
			grid.getChildren().remove(iv11);
			grid.getChildren().remove(iv12);
			grid.getChildren().remove(iv13);
			grid.getChildren().remove(iv9);
			grid.getChildren().remove(iv8);
		}
		else if (result2 == 4) {
			grid.getChildren().remove(iv11);
			grid.getChildren().add(iv11);
			grid.getChildren().remove(iv12);
			grid.getChildren().remove(iv13);
			grid.getChildren().remove(iv10);
			grid.getChildren().remove(iv9);
			grid.getChildren().remove(iv8);
		}
		else if (result2 == 5) {		
			grid.getChildren().remove(iv12);
			grid.getChildren().add(iv12);
			grid.getChildren().remove(iv13);
			grid.getChildren().remove(iv11);
			grid.getChildren().remove(iv10);
			grid.getChildren().remove(iv9);
			grid.getChildren().remove(iv8);
		}
		else if (result2 == 6) {
			grid.getChildren().remove(iv13);
			grid.getChildren().add(iv13);
			grid.getChildren().remove(iv12);
			grid.getChildren().remove(iv11);
			grid.getChildren().remove(iv10);
			grid.getChildren().remove(iv9);
			grid.getChildren().remove(iv8);
		}
			
	}
		
}

	
