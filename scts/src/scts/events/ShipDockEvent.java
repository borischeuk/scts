package scts.events;

import scts.domain.Ship;
import scts.simulations.Stats;
import scts.simulations.UnloadingSimulation;
import simulation.event.EventHandler;
import simulation.event.ScheduledEvent;
import simulation.simulation.Simulation;

/**
 * 
 * This class represents ship docks to the berth.
 *
 */
public class ShipDockEvent extends ScheduledEvent{

	Ship theShip;
	
	public ShipDockEvent(Ship theShip, long duration) {
		super(duration);
		this.theShip = theShip;
	}
	
	@Override
	public void execute(Simulation simulation) {
		
		if(this.getStartTime() == null)
			this.initialize();
		
		EventHandler handler = new EventHandler(simulation, this);
		handler.adjustTime();
		if(!handler.isTimeOut()) {
			theShip.setStatus(Ship.DOCKING);
			handler.reschedule();
		} else {
			theShip.setStatus(Ship.DOCKED);
			
			//Update the statistics of the simulation.
			Stats stats = ((UnloadingSimulation)simulation).getStats();
			stats.setTotalShips(stats.getTotalShips() + 1);
			stats.setTotalContainers(stats.getTotalContainers() + theShip.getNoOfContainer());
		}
		
	}

}
