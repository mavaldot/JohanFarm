package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Beginner;
import model.Time;
import thread.TimeThread;

public class GameController implements Initializable, Beginner {

	Stage stage;
	
	@FXML Label l1;
	@FXML Label l2;
	
	@FXML AnchorPane ap;
	
	Time time;
	TimeThread tt;
	
	public void setStage(Stage stg) {
		
		stage = stg;
		
	}
	
	public void begin() {
		
		time = new Time();
		new TimeThread(time).start();
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		begin();
		
		l1 = new Label();
		l1.setText("hello");
		
		ap.getChildren().add(l1);
		
		
		new AnimationTimer() {

			@Override
			public void handle(long arg0) {
				l1.setText(time.getTime());
				
			}
			
		}.start();
	}
	
	
	
	
	
}
