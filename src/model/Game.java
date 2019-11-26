package model;

import java.io.Serializable;
import java.util.Random;

public class Game implements Serializable {

	private Trout rootTrout;
	private Tilapia firstTilapia;
	private double money;
	
	private final Random rand = new Random();
	
	public Game() {
		
	}
	
	public void begin() {
		money = 0;
	}
	
	public void addTilapia() {
		
		int num = rand.nextInt(1000);
		double size = rand.nextDouble()*50;
		
		if (firstTilapia == null)
			firstTilapia = new Tilapia(num, size);
		else
			firstTilapia.addTilapia(new Tilapia(num, size));
		
	}
	
	public void calculateMoney() {
		
		money += 0.1;
		money += firstTilapia != null ? firstTilapia.addMoney() : 0;
		
	}
	
	public double getMoney() {
		
		return money;
		
	}
	
}
