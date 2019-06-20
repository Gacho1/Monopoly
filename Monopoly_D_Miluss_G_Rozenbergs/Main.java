/**
 * Main, only used for launching the app, creating the starting menu and allowing for movement trough different stages
 */
package main;



import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Board;
import model.Credits;
import model.HowToPlay;


public class Main extends Application{

	static Image bcg = new Image ("file:MenuBG.jpg");
	
	StackPane pane = new StackPane();
	Scene scene = new Scene (pane, 1200, 900);
	Stage p1 = new Stage();
	Stage p3 = new Stage();
	Stage p4 = new Stage();
	Stage primaryStage = new Stage();
     
    
	public static void main(String[] args) {
		launch(args);
	}
	
	private Parent createContent() {
		Pane root  = new Pane();
		root.setPrefSize(1200, 900);
		
		ImageView iv = new ImageView(bcg);		
		root.getChildren().add(iv);
		
		MenuBox v1 = new MenuBox(
				new MenuItem("New Game"));
		MenuBox v2 = new MenuBox(
				new MenuItem("Load Game"));
		MenuBox v3 = new MenuBox(
				new MenuItem("How To Play"));
		MenuBox v4 = new MenuBox(
				new MenuItem("Credits"));
		MenuBox v5 = new MenuBox(
				new MenuItem("Quit Game"));
				
		v1.setTranslateX(490);
		v1.setTranslateY(450);
		v2.setTranslateX(490);
		v2.setTranslateY(500);
		v3.setTranslateX(490);
		v3.setTranslateY(550);
		v4.setTranslateX(490);
		v4.setTranslateY(600);
		v5.setTranslateX(490);
		v5.setTranslateY(650);
		
		v1.setOnMouseClicked(e -> {
		    Board board = new Board();
		    
		    p1.getScene().setRoot(board.getPlcr1().getPane());
			p1.setTitle("New Game");
		    p1.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
		    	 if(key.getCode()==KeyCode.ESCAPE) {
		    		p1.setTitle("Ventspils Monopols"); 
		    		p1.getScene().setRoot(root);
		    		p1.setFullScreen(false);
		    		 
		    	 }
		    	 if(key.getCode()==KeyCode.ENTER) {
		    		 p1.getScene().setRoot(board.getGrid());
		    	
		    		 p1.setFullScreenExitHint("");
		    		 p1.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
		    		 p1.setFullScreen(true);
		    
		    	 }
		    	 
		    });
		
		});
		v2.setOnMouseClicked(e-> System.out.println("Currently Unavailable"));
		
		v3.setOnMouseClicked(e -> {
		    HowToPlay htp = new HowToPlay();
		    p3.getScene().setRoot(htp.getPane());
		    p3.setTitle("How To Play");
		    p3.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
		    	 if(key.getCode()==KeyCode.ESCAPE) {
		    		p3.setTitle("Ventspils Monopols");
		    		p3.getScene().setRoot(root);
		    		 
		    	 }
		    });
		
		});
		
		v4.setOnMouseClicked(e -> {
		    Credits crd = new Credits();
		    p4.getScene().setRoot(crd.getPane());
		    p4.setTitle("Credits");
		    p4.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
		    	 if(key.getCode()==KeyCode.ESCAPE) {
		    		p4.setTitle("Ventspils Monopols"); 
		    		p4.getScene().setRoot(root);
		    			 
		    	 }		    	
		    });
				    
		});
		v5.setOnMouseClicked(e-> Platform.exit());
		
		root.getChildren().addAll(v1, v2, v3, v4, v5);
		
		return root;
	
		
	}
	public void start(Stage primaryStage) throws Exception {
		Scene scene = new Scene(createContent());
		p1=primaryStage;
		p3=primaryStage;
		p4 = primaryStage;
		

		primaryStage.setResizable(false);

		primaryStage.setTitle("Ventspils Monopols");
		primaryStage.setScene(scene);
		
		primaryStage.show();
	}

	//Class that represents the menu box as a whole 
	public static class MenuBox extends VBox{
		public MenuBox(MenuItem... items) {
			getChildren().add(createSeperator());
			
			for(MenuItem item : items) {
				getChildren().addAll(item, createSeperator());
				
			}
		}
		private Line createSeperator() {
			Line sep = new Line();
			sep.setEndX(200);
			sep.setStroke(Color.DARKGRAY);
			return sep;
		}
	}
	//Class that sets the actions for the menu items, and their properties. Like for example color change and how it is represented on mouse over and click
	public static class MenuItem extends StackPane{
		public MenuItem(String name) {
			LinearGradient gradient = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, new Stop[] {
					new Stop(0, Color.GREEN),
					new Stop(0.2, Color.BLACK),
					new Stop(0.8, Color.BLACK),
					new Stop(1, Color.GREEN)
			});
			
			Rectangle bg = new Rectangle (200, 50);
			bg.setOpacity(0.4);
			
			Text txt = new Text(name);
			txt.setFill(Color.DARKGRAY);
			txt.setFont(Font.font("Tw Cen MT Condensed", FontWeight.SEMI_BOLD, 30));
			
			setAlignment(Pos.CENTER);
			getChildren().addAll(bg, txt);
			
			setOnMouseEntered(event ->{
				bg.setFill(gradient);
				txt.setFill(Color.WHITE);
			});
			
			setOnMouseExited(event -> {
				bg.setFill(Color.BLACK);
				txt.setFill(Color.DARKGRAY);
			});
			setOnMousePressed(event -> {
				bg.setFill(Color.GREEN);
			});
			setOnMouseReleased(event -> {
				bg.setFill(gradient);
			});
		}
		
	}

}
