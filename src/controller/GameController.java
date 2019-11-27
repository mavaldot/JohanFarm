package controller;

import java.net.URL;
import java.util.ResourceBundle;

import exception.DuplicateValueException;
import exception.GameSerializationException;
import exception.InvalidTimeException;
import exception.InvalidTimeFileException;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Beginner;
import model.FileHandler;
import model.Game;
import model.Time;
import thread.GameThread;
import thread.MusicThread;
import thread.TimeThread;
import view.Main;

/**
 * 
 * The game controller that connects the Game.fxml file in the view with the model
 * 
 * @author Mateo
 *
 */
public class GameController implements Initializable, Beginner {

	private Stage stage;
	
	@FXML private Label moneyLabel;
	@FXML private Label timeLabel;
	
	@FXML private AnchorPane ap;
	
	@FXML private Label l1;
	@FXML private Label l2;
	@FXML private Label l3;
	@FXML private Label l4;
	@FXML private Label l5;
	@FXML private Label l6;
	
	private Time time;
	private TimeThread tt;
	
	private Game game;
	
	private FileHandler fHandler;
	
	public void setStage(Stage stg) {
		
		stage = stg;
		
	}
	
	/**
	 * Initializes many important variables and does file I/0. Also starts the threads.
	 * 
	 */
	public void begin() {
		
		ap.getStylesheets().add(Main.class.getResource("application.css").toExternalForm());
		
		fHandler = new FileHandler();
		
		try {
			game = fHandler.loadGame();
			time = fHandler.loadTime();
		}
		catch (GameSerializationException e) {
//			e.printStackTrace();
		} 
		catch (InvalidTimeFileException e) {
//			e.printStackTrace();
		}
		
		if (time == null) 
			time = new Time();
		
		
		new TimeThread(time, this).start();
		
		if (game == null) {
			game = new Game();
			game.begin();
		}
			
		
		new GameThread(game, this).start();
		
		new MusicThread().start();
	}

	
	/**
	 * Creates some graphical components of the window that the application will use
	 * 
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		begin();
		
		moneyLabel = new Label();
		moneyLabel.setText("hello");
		
		timeLabel = new Label();
		timeLabel.setTranslateX(600);
		timeLabel.setText("johan");
		
		ap.getChildren().add(moneyLabel);
		ap.getChildren().add(timeLabel);
	
//		new AnimationTimer() {
//
//			@Override
//			public void handle(long arg0) {
//				l1.setText(time.getTime());
//				
//			}
//			
//		}.start();
	}
	
	/**
	 * Updates the labels related to the game information
	 * 
	 */
	public void updateLabels() {
		
		moneyLabel.setText(String.format("Money: %.1f", game.getMoney()));
		
		l1.setText("Quantity: " + game.getNumTilapia());
		l2.setText("Quantity: " + game.getNumTrouts());
		l3.setText("Quantity: " + game.getNumChickens());
		l4.setText("Quantity: " + game.getNumDucks());
		l5.setText("Quantity: " + game.getNumCows());
		l6.setText("Quantity: " + game.getNumDogs());
		
	}

	/**
	 * Update the time label
	 * 
	 */
	public void updateTime() {
		timeLabel.setText("Time: " + time.getTime());
	}
	
	/**
	 * calls the game method to add a new tilapia
	 * 
	 * @param e JAVAFX ACTIONEVENT
	 */
	public void addTilapia(ActionEvent e) {
		game.addTilapia();
	}
	
	/**
	 * calls the game method to add a new trout
	 * 
	 * @param e JAVAFX ACTIONEVENT
	 */
	public void addTrout(ActionEvent e) {
		try {
			game.addTrout();
		} catch (DuplicateValueException e1) {
//			e1.printStackTrace();
		}
	}
	
	/**
	 * calls the game method to add a new chicken
	 * 
	 * @param e JAVAFX ACTIONEVENT
	 */
	public void addChicken(ActionEvent e) {
		game.addChicken();
	}
	
	/**
	 * calls the game method to add a new duck
	 * 
	 * @param e JAVAFX ACTIONEVENT
	 */
	public void addDuck(ActionEvent e) {
		try {
			game.addDuck();
		}
		catch (DuplicateValueException e1) {
//			e1.printStackTrace();
		}
	}
	
	/**
	 * calls the game method to add a new cow
	 * 
	 * @param e JAVAFX ACTIONEVENT
	 */
	public void addCow(ActionEvent e) {
		game.addCow();
	}
	
	/**
	 * calls the game method to add a new dog
	 * 
	 * @param e JAVAFX ACTIONEVENT
	 */
	public void addDog(ActionEvent e) {
		game.addDog();
	}
	
	
	/**
	 * Saves the game using the file handler
	 * 
	 * @param e JAVAFX ACTIONEVENT
	 */
	public void saveGame(ActionEvent e) {
		try {
			fHandler.saveGame(game);
			fHandler.saveTime(time);
		}
		catch (GameSerializationException e1) {
//			e1.printStackTrace();
		} 
		catch (InvalidTimeException e1) {
//			e1.printStackTrace();
		}
		
	}
	
	
}
