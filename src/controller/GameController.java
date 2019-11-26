package controller;

import java.net.URL;
import java.util.ResourceBundle;

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
import thread.TimeThread;
import view.Main;

public class GameController implements Initializable, Beginner {

	private Stage stage;
	
	@FXML private Label l1;
	@FXML private Label l2;
	
	@FXML private AnchorPane ap;
	
	private Time time;
	private TimeThread tt;
	
	private Game game;
	
	private FileHandler fHandler;
	
	public void setStage(Stage stg) {
		
		stage = stg;
		
	}
	
	public void begin() {
		
		ap.getStylesheets().add(Main.class.getResource("application.css").toExternalForm());
		
		fHandler = new FileHandler();
		
		try {
			game = fHandler.loadGame();
			time = fHandler.loadTime();
		} catch (GameSerializationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidTimeFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (time == null) 
			time = new Time();
		
		
		new TimeThread(time, this).start();
		
		if (game == null) {
			game = new Game();
			game.begin();
		}
			
		
		new GameThread(game, this).start();
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		begin();
		
		l1 = new Label();
		l1.setText("hello");
		
		l2 = new Label();
		l2.setTranslateX(200);
		l2.setText("johan");
		
		ap.getChildren().add(l1);
		ap.getChildren().add(l2);
	
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
	
	public void updateL1() {
		
		l1.setText(String.format("Money: %.1f", game.getMoney()));
		
	}

	public void updateTime() {
		l2.setText(time.getTime());
	}
	
	public void addTilapia(ActionEvent e) {
		game.addTilapia();
	}
	
	public void saveGame(ActionEvent e) {
		try {
			fHandler.saveGame(game);
			fHandler.saveTime(time);
		} catch (GameSerializationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InvalidTimeException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	
}
