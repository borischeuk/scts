package scts.simulations;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import scts.domain.ContainerStack;
import scts.domain.Crane;
import scts.domain.Lane;
import scts.domain.Ship;
import scts.domain.YardVehicle;

public class SimulationState {

	private Queue<Ship> shipQueue;
	private List<Crane> QCArray;
	private List<Crane> YCArray;
	private List<Lane> laneArray; 
	private Queue<YardVehicle> vehicleQuayQueue;
	private Queue<YardVehicle> vehicleStackQueue;
	private YardVehicle vehicleAtLane;
	private YardVehicle vehicleAtTPt;
	private List<ContainerStack> stackArray;
	
	public SimulationState() {
		shipQueue = new PriorityQueue<Ship>();
		QCArray = new ArrayList<Crane>();
		YCArray = new ArrayList<Crane>();
		laneArray = new ArrayList<Lane>();
		vehicleQuayQueue = new ArrayDeque<YardVehicle>();
		vehicleStackQueue = new ArrayDeque<YardVehicle>();
		vehicleAtLane = null;
		vehicleAtTPt = null;
		stackArray = new ArrayList<ContainerStack>();
	}
	
	public Queue<Ship> getShipQueue() {
		return shipQueue;
	}
	
	public List<Crane> getQCArray() {
		return QCArray;
	}
	
	public List<Crane> getYCArray() {
		return YCArray;
	}
	
	public List<Lane> getlaneArray() {
		return laneArray;
	}
	
	public Queue<YardVehicle> getVehicleQuayQueue() {
		return vehicleQuayQueue;
	}
	
	public Queue<YardVehicle> getVehicleStackQueue() {
		return vehicleStackQueue;
	}
	
	public YardVehicle getVehicleAtLane() {
		return vehicleAtLane;
	}
	
	public YardVehicle getVehicleAtTPt() {
		return vehicleAtTPt;
	}
	
	public List<ContainerStack> getStackArray() {
		return stackArray;
	}
	
	public void setShipQueue(Queue<Ship> shipQueue) {
		this.shipQueue = shipQueue;
	}
	
	public void setQCArray(List<Crane> craneArray) {
		this.YCArray = craneArray;
	}
	
	public void setYCArray(List<Crane> craneArray) {
		this.QCArray = craneArray;
	}
	
	public void setLaneArray(List<Lane> laneArray) {
		this.laneArray = laneArray;
	}
	
	public void setVehicleQuayQueue(Queue<YardVehicle> vehicleQuayQueue) {
		this.vehicleQuayQueue = vehicleQuayQueue;
	}
	
	public void setVehicleStackQueue(Queue<YardVehicle> vehicleQuayQueue) {
		this.vehicleQuayQueue = vehicleQuayQueue;
	}
	
	public void setVehicleAtLane(YardVehicle vehicle) {
		this.vehicleAtLane = vehicle;
	}
	
	public void setVehicleAtTPt(YardVehicle vehicle) {
		this.vehicleAtTPt = vehicle;
	}
	
	public void setStackArray(List<ContainerStack> stackArray) {
		this.stackArray = stackArray;
	}
	
}
