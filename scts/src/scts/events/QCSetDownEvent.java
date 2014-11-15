package scts.events;

import scts.domain.Crane;
import scts.domain.Lane;
import simulation.event.EventHandler;
import simulation.event.ScheduledEvent;
import simulation.simulation.Simulation;

public class QCSetDownEvent extends ScheduledEvent{

	Crane crane;
	Lane lane;
	
	public QCSetDownEvent(Crane crane, Lane lane, int duration) {
		super(duration);
		this.crane = crane;
		this.lane = lane;
	}

	@Override
	public void execute(Simulation simulation) {
		
		//System.out.println("============ Setting Down ===============");
		
		if(this.getStartTime() == null)
			this.initialize();
		
		EventHandler handler = new EventHandler(simulation, this);
		handler.adjustTime();
		if(!handler.isTimeOut()) {
			crane.setStatus(Crane.SETTINGDOWN);
			lane.setStatus(Lane.LOADING);
			//simulation.schedule(this);
			handler.reschedule();
		} else {
			crane.setDown();
			crane.setStatus(Crane.IDLE);
			lane.setStatus(Lane.OCCUPIED);
			lane.accommodate();
		}
	}

}
