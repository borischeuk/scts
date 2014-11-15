package scts.domain;

public class Ship {
	
	//List of status
	public static final int WAITING = 0;
	public static final int DOCKING = 1;
	public static final int DOCKED = 2;
	public static final int UNDOCKING = 3;
	
	private int noOfContainer;
	private boolean isUnloaded;
	private int priority;
	private int status;
	
	public Ship() {
		this.noOfContainer = 0;
		this.isUnloaded = false;
		this.priority = 1;
		this.status = this.WAITING;
	}

	public void setNoOfContainer(int noOfContainer) {
		this.noOfContainer = noOfContainer;
	}
	
	public void setIsUnloaded(boolean isUnloaded) {
		this.isUnloaded = isUnloaded;
	}
	
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
	
	public int getPriority() {
		return this.priority;
	}
	
	public int getNoOfContainer() {
		return this.noOfContainer;
	}
	
	public int getStatus() {
		return status;
	}
	
	public void removeContainer() {
		this.noOfContainer -= 1;
	}
	
}
