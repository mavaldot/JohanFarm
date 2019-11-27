package thread;

import controller.GameController;
import javafx.application.Platform;
import model.Game;

public class GameThread extends Thread {

	private Game game;
	private GameController gc;
	
	public GameThread(Game game, GameController gc) {
		this.game = game;
		this.gc = gc;
		setDaemon(true);
	}
	
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
