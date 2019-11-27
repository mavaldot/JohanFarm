package model;

/**
 * Class that represents a cow in the farm. Cows are represented by a single linked list
 * 
 * @author Mateo
 *
 */
public class Cow extends Mammal implements MoneyAdder {

	public final static double VALUE = 5;
	public final static double PRICE = 100;
	
	private Cow next;
	
	/**
	 * Constructor
	 * 
	 * @param num The cow's number
	 * @param nm The cow's name
	 * @param wt The cow's weight
	 */
	public Cow(int num, String nm, double wt) {
		super(num, PRICE, nm, wt);
	}
	
	/**
	 * 
	 * @return The next cow in the linked list
	 */
	public Cow getNext() {
		return next;
	}
	
	/**
	 * Adds a new cow to the linked list
	 * 
	 * @param c The new cow
	 */
	public void addCow(Cow c) {
		
		if (next == null)
			next = c;
		else
			next.addCow(c);
		
	}

	/**
	 * Adds up all of the cow's values
	 * 
	 */
	@Override
	public double addMoney() {
		
		if (next == null)
			return VALUE;
	
		return VALUE + next.addMoney();
		
	}
}
