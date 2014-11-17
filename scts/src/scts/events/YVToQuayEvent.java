package scts.events;

import scts.domain.YardVehicle;
import scts.simulations.Stats;
import scts.simulations.UnloadingSimulation;
import simulation.event.EventHandler;
import simulation.event.ScheduledEvent;
import simulation.simulation.Simulation;

/**
 * 
 * This class represents a yard vehicle travels to the quay.
 *
 */
public class YVToQuayEvent extends ScheduledEvent{

	YardVehicle yardVehicle;
	
	public YVToQuayEvent(YardVehicle yardVehicle, long duration) {
		super(duration);
		this.yardVehicle = yardVehicle;
	}

	@Override
	public void execute(Simulation simulation) {
		
		EventHandler handler = new EventHandler(simulation, this);
		
		if(this.getStartTime() == null)
			this.initialize();
		
		handler.adjustTime();
		if(!handler.isTimeOut()) {
			yardVehicle.setStatus(YardVehicle.TRAVELING);
			handler.reschedule();
		} else {
			yardVehicle.setStatus(YardVehicle.WAITING);
			((UnloadingSimulation)simulation).getState().getVehicleQuayQueue().add(yardVehicle);
			
			//Update the statistics of the simulation.
			Stats stats = ((UnloadingSimulation)simulation).getStats();
			double travelingTime = this.getDuration() * ((UnloadingSimulation)simulation).getConfigValues().getSimulationSpeed() / 1000 / 60;
			stats.setYardVehicleTotalTimeSpent(stats.getYardVehicleTotalTimeSpent() + travelingTime);
		}
	}

}
