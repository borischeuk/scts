package scts.events;

import scts.domain.SSTransferPt;
import scts.domain.YardVehicle;
import scts.simulations.UnloadingSimulation;
import simulation.event.EventHandler;
import simulation.event.ScheduledEvent;
import simulation.simulation.Simulation;

public class YVUnloadEvent extends ScheduledEvent{

	YardVehicle vehicle;
	SSTransferPt transferPt;
	
	public YVUnloadEvent(YardVehicle vehicle, SSTransferPt transferPt, int duration) {
		super(duration);
		this.vehicle = vehicle;
		this.transferPt = transferPt;
	}

	@Override
	public void execute(Simulation simulation) {
		
		System.out.println("================= Vehicle Unload ================");
		
		EventHandler handler = new EventHandler(simulation, this);
		
		if(this.getStartTime() == null)
			this.initialize();
		
		((UnloadingSimulation)simulation).getState().setVehicleAtTPt(vehicle);
		
		handler.adjustTime();
		if(!handler.isTimeOut()) {
			vehicle.setStatus(YardVehicle.UNLOADING);
			transferPt.setStatus(SSTransferPt.LOADING);
			//simulation.schedule(this);
			handler.reschedule();
		} else {
			//((UnloadingSimulation)simulation).getState().getVehicleStackQueue().poll();
			((UnloadingSimulation)simulation).getState().setVehicleAtTPt(null);
			transferPt.setStatus(SSTransferPt.OCCUPIED);
			simulation.schedule(new YVToQuayEvent(vehicle, 3));
		}
	}

}
