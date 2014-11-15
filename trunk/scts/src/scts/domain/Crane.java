package scts.domain;

public class Crane {

	//List of status
	public static final int IDLE = 0;
	public static final int LOADING = 1;
	public static final int OCCUPIED = 2;
	public static final int SETTINGDOWN = 3;
	
	private boolean occupied;
	private int status;
	
	public Crane() {
		occupied = false;
		status = IDLE;
	}
	
	public void pick() {
		occupied = true;
	}
	
	public void setDown() {
		occupied = false;
	}
	
	public int getStatus() {
		return status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
	
}
