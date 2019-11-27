package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import exception.DuplicateValueException;

class TroutTest {

	private Trout root;
	private Trout t1;
	private Trout t2;
	private Trout t3;
	private Trout t4;
	
	private void loadScene1() {
		
		root = new Trout(123, 4);
		t1 = new Trout(124, 5);
		t2 = new Trout(100, 8);
		t3 = new Trout(50, 12);
		t4 = new Trout(123, 4);
		
	}
	
	@Test
	public void addTroutTest1() {
		
		loadScene1();
		try {
			root.addTrout(t4);
			fail();
		} catch (DuplicateValueException e) {
			//ok
		}
		
	}
	
	@Test
	public void addTroutTest2() {
		
		loadScene1();
		try {
			root.addTrout(t1);
			root.addTrout(t2);
			root.addTrout(t3);
		} catch (DuplicateValueException e) {
			fail();
		}
		
		assertEquals(t1, root.getRight());
		assertEquals(t2, root.getLeft());
		assertEquals(t3, root.getLeft().getLeft());
		
		assertNull(root.getLeft().getRight());
		assertNull(root.getRight().getRight());
		assertNull(root.getRight().getLeft());
		
	}
	
	@Test
	public void testAddMoney() {
		
		loadScene1();
		
		assertEquals(0.3, root.addMoney());
		
		try {
			root.addTrout(t1);
		} catch (DuplicateValueException e) {
			// TODO Auto-generated catch block
			fail();
		}
		assertEquals(0.3*2, root.addMoney());
		
		try {
			root.addTrout(t2);
		} catch (DuplicateValueException e) {
			// TODO Auto-generated catch block
			fail();
		}
		assertEquals(0.3*3, root.addMoney());
		
		try {
			root.addTrout(t3);
		} catch (DuplicateValueException e) {
			// TODO Auto-generated catch block
			fail();
		}
		assertEquals(0.3*4, root.addMoney());
		
	}

}
