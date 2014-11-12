package scts.events;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Random;

import scts.domain.Ship;
import scts.simulations.UnloadingSimulation;
import simulation.BaseEvent;
import simulation.Simulation;

public class ShipGeneration extends BaseEvent{
	
	//For subsequent release
	private int noOfShipArrive;
	private ArrayList<Integer> priorityArray;
	
	public ShipGeneration() {
	}
	
	@Override
	public void execute(Simulation simulation) {
		
		UnloadingSimulation unloadingSimulation = (UnloadingSimulation)simulation;
		
		Ship ship = new Ship();
		ship.setNoOfContainer(10);
		
		PriorityQueue<Ship> shipQueue = new PriorityQueue<Ship>();
		shipQueue.add(ship);
		
		unloadingSimulation.setShipQueue(shipQueue);
		
		System.out.println("Total Number of Ship Generated ================= " + unloadingSimulation.getShipQueue().size());
		
	}

}
