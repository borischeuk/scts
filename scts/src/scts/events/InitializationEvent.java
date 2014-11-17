package scts.events;

import scts.domain.ContainerStack;
import scts.domain.Crane;
import scts.domain.Lane;
import scts.domain.SSTransferPt;
import scts.domain.Ship;
import scts.domain.YardVehicle;
import scts.simulations.ConfigValues;
import scts.simulations.SimulationState;
import scts.simulations.UnloadingSimulation;
import simulation.event.ScheduledEvent;
import simulation.simulation.Simulation;
import simulation.utils.RandomFactory;

/**
 * 
 * This is the first event needed to be scheduled in order to initialize the simulation.
 *
 */
public class InitializationEvent extends ScheduledEvent {

	public InitializationEvent(int duration) {
		super(duration);
	}

	public void execute(Simulation simulation) {
		SimulationState state = ((UnloadingSimulation)simulation).getState();
		ConfigValues configValues = ((UnloadingSimulation)simulation).getConfigValues();

		Ship ship = new Ship();
		int minNum = configValues.getMinContainers();
		int maxNum = configValues.getMaxContainers();
		ship.setNoOfContainer(RandomFactory.randInt(minNum, maxNum));
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
