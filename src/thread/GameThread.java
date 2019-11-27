package thread;

import controller.GameController;
import javafx.application.Platform;
import model.Game;

/**
 * A thread that connects the game with the gamecontroller 
 * 
 * @author Mateo
 *
 */
public class GameThread extends Thread {

	private Game game;
	private GameController gc;
	
	/**
	 * Constructor
	 * 
	 * @param game This thread's game
	 * @param gc The game controller
	 */
	public GameThread(Game game, GameController gc) {
		this.game = game;
		this.gc = gc;
		setDaemon(true);
	}
	
	/**
	 * This will be executed as a thread continiously. modifies the game and game controller
	 */
	public void run() {
		
		while(true) {
			
			game.calculateMoney();
			
			Platform.runLater(() -> gc.updateLabels());
			
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
