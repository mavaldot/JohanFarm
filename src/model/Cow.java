package model;

public class Cow extends Mammal implements MoneyAdder {

	public final static double VALUE = 5;
	public final static double PRICE = 100;
	
	private Cow next;
	
	public Cow(int num, String nm, double wt) {
		super(num, PRICE, nm, wt);
	}

	public void addCow(Cow c) {
		
		if (next == null)
			next = c;
		else
			next.addCow(c);
		
	}

	@Override
	public double addMoney() {
		
		if (next == null)
			return VALUE;
	
		return VALUE + next.addMoney();
		
	}
	
}
