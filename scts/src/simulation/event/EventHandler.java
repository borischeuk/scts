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
	
	public void adjustTime() {
		Date globalStartTime = simulation.getStartTime();
		long globalCurrentTime = simulation.getCurrentTime();
		Date eventStartTime = event.getStartTime();
		long eventTimeOfOccurance = event.getTimeOfOccurance();
		
		//double timeDiff = ( new Long(eventStartTime.getTime() - globalStartTime.getTime()).doubleValue() ) / 1000;
		long timeDiff = ( Calendar.getInstance().getTimeInMillis() - eventStartTime.getTime() ) / 1000;
		/*System.out.println("Current Time ================== " + Calendar.getInstance().getTime());
		System.out.println("Event start time ================== " + eventStartTime);
		System.out.println("Time Difference ================== " + timeDiff);*/
		eventTimeOfOccurance = timeDiff;
		event.setTimeOfOccurance(eventTimeOfOccurance);
		
		//event.setStartTime(Calendar.getInstance().getTime());
	}
	
	public boolean isTimeOut() {
		if(event.getDuration() <= event.getTimeOfOccurance())
			return true;
		
		return false;
	}
	
	public void reschedule() {
		simulation.schedule(event);
	}
	
}
