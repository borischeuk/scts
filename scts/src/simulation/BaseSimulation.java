package simulation;

import java.util.ArrayDeque;
import java.util.Date;

public abstract class BaseSimulation {

	protected ArrayDeque<ScheduledEvent> scheduleQueue;
	
	protected Date startTime;
	protected int currentTime;
	
	protected boolean stop;
	
	public abstract void schedule(ScheduledEvent event);
	
	public abstract void run();
	
	public abstract void stop();
	
	public Date getStartTime() {
		return startTime;
	}
	
	public int currentTime() {
		return currentTime;
	}
	
}
