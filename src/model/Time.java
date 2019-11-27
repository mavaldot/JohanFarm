package model;

import exception.InvalidTimeException;

public class Time {

	private int hours;
	private int minutes;
	private int seconds;
	
	/**
	 * Constructor
	 */
	public Time() {
		
		hours = 0;
		minutes = 0;
		seconds = 0;
	}
	
	/**
	 * Other constructor
	 * @param h hours
	 * @param m minutes
	 * @param s seconds
	 * @throws InvalidTimeException
	 */
	public Time(int h, int m, int s) throws InvalidTimeException {
		
		if (h < 0 || m < 0 || s < 0) {
			throw new InvalidTimeException("Hours, minutes and seconds must be a positive integer");
		}
		hours = h;
		minutes = m;
		seconds = s;
	}

	/**
	 * 
	 * @return the hours
	 */
	public int getHours() {
		return hours;
	}

	/**
	 * 
	 * @return the minutes
	 */
	public int getMinutes() {
		return minutes;
	}

	/**
	 * 
	 * @return the seconds
	 */
	public int getSeconds() {
		return seconds;
	}

	/**
	 * 
	 * @return a string represent the time
	 */
	public String getTime() {
		return seconds + "";
	}
	
	/**
	 * increments the time by a second
	 */
	public void incrementTime() {
		seconds++;
	}
	
	
}
