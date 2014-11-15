package scts.domain;

public class Lane {

	public static final int FREE = 0;
	public static final int OCCUPIED = 1;
	public static final int LOADING = 2;
	
	private boolean occupied;
	private int status;
	
	public void Lane() {
		occupied = false;
		status = FREE;
	}
	
	public boolean hasContainer() {
		if(status == OCCUPIED)
			return true;
		else
			return false;
	}
	
	public void accommodate() {
		occupied = true;
		status = OCCUPIED;
	}
	
	public void removeContainer() {
		occupied = false;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
	
	public int getStatus() {
		return status;
	}
	
}
