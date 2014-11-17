package simulation.event;

import java.lang.Comparable;
import java.util.Calendar;
import java.util.Date;

import simulation.simulation.Simulation;

public abstract class ScheduledEvent implements BaseEvent, Comparable<ScheduledEvent>{

	protected Date startTime;
	protected long duration;
	protected long timeOfOccurance;
	
	public ScheduledEvent(long duration) {
		this.duration = duration;
		this.timeOfOccurance = 0;
		this.startTime = null;
	}
	
	//The logic of the event
	@Override
	public abstract void execute(Simulation simulation);
	
	//Initialize the event if the event has not been started.
	public void initialize() {
		this.startTime = Calendar.getInstance().getTime();
	}
	
	//Determine which event would be executed first when 2 events are executed simultaneously.
	@Override
	public int compareTo(ScheduledEvent e) {
		return Integer.compare(this.getPriority(), e.getPriority());
	}
	
	public Date getStartTime() {
		return startTime;
	}
	
	public long getDuration() {
		return duration;
	}
	
	public int getPriority() {
		return (int)duration;
	}
	
	public long getTimeOfOccurance() {
		return timeOfOccurance;
	}
	
	public void setTimeOfOccurance(long timeOfOccurance) {
		this.timeOfOccurance = timeOfOccurance;
	}
	
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

}
