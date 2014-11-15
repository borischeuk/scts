package scts.events;

import scts.domain.Crane;
import scts.domain.Lane;
import scts.domain.Ship;
import scts.simulations.UnloadingSimulation;
import simulation.event.EventHandler;
import simulation.event.ScheduledEvent;
import simulation.simulation.Simulation;

public class QCLoadEvent extends ScheduledEvent {

	private Ship ship;
	private Crane crane;
	
	public QCLoadEvent(Ship ship, Crane crane, int duration) {
		super(duration);
		this.ship = ship;
		this.crane = crane;
	}

	@Override
	public void execute(Simulation simulation) {
		
		//System.out.println("====================== Unloading ======================");
		
		if(this.getStartTime() == null)
			this.initialize();
		
		EventHandler handler = new EventHandler(simulation, this);
		handler.adjustTime();
		if(!handler.isTimeOut()) {
			//crane.setStatus(Crane.LOADING);
			//simulation.schedule(this);
			handler.reschedule();
		} else {
			crane.pick();
			crane.setStatus(Crane.OCCUPIED);
			ship.setNoOfContainer(ship.getNoOfContainer() - 1);
			
			Lane lane = ((UnloadingSimulation)simulation).getState().getlaneArray().get(0);
			simulation.schedule(new QCWaitEvent(crane, lane, 0));
		}
		
	}
	
}
