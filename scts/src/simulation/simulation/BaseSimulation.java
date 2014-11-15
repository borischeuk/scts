package simulation.simulation;

import java.util.ArrayDeque;
import java.util.Date;

import simulation.event.ScheduledEvent;

public abstract class BaseSimulation {

	protected ArrayDeque<ScheduledEvent> scheduleQueue;
	
	protected Date startTime;
	protected long currentTime;
	
	protected boolean stop;
	
	public abstract void schedule(ScheduledEvent event);
	
	public abstract void run();
	
	public abstract void stop();
	
	public Date getStartTime() {
		return startTime;
	}
	
	public long getCurrentTime() {
		return currentTime;
	}
	
}
