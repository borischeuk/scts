package scts.events;

import simulation.event.ScheduledEvent;
import simulation.simulation.Simulation;

/**
 * 
 * This class stops the simulation.
 *
 */
public class StopEvent extends ScheduledEvent{

	Simulation simulation;
	
	public StopEvent(Simulation simulation, int duration) {
		super(duration);
		this.simulation = simulation;
	}
	
	@Override
	public void execute(Simulation simulation) {
		
		System.out.println("===================Simulation Stop===============");
		simulation.stop();
		
	}

}
