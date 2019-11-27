package exception;

/**
 * Exception for when a time has problems (i.e. illegal values such as negative seconds)
 * 
 * @author Mateo
 *
 */
public class InvalidTimeException extends Exception {

	public InvalidTimeException() {
		super();
	}
	
	public InvalidTimeException(String msg) {
		super(msg);
	}
	
}
