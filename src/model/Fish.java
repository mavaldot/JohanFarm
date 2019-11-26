package model;

import java.io.Serializable;

public abstract class Fish extends Animal implements MoneyAdder, Serializable {

	protected double size;
	
	public Fish(int num, double size) {
		super(num);
		// TODO Auto-generated constructor stub
	}
	
}
