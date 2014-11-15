package scts.events;

import java.util.ArrayDeque;
import java.util.ArrayList;

import scts.domain.ContainerStack;
import scts.domain.Crane;
import scts.domain.Lane;
import scts.domain.SSTransferPt;
import scts.domain.Ship;
import scts.domain.YardVehicle;
import scts.simulations.SimulationState;
import scts.simulations.UnloadingSimulation;
import simulation.event.ScheduledEvent;
import simulation.simulation.Simulation;

public class InitializationEvent extends ScheduledEvent {

	public InitializationEvent(int duration) {
		super(duration);
	}

	public void execute(Simulation simulation) {
		SimulationState state = ((UnloadingSimulation)simulation).getState();
		
		Ship ship = new Ship();
		ship.setNoOfContainer(10);
		state.getShipQueue().add(ship);
		
		Crane quayCrane = new Crane();
		state.getQCArray().add(quayCrane);
		
		Crane yardCrane = new Crane();
		state.getYCArray().add(yardCrane);
		
		Lane lane = new Lane();
		state.getlaneArray().add(lane);
		
		YardVehicle vehicle = new YardVehicle();
		state.getVehicleQuayQueue().add(vehicle);
		
		ContainerStack containerStack = new ContainerStack();
		containerStack.setYardCrane(yardCrane);
		containerStack.setTransferPt(new SSTransferPt());
		state.getStackArray().add(containerStack);
	}
}
