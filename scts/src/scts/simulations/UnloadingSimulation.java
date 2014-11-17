package scts.simulations;

import java.util.ArrayDeque;
import java.util.Calendar;
import java.util.Date;

import scts.domain.ContainerStack;
import scts.domain.Crane;
import scts.domain.Lane;
import scts.domain.SSTransferPt;
import scts.domain.Ship;
import scts.domain.YardVehicle;
import scts.events.ShipDockEvent;
import scts.events.InitializationEvent;
import scts.events.ShipUndockEvent;
import scts.events.YCLoadEvent;
import scts.events.YCUnloadEvent;
import scts.events.YVPickEvent;
import scts.events.ShipGeneration;
import scts.events.QCLoadEvent;
import scts.events.YVUnloadEvent;
import scts.ui.LivePanel;
import simulation.event.ScheduledEvent;
import simulation.simulation.Simulation;
import simulation.utils.RandomFactory;

/**
 * 
 * This class is about the operation of the terminal simulation.
 *
 */
public class UnloadingSimulation extends Simulation{
	
	//List of status
	public static final int RUNNING = 0;
	public static final int STOP = 2;
	public static final int PAUSE = 3;
	
	private static UnloadingSimulation instance;
	private static SimulationState state;
	private int status;
	private Stats stats;
	private ConfigValues configValues;
	private int simulationSpeed;
	
	public UnloadingSimulation() {
		super();
		
		if(instance == null)
			instance = this;
		
		state = new SimulationState();
		status = STOP;
		configValues = new ConfigValues();
		simulationSpeed = configValues.getSimulationSpeed();
		stats = new Stats();

		this.schedule(new InitializationEvent(0));
		
	}
	
