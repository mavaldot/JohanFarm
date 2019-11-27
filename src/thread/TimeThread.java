package thread;

import controller.GameController;
import javafx.application.Platform;
import model.Time;

public class TimeThread extends Thread {

	Time time;
	GameController gc;
	
	/**
	 * A thread that connects the time with the game controller
	 * @param t The time
	 * @param gmc The game controller
	 */
	public TimeThread(Time t, GameController gmc) {
		
		time = t;
		gc = gmc;
		setDaemon(true);
	}
	
	/**
	 * This will be executed as a thread continiously. modifies the time and game contoller
	 */
	public void run() {
		
		while (true) {
		
			time.incrementTime();
			
			Platform.runLater(() -> gc.updateTime()); 
			
			try {
				sleep(1000);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
