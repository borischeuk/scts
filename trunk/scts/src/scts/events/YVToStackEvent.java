package scts.events;

import scts.domain.YardVehicle;
import scts.simulations.Stats;
import scts.simulations.UnloadingSimulation;
import simulation.event.EventHandler;
import simulation.event.ScheduledEvent;
import simulation.simulation.Simulation;

/**
 * 
 * This class represents a yard vehicle travels to a seaside transfer point.
 *
 */
public class YVToStackEvent extends ScheduledEvent{
	
	YardVehicle vehicle;
	
	public YVToStackEvent(YardVehicle vehicle, long duration) {
		super(duration);
		this.vehicle = vehicle;
	}

	@Override
	public void execute(Simulation simulation) {
		
		System.out.println("================= YV Going To Stack  ================");
		
		EventHandler handler = new EventHandler(simulation, this);
		
		if(this.getStartTime() == null)
			this.initialize();
		
		handler.adjustTime();
		if(!handler.isTimeOut()) {
			vehicle.setStatus(YardVehicle.TRAVELING);
			//simulation.schedule(this);
			handler.reschedule();
		} else {
			vehicle.setStatus(YardVehicle.WAITING);
			((UnloadingSimulation)simulation).getState().getVehicleStackQueue().add(vehicle);
			
			//Update the statistics of the simulation.
			Stats stats = ((UnloadingSimulation)simulation).getStats();
			double travelingTime = this.getDuration() * ((UnloadingSimulation)simulation).getConfigValues().getSimulationSpeed() / 1000 / 60;
			stats.setYardVehicleTotalTimeSpent(stats.getYardVehicleTotalTimeSpent() + travelingTime);
		}
	}

}
