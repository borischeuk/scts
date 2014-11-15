package scts.simulations;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.PriorityQueue;
import java.util.Queue;

import scts.domain.ContainerStack;
import scts.domain.Crane;
import scts.domain.Lane;
import scts.domain.SSTransferPt;
import scts.domain.Ship;
import scts.domain.YardVehicle;
import scts.events.ShipDockEvent;
import scts.events.EventType;
import scts.events.InitializationEvent;
import scts.events.ShipUndockEvent;
import scts.events.YCLoadEvent;
import scts.events.YCUnloadEvent;
import scts.events.YVPickEvent;
import scts.events.ShipGeneration;
import scts.events.StopEvent;
import scts.events.QCLoadEvent;
import scts.events.QCWaitEvent;
import scts.events.YVUnloadEvent;
import scts.events.eventHandler.DockingHandler;
import simulation.event.EventHandler;
import simulation.event.ScheduledEvent;
import simulation.simulation.Simulation;

public class UnloadingSimulation extends Simulation{
	
	public static final int RUNNING = 0;
	public static final int STOP = 2;
	public static final int PAUSE = 3;
	
	private UnloadingSimulation instance;
	private static SimulationState state;
	private int status;
	
	public UnloadingSimulation() {
		super();
		state = new SimulationState();
		if(instance == null)
			instance = this;
		status = STOP;
		
		//this.schedule( new ScheduledEvent(new ShipGeneration(), 0) );
		this.schedule(new InitializationEvent(0));
		
	}
	
	@Override
	public void run() {
		
		ScheduledEvent currentEvent;
		
		while(!scheduleQueue.isEmpty() && !stop) {
			
			System.out.println("Global start time ==================== " + this.startTime);
			System.out.println("Simulation address ===================== " + this);
			System.out.println("Event Queue Size =============== " + scheduleQueue.size());
			
			currentEvent = scheduleQueue.poll();
			currentEvent.execute(this);
			
			if(checkStop()) {
				this.stop();
				continue;
			}
			
			//Flow of the terminal operation
			if(state.getShipQueue().isEmpty() && this.stop == false)
				this.schedule(new ShipGeneration(0));
			else {
				
				//Ship Docking
				if(state.getShipQueue().peek().getStatus() == Ship.WAITING) {
					this.schedule( new ShipDockEvent(state.getShipQueue().peek(), 3) );
				}
				
				//Operation of quay crane
				if(state.getShipQueue().peek().getStatus() == Ship.DOCKED) {
					for(Crane crane : state.getQCArray()) {
						if(crane.getStatus() == Crane.IDLE && state.getShipQueue().peek().getNoOfContainer() > 0) {
							crane.setStatus(Crane.LOADING);
							this.schedule(new QCLoadEvent(state.getShipQueue().peek(), crane, 3));
						}
					}
				}
				
				//Operation of yard vehicles
				for(Lane lane : state.getlaneArray()) {
					System.out.println("Quay queue size ====================== " + state.getVehicleQuayQueue().size());
					System.out.println("Number of Container ================ " + state.getShipQueue().peek().getNoOfContainer());
					if (!state.getVehicleQuayQueue().isEmpty()) {
					
						if(lane.getStatus() == Lane.OCCUPIED && state.getVehicleAtLane() == null) {
							YardVehicle vehiclePolled = state.getVehicleQuayQueue().poll();
							lane.setStatus(Lane.LOADING);
							System.out.println("vehicle at quay ================= " + state.getVehicleAtLane());
							this.schedule(new YVPickEvent(lane, vehiclePolled, 3));
						}
					
					}
				}
				
				//Operation of sea side transfer point
				for(ContainerStack containerStack : state.getStackArray()) {
					System.out.println("Stack Queue size ======================== " + state.getVehicleStackQueue().size());
					System.out.println("Transfer Point Status ========================= " + containerStack.getTransferPt().getStatus());
					if( (!state.getVehicleStackQueue().isEmpty()) && (containerStack.getTransferPt().getStatus() == SSTransferPt.FREE)) {
						System.out.println("============Waiting at Stack============");
						containerStack.getTransferPt().setStatus(SSTransferPt.LOADING);
						YardVehicle vehiclePolled = state.getVehicleStackQueue().poll();
						this.schedule(new YVUnloadEvent(vehiclePolled, containerStack.getTransferPt(), 3));
					}
				}
				
				//Operation of yard crane
				for(ContainerStack containerStack : state.getStackArray()) {
					if(containerStack.getTransferPt().getStatus() == SSTransferPt.OCCUPIED && containerStack.getYardCrane().getStatus() == Crane.IDLE) {
						containerStack.getTransferPt().setStatus(SSTransferPt.UNLOADING);
						this.schedule(new YCLoadEvent(containerStack, 3));
					} else if (containerStack.getYardCrane().getStatus() == Crane.OCCUPIED) {
						//containerStack.getYardCrane().setStatus(Crane.IDLE);
						containerStack.getYardCrane().setStatus(Crane.SETTINGDOWN);
						this.schedule(new YCUnloadEvent(containerStack, 3));
					}
				}
				
				//Ship undocks
				Ship ship = this.getState().getShipQueue().peek();
				if(ship.getNoOfContainer() == 0 && ship.getStatus() == Ship.DOCKED) {
					ship.setStatus(Ship.UNDOCKING);
					this.schedule(new ShipUndockEvent(ship, 3));
				}
				
			}
			
			this.adjustSimulationTime();
			
		}
		
	}
	
	public SimulationState getState() {
		return state;
	}
	
	public void adjustSimulationTime() {
		Date currentDate = Calendar.getInstance().getTime();
		long timeDiff = ( currentDate.getTime() - this.getStartTime().getTime() ) / 1000;
		this.currentTime = timeDiff;
	}
	
	public UnloadingSimulation getInstance() {
		return instance;
	}
	
	public boolean checkStop() {
		if(this.getState().getShipQueue().isEmpty() && this.stop == false)
			return true;
		return false;
	}
	
	public int getStatus() {
		return this.status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
	
	public void initialize() {
		this.stop = false;
		this.scheduleQueue.clear();
		this.state = new SimulationState();
		this.status = STOP;
		this.schedule(new InitializationEvent(0));
	}
	
	public void resume() {
		this.stop = false;
		this.run();
	}
	
}
