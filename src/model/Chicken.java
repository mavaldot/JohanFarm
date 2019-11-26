package model;

public class Chicken extends Bird {

	public static final double MULTIPLIER = 1.01;
	
	private Chicken next;
	
	public Chicken(int num, int epw) {
		super(num, epw);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double multiplyMoney(double money) {
		
		if (next == null)
			return money *= MULTIPLIER;
		else
			return next.multiplyMoney(money * MULTIPLIER);
		
	}
	
	public void addChicken(Chicken c) {
		
		if (next == null)
			next = c;
		else
			next.addChicken(c);
		
	}

	
	
}
