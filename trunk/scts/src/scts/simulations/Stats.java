package scts.simulations;

/**
 * 
 * This class stores the values used by the report of the simulation.
 *
 */
public class Stats {
	private int totalShips;
	private int totalContainers;
	private double shipServiceTime;
	private double quayCraneUnloadTime;
	private int longestShipQueue;
	private int maxRoadVehicleQueue;
	private double yardVehicleTimeSpentInQA;
	private double yardVehicleTimeSpentInSeaside;
	private double yardVehicleTotalTimeSpent;
	private double yardVehiclePercentageTimeSpentInQA;
	private double yardVehiclePercentageTimeSpentInSeaside;
	
	
	public Stats() {
		totalShips = 0;
		totalContainers = 0;
		shipServiceTime = 0.0;
		quayCraneUnloadTime = 0.0;
		longestShipQueue = 0;
		maxRoadVehicleQueue = 0;
		yardVehicleTimeSpentInQA = 0.0;
		yardVehicleTimeSpentInSeaside = 0.0;
		yardVehicleTotalTimeSpent = 0.0;
		yardVehiclePercentageTimeSpentInQA = 0.0;
		yardVehiclePercentageTimeSpentInSeaside = 0.0;
	}
	
	// Get Values
	
	public int getTotalShips() {
		return totalShips;
	}
	
	public int getTotalContainers() {
		return totalContainers;
	}
	
	public double getShipServiceTime() {
		return shipServiceTime;
	}
	
	public double getQuayCraneUnloadTime() {
		return quayCraneUnloadTime;
	}
	
	public int getLongestShipQueue() {
		return longestShipQueue;
	}
	
	public int getMaxRoadVehicleQueue() {
		return maxRoadVehicleQueue;
	}

	public double getYardVehicleTimeSpentInQA() {
		return yardVehicleTimeSpentInQA;
	}
	
	public double getYardVehicleTimeSpentInSeaside() {
		return yardVehicleTimeSpentInSeaside;
	}
	
	public double getYardVehicleTotalTimeSpent() {
		return yardVehicleTotalTimeSpent;
	}
	
	public double getYardVehiclePercentageTimeSpentInQA() {
		return yardVehiclePercentageTimeSpentInQA;
	}
	
	public double getYardVehiclePercentageTimeSpentInSeaside() {
		return yardVehiclePercentageTimeSpentInSeaside;
	}
	
	// Set Values
	
	public void setTotalShips(int totalShips) {
		this.totalShips = totalShips;
	}
	
	public void setTotalContainers(int totalContainers) {
		this.totalContainers = totalContainers;
	}
	
	public void setShipServiceTime(double time) {
		this.shipServiceTime = time;
	}
	
	public void setQuayCraneUnloadTime(double time) {
		this.quayCraneUnloadTime = time;
	}
	
	public void setLongestShipQueue(int longestShipQueue) {
		this.longestShipQueue = longestShipQueue;
	}
	
	public void setMaxRoadVehicleQueue(int maxRoadVehicleQueue) {
		this.maxRoadVehicleQueue = maxRoadVehicleQueue;
	}

	public void setYardVehicleTimeSpentInQA(double time) {
		this.yardVehicleTimeSpentInQA = time;
	}
	
	public void setYardVehicleTimeSpentInSeaside(double time) {
		this.yardVehicleTimeSpentInSeaside = time;
	}
	
	public void setYardVehicleTotalTimeSpent(double time) {
		this.yardVehicleTotalTimeSpent = time;
	}
	
	public void setYardVehiclePercentageTimeSpentInQA() {
		this.yardVehiclePercentageTimeSpentInQA = yardVehicleTimeSpentInQA / yardVehicleTotalTimeSpent * 100;
	}
	
	public void setYardVehiclePercentageTimeSpentInSeaside() {
		this.yardVehiclePercentageTimeSpentInSeaside = yardVehicleTimeSpentInSeaside / yardVehicleTotalTimeSpent * 100;
	}
	
	public void update() {
		setYardVehiclePercentageTimeSpentInQA();
		setYardVehiclePercentageTimeSpentInSeaside();
	}
}
