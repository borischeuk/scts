package scts.events;

import simulation.BaseEvent;
import simulation.Simulation;

public class TestEvent extends BaseEvent{

	int n;
	
	public TestEvent(int n) {
		this.n = n;
	}
	
	@Override
	public void execute(Simulation simulation) {
		
		System.out.println("Testing ======================= " + n);
		
	}

}
