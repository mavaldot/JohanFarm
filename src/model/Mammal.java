package model;

/**
 * Abstract class to represent any mammal
 * 
 * @author Mateo
 *
 */
public abstract class Mammal extends Animal{

	protected String name;
	protected double weight;
	
	public static final String[] names = {"Sparky", "Becky", "Milo", "Caramel", "Princess", "Pinkie Pie", "Twilight",
			"Sparkles", "Moody", "Happy", "Skippy", "Mateo", "Toby", "Max", "Teo", "Cato", "Sunny", "Crystal", "Paris",
			"Milan", "London", "Felix", "Timmy", "Niko", "Heidi", "Pikachu", "Charizard", "Mew", "King"};
	
	/**
	 * Constructor
	 * 
	 * @param num the mammal's number
	 * @param price The mammal's price
	 * @param nm The mammal's name
	 * @param wt The mamal's weight
	 */
	public Mammal(int num, double price, String nm, double wt) {
		super(num, price);
		name = nm;
		weight = wt;
	}

	/**
	 * 
	 * @return The mammal's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @return The mammal's weight
	 */
	public double getWeight() {
		return weight;
	}
	
	
}
