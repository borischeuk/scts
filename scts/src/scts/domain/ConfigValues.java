package scts.domain;

public class ConfigValues {
	/*
	 * Time for ship to dock or undock containers : 10 - 20 mins;
Quay Crane to remove a container from a ship: 1-5 mins;
Quay Crane to place a container in the Quay Area: 1-2 mins
Yard Vehicle to pick up container after leaving queue: 1-3 mins
YV travel to sea-side transfer point: 5-10 mins
YV to drop its container: 1-2 mins
YV to travel to Quay Area queue3-5 mins
No. of containers: 8000 - 18000 TEU (Twentyfoot Equivalent Unit??)
Max allowable size of the stack: 2000 TEU
Num of QC1
Initial value: 500 TEU
Yard Vehicles: 200
Time limit for a run: 1 day
Num of ships already waiting: 2 without priority

	 */
	private int dockMinTime;
	private int dockMaxTime;
	private int undockMinTime;
	private int undockMaxTime;
	private int qcRemoveMinTime;
	private int qcRemoveMaxTime;
	private int qcPlaceMinTime;
	private int qcPlaceMaxTime;
	private int yvPickMinTime;
	private int yvPickMaxTime;
	private int yvDropMinTime;
	private int yvDropMaxTime;
	private int yvTravelToSeaSideMinTime;
	private int yvTravelToSeaSideMaxTime;
	private int yvTravelToQAMinTime;
	private int yvTravelToQAMaxTime;
	private int minContainers;
	private int maxContainers;
	private int maxStackSize;
	private int initialStackSize;
	private int numQC;
	private int numYV;
	private int timeLimit;
	private int numShipsWaiting;
	
	// Set Values
	public void setDockMinTime(int dockMinTime) {
		this.dockMinTime = dockMinTime;
	}
	
	public void setDockMaxTime(int dockMaxTime) {
		this.dockMaxTime = dockMaxTime;
	}
	
	public void setUndockMinTime(int undockMinTime) {
		this.undockMinTime = undockMinTime;
	}
	
	public void setUndockMaxTime(int undockMaxTime) {
		this.undockMaxTime = undockMaxTime;
	}
	
	public void setqcRemoveMinTime(int qcRemoveMinTime) {
		this.qcRemoveMinTime = qcRemoveMinTime;
	}
	
	public void setqcRemoveMaxTime(int qcRemoveMaxTime) {
		this.qcRemoveMaxTime = qcRemoveMaxTime;
	}
	
	public void setqcPlaceMinTime(int qcPlaceMinTime) {
		this.qcPlaceMinTime = qcPlaceMinTime;
	}
	
	public void setqcPlaceMaxTime(int qcPlaceMaxTime) {
		this.qcPlaceMaxTime = qcPlaceMaxTime;
	}
	
	public void setyvPickMinTime(int yvPickMinTime) {
		this.yvPickMinTime = yvPickMinTime;
	}
	
	public void setyvPickMaxTime(int yvPickMaxTime) {
		this.yvPickMaxTime = yvPickMaxTime;
	}
	
	public void setyvDropMinTime(int yvDropMinTime) {
		this.yvDropMinTime = yvDropMinTime;
	}
	
	public void setyvDropMaxTime(int yvDropMaxTime) {
		this.yvDropMaxTime = yvDropMaxTime;
	}
	
	public void setyvTravelToSeaSideMinTime(int yvTravelToSeaSideMinTime) {
		this.yvTravelToSeaSideMinTime = yvTravelToSeaSideMinTime;
	}
	
	public void setyvTravelToSeaSideMaxTime(int yvTravelToSeaSideMaxTime) {
		this.yvTravelToSeaSideMaxTime = yvTravelToSeaSideMaxTime;
	}
	
	public void setyvTravelToQAMinTime(int yvTravelToQAMinTime) {
		this.yvTravelToQAMinTime = yvTravelToQAMinTime;
	}
	
	public void setyvTravelToQAMaxTime(int yvTravelToQAMaxTime) {
		this.yvTravelToQAMaxTime = yvTravelToQAMaxTime;
	}
	
	public void setMinContainers(int minContainers) {
		this.minContainers = minContainers;
	}
	
	public void setMaxContainers(int maxContainers) {
		this.maxContainers = maxContainers;
	}
	
	public void setMaxStackSize(int maxStackSize) {
		this.maxStackSize = maxStackSize;
	}
	
	public void setInitialStackSize(int initialStackSize) {
		this.initialStackSize = initialStackSize;
	}
	
	public void setNumQC(int numQC) {
		this.numQC = numQC;
	}
	
	public void setNumYV(int numYV) {
		this.numYV = numYV;
	}
	
	public void setTimeLimit(int timeLimit) {
		this.timeLimit = timeLimit;
	}
	
	public void setNumShipsWaiting(int numShipsWaiting) {
		this.numShipsWaiting = numShipsWaiting;
	}
	
	// get values
	
	public int getDockMinTime() {
		return dockMinTime;
	}
	
	public int getDockMaxTime() {
		return dockMaxTime;
	}
	
	public int getUndockMinTime() {
		return undockMinTime;
	}
	
	public int getUndockMaxTime() {
		return undockMaxTime;
	}
	
	public int getqcRemoveMinTime() {
		return qcRemoveMinTime;
	}
	
	public int getqcRemoveMaxTime() {
		return qcRemoveMaxTime;
	}
	
	public int getqcPlaceMinTime() {
		return qcPlaceMinTime;
	}
	
	public int getqcPlaceMaxTime() {
		return qcPlaceMaxTime;
	}
	
	public int getyvPickMinTime() {
		return yvPickMinTime;
	}
	
	public int getyvPickMaxTime() {
		return yvPickMaxTime;
	}
	
	public int getyvDropMinTime() {
		return yvDropMinTime;
	}
	
	public int getyvDropMaxTime() {
		return yvDropMaxTime;
	}
	
	public int getyvTravelToSeaSideMinTime() {
		return yvTravelToSeaSideMinTime;
	}
	
	public int getyvTravelToSeaSideMaxTime() {
		return yvTravelToSeaSideMaxTime;
	}
	
	public int getyvTravelToQAMinTime() {
		return yvTravelToQAMinTime;
	}
	
	public int getyvTravelToQAMaxTime() {
		return yvTravelToQAMaxTime;
	}
	
	public int getMinContainers() {
		return minContainers;
	}
	
	public int getMaxContainers() {
		return maxContainers;
	}
	
	public int getMaxStackSize() {
		return maxStackSize;
	}
	
	public int getInitialStackSize() {
		return initialStackSize;
	}
	
	public int getNumQC() {
		return numQC;
	}
	
	public int getNumYV() {
		return numYV;
	}

	public int getTimeLimit() {
		return timeLimit;
	}
	
	public int getNumShipsWaiting() {
		return numShipsWaiting;
	}
	
}
