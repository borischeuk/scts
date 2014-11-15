package simulation.event;

import java.lang.Comparable;
import java.util.Calendar;
import java.util.Date;

import simulation.simulation.Simulation;

public abstract class ScheduledEvent extends BaseEvent implements Comparable<ScheduledEvent>{

	private Date startTime;
	private long duration;
	private long timeOfOccurance;
	//private BaseEvent event;
	
	public ScheduledEvent(int duration) {
		this.duration = duration;
		this.timeOfOccurance = 0;
		this.startTime = null;
	}
	
	/*public ScheduledEvent(BaseEvent event, int duration) {
		this.event = event;
		this.duration = duration;
		this.currentTime = 0;
	}
	
	public BaseEvent getEvent() {
		return event;
	}*/
	
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
	
	@Override
	public int compareTo(ScheduledEvent e) {
		return Integer.compare(this.getPriority(), e.getPriority());
	}

	@Override
	public abstract void execute(Simulation simulation);
	
	public void initialize() {
		this.startTime = Calendar.getInstance().getTime();
	}

}
