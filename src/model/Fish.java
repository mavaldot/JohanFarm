package model;

import java.io.Serializable;

public abstract class Fish extends Animal implements MoneyAdder, Serializable {

	protected double size;
	
	public Fish(int num, double price, double size) {
		super(num, price);
		this.size = size;
		// TODO Auto-generated constructor stub
	}
	
}
