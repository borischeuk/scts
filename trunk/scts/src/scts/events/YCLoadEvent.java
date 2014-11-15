package scts.events;

import scts.domain.ContainerStack;
import scts.domain.Crane;
import scts.domain.SSTransferPt;
import simulation.event.EventHandler;
import simulation.event.ScheduledEvent;
import simulation.simulation.Simulation;

public class YCLoadEvent extends ScheduledEvent{

	ContainerStack containerStack;
	
	public YCLoadEvent(ContainerStack containerStack, int duration) {
		super(duration);
		this.containerStack = containerStack;
	}

	@Override
	public void execute(Simulation simulation) {
		
		EventHandler handler = new EventHandler(simulation, this);
		
		if(this.getStartTime() == null)
			this.initialize();
		
		handler.adjustTime();
		if(!handler.isTimeOut()) {
			simulation.schedule(this);
		} else {
			containerStack.getTransferPt().setStatus(SSTransferPt.FREE);
			containerStack.getYardCrane().setStatus(Crane.OCCUPIED);
		}
		
	}

}
