package scts.events;

import scts.domain.Lane;
import scts.domain.YardVehicle;
import scts.simulations.ConfigValues;
import scts.simulations.Stats;
import scts.simulations.UnloadingSimulation;
import simulation.event.EventHandler;
import simulation.event.ScheduledEvent;
import simulation.simulation.Simulation;
import simulation.utils.RandomFactory;

/**
 * 
 * This class represents a yard vehicle picks a container from a lane.
 *
 */
public class YVPickEvent extends ScheduledEvent{

	YardVehicle vehicle;
	Lane lane;
	
	public YVPickEvent(Lane lane, YardVehicle vehicle, long duration) {
		super(duration);
		this.lane = lane;
		this.vehicle = vehicle;
	}

	@Override
	public void execute(Simulation simulation) {
		
		System.out.println("================= YV Picking ================");
		
		EventHandler handler = new EventHandler(simulation, this);
		
		if(this.getStartTime() == null)
			this.initialize();
		
		((UnloadingSimulation)simulation).getState().setVehicleAtLane(vehicle);
		
		handler.adjustTime();
		if(!handler.isTimeOut()) {
			vehicle.setStatus(YardVehicle.LOADING);
			lane.setStatus(Lane.LOADING);
			handler.reschedule();
		} else {
			vehicle.setStatus(YardVehicle.TRAVELING);
			lane.setStatus(Lane.FREE);
			((UnloadingSimulation)simulation).getState().getVehicleToStackQueue().add(vehicle);
			((UnloadingSimulation)simulation).getState().setVehicleAtLane(null);
			
			ConfigValues configValues = ((UnloadingSimulation)simulation).getConfigValues();
			int minTime = configValues.getyvTravelToSeaSideMinTime();
			int maxTime = configValues.getyvTravelToSeaSideMaxTime();
			int simulationSpeed = configValues.getSimulationSpeed();
			//int duration = RandomFactory.randSimulationTime(minTime, maxTime, simulationSpeed);
			long duration = RandomFactory.randSimTimeInMilliSec(minTime, maxTime, simulationSpeed);
			simulation.schedule(new YVToStackEvent(vehicle, duration));
			
			//Update the statistics of the simulation.
			Stats stats = ((UnloadingSimulation)simulation).getStats();
			double pickingTime = this.getDuration() * ((UnloadingSimulation)simulation).getConfigValues().getSimulationSpeed() / 1000 / 60;
			stats.setYardVehicleTimeSpentInQA(stats.getYardVehicleTimeSpentInQA() + pickingTime);
			stats.setYardVehicleTotalTimeSpent(stats.getYardVehicleTotalTimeSpent() + pickingTime);
		}
	}

}
