package scts.events;

import scts.domain.Ship;
import scts.simulations.Stats;
import scts.simulations.UnloadingSimulation;
import simulation.event.EventHandler;
import simulation.event.ScheduledEvent;
import simulation.simulation.Simulation;

/**
 * 
 * This class represents ship undocks.
 *
 */
public class ShipUndockEvent extends ScheduledEvent{

	Ship ship;
	
	public ShipUndockEvent(Ship ship, long duration) {
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
			Stats stats = ((UnloadingSimulation)simulation).getStats();
			double serviceTime = simulation.getCurrentTime() /60 / 1000;
			stats.setShipServiceTime(serviceTime);
		}
	}

}
