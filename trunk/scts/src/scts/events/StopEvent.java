package scts.events;

import simulation.BaseEvent;
import simulation.Simulation;

public class StopEvent extends BaseEvent{

	Simulation simulation;
	
	public StopEvent(Simulation simulation) {
		this.simulation = simulation;
	}
	
	@Override
	public void execute(Simulation simulation) {
		
		System.out.println("===================Simulation Stop===============");
		simulation.stop();
		
	}

}
