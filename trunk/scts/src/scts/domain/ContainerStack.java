package scts.domain;

import java.util.Stack;

public class ContainerStack {

	private Crane yardCrane;
	private SSTransferPt transferPt;
	private int noOfContainer;
	private int size;
	
	public ContainerStack() {
		yardCrane = new Crane();
		transferPt = new SSTransferPt();
		noOfContainer = 0;
	}
	
	public Crane getYardCrane() {
		return yardCrane;
	}
	
	public int getNoOfContainer() {
		return noOfContainer;
	}
	
	public SSTransferPt getTransferPt() {
		return transferPt;
	}
	
	public int getSize() {
		return size;
	}
	
	public void setYardCrane(Crane crane) {
		this.yardCrane = crane;
	}
	
	public void setNoOfContainer(int noOfContainer) {
		this.noOfContainer = noOfContainer;
	}
	
	public void setTransferPt(SSTransferPt transferPt) {
		this.transferPt = transferPt;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
	public boolean isEmpty() {
		if(noOfContainer == 0)
			return true;
		else
			return false;
	}
	
	public boolean isFull() {
		if(noOfContainer == size)
			return true;
		else
			return false;
	}
	
}
