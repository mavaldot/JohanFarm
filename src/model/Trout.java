package model;

import java.io.Serializable;

import exception.DuplicateValueException;

public class Trout extends Fish implements Serializable {

	public static final double VALUE = 1;
	
	private Trout left;
	private Trout right;
	
	public Trout(int num, double size) {
		super(num, size);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public double addMoney() {

		double leftMoney = left != null ? left.addMoney() : 0;
		double rightMoney = right != null ? right.addMoney() : 0;
		
		return VALUE + leftMoney + rightMoney;
		
	}
	
	public void addTrout(Trout t) throws DuplicateValueException {
		
		if (t.number < number) {
			
			if (left == null) 
				left = t;
			else
				left.addTrout(t);
			
		}
		else if (t.number > number) {
			
			if (right == null)
				right = t;
			else
				right.addTrout(t);
			
		}
		else
			throw new DuplicateValueException("Duplicate value when adding a new trout");
		
	}

}
