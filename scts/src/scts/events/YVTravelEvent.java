package scts.events;

import scts.domain.YardVehicle;
import scts.simulations.UnloadingSimulation;
import simulation.event.EventHandler;
import simulation.event.ScheduledEvent;
import simulation.simulation.Simulation;

public class YVTravelEvent extends ScheduledEvent{
	
	YardVehicle vehicle;
	
	public YVTravelEvent(YardVehicle vehicle, int duration) {
		super(duration);
		this.vehicle = vehicle;
	}

	@Override
	public void execute(Simulation simulation) {
		
		//System.out.println("================= Traveling ================");
		
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
		}
	}

}
