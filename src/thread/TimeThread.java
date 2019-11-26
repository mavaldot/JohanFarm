package thread;

import model.Time;

public class TimeThread extends Thread {

	Time time;
	
	public TimeThread(Time t) {
		
		time = t;
		setDaemon(true);
	}
	
	public void run() {
		
		while (true) {
		
			time.incrementTime();
			try {
				sleep(1000);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
