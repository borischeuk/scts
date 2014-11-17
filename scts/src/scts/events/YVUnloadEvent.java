package scts.events;

import scts.domain.SSTransferPt;
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
 * This class represents a yard vehicle unloads a container to a seaside transfer point.
 *
 */
public class YVUnloadEvent extends ScheduledEvent{

	YardVehicle vehicle;
	SSTransferPt transferPt;
	
	public YVUnloadEvent(YardVehicle vehicle, SSTransferPt transferPt, long duration) {
		super(duration);
		this.vehicle = vehicle;
		this.transferPt = transferPt;
	}

	@Override
	public void execute(Simulation simulation) {
		
		if(this.getStartTime() == null)
			this.initialize();
		
		((UnloadingSimulation)simulation).getState().setVehicleAtTPt(vehicle);
		
		EventHandler handler = new EventHandler(simulation, this);
		handler.adjustTime();
		if(!handler.isTimeOut()) {
			vehicle.setStatus(YardVehicle.UNLOADING);
			transferPt.setStatus(SSTransferPt.LOADING);
			handler.reschedule();
		} else {
			((UnloadingSimulation)simulation).getState().setVehicleAtTPt(null);
			transferPt.setStatus(SSTransferPt.OCCUPIED);
			
			ConfigValues configValues = ((UnloadingSimulation)simulation).getConfigValues();
			int minTime = configValues.getyvTravelToQAMinTime();
			int maxTime = configValues.getyvTravelToQAMaxTime();
			int simulationSpeed = configValues.getSimulationSpeed();
			long duration = RandomFactory.randSimTimeInMilliSec(minTime, maxTime, simulationSpeed);
			simulation.schedule(new YVToQuayEvent(vehicle, duration));
			
			//Update the statistics of the simulation.
			Stats stats = ((UnloadingSimulation)simulation).getStats();
			double unloadingTime = this.getDuration() * ((UnloadingSimulation)simulation).getConfigValues().getSimulationSpeed() / 1000 / 60;
			stats.setYardVehicleTimeSpentInSeaside(stats.getYardVehicleTimeSpentInSeaside() + unloadingTime);
			stats.setYardVehicleTotalTimeSpent(stats.getYardVehicleTotalTimeSpent() + unloadingTime);
		}
	}

}
