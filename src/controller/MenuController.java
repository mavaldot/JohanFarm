package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Controls the first menu window
 * 
 * @author Mateo
 *
 */
public class MenuController {
	
	@FXML
	private Button start;
	
	/**
	 * Starts the game. Let's enjoy! The world is yours.
	 * 
	 * @param e JAVAFX ACTION EVENT
	 * @throws IOException
	 */
	public void startGame(ActionEvent e) throws IOException {
		
		Scene menuScene = ((Node) e.getSource()).getScene();
		
		FXMLLoader gameLoader = new FXMLLoader(getClass().getResource("/view/Game.fxml"));
		Parent gamePane = gameLoader.load();
		
		Stage stage = (Stage) menuScene.getWindow();
		Scene gameScene = new Scene(gamePane, 800, 600);
		GameController gameController = (GameController) gameLoader.getController();
		gameController.setStage(stage);
		gameController.begin();
		stage.setScene(gameScene);
		
	}
	
}
