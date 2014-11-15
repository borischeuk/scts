package scts.events;

import scts.domain.Crane;
import scts.domain.Ship;
import scts.simulations.UnloadingSimulation;
import simulation.event.BaseEvent;
import simulation.event.EventHandler;
import simulation.event.ScheduledEvent;
import simulation.simulation.Simulation;

public class ShipDockEvent extends ScheduledEvent{

	Ship theShip;
	
	public ShipDockEvent(Ship theShip, int duration) {
		super(duration);
		this.theShip = theShip;
	}
	
	@Override
	public void execute(Simulation simulation) {
		
		System.out.println("=============== Docking ================");
		
		if(this.getStartTime() == null)
			this.initialize();
		
		EventHandler handler = new EventHandler(simulation, this);
		handler.adjustTime();
		if(!handler.isTimeOut()) {
			theShip.setStatus(Ship.DOCKING);
			//simulation.schedule(this);
			handler.reschedule();
		} else {
			theShip.setStatus(Ship.DOCKED);
			//Crane crane = ((UnloadingSimulation)simulation).getState().getCraneQueue().peek();
			//simulation.schedule(new UnloadingEvent(this.theShip, crane, 10));
		}
		
	}

}
