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

/**
 * 
 * This class stores the values used by simulation and represent the context of the simulation.
 *
 */
public class SimulationState {

	private Queue<Ship> shipQueue;  //Ship waiting for docking
	private List<Crane> QCArray;    //Quay cranes in the simulation
	private List<Crane> YCArray;    //Yard cranes in the simulation
	private List<Lane> laneArray;   //Lanes in the simulation
	private Queue<YardVehicle> vehicleQuayQueue;     //Yard vehicles waiting in quay area
	private Queue<YardVehicle> vehicleStackQueue;    //Yard vehicles waiting in seaside transfer point
	private YardVehicle vehicleAtLane;               //Yard vehicles working at lane
	private YardVehicle vehicleAtTPt;                //Yard vehicles working at seaside transfer point
	private List<YardVehicle> vehicleToStackQueue;   //Yard vehicles traveling to stack
	private List<YardVehicle> vehicleToQuayQueue;    //Yard vehicles traveling to quay
	private List<ContainerStack> stackArray;         //Stacks in the simulation
	
	public SimulationState() {
		shipQueue = new PriorityQueue<Ship>();
		QCArray = new ArrayList<Crane>();
		YCArray = new ArrayList<Crane>();
		laneArray = new ArrayList<Lane>();
		vehicleQuayQueue = new ArrayDeque<YardVehicle>();
		vehicleStackQueue = new ArrayDeque<YardVehicle>();
		vehicleAtLane = null;
		vehicleAtTPt = null;
		vehicleToStackQueue = new ArrayList<YardVehicle>();
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
	
	public List<YardVehicle> getVehicleToStackQueue() {
		return vehicleToStackQueue;
	}
	
	public List<YardVehicle> getVehicleToQuayQueue() {
		return vehicleToQuayQueue;
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
	
	public void setVehicleTravelingQueue(List<YardVehicle> vehicleToStackQueue) {
		this.vehicleToStackQueue = vehicleToStackQueue;
	}
	
	public void setVehicleToQuayQueue(List<YardVehicle> vehicleToQuayQueue) {
		this.vehicleToQuayQueue = vehicleToQuayQueue;
	}
	
	public void setStackArray(List<ContainerStack> stackArray) {
		this.stackArray = stackArray;
	}
	
}
