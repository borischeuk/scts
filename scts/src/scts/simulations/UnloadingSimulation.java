package scts.simulations;

import java.util.PriorityQueue;
import java.util.Queue;

import scts.domain.Ship;
import scts.events.ShipGeneration;
import scts.events.StopEvent;
import scts.events.TestEvent;
import simulation.ScheduledEvent;
import simulation.Simulation;

public class UnloadingSimulation extends Simulation{
	
	private Queue<Ship> shipQueue;
	
	public UnloadingSimulation() {
		super();
		shipQueue = new PriorityQueue<Ship>();
		
		this.schedule( new ScheduledEvent(new ShipGeneration(), 0) );
		
	}
	
	public PriorityQueue getShipQueue() {
		return (PriorityQueue)this.shipQueue;
	}
	
	public void setShipQueue(PriorityQueue shipQueue) {
		this.shipQueue = shipQueue;
	}
	
}
