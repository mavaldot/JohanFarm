package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import exception.DuplicateValueException;

/**
 * Class that handles the game's important functions and holds all the animals and data
 * 
 * @author Mateo
 *
 */
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
	
	/**
	 * Constructor
	 */
	public Game() {
		
	}
	
	/**
	 * Initializes the variables for when a new game is started
	 */
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
	
	/**
	 * 
	 * @return The first trout in the binary tree
	 */
	public Trout getRootTrout() {
		return rootTrout;
	}

	/**
	 * 
	 * @return The first tilapia in the linked list
	 */
	public Tilapia getFirstTilapia() {
		return firstTilapia;
	}

	/**
	 * 
	 * @return The first chicken in the linked list
	 */
	public Chicken getFirstChicken() {
		return firstChicken;
	}

	/**
	 * 
	 * @return The root duck in the binary tree
	 */
	public Duck getRootDuck() {
		return rootDuck;
	}
	
	/**
	 * 
	 * @return The first cow in the linked list
	 */
	public Cow getFirstCow() {
		return firstCow;
	}

	/**
	 * 
	 * @return The dog arraylist
	 */
	public ArrayList<Dog> getDogs() {
		return dogs;
	}

	/**
	 * 
	 * @return number of trouts in the farm
	 */
	public int getNumTrouts() {
		return numTrouts;
	}

	/**
	 * 
	 * @return number of tilapia in the farm
	 */
	public int getNumTilapia() {
		return numTilapia;
	}

	/**
	 * 
	 * @return number of chickens in the farm
	 */
	public int getNumChickens() {
		return numChickens;
	}

	/**
	 * 
	 * @return number of ducks in the farm
	 */
	public int getNumDucks() {
		return numDucks;
	}

	/**
	 * 
	 * @return number of cows in the farm
	 */
	public int getNumCows() {
		return numCows;
	}

	/**
	 * 
	 * @return number of dog in the farm
	 */
	public int getNumDogs() {
		return numDogs;
	}

	/**
	 * 
	 * @return The random object
	 */
	public Random getRand() {
		return rand;
	}

	/**
	 * Adds all the money earned by the animals. The money attribute is modified
	 * 
	 */
	public void calculateMoney() {
		
		money += firstTilapia != null ? firstTilapia.addMoney() : 0;
		money += rootTrout != null ? rootTrout.addMoney() : 0;
		money += firstChicken != null ? firstChicken.multiplyMoney(money) : 0;
		money += rootDuck != null ? rootDuck.multiplyMoney(money) : 0;
		money += firstCow != null ? firstCow.addMoney() : 0;
		
	}
	
	/**
	 * 
	 * @return The money earned
	 */
	public double getMoney() {
		
		return money;
		
	}
	
	/**
	 * Adds a new tilapia to the game
	 */
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

	/**
	 * Adds a new trout to the game
	 * 
	 * @throws DuplicateValueException
	 */
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

	/**
	 * Adds a new chicken to game
	 * 
	 */
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

	/**
	 * adds a new duck to the game
	 * 
	 * @throws DuplicateValueException
	 */
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

	/**
	 * Adds a new cow to game
	 * 
	 */
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

	/**
	 * Adds a new dog to game
	 * 
	 */
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
