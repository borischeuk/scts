package scts.events;

import scts.domain.ContainerStack;
import scts.domain.Crane;
import simulation.event.EventHandler;
import simulation.event.ScheduledEvent;
import simulation.simulation.Simulation;

public class YCUnloadEvent extends ScheduledEvent{

	ContainerStack containerStack;
	
	public YCUnloadEvent(ContainerStack containerStack, int duration) {
		super(duration);
		this.containerStack = containerStack;
	}

	@Override
	public void execute(Simulation simulation) {
		
		if(this.getStartTime() == null)
			this.initialize();
		
		EventHandler handler = new EventHandler(simulation, this);
		
		handler.adjustTime();
		if(!handler.isTimeOut()) {
			handler.reschedule();
		} else {
			containerStack.getYardCrane().setStatus(Crane.IDLE);
			containerStack.setNoOfContainer(containerStack.getNoOfContainer() + 1);
		}
	}

}
