package scts.events;

import scts.domain.Crane;
import scts.domain.Lane;
import scts.domain.Ship;
import scts.simulations.Stats;
import scts.simulations.UnloadingSimulation;
import simulation.event.EventHandler;
import simulation.event.ScheduledEvent;
import simulation.simulation.Simulation;

/**
 * 
 * This class represent the quay crane loads a container from a ship.
 *
 */
public class QCLoadEvent extends ScheduledEvent {

	private Ship ship;
	private Crane crane;
	
	public QCLoadEvent(Ship ship, Crane crane, long duration) {
		super(duration);
		this.ship = ship;
		this.crane = crane;
	}

	@Override
	public void execute(Simulation simulation) {
		
		if(this.getStartTime() == null)
			this.initialize();
		
		EventHandler handler = new EventHandler(simulation, this);
		handler.adjustTime();
		if(!handler.isTimeOut()) {
			handler.reschedule();
		} else {
			crane.load();
			crane.setStatus(Crane.OCCUPIED);
			ship.setNoOfContainer(ship.getNoOfContainer() - 1);
			Lane lane = ((UnloadingSimulation)simulation).getState().getlaneArray().get(0);
			simulation.schedule(new QCWaitEvent(crane, lane, 0));
			
			//Update the statistics of the simulation.
			Stats stats = ((UnloadingSimulation)simulation).getStats();
			double unloadTime = this.getDuration() * ((UnloadingSimulation)simulation).getConfigValues().getSimulationSpeed() / 1000 / 60;
			stats.setQuayCraneUnloadTime(stats.getQuayCraneUnloadTime() + unloadTime);
		}
		
	}
	
}
