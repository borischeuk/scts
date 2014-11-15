package scts.events;

import scts.domain.Ship;
import scts.simulations.UnloadingSimulation;
import simulation.event.EventHandler;
import simulation.event.ScheduledEvent;
import simulation.simulation.Simulation;

public class ShipUndockEvent extends ScheduledEvent{

	Ship ship;
	
	public ShipUndockEvent(Ship ship, int duration) {
		super(duration);
		this.ship = ship;
	}

	@Override
	public void execute(Simulation simulation) {
		
		System.out.println("================ Undocking ================");
		
		if(this.getStartTime() == null)
			this.initialize();
		
		EventHandler handler = new EventHandler(simulation, this);
		
		handler.adjustTime();
		if(!handler.isTimeOut()) {
			//simulation.schedule(this);
			handler.reschedule();
		} else {
			((UnloadingSimulation)simulation).getState().getShipQueue().poll();
		}
	}

}
