package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

import exception.GameSerializationException;
import exception.InvalidTimeException;
import exception.InvalidTimeFileException;

/**
 * A class to handle all the program's IO (saves and loads files)
 * 
 * @author Mateo
 *
 */
public class FileHandler {
	
	private final String TIMEFILE = "time.txt";
	private final String GAMEFILE = "game.sav";
	
	/**
	 * Constructor
	 */
	public FileHandler() {
	}
	
	/**
	 * Saves the time in a .txt file
	 * 
	 * @param time The time that will be saved
	 * @throws InvalidTimeException
	 */
	public void saveTime(Time time) throws InvalidTimeException {
		
		File tf = new File(TIMEFILE);
		
		try (PrintWriter out = new PrintWriter(tf)){
			out.println(time.getHours() + "");
			out.println(time.getMinutes() + "");
			out.println(time.getSeconds() + "");
		}
		catch (Exception e) {
//			e.printStackTrace();
			throw new InvalidTimeException("There was a problem saving the time");
		}
		
	}
	/**
	 * Loads the time from a .txt file
	 * 
	 * @return The time 
	 * @throws InvalidTimeFileException
	 */
	public Time loadTime() throws InvalidTimeFileException {
		
		File tf = new File(TIMEFILE);
		
		Time time = null;
		
		try (BufferedReader br = new BufferedReader(new FileReader(tf))) {
			
			int hours = Integer.parseInt(br.readLine().trim());
			int minutes = Integer.parseInt(br.readLine().trim());
			int seconds = Integer.parseInt(br.readLine().trim());
			
			time = new Time(hours, minutes, seconds);
		}
		catch (NumberFormatException | IOException | InvalidTimeException e) {
//			e.printStackTrace();
			throw new InvalidTimeFileException("Invalid time file. Check your txt time file");
		}
		return time;
		
	}
	
	/**
	 * Saves the game via serialization
	 * 
	 * @param game The game that will be saved
	 * @throws GameSerializationException
	 */
	public void saveGame(Game game) throws GameSerializationException {
		
		File gf = new File(GAMEFILE);

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(gf))) {
			
			oos.writeObject(game);
			
		} 
		catch (IOException e) {
//			e.printStackTrace();
			throw new GameSerializationException("There was a problem saving the game");
		}
		
	}
	
	/**
	 * Loads the game from a serialized file
	 * 
	 * @return The game that was loaded
	 * @throws GameSerializationException
	 */
	public Game loadGame() throws GameSerializationException {
		
		File gf = new File(GAMEFILE);
		
		Game game = null;
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(gf))) {
			
			game = (Game) ois.readObject();
			
		} 
		catch (IOException | ClassNotFoundException e) {
//			e.printStackTrace();
			throw new GameSerializationException("There was a problem reading the saved game file");
		}
		
		return game;
		
		
	}
	
}
