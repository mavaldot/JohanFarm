package model;

/**
 * Class to represent a chicken that belongs to the farm. Contains a reference to the next chicken,
 * thus creating a linked list
 * 
 * @author Mateo
 *
 */
public class Chicken extends Bird {

	public static final double MULTIPLIER = 1.01;
	public static final double PRICE = 10;
	
	private Chicken next;
	
	/**
	 * Constructor
	 * @param num number
	 * @param epw eggs per week - how many eggs the chicken lays in a week
	 */
	public Chicken(int num, int epw) {
		super(num, PRICE, epw);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * 
	 * @return the next chicken
	 */
	public Chicken getNext() {
		return next;
	}

	/**
	 * Multiplies the money by the chicken's multiplier
	 * 
	 * @param the money that will be multiplies
	 */
	@Override
	public double multiplyMoney(double money) {
		
		if (next == null)
			return money *= MULTIPLIER;
		else
			return next.multiplyMoney(money * MULTIPLIER);
		
	}
	
	/**
	 * Adds a new chicken to the linked list
	 * 
	 * @param c The new chicken
	 */
	public void addChicken(Chicken c) {
		
		if (next == null)
			next = c;
		else
			next.addChicken(c);
		
	}

	
	
}
