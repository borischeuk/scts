package simulation.event;

import java.util.Calendar;
import java.util.Date;

import simulation.simulation.Simulation;

public class EventHandler {
	
	private ScheduledEvent event;
	private Simulation simulation;
	
	public EventHandler(Simulation simulation, ScheduledEvent event) {
		this.event = event;
		this.simulation = simulation;
	}
	
	//Adjust the time of event.
	public void adjustTime() {
		Date eventStartTime = event.getStartTime();
		long eventTimeOfOccurance = event.getTimeOfOccurance();
		
		long timeDiff = Calendar.getInstance().getTimeInMillis() - eventStartTime.getTime();
		eventTimeOfOccurance = timeDiff;
		event.setTimeOfOccurance(eventTimeOfOccurance);
		
		//Used for debugging
		System.out.println("Current Time ================== " + Calendar.getInstance().getTime());
		System.out.println("Event start time ================== " + eventStartTime);
		System.out.println("Event duration ======================== " + event.getDuration());
		System.out.println("Time Difference ================== " + timeDiff);

	}
	
	//Check whether the event finishes or not.
	public boolean isTimeOut() {
		if(event.getDuration() <= event.getTimeOfOccurance())
			return true;
		
		return false;
	}
	
	//Schedule the event to the simulation.
	public void reschedule() {
		simulation.schedule(event);
	}
	
}