	@Override
	public void run() {
		
		ScheduledEvent currentEvent;
		
		while(!scheduleQueue.isEmpty() && !stop) {
			
			currentEvent = scheduleQueue.poll();
			currentEvent.execute(this);
			
			if(checkStop()) {
				this.stop();
				this.setStatus(STOP);
				continue;
			}
			
			//Flow of the terminal operation
			if(state.getShipQueue().isEmpty() && this.stop == false)
				this.schedule(new ShipGeneration(0));
			else {
				
				//Ship Docking
				if(state.getShipQueue().peek().getStatus() == Ship.WAITING) {
					int minTime = configValues.getDockMinTime();
					int maxTime = configValues.getDockMaxTime();
					long duration = RandomFactory.randSimTimeInMilliSec(minTime, maxTime, simulationSpeed);
					this.schedule( new ShipDockEvent(state.getShipQueue().peek(), duration) );
				}
				
				//Operation of quay crane
				if(state.getShipQueue().peek().getStatus() == Ship.DOCKED) {
					for(Crane crane : state.getQCArray()) {
						if(crane.getStatus() == Crane.IDLE && state.getShipQueue().peek().getNoOfContainer() > 0) {
							int minTime = configValues.getqcRemoveMinTime();
							int maxTime = configValues.getqcRemoveMaxTime();
							long duration = RandomFactory.randSimTimeInMilliSec(minTime, maxTime, simulationSpeed);
							crane.setStatus(Crane.LOADING);
							this.schedule(new QCLoadEvent(state.getShipQueue().peek(), crane, duration));
						}
					}
				}
				
				//Operation of yard vehicles
				for(Lane lane : state.getlaneArray()) {
					if (!state.getVehicleQuayQueue().isEmpty()) {
					
						if(lane.getStatus() == Lane.OCCUPIED && state.getVehicleAtLane() == null) {
							YardVehicle vehiclePolled = state.getVehicleQuayQueue().poll();
							lane.setStatus(Lane.LOADING);
							
							int minTime = configValues.getyvPickMinTime();
							int maxTime = configValues.getyvPickMaxTime();
							long duration = RandomFactory.randSimTimeInMilliSec(minTime, maxTime, simulationSpeed);
							this.schedule(new YVPickEvent(lane, vehiclePolled, duration));
						}
					
					}
				}
				
				//Operation of sea side transfer point
				for(ContainerStack containerStack : state.getStackArray()) {
					if( (!state.getVehicleStackQueue().isEmpty()) && (containerStack.getTransferPt().getStatus() == SSTransferPt.FREE)) {
						containerStack.getTransferPt().setStatus(SSTransferPt.LOADING);
						YardVehicle vehiclePolled = state.getVehicleStackQueue().poll();
						
						int minTime = configValues.getyvDropMinTime();
						int maxTime = configValues.getyvDropMaxTime();
						long duration = RandomFactory.randSimTimeInMilliSec(minTime, maxTime, simulationSpeed);
						this.schedule(new YVUnloadEvent(vehiclePolled, containerStack.getTransferPt(), duration));
					}
				}
				
				//Operation of yard crane
				for(ContainerStack containerStack : state.getStackArray()) {
					if(containerStack.getTransferPt().getStatus() == SSTransferPt.OCCUPIED && containerStack.getYardCrane().getStatus() == Crane.IDLE) {
						containerStack.getTransferPt().setStatus(SSTransferPt.UNLOADING);
						
						int minTime = configValues.getqcRemoveMinTime();
						int maxTime = configValues.getqcRemoveMaxTime();
						long duration = RandomFactory.randSimTimeInMilliSec(minTime, maxTime, simulationSpeed);
						this.schedule(new YCLoadEvent(containerStack, duration));
					} else if (containerStack.getYardCrane().getStatus() == Crane.OCCUPIED) {
						containerStack.getYardCrane().setStatus(Crane.SETTINGDOWN);
						
						int minTime = configValues.getqcPlaceMinTime();
						int maxTime = configValues.getqcPlaceMaxTime();
						long duration = RandomFactory.randSimTimeInMilliSec(minTime, maxTime, simulationSpeed);
						this.schedule(new YCUnloadEvent(containerStack, duration));
					}
				}
				
				//Ship undocks
				Ship ship = this.getState().getShipQueue().peek();
				if(ship.getNoOfContainer() == 0 && ship.getStatus() == Ship.DOCKED) {
					ship.setStatus(Ship.UNDOCKING);
					
					int minTime = configValues.getUndockMinTime();
					int maxTime = configValues.getUndockMaxTime();
					long duration = RandomFactory.randSimTimeInMilliSec(minTime, maxTime, simulationSpeed);
					this.schedule(new ShipUndockEvent(ship, duration));
				}
				
			}
			
			this.adjustSimulationTime();
			stats.update();
			
		}
		
	}
	
	@Override
	public void stop() {
		super.stop();
	}
	
	public void resume() {
		this.stop = false;
		this.run();
	}
	
	public void update() {
		new LivePanel(this).getInstance().startTimer();
	}
	
	public void initialize() {
		this.stop = false;
		this.scheduleQueue.clear();
		this.state = new SimulationState();
		this.status = STOP;
		this.currentTime = 0;
		this.configValues = new ConfigValues();
		this.startTime = Calendar.getInstance().getTime();
		this.stats = new Stats();
		simulationSpeed = configValues.getSimulationSpeed();
		this.schedule(new InitializationEvent(0));
	}
	
	//This function adjusts the current time of the simulation.
	public void adjustSimulationTime() {
		Date currentDate = Calendar.getInstance().getTime();
		long timeDiff = currentDate.getTime() - this.getStartTime().getTime();
		this.currentTime = timeDiff * simulationSpeed;
	}
	
	//This function checks whether the simulations have to stop.
	public boolean checkStop() {
		if(this.getState().getShipQueue().isEmpty() && this.stop == false)
			return true;
		return false;
	}
	
	
	//Getters and Setters
	
	public static UnloadingSimulation getInstance() {
		return instance;
	}
	
	public SimulationState getState() {
		return this.state;
	}
	
	public int getStatus() {
		return this.status;
	}
	
	public ConfigValues getConfigValues() {
		return configValues;
	}
	
	public Stats getStats() {
		return stats;
	}
	
	public ArrayDeque<ScheduledEvent> getScheduleQueue() {
		return this.scheduleQueue;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
	
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	
}
