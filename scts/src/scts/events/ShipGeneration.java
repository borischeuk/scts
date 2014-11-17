package scts.events;

import java.util.ArrayList;
import java.util.PriorityQueue;

import scts.domain.Ship;
import scts.simulations.UnloadingSimulation;
import simulation.event.ScheduledEvent;
import simulation.simulation.Simulation;

/**
 * 
 * This class generates ship.
 *
 */
public class ShipGeneration extends ScheduledEvent{
	
	//For subsequent release
	private int noOfShipArrive;
	private ArrayList<Integer> priorityArray;
	
	public ShipGeneration(int duration) {
		super(duration);
	}
	
	@Override
	public void execute(Simulation simulation) {
		
		UnloadingSimulation unloadingSimulation = (UnloadingSimulation)simulation;
		
		Ship ship = new Ship();
		ship.setNoOfContainer(10);
		
		PriorityQueue<Ship> shipQueue = new PriorityQueue<Ship>();
		shipQueue.add(ship);
		
		unloadingSimulation.getState().setShipQueue(shipQueue);
		
	}

}
