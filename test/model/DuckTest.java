package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import exception.DuplicateValueException;

class DuckTest {

	private Duck root;
	private Duck d1;
	private Duck d2;
	private Duck d3;
	private Duck d4;
	
	private void loadScene1() {
		
		root = new Duck(123, 4);
		d1 = new Duck(124, 5);
		d2 = new Duck(100, 8);
		d3 = new Duck(50, 12);
		d4 = new Duck(123, 4);
	}
	
	@Test
	public void addDuckTest1() {
		
		loadScene1();
		try {
			root.addDuck(d4);
			fail();
		} catch (DuplicateValueException e) {
			//ok
		}
		
	}
	
	@Test
	public void addDuckTest2() {
		
		loadScene1();
		try {
			root.addDuck(d1);
			root.addDuck(d2);
			root.addDuck(d3);
		} catch (DuplicateValueException e) {
			fail();
		}
		
		assertEquals(d1, root.getRight());
		assertEquals(d2, root.getLeft());
		assertEquals(d3, root.getLeft().getLeft());
		
		assertNull(root.getLeft().getRight());
		assertNull(root.getRight().getRight());
		assertNull(root.getRight().getLeft());
		
	}
	
	@Test
	public void testMultiplyMoney() {
		
		loadScene1();
		
		assertEquals(1.02, root.multiplyMoney(1));
		
		try {
			root.addDuck(d1);
		} catch (DuplicateValueException e) {
			fail();
		}
		assertEquals(1.02+1.02, root.multiplyMoney(1));
		
	}
	
}
