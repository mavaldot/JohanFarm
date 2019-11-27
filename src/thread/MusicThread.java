package thread;

import java.io.File;

import javafx.concurrent.Task;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * Thread for playing music in the background
 * 
 * @author Mateo
 *
 */
public class MusicThread extends Thread {

	/**
	 * Constructor
	 */
	public MusicThread() {
		
	}
	
	/**
	 * This will be executed as a thread
	 */
	public void run() {
		
		String musicFile = "afternoon.mp3";    

		Media sound = new Media(new File(musicFile).toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.play();
		
	}
	
	
	
}
