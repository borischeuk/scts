package simulation.utils;

import java.util.Calendar;
import java.util.Random;

/**
 * 
 * This class is responsible for generating random number for simulation.
 * E.g.: Duration of Event, Poisson Distribution
 *
 */
public class RandomFactory {

	private static Random random = new Random(Calendar.getInstance().getTimeInMillis());
	
	public static int randSimulationTime(int min, int max, int speed) {
		int minInSec = min * 60;
		int maxInSec = max * 60;
		return (random.nextInt((maxInSec - minInSec + 1)) + minInSec) / speed;
	}
	
	public static long randSimTimeInMilliSec(int min, int max, int speed) {
		long minInMilliSec = min * 60 * 1000;
		long maxInMilliSec = max * 60 * 1000;
		return (long)(((random.nextDouble() * (maxInMilliSec - minInMilliSec + 1)) + minInMilliSec) / speed);
		//return (long)random.nextDouble();
	}
	
	public static int randInt(int min, int max) {
		return (random.nextInt((max - min + 1)) + min);
	}
	
}
