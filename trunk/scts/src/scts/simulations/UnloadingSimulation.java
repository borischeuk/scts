package scts.simulations;

import scts.events.StopEvent;
import scts.events.TestEvent;
import simulation.ScheduledEvent;
import simulation.Simulation;

public class UnloadingSimulation extends Simulation{
	
	public UnloadingSimulation() {
		super();
		
		for (int i = 0; i < 50; i++) {
			ScheduledEvent testEvent = new ScheduledEvent(new TestEvent(i), 20);
			this.schedule(testEvent);
		}
		
		this.schedule( new ScheduledEvent(new StopEvent(this), 100000) );
		
		for (int i = 50; i < 100; i++) {
			ScheduledEvent testEvent = new ScheduledEvent(new TestEvent(i), 20);
			this.schedule(testEvent);
		}
		
	}
	
}
