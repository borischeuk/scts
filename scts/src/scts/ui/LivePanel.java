package scts.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import scts.domain.ConfigValues;
import scts.domain.ContainerStack;
import scts.domain.Crane;
import scts.domain.Ship;
import scts.domain.Stats;
import scts.domain.YardVehicle;
import scts.simulations.UnloadingSimulation;
import scts.simulations.SimulationState;
import scts.ui.view.*;
import simulation.simulation.Simulation;

public class LivePanel extends JPanel {
	
	LivePanel instance;
	
	private Simulation simulation;
	private SimulationState state;
	
	private YardVehicleView yardVehicle = new YardVehicleView();
	private ShipView ship = new ShipView();
	private QuayCraneView quayCrane = new QuayCraneView();
	private StackView stack = new StackView();
	private TruckView truck = new TruckView();
	private JLabel numShipWaiting;
	private JLabel numYV;
	private JLabel numQC;
	private JLabel laneContainers;
	private ConfigValues values;
	
	public LivePanel(Simulation simulation) {
		//super();
		
		this.simulation = simulation;
		this.state = ((UnloadingSimulation)simulation).getState();
		
		values = new ConfigValues();
		
		numShipWaiting = new JLabel("Number of ships waiting: " + values.getNumShipsWaiting());
		numShipWaiting.setBounds(10, 100, numShipWaiting.getPreferredSize().width, numShipWaiting.getPreferredSize().height);
		
		numQC = new JLabel("Number of Quay Cranes: " + values.getNumQC());
		numQC.setBounds(10, 180, numQC.getPreferredSize().width, numQC.getPreferredSize().height);
		
		numYV = new JLabel("Number of Yard Vehicles: " + values.getNumYV());
		numYV.setBounds(10, 350, numYV.getPreferredSize().width, numYV.getPreferredSize().height);
		
		laneContainers = new JLabel("0");
		laneContainers.setBounds(300, 200, laneContainers.getPreferredSize().width, laneContainers.getPreferredSize().height);
		
		this.setLayout(null);
		this.add(numShipWaiting);
		this.add(numQC);
		this.add(numYV);
		this.add(laneContainers);
		this.add(quayCrane);
		this.add(yardVehicle);
		this.add(ship);
		this.add(stack);
		this.add(truck);
		this.validate();
		this.setVisible(true);
		
		JButton b1 = new JButton("Move");
		this.add(b1);
        Dimension size = b1.getPreferredSize();
        b1.setBounds(25, 25,
                     size.width, size.height);
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				yardVehicle.moveRight();
				repaint();
			}
		});
		
	}
	
	//Get information of the simulation and update the ui
	public void update() {
		//The ship in the berth
		Ship shipInBerth = state.getShipQueue().peek();
		//The crane used in this simulation
		Crane crane = state.getQCArray().get(0);
		//The vehicle in different positions
		YardVehicle laneVehicle = state.getVehicleAtLane();
		YardVehicle tPtVehicle = state.getVehicleAtTPt();
		YardVehicle vehicleToStack = state.getVehicleToStackQueue().get(0);
		YardVehicle vehicleToQuay = state.getVehicleToQuayQueue().get(0);
		//The stack used in this simulation
		ContainerStack containerStack = state.getStackArray().get(0);
		
		Point shipInitPos = new Point(10, 10);
		Point shipDockPos = new Point((this.getSize().width/4), 10);
		Point shipWaitPos = new Point((this.getSize().width/2), 10);
		Point shipUndockPos = new Point((this.getSize().width/4)*3, 10);
		Point shipLastPos = new Point((this.getSize().width), 10);
		
		if(shipInBerth.getStatus() == Ship.DOCKING) {
			Point newPos = new Point();
			if(ship.getLocation().equals(shipInitPos)) newPos = shipDockPos;
			if(ship.getLocation().equals(shipDockPos)) newPos = shipWaitPos;
			if(ship.getLocation().equals(shipWaitPos)) newPos = shipInitPos;
			ship.move(newPos.x, newPos.y);
		} else if (shipInBerth.getStatus() == Ship.UNDOCKING) {
			Point newPos = new Point();
			if(ship.getLocation().equals(shipWaitPos)) newPos = shipUndockPos;
			if(ship.getLocation().equals(shipUndockPos)) newPos = shipLastPos;
			if(ship.getLocation().equals(shipLastPos)) newPos = shipWaitPos;
			ship.move(newPos.x, newPos.y);
		} else {
			ship.move(shipWaitPos.x, shipWaitPos.y);
		}
		
		Point vehicleInitPos = new Point(10, 10);
		Point vehicleToStackPos = new Point((this.getSize().width/4), 10);
		Point vehicleMidPos = new Point((this.getSize().width/2), 10);
		Point vehicleToQuayPos = new Point((this.getSize().width/4)*3, 10);
		Point vehicleLastPos = new Point((this.getSize().width), 10);
		
		repaint();
	}
	
}
