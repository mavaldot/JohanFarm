package model;

import java.io.Serializable;

public abstract class Animal implements Serializable {

	protected int number;

	public Animal(int num) {
		number = num;
	}
}
