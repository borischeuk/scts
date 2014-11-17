package scts.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import scts.domain.Ship;
import scts.domain.YardVehicle;
import scts.simulations.SimulationState;
import scts.simulations.UnloadingSimulation;
import scts.ui.view.QuayCraneView;
import scts.ui.view.ShipView;
import scts.ui.view.StackView;
import scts.ui.view.YardVehicleView;
import simulation.simulation.Simulation;

public class LivePanel extends JPanel{
	
	private static LivePanel instance;
	
	private Simulation simulation;
	private SimulationState state;
	private Timer timer;
	
	private ShipView shipView;
	private QuayCraneView craneView;
	private StackView stackView;
	private YardVehicleView yardVehicleView;
	private String numShipWait;
	private String numShipContainer;
	private String numStackContainer;
	private String QCStatus;
	private String laneStatus;
	private String SSTransferPtStatus;
	private String clock;

	public LivePanel(Simulation simulation) {
		if(instance == null)
			instance = this;
		this.simulation = simulation;
		this.state = ((UnloadingSimulation)simulation).getState();
		//System.out.println("2 State ============== " + state);
		//System.out.println("2 Get State ============== " + ((UnloadingSimulation)simulation).getState());
		timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				update(LivePanel.getInstance().getGraphics());
				paint(LivePanel.getInstance().getGraphics());
			}
			
		});
		
		shipView = new ShipView();
		craneView = new QuayCraneView();
		stackView = new StackView();
		yardVehicleView = new YardVehicleView();
		numShipWait = new String("Number of ships wait: ");
		numShipContainer = new String("Number of containers on ship: ");
		numStackContainer = new String("Number of containers in stack: ");
		QCStatus = new String("Status of quay crane: ");
		laneStatus = new String("Status of lane: ");
		SSTransferPtStatus = new String("Status of Seaside Transfer Point: ");
		clock = new String("00:00");
		
		this.setBackground(Color.WHITE);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(shipView.getImage(), shipView.getX(), shipView.getY(), null);
		g.drawImage(craneView.getImage(), craneView.getX(), craneView.getY(), null);
		g.drawImage(stackView.getImage(), stackView.getX(), stackView.getY(), null);
		g.drawImage(yardVehicleView.getImage(), yardVehicleView.getX(), yardVehicleView.getY(), null);
		g.drawString(numShipWait, 10, 525);
		g.drawString(numShipContainer, 10, 540);
		g.drawString(numStackContainer, 10, 555);
		g.drawString(QCStatus, 10, 570);
		g.drawString(laneStatus, 10, 585);
		g.drawString(SSTransferPtStatus, 10, 600);
		
		g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
		g.drawString(clock, 750, 600);
		
		if(((UnloadingSimulation)simulation).getStatus() == UnloadingSimulation.RUNNING) {
			//System.out.println("Running");
			shipMove();
			vehicleMove();
			numShipWait = "Number of ships wait: " + (state.getShipQueue().size() - 1);
			if(state.getShipQueue().peek() != null) {
				numShipContainer = "Number of containers on ship: " + state.getShipQueue().peek().getNoOfContainer();
			} else {
				numShipContainer = "Number of containers on ship: " + 0;
			}
			numStackContainer = "Number of containers in stack: " + state.getStackArray().get(0).getNoOfContainer();
			QCStatus = "Status of quay crane: " + state.getQCArray().get(0).getStatus();
			laneStatus = "Status of lane: " + state.getlaneArray().get(0).getStatus();
			SSTransferPtStatus = "Status of seaside transfer point: " + state.getStackArray().get(0).getTransferPt().getStatus();
			clock = calSimTime();
		}
	}
	
	public void initialize() {
		this.state = UnloadingSimulation.getInstance().getState();
	}
	
	public void startTimer() {
		timer.start();
	}
	
	public void stopTimer() {
		timer.stop();
	}
	
	private String calSimTime() {
		long currentTime = simulation.getCurrentTime();
		long mins = currentTime / 1000/ 60;
		long sec = (currentTime /1000) % 60;
		return "" + mins + ":" + sec;
	}
	
	private void shipMove() {
		//System.out.println("State address ================ " + state);
		Ship shipInBerth = null;
		if(!state.getShipQueue().isEmpty()) {
			//System.out.println("Ship Move");
			shipInBerth = state.getShipQueue().peek();
		}
		if(shipInBerth != null) {
			
			Point shipInitPos = new Point(10, 10);
			Point shipDockPos = new Point((this.getSize().width/4), 10);
			//Point shipWaitPos = new Point((this.getSize().width/2), 10);
			Point shipWaitPos = new Point(340, 10);
			Point shipUndockPos = new Point((this.getSize().width/4)*3, 10);
			Point shipLastPos = new Point((this.getSize().width), 10);
			Point newPos = shipInitPos;
			
			//System.out.println("Ship Status ================ " + shipInBerth.getStatus());
			int currentX = shipView.getX();
			int currentY = shipView.getY();
			if(shipInBerth.getStatus() == Ship.DOCKING) {
				if(currentX == shipInitPos.x && currentY == shipInitPos.y) newPos = shipDockPos;
				else if(currentX == shipDockPos.x && currentY == shipDockPos.y) newPos = shipWaitPos;
				else if(currentX == shipWaitPos.x && currentY == shipWaitPos.y) newPos = shipInitPos;
			} else if(shipInBerth.getStatus() == Ship.UNDOCKING) {
				if(currentX == shipWaitPos.x && currentY == shipWaitPos.y) newPos = shipUndockPos;
				else if(currentX == shipUndockPos.x && currentY == shipUndockPos.y) newPos = shipLastPos;
				else if(currentX == shipLastPos.x && currentY == shipLastPos.y) newPos = shipWaitPos;
			} else {
				newPos = shipWaitPos;
			}
			
			shipView.setPosition(newPos.x, newPos.y);
		}
	}
	
	private void vehicleMove() {
		Point vehicleQuayPos = new Point(410, 140);
		Point vehicleMidPos = new Point(410, 240);
		Point vehicleStackPos = new Point(410, 340);
		Point newPos = vehicleQuayPos;
		
		YardVehicle yardVehicle = null;
		if(state.getVehicleAtLane() != null) {
			yardVehicle = state.getVehicleAtLane();
			if(yardVehicle != null) newPos = vehicleQuayPos;
		}
		else if(state.getVehicleAtTPt() != null) {
			yardVehicle = state.getVehicleAtTPt();
			if(yardVehicle != null) newPos = vehicleStackPos;
		}
		else if(state.getVehicleToQuayQueue() != null) {
			if (!state.getVehicleToQuayQueue().isEmpty()) {
				System.out.println("null null null");
				yardVehicle = state.getVehicleToQuayQueue().get(0);
				if(yardVehicle != null) {
					int currentX = yardVehicleView.getX();
					int currentY = yardVehicleView.getY();
					if(currentX == vehicleStackPos.x && currentY == vehicleStackPos.y) newPos = vehicleMidPos;
					else if(currentX == vehicleMidPos.x && currentY == vehicleMidPos.y) newPos = vehicleQuayPos;
					else if(currentX == vehicleQuayPos.x && currentY == vehicleQuayPos.y) newPos = vehicleStackPos;
				}
			}
		}
		else if(!state.getVehicleToStackQueue().isEmpty()) {
			yardVehicle = state.getVehicleToStackQueue().get(0);
			if(yardVehicle != null) {
				int currentX = yardVehicleView.getX();
				int currentY = yardVehicleView.getY();
				if(currentX == vehicleQuayPos.x && currentY == vehicleQuayPos.y) newPos = vehicleMidPos;
				else if(currentX == vehicleMidPos.x && currentY == vehicleMidPos.y) newPos = vehicleStackPos;
				else if(currentX == vehicleStackPos.x && currentY == vehicleStackPos.y) newPos = vehicleQuayPos;
			}
		}
		
		yardVehicleView.setPosition(newPos.x, newPos.y);
	}

	public static LivePanel getInstance() {
		return instance;
	}
	
}
