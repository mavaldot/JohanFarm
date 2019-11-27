package model;

import java.io.Serializable;

import exception.DuplicateValueException;

/**
 * A class that represent the trouts in the farm. Trouts are represented by binary tree.
 * 
 * @author Mateo
 *
 */
public class Trout extends Fish implements Serializable {

	public static final double VALUE = 0.3;
	public static final double PRICE = 3;
	
	private Trout left;
	private Trout right;
	
	/**
	 * Constructor
	 * 
	 * @param num The trout's number
	 * @param size The trout's size
	 */
	public Trout(int num, double size) {
		super(num, PRICE, size);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @return The trout to the left of this trout
	 */
	public Trout getLeft() {
		return left;
	}

	/**
	 * 
	 * @return The trout to the right of this trout
	 */
	public Trout getRight() {
		return right;
	}

	/**
	 * Adds up all the trouts values in the binary tree
	 */
	@Override
	public double addMoney() {

		double leftMoney = left != null ? left.addMoney() : 0;
		double rightMoney = right != null ? right.addMoney() : 0;
		
		return VALUE + leftMoney + rightMoney;
		
	}
	
	/**
	 * Adds a new trout to this binary tree
	 * 
	 * @param t the new trout
	 * @throws DuplicateValueException
	 */
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
