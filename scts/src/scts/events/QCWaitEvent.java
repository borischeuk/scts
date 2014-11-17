package scts.events;

import scts.domain.Crane;
import scts.domain.Lane;
import scts.simulations.ConfigValues;
import scts.simulations.UnloadingSimulation;
import simulation.event.EventHandler;
import simulation.event.ScheduledEvent;
import simulation.simulation.Simulation;
import simulation.utils.RandomFactory;

/**
 * 
 * This class represents quay crane waits for putting a container to a lane.
 *
 */
public class QCWaitEvent extends ScheduledEvent{

	Crane crane;
	Lane lane;
	
	public QCWaitEvent(Crane crane, Lane lane, long duration) {
		super(duration);
		this.crane = crane;
		this.lane = lane;
	}

	@Override
	public void execute(Simulation simulation) {
		
		EventHandler handler = new EventHandler(simulation, this);
		
		if(lane.hasContainer() || lane.getStatus() == Lane.LOADING) {
			handler.reschedule();
		} else {
			ConfigValues configValues = ((UnloadingSimulation)simulation).getConfigValues();
			int minTime = configValues.getqcPlaceMinTime();
			int maxTime = configValues.getqcPlaceMaxTime();
			//int duration = RandomFactory.randSimulationTime(minTime, maxTime, configValues.getSimulationSpeed());
			long duration = RandomFactory.randSimTimeInMilliSec(minTime, maxTime, configValues.getSimulationSpeed());
			simulation.schedule(new QCSetDownEvent(crane, lane, duration));
		}
	}

}
