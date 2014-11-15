package scts.events;

import scts.domain.YardVehicle;
import scts.simulations.UnloadingSimulation;
import simulation.event.EventHandler;
import simulation.event.ScheduledEvent;
import simulation.simulation.Simulation;

public class YVToQuayEvent extends ScheduledEvent{

	YardVehicle yardVehicle;
	
	public YVToQuayEvent(YardVehicle yardVehicle, int duration) {
		super(duration);
		this.yardVehicle = yardVehicle;
	}

	@Override
	public void execute(Simulation simulation) {
		
		//System.out.println("======================== Going to quay =========================");
		
		EventHandler handler = new EventHandler(simulation, this);
		
		if(this.getStartTime() == null)
			this.initialize();
		
		handler.adjustTime();
		if(!handler.isTimeOut()) {
			yardVehicle.setStatus(YardVehicle.TRAVELING);
			//simulation.schedule(this);
			handler.reschedule();
		} else {
			yardVehicle.setStatus(YardVehicle.WAITING);
			((UnloadingSimulation)simulation).getState().getVehicleQuayQueue().add(yardVehicle);
		}
	}

}
