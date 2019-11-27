package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


public class CowTest {

	private Cow root;
	private Cow cow1;
	private Cow cow2;
	
	private void loadScene1() {
		
		root = new Cow(123, "Mateo", 50.0);
		cow1 = new Cow(321, "Johan", 51.0);
		cow2 = new Cow(213, "Ariza", 52.0);
		
	}
	
	@Test
	public void testAddCow() { 
		
		loadScene1();
		
		root.addCow(cow1);
		root.addCow(cow2);
		
		assertNotNull(root.getNext());
		assertNotNull(root.getNext().getNext());
		assertNull(root.getNext().getNext().getNext());
		
		assertEquals(cow1, root.getNext());
		assertEquals(cow2, root.getNext().getNext());
		
	}
	
	@Test
	public void testAddMoney() {
		
		loadScene1();
		
		assertEquals(5, root.addMoney());
		
		root.addCow(cow1);
		assertEquals(10, root.addMoney());
		
		root.addCow(cow2);
		assertEquals(15, root.addMoney());
		
		
		
	}
	
}

