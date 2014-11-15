package scts.events;

import simulation.event.EventHandler;
import simulation.event.ScheduledEvent;
import simulation.simulation.Simulation;

public class TestEvent extends ScheduledEvent{

	public TestEvent(int duration) {
		super(duration);
	}

	@Override
	public void execute(Simulation simulation) {
		EventHandler handler = new EventHandler(simulation, this);
		
		System.out.println("=============Testing Testing Testing ========================");
		
		handler.adjustTime();
		if(!handler.isTimeOut())
			simulation.schedule(this);
		else {
			
		}
	}

}
