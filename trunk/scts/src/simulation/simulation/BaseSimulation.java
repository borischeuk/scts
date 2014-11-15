package simulation.simulation;

import java.util.ArrayDeque;
import java.util.Date;

import simulation.event.ScheduledEvent;

public interface BaseSimulation {
	
	public void schedule(ScheduledEvent event);
	
	public void run();
	
	public void stop();
	
}
