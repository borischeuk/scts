package simulation.utils;

import java.util.Date;

public class Clock {

	Date actualStartTime;
	Date actualMidStartTime;
	long simulationStartTime;
	long simulationMidStartTime;
	int speed;
	long currentTime;
	
	public void Clock(Date startTime, int speed) {
		this.actualStartTime = startTime;
		this.actualMidStartTime = startTime;
		this.speed = speed;
		this.currentTime = 0;
	}
	
}
