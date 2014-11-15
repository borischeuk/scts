package simulation.event;

import java.sql.Time;
import java.lang.Comparable;

import simulation.simulation.Simulation;

public interface BaseEvent{

	public void execute(Simulation simulation);
	
}
