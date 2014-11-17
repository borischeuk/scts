package scts.events;

import scts.domain.ContainerStack;
import scts.domain.Crane;
import scts.domain.SSTransferPt;
import simulation.event.EventHandler;
import simulation.event.ScheduledEvent;
import simulation.simulation.Simulation;

/**
 * 
 * This class represents yard crane loads a container from a seaside transfer point.
 *
 */
public class YCLoadEvent extends ScheduledEvent{

	ContainerStack containerStack;
	
	public YCLoadEvent(ContainerStack containerStack, long duration) {
		super(duration);
		this.containerStack = containerStack;
	}

	@Override
	public void execute(Simulation simulation) {
		
		System.out.println("=============YC Loading============");
		
		if(this.getStartTime() == null)
			this.initialize();
		
		EventHandler handler = new EventHandler(simulation, this);
		handler.adjustTime();
		if(!handler.isTimeOut()) {
			handler.reschedule();
		} else {
			containerStack.getTransferPt().setStatus(SSTransferPt.FREE);
			containerStack.getYardCrane().setStatus(Crane.OCCUPIED);
		}
		
	}

}
