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

public class FileHandler {

	private Time time;
	private Game game;
	
	private final String TIMEFILE = "time.txt";
	private final String GAMEFILE = "game.sav";
	
	public FileHandler(Time t, Game g) {
		time = t;
		game = g;
	}
	
	public void saveTime() throws InvalidTimeException {
		
		File tf = new File(TIMEFILE);
		
		try (PrintWriter out = new PrintWriter(tf)){
			out.println(time.getHours());
			out.println(time.getMinutes());
			out.println(time.getSeconds());
		}
		catch (Exception e) {
			throw new InvalidTimeException("There was a problem saving the time");
		}
		
	}
	
	public void loadTime() throws InvalidTimeFileException {
		
		File tf = new File(GAMEFILE);
		
		try (BufferedReader br = new BufferedReader(new FileReader(tf))) {
			
			int hours = Integer.parseInt(br.readLine());
			int minutes = Integer.parseInt(br.readLine());
			int seconds = Integer.parseInt(br.readLine());
			
			time = new Time(hours, minutes, seconds);
		}
		catch (NumberFormatException | IOException | InvalidTimeException e) {
			throw new InvalidTimeFileException("Invalid time file. Check your txt time file");
		}
		
	}
	
	public void saveGame() throws GameSerializationException {
		
		File gf = new File(GAMEFILE);
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(gf))) {
			
			oos.writeObject(game);
			
		} 
		catch (IOException e) {
			throw new GameSerializationException("There was a problem saving the game");
		}
		
	}
	
	public void loadGame() throws GameSerializationException {
		
		File gf = new File(GAMEFILE);
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(gf))) {
			
		} 
		catch (IOException e) {
			throw new GameSerializationException("There was a problem reading the saved game file");
		}
		
		
	}
	
}
