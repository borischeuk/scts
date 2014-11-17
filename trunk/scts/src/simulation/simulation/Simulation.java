package simulation.simulation;

import java.util.ArrayDeque;
import java.util.Calendar;
import java.util.Date;

import simulation.event.ScheduledEvent;

public class Simulation implements BaseSimulation{
	
	protected ArrayDeque<ScheduledEvent> scheduleQueue;
	
	protected Date startTime;
	protected long currentTime;
	protected boolean stop;

	public Simulation() {
		scheduleQueue = new ArrayDeque<ScheduledEvent>();
		startTime = Calendar.getInstance().getTime();
		currentTime = 0;
		stop = false;
	}
	
	@Override
	public void schedule(ScheduledEvent newEvent) {
		scheduleQueue.add(newEvent);
	}

	@Override
	public void run() {
		
		ScheduledEvent currentEvent;
		
		while(!scheduleQueue.isEmpty() && !this.stop) {
			currentEvent = scheduleQueue.poll();
			currentEvent.execute(this);
		}
		
	}

	@Override
	public void stop() {
		this.stop = true;
	}

	public Date getStartTime() {
		return startTime;
	}
	
	public long getCurrentTime() {
		return currentTime;
	}

}
