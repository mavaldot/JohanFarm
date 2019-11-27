package model;

public abstract class Mammal extends Animal{

	private String name;
	private double weight;
	
	public static final String[] names = {"Sparky", "Becky", "Milo", "Caramel", "Princess", "Pinkie Pie", "Twilight",
			"Sparkles", "Moody", "Happy", "Skippy", "Mateo", "Toby", "Max", "Teo", "Cato", "Sunny", "Crystal", "Paris",
			"Milan", "London", "Felix", "Timmy", "Niko", "Heidi", "Pikachu", "Charizard", "Mew", "King"};
	
	public Mammal(int num, double price, String nm, double wt) {
		super(num, price);
		name = nm;
		weight = wt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	
	
}
