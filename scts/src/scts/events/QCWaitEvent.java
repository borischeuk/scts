package scts.events;

import scts.domain.Crane;
import scts.domain.Lane;
import simulation.event.EventHandler;
import simulation.event.ScheduledEvent;
import simulation.simulation.Simulation;

public class QCWaitEvent extends ScheduledEvent{

	Crane crane;
	Lane lane;
	
	public QCWaitEvent(Crane crane, Lane lane, int duration) {
		super(duration);
		this.crane = crane;
		this.lane = lane;
	}

	@Override
	public void execute(Simulation simulation) {
		
		System.out.println("================= Waiting ================");
		
		EventHandler handler = new EventHandler(simulation, this);
		
		if(lane.hasContainer() || lane.getStatus() == Lane.LOADING) {
			//System.out.println("Lane has container");
			//simulation.schedule(this);
			handler.reschedule();
		} else {
			//System.out.println("Lane does not have container");
			simulation.schedule(new QCSetDownEvent(crane, lane, 3));
		}
	}

}
