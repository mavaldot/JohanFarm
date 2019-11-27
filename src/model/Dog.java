package model;

/**
 * A class that represents a dog in the farm
 * 
 * @author Mateo
 *
 */
public class Dog extends Mammal {

	public final static double PRICE = 500;
	
	/**
	 * Constructor
	 * 
	 * @param num The dog's number
	 * @param nm The dog's name
	 * @param wt The dog's weight
	 */
	public Dog(int num, String nm, double wt) {
		super(num, PRICE, nm, wt);
		// TODO Auto-generated constructor stub
	}
	
}
