package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ChickenTest {

	private Chicken root;
	private Chicken c1;
	private Chicken c2;
	
	private void loadScene1() {
		
		root = new Chicken(123, 5);
		c1 = new Chicken(321, 7);
		c2 = new Chicken(213, 9);
		
	}
	
	@Test
	public void testAddChicken() { 
		
		loadScene1();
		
		root.addChicken(c1);
		root.addChicken(c2);
		
		assertNotNull(root.getNext());
		assertNotNull(root.getNext().getNext());
		assertNull(root.getNext().getNext().getNext());
		
		assertEquals(c1, root.getNext());
		assertEquals(c2, root.getNext().getNext());

	}
	
	@Test
	public void testMultiplyMoney() {
		
		loadScene1();
		
		assertEquals(1.01, root.multiplyMoney(1));
		
		root.addChicken(c1);
		assertEquals(1.01*1.01, root.multiplyMoney(1));
		
		root.addChicken(c2);
		assertEquals(1.01*1.01*1.01, root.multiplyMoney(1));
		
	}

}
