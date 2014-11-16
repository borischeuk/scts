package simulation.utils;

public class RandomFactory {

	public static int randSimulationTime(int min, int max, int speed) {
		int minInSec = min * 60;
		int maxInSec = max * 60;
		/*System.out.println("minInSec ==================== " + minInSec);
		System.out.println("maxInSec ==================== " + maxInSec);
		System.out.println("Speed ==================== " + speed);
		System.out.println("Random ======================== " + (int)(((Math.random()*(maxInSec-minInSec+1))+minInSec)/speed));*/
		return (int)(((Math.random()*(maxInSec - minInSec + 1)) + minInSec) / speed);
	}
	
}
