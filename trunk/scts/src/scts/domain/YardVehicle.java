package scts.domain;

public class YardVehicle {

	public static final int TRAVELING = 0;
	public static final int WAITING = 1;
	public static final int LOADING = 2;
	public static final int UNLOADING = 3;
	
	private boolean occupied;
	private int status;
	
	public YardVehicle() {
		occupied = false;
		status = WAITING;
	}
	
	public boolean isOccupied() {
		return occupied;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
	
	public int getStatus() {
		return status;
	}
}
