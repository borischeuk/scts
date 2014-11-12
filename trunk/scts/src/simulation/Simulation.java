package simulation;

import java.util.ArrayDeque;

public class Simulation extends BaseSimulation{

	public Simulation() {
		sqs = new ArrayDeque<ScheduledEvent>();
		currentTime = 0;
		stop = false;
	}
	
	@Override
	public void schedule(ScheduledEvent newEvent) {
		sqs.add(newEvent);
	}

	@Override
	public void run() {
		
		ScheduledEvent currentEvent;
		
		while(!sqs.isEmpty() && !this.stop) {
			currentEvent = sqs.poll();
			currentEvent.getEvent().execute(this);
		}
		
	}

	@Override
	public void stop() {
		
		this.stop = true;
		
	}


}
