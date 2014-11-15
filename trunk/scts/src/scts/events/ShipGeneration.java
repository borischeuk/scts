package scts.events;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Random;

import scts.domain.Ship;
import scts.simulations.UnloadingSimulation;
import simulation.event.BaseEvent;
import simulation.event.ScheduledEvent;
import simulation.simulation.Simulation;

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
		
		//System.out.println("Total Number of Ship Generated ================= " + unloadingSimulation.getState().getShipQueue().size());
		
		//simulation.schedule( new DockingEvent( ( (UnloadingSimulation)simulation).getState().getShipQueue().peek(), 10) );
	}

}
