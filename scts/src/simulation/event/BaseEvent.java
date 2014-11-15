package simulation.event;

import java.sql.Time;
import java.lang.Comparable;

import simulation.simulation.Simulation;

public abstract class BaseEvent{

	public abstract void execute(Simulation simulation);
	
}
