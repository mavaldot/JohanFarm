package model;

import exception.DuplicateValueException;

/**
 * Class that represents a duck in the farm. The ducks are represented by a binary tree
 * 
 * @author Mateo
 *
 */
public class Duck extends Bird {
	
	public static final double MULTIPLIER = 1.02;
	public static final double PRICE = 50;
	
	private Duck left;
	private Duck right;
	
	/**
	 * Constructor
	 * 
	 * @param num The duck's number
	 * @param epw Eggs per week - how many eggs the duck lays in a week
	 */
	public Duck(int num, int epw) {
		super(num, PRICE, epw);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @return The duck's left node
	 */
	public Duck getLeft() {
		return left;
	}

	/**
	 * 
	 * @return The duck's right node
	 */
	public Duck getRight() {
		return right;
	}

	
	/**
	 * Multiplies the money by the dog's multiplier
	 * 
	 * @param money the money that will be multiplied
	 */
	@Override
	public double multiplyMoney(double money) {
		
		double leftMoney = left != null ? left.multiplyMoney(money) : 0;
		
		double rightMoney = right != null ? right.multiplyMoney(money) : 0;
		
		return money*MULTIPLIER + leftMoney + rightMoney;
		
	}

	/**
	 * Adds a new duck to a node
	 * 
	 * @param dk The new duck
	 * @throws DuplicateValueException
	 */
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
