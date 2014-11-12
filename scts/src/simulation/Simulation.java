package simulation;

import java.util.ArrayDeque;

public class Simulation extends BaseSimulation{

	public Simulation() {
		scheduleQueue = new ArrayDeque<ScheduledEvent>();
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
			currentEvent.getEvent().execute(this);
		}
		
	}

	@Override
	public void stop() {
		
		this.stop = true;
		
	}


}
