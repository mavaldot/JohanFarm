package model;

/**
 * Class to represent birds that lay eggs
 * 
 * @author Mateo
 *
 */
public abstract class Bird extends Animal implements MoneyMultiplier {

	protected int eggsPerWeek;
	
	/**
	 * Constructor
	 * 
	 * @param num The bird's number
	 * @param price The bird's price
	 * @param epw Eggs per week - how many eggs the bird lays per week
	 */
	public Bird(int num, double price, int epw) {
		super(num, price);
		eggsPerWeek = epw;
	}

	public abstract double multiplyMoney(double money);
	
}
