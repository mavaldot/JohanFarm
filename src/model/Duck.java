package model;

import exception.DuplicateValueException;

public class Duck extends Bird {

	public static final double MULTIPLIER = 1.02;
	
	private Duck left;
	private Duck right;
	
	public Duck(int num, int epw) {
		super(num, epw);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double multiplyMoney(double money) {
		
		double leftMoney = left != null ? left.multiplyMoney(money) : 0;
		
		double rightMoney = left != null ? right.multiplyMoney(money) : 0;
		
		return money*MULTIPLIER + leftMoney + rightMoney;
		
	}

	public void addDuck(Duck dk) throws DuplicateValueException {
		
		if (dk.number < number) {
			
			if (left == null) 
				left = dk;
			else
				left.addDuck(dk);
			
		}
		else if (dk.number > number) {
			
			if (right == null)
				right = dk;
			else
				right.addDuck(dk);
			
		}
		else
			throw new DuplicateValueException("Duplicate value when adding a new duck");
		
	}
	
}
