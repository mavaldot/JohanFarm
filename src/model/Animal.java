package model;

import java.io.Serializable;

public abstract class Animal implements Serializable {

	protected int number;
	protected double price;

	public Animal(int num, double pric) {
		number = num;
		price = pric;
	}
	
	public int getNumber() {
		return number;
	}
	
	public double getPrice() {
		return price;
	}
}
