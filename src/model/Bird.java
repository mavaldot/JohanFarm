package model;

public abstract class Bird extends Animal implements MoneyMultiplier {

	private int eggsPerWeek;
	
	public Bird(int num, int epw) {
		super(num);
		eggsPerWeek = epw;
	}

	public abstract double multiplyMoney(double money);
	
}
