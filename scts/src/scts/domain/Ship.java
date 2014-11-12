package scts.domain;

public class Ship {
	
	//List of status
	private final int WAITING = 0;
	private final int DOCKING = 1;
	private final int DOCKED = 2;
	private final int UNDOCKING = 3;
	
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
	
	public int getPriority() {
		return this.priority;
	}
	
	public void removeContainer() {
		this.noOfContainer -= 1;
	}
	
}
