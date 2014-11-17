package scts.domain;

public class SSTransferPt {

	//List of status
	public static final int FREE = 0;
	public static final int OCCUPIED = 1;
	public static final int LOADING = 2;
	public static final int UNLOADING = 3;
	
	private int status;
	
	public SSTransferPt() {
		status = FREE;
	}
	
	public void accommodate() {
		status = OCCUPIED;
	}
	
	public void removeContainer() {
		status = FREE;
	}
	
	public boolean hasContainer() {
		if(status == OCCUPIED)
			return true;
		else
			return false;
	}
	
	public int getStatus() {
		return status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
	
}
