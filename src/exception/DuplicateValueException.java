package exception;

/**
 * Excpetion for when two objects have duplicate values (and they shouldn't)
 * 
 * @author Mateo
 *
 */
public class DuplicateValueException extends Exception {

	public DuplicateValueException() {
		super();
	}
	
	public DuplicateValueException(String msg) {
		super(msg);
	}
	
}
