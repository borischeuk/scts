package scts.events;

import scts.domain.Ship;
import simulation.BaseEvent;
import simulation.Simulation;

public class Dock extends BaseEvent{

	Ship theShip;
	
	public Dock(Ship theShip) {
		this.theShip = theShip;
	}
	
	@Override
	public void execute(Simulation simulation) {
		
		
		
	}

}
