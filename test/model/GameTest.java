package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import exception.DuplicateValueException;

class GameTest {

	private Game game;
	
	private void loadScene1() {
		game = new Game();
		game.begin();
		game.setMoney(500);
	}
	
	
	@Test 
	public void testAddTilapia() {
		
		loadScene1();
		assertNull(game.getFirstTilapia());
		game.addTilapia();
		assertNotNull(game.getFirstTilapia());
		
	}
	
	@Test 
	public void testAddTrout() {
		
		loadScene1();
		assertNull(game.getRootTrout());
		try {
			game.addTrout();
		} catch (DuplicateValueException e) {
			fail();
		}
		assertNotNull(game.getRootTrout());
		
	}
	
	@Test 
	public void testAddChicken() {
		
		loadScene1();
		assertNull(game.getFirstChicken());
		game.addChicken();
		assertNotNull(game.getFirstChicken());
		
	}
	
	@Test 
	public void testAddDuck() {
		
		loadScene1();
		assertNull(game.getRootDuck());
		try {
			game.addDuck();
		} catch (DuplicateValueException e) {
			fail();
		}
		assertNotNull(game.getRootDuck());
		
	}
	
	@Test 
	public void testAddCow() {
		
		loadScene1();
		assertNull(game.getFirstCow());
		game.addCow();
		assertNotNull(game.getFirstCow());
		
	}
	
	@Test 
	public void testAddDog() {
		
		loadScene1();
		assertEquals(0, game.getDogs().size());
		game.addDog();
		assertNotNull(game.getDogs().get(0));
		
	}
	
	public void testCalculateMoney() {
		
		loadScene1();
		
		game.calculateMoney();
		assertEquals(0, game.getMoney());
		
		game.addTilapia();
		game.calculateMoney();
		assertEquals(Tilapia.VALUE, game.getMoney());
		
		try {
			game.addTrout();
		} catch (DuplicateValueException e) {
			fail();
		}
		game.calculateMoney();
		assertEquals(Tilapia.VALUE + Trout.VALUE, game.getMoney());
	}
	
	
}
