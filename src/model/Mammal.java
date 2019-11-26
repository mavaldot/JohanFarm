package model;

public abstract class Mammal extends Animal{

	private String name;
	private String weight;
	
	public Mammal(int num, String nm, String wt) {
		super(num);
		name = nm;
		weight = wt;
	}
	
}
