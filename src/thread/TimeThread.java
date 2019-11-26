package thread;

import controller.GameController;
import javafx.application.Platform;
import model.Time;

public class TimeThread extends Thread {

	Time time;
	GameController gc;
	
	public TimeThread(Time t, GameController gmc) {
		
		time = t;
		gc = gmc;
		setDaemon(true);
	}
	
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
