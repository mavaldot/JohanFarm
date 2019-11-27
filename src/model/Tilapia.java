package model;

import java.io.Serializable;

/**
 * A class to represent a tilapia in the farm. Tilapias are represnted by a doubly linked list.
 * 
 * @author Mateo
 *
 */
public class Tilapia extends Fish implements Serializable {

	public static final double VALUE = 0.1;
	
	public static final double PRICE = 1;
	
	private Tilapia next;
	private Tilapia prev;
	
	/**
	 * Constructor
	 * 
	 * @param num The tilapia's number
	 * @param size The tilapia's size
	 */
	public Tilapia(int num, double size) {
		super(num, PRICE, size);
	}

	/**
	 * 
	 * @return The next tilapia in the doubly linked list
	 */
	public Tilapia getNext() {
		return next;
	}

	/**
	 * 
	 * @return The previos tilapia in the doubly linked list
	 */
	public Tilapia getPrev() {
		return prev;
	}

	/**
	 * Sets the next tilapia in the doubly linked list
	 * 
	 * @param next The tilapia the will be set
	 */
	public void setNext(Tilapia next) {
		this.next = next;
	}

	/**
	 * Sets the previous tilapia in the doubly linked list
	 * 
	 * @param prev The tilapia the will be set
	 */
	public void setPrev(Tilapia prev) {
		this.prev = prev;
	}

	/**
	 * Adds up all the values of the tilapias
	 * 
	 */
	@Override
	public double addMoney() {
		
		if (next == null)
			return VALUE;
	
		return VALUE + next.addMoney();
		
	}
	
	/**
	 * Adds a new tilapia the doubly linked list
	 * 
	 * @param t The new tilapia 
	 */
	public void addTilapia(Tilapia t) {
		
		if (next == null) {
			t.setPrev(this);
			next = t;
		}
			
		else
			next.addTilapia(t);
		
	}
	
	
}
