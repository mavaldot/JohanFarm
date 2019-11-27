package model;

import java.io.Serializable;

/**
 * Abstract class to represent a fish on the farm
 * 
 * @author Mateo
 *
 */
public abstract class Fish extends Animal implements MoneyAdder, Serializable {

	protected double size;
	
	/**
	 * Constructor
	 * 
	 * @param num The fish's number
	 * @param price The fish's price
	 * @param size The fish's size
	 */
	public Fish(int num, double price, double size) {
		super(num, price);
		this.size = size;
		// TODO Auto-generated constructor stub
	}
	
}
