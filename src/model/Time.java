package model;

import exception.InvalidTimeException;

public class Time {

	private int hours;
	private int minutes;
	private int seconds;
	
	public Time() {
		
		hours = 0;
		minutes = 0;
		seconds = 0;
	}
	
	public Time(int h, int m, int s) throws InvalidTimeException {
		
		if (h < 0 || m < 0 || s < 0) {
			throw new InvalidTimeException("Hours, minutes and seconds must be a positive integer");
		}
		hours = h;
		minutes = m;
		seconds = s;
	}

	public int getHours() {
		return hours;
	}

	public int getMinutes() {
		return minutes;
	}

	public int getSeconds() {
		return seconds;
	}

	public String getTime() {
		return seconds + "";
	}
	
	public void incrementTime() {
		seconds++;
	}
	
	
}
