package model;

public abstract class Bird extends Animal implements MoneyMultiplier {

	private int eggsPerWeek;
	
	public Bird(int num, double price, int epw) {
		super(num, price);
		eggsPerWeek = epw;
	}

	public abstract double multiplyMoney(double money);
	
}
