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
	private final static String musicFile = "afternoon.mp3";    
	final static Media sound = new Media(new File(musicFile).toURI().toString());
	final static MediaPlayer mediaPlayer = new MediaPlayer(sound);
	
	public MusicThread() {
		

		
		setDaemon(true);
	}
	
	/**
	 * This will be executed as a thread
	 */
	public void run() {
		

		mediaPlayer.play();
		
	}
	
	
	
}
