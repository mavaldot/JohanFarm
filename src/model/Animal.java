	package model;

import java.io.Serializable;

/**
 * Abstract class to represent animals (any kind) in the context of the application's world
 * 
 * @author Mateo
 *
 */
public abstract class Animal implements Serializable {

	protected int number;
	protected double price;

	public Animal(int num, double pric) {
		number = num;
		price = pric;
	}
	
	/**
	 * 
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}
	
	/**
	 * 
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
}
