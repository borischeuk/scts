package scts.domain;

public class Stats {
	private int totalShips;
	private int avgShips;
	private int totalContainers;
	private int avgContainers;
	private double maxNPShipServiceTime;
	private double minNPShipServiceTime;
	private double avgNPShipServiceTime;
	private double maxPShipServiceTime;
	private double minPShipServiceTime;
	private double avgPShipServiceTime;
	private double longestShipServiceTime;
	private int longestShipQueue;
	private int maxRoadVehicleQueue;
	private int maxStackSize;
	private int minStackSize;
	private int avgStackSize;
	private double yardVehiclePercentageTimeSpent;
	
	
	public Stats() {
		totalShips = 0;
		avgShips = 0;
		totalContainers = 0;
		avgContainers = 0;
		maxNPShipServiceTime = 0.0;
		minNPShipServiceTime = 0.0;
		avgNPShipServiceTime = 0.0;
		maxPShipServiceTime = 0.0;
		minPShipServiceTime = 0.0;
		avgPShipServiceTime = 0.0;
		longestShipServiceTime = 0.0;
		longestShipQueue = 0;
		maxRoadVehicleQueue = 0;
		maxStackSize = 0;
		minStackSize = 0;
		avgStackSize = 0;
		yardVehiclePercentageTimeSpent = 0.0;
	}
	
	// Get Values
	
	public int getTotalShips() {
		return totalShips;
	}
	
	public int getAvgShips() {
		return avgShips;
	}
	
	public int getTotalContainers() {
		return totalContainers;
	}
	
	public int getAvgContainers() {
		return avgContainers;
	}
	
	public double getNPMaxServiceTime() {
		return maxNPShipServiceTime;
	}
	
	public double getNPMinServiceTime() {
		return minNPShipServiceTime;
	}
	
	public double getNPAvgServiceTime() {
		return avgNPShipServiceTime;
	}
	
	public double getPMaxServiceTime() {
		return maxPShipServiceTime;
	}
	
	public double getPMinServiceTime() {
		return minPShipServiceTime;
	}
	
	public double getPAvgServiceTime() {
		return avgPShipServiceTime;
	}
	
	public double getLongestServiceTime() {
		return longestShipServiceTime;
	}
	
	public int getLongestShipQueue() {
		return longestShipQueue;
	}
	
	public int getMaxRoadVehicleQueue() {
		return maxRoadVehicleQueue;
	}
	
	public int getMaxStackSize() {
		return maxStackSize;
	}
	
	public int getMinStackSize() {
		return minStackSize;
	}
	
	public int getAvgStackSize() {
		return avgStackSize;
	}
	
	public double getYardVehiclePercentageTimeSpent() {
		return yardVehiclePercentageTimeSpent;
	}
	
	// Set Values
	
	public void setTotalShips(int totalShips) {
		this.totalShips = totalShips;
	}
	
	public void setAvgShips(int avgShips) {
		this.avgShips = avgShips;
	}
	
	public void setTotalContainers(int totalContainers) {
		this.totalContainers = totalContainers;
	}
	
	public void setAvgContainers(int avgContainers) {
		this.avgContainers = avgContainers;
	}
	
	public void setNPShipServiceTime(double max, double min, double avg) {
		this.maxNPShipServiceTime = max;
		this.minNPShipServiceTime = min;
		this.avgNPShipServiceTime = avg;
	}
	
	public void setPShipServiceTime(double max, double min, double avg) {
		this.maxPShipServiceTime = max;
		this.minPShipServiceTime = min;
		this.avgPShipServiceTime = avg;
	}
	
	public void setLongestShipServiceTime(double longest) {
		this.longestShipServiceTime = longest;
	}
	
	public void setLongestShipQueue(int longestShipQueue) {
		this.longestShipQueue = longestShipQueue;
	}
	
	public void setMaxRoadVehicleQueue(int maxRoadVehicleQueue) {
		this.maxRoadVehicleQueue = maxRoadVehicleQueue;
	}
	
	public void setStackSize(int max, int min, int avg) {
		this.maxStackSize = max;
		this.minStackSize = min;
		this.avgStackSize = avg;
	}
	
	public void setYardVehiclePercentageTimeSpent(double percentage) {
		this.yardVehiclePercentageTimeSpent = percentage;
	}
	
}
