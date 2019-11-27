package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import exception.DuplicateValueException;

public class Game implements Serializable, Beginner {

	private Trout rootTrout;
	private Tilapia firstTilapia;
	private Chicken firstChicken;
	private Duck rootDuck;
	private Cow firstCow;
	private ArrayList<Dog> dogs;
	
	
	private double money;
	
	private int numTrouts;
	private int numTilapia;
	private int numChickens;
	private int numDucks;
	private int numCows;
	private int numDogs;
	
	private final Random rand = new Random();
	
	public Game() {
		
	}
	
	public void begin() {
		money = 5;
		numTrouts = 0;
		numTilapia = 0;
		numChickens = 0;
		numDucks = 0;
		numCows = 0;
		numDogs = 0;
		
		dogs = new ArrayList<Dog>();
	}
	
	
	
	public Trout getRootTrout() {
		return rootTrout;
	}

	public Tilapia getFirstTilapia() {
		return firstTilapia;
	}

	public Chicken getFirstChicken() {
		return firstChicken;
	}

	public Duck getRootDuck() {
		return rootDuck;
	}

	public Cow getFirstCow() {
		return firstCow;
	}

	public ArrayList<Dog> getDogs() {
		return dogs;
	}

	public int getNumTrouts() {
		return numTrouts;
	}

	public int getNumTilapia() {
		return numTilapia;
	}

	public int getNumChickens() {
		return numChickens;
	}

	public int getNumDucks() {
		return numDucks;
	}

	public int getNumCows() {
		return numCows;
	}

	public int getNumDogs() {
		return numDogs;
	}

	public Random getRand() {
		return rand;
	}

	public void calculateMoney() {
		
		money += firstTilapia != null ? firstTilapia.addMoney() : 0;
		money += rootTrout != null ? rootTrout.addMoney() : 0;
		money += firstChicken != null ? firstChicken.multiplyMoney(money) : 0;
		money += rootDuck != null ? rootDuck.multiplyMoney(money) : 0;
		money += firstCow != null ? firstCow.addMoney() : 0;
		
	}
	
	public double getMoney() {
		
		return money;
		
	}
	
	public void addTilapia() {
		
		if (money >= Tilapia.PRICE) {
		
			int num = rand.nextInt(1000);
			double size = rand.nextDouble()*50;
			
			if (firstTilapia == null)
				firstTilapia = new Tilapia(num, size);
			else
				firstTilapia.addTilapia(new Tilapia(num, size));
			
			++numTilapia;
			money -= Tilapia.PRICE;
			
		}
		
	}

	public void addTrout() throws DuplicateValueException {
		
		if (money >= Trout.PRICE) {

			int num = rand.nextInt(1000);
			double size = rand.nextDouble()*50;
			Trout t = new Trout(num, size);
			
			if (rootTrout == null) {
				rootTrout = t;
			}
			else
				rootTrout.addTrout(t);
			
			++numTrouts;
			money -= Trout.PRICE;
		}
	}

	public void addChicken() {
		
		if (money >= Chicken.PRICE) {
			
			int num = rand.nextInt(1000);
			int epw = rand.nextInt(25);
			Chicken c = new Chicken(num, epw);
			
			if (firstChicken == null) {
				firstChicken = c;
			}
			else
				firstChicken.addChicken(c);
			
			++numChickens;			
			money -= Chicken.PRICE;
		}
	}

	public void addDuck() throws DuplicateValueException {
		
		if (money >= Duck.PRICE) {
			
			int num = rand.nextInt(1000);
			int epw = rand.nextInt(25);
			Duck d = new Duck(num, epw);
			
			if (rootDuck == null) {
				rootDuck = d;
			}
			else
				rootDuck.addDuck(d);
			
			++numDucks;			
			money -= Duck.PRICE;
		}
		
	}

	public void addCow() {
		
		if (money >= Cow.PRICE) {
			
			int num = rand.nextInt(1000);
			int index = rand.nextInt(Mammal.names.length);
			String name = Mammal.names[index];
			double weight = rand.nextDouble() * 30;
			
			Cow c = new Cow(num, name, weight);
			
			if (firstCow == null)
				firstCow = c;
			else
				firstCow.addCow(c);
			
			++numCows;
			money -= Cow.PRICE;
		}
		
		
	}

	public void addDog() {
		
		if (money >= Dog.PRICE) {
			
			int num = rand.nextInt(1000);
			int index = rand.nextInt(Mammal.names.length);
			String name = Mammal.names[index];
			double weight = rand.nextDouble() * 30;
			dogs.add(new Dog(num, name, weight));
			
			++numDogs;
			money -= Dog.PRICE;
		}
		
		
	}
	
}
