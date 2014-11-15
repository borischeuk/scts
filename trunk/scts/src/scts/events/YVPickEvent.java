package scts.events;

import scts.domain.Lane;
import scts.domain.YardVehicle;
import scts.simulations.UnloadingSimulation;
import simulation.event.EventHandler;
import simulation.event.ScheduledEvent;
import simulation.simulation.Simulation;

public class YVPickEvent extends ScheduledEvent{

	YardVehicle vehicle;
	Lane lane;
	
	public YVPickEvent(Lane lane, YardVehicle vehicle, int duration) {
		super(duration);
		this.lane = lane;
		this.vehicle = vehicle;
	}

	@Override
	public void execute(Simulation simulation) {
		
		System.out.println("================= Picking ================");
		
		EventHandler handler = new EventHandler(simulation, this);
		
		if(this.getStartTime() == null)
			this.initialize();
		
		((UnloadingSimulation)simulation).getState().setVehicleAtLane(vehicle);
		
		handler.adjustTime();
		if(!handler.isTimeOut()) {
			vehicle.setStatus(YardVehicle.LOADING);
			lane.setStatus(Lane.LOADING);
			//simulation.schedule(this);
			handler.reschedule();
		} else {
			vehicle.setStatus(YardVehicle.TRAVELING);
			lane.setStatus(Lane.FREE);
			((UnloadingSimulation)simulation).getState().getVehicleToStackQueue().add(vehicle);
			//((UnloadingSimulation)simulation).getState().getVehicleQuayQueue().poll();
			((UnloadingSimulation)simulation).getState().setVehicleAtLane(null);
			simulation.schedule(new YVTravelEvent(vehicle, 3));
		}
	}

}
