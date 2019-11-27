package exception;

/**
 * Exception for when a time .txt file has invalid content
 * 
 * @author Mateo
 *
 */
public class InvalidTimeFileException extends Exception {

	public InvalidTimeFileException() {
		super();
	}
	
	public InvalidTimeFileException(String msg) {
		super(msg);
	}
}
