package exception;

/**
 * Exception for when something goes wrong during serialization
 * 
 * @author Mateo
 *
 */
public class GameSerializationException extends Exception {

	public GameSerializationException() {
		super();
	}
	
	public GameSerializationException(String msg) {
		super(msg);
	}
	
}
