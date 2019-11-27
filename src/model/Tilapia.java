package model;

import java.io.Serializable;

public class Tilapia extends Fish implements Serializable {

	public static final double VALUE = 0.1;
	
	public static final double PRICE = 1;
	
	private Tilapia next;
	private Tilapia prev;
	
	public Tilapia(int num, double size) {
		super(num, PRICE, size);
	}

	public Tilapia getNext() {
		return next;
	}

	public Tilapia getPrev() {
		return prev;
	}

	
	public void setNext(Tilapia next) {
		this.next = next;
	}

	public void setPrev(Tilapia prev) {
		this.prev = prev;
	}

	@Override
	public double addMoney() {
		
		if (next == null)
			return VALUE;
	
		return VALUE + next.addMoney();
		
	}
	
	public void addTilapia(Tilapia t) {
		
		if (next == null) {
			t.setPrev(this);
			next = t;
		}
			
		else
			next.addTilapia(t);
		
	}
	
	
}
