package simulation;

import java.lang.Comparable;
import java.util.Date;

public class ScheduledEvent implements Comparable<ScheduledEvent>{
	
	private Date startTime;
	private int currentTime;
	private int duration;
	private BaseEvent event;
	
	public ScheduledEvent(BaseEvent event, int duration) {
		this.event = event;
		this.duration = duration;
		this.currentTime = 0;
	}
	
	public BaseEvent getEvent() {
		return event;
	}
	
	public Date getStartTime() {
		return startTime;
	}
	
	public int currentTime() {
		return currentTime;
	}
	
	public int getDuration() {
		return duration;
	}
	
	public int getPriority() {
		return duration;
	}
	
	@Override
	public int compareTo(ScheduledEvent e) {
		return Integer.compare(this.getPriority(), e.getPriority());
	}

}
