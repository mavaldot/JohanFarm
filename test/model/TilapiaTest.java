package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TilapiaTest {

	private Tilapia root;
	private Tilapia t1;
	private Tilapia t2;

	private void loadScene1() {
		
		root = new Tilapia(123, 5);
		t1 = new Tilapia(321, 7);
		t2 = new Tilapia(213, 9);
		
	}
	
	@Test
	public void testAddTilapia() {
		
		loadScene1();
		root.addTilapia(t1);
		root.addTilapia(t2);
		
		assertNotNull(root.getNext());
		assertNotNull(root.getNext().getNext());
		assertNotNull(t1.getPrev());
		assertNotNull(t2.getPrev());
		
		assertEquals(t1, root.getNext());
		assertEquals(t2, root.getNext().getNext());
		assertEquals(root, t1.getPrev());
		assertEquals(t1, t2.getPrev());
		assertEquals(root, t2.getPrev().getPrev());
		
	}
	
	@Test
	public void testAddMoney() {
		
		loadScene1();
		
		assertEquals(0.1, root.addMoney());
		
		root.addTilapia(t1);
		assertEquals(0.1*2, root.addMoney());
		
		root.addTilapia(t2);
		assertEquals(0.1*3, root.addMoney());
		
	}
	

}
