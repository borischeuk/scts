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
	
	public StopEvent(Simulation simulation, long duration) {
		super(duration);
		this.simulation = simulation;
	}
	
	@Override
	public void execute(Simulation simulation) {

		simulation.stop();
		
	}

}
