package simulation.simulation;

import java.util.ArrayDeque;
import java.util.Calendar;

import simulation.event.ScheduledEvent;

public class Simulation extends BaseSimulation{

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


}
