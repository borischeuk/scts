package scts.events.eventHandler;

import scts.events.ShipDockEvent;
import simulation.event.EventHandler;
import simulation.simulation.Simulation;

public class DockingHandler extends EventHandler{
	
	public DockingHandler(Simulation simulation, ShipDockEvent dockingEvent) {
		super(simulation, dockingEvent);
	}

}
