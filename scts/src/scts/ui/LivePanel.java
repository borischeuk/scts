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
import javax.swing.Timer;

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
	
	private LivePanel instance;
	private Thread thread;
	private Timer timer;
	
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
	private JLabel QCStatus;
	private JLabel laneStatus;
	private JLabel seasideStatus;
	private JLabel landsideStatus;
	private ConfigValues values;
	private int x;
	private int y;
	
	public LivePanel(Simulation simulation) {
		//super();
		
		x = 100;
		y = 100;
		
		if(instance == null)
			instance = this;
		
		thread = new Thread(new Runnable() {

			@Override
			public void run() {
				while(true) {
					try {
						thread.sleep(2000);
					} catch (InterruptedException e) {
					}
					update();
				}
			}
			
		});
		
		timer = new Timer(2000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				update();
			}
			
		});
		
		this.simulation = simulation;
		this.state = ((UnloadingSimulation)simulation).getState();
		
		values = new ConfigValues();
		
		numShipWaiting = new JLabel("Number of ships waiting: " + values.getNumShipsWaiting());
		numShipWaiting.setBounds(10, 100, numShipWaiting.getPreferredSize().width, numShipWaiting.getPreferredSize().height);
		
		numQC = new JLabel("Number of Quay Cranes: " + values.getNumQC());
		numQC.setBounds(10, 180, numQC.getPreferredSize().width, numQC.getPreferredSize().height);
		
		numYV = new JLabel("Number of Yard Vehicles: " + values.getNumYV());
		numYV.setBounds(10, 350, numYV.getPreferredSize().width, numYV.getPreferredSize().height);
		
		QCStatus = new JLabel("Quay Crane Status: ");
		QCStatus.setBounds(450, 100, QCStatus.getPreferredSize().width, QCStatus.getPreferredSize().height);
		
		laneStatus = new JLabel("Lane Status: ");
		laneStatus.setBounds(450, 200, laneStatus.getPreferredSize().width, laneStatus.getPreferredSize().height);
		
		seasideStatus = new JLabel("Seaside Trnasfer Point Status: ");
		seasideStatus.setBounds(500, 370, seasideStatus.getPreferredSize().width, seasideStatus.getPreferredSize().height);
		
		landsideStatus = new JLabel("Landside Transfer Point Status: ");
		landsideStatus.setBounds(500, 500, landsideStatus.getPreferredSize().width, landsideStatus.getPreferredSize().height);
		
		this.setLayout(null);
		this.add(numShipWaiting);
		this.add(numQC);
		this.add(numYV);
		this.add(QCStatus);
		this.add(laneStatus);
		this.add(seasideStatus);
		this.add(landsideStatus);
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
				ship.move();
				yardVehicle.moveRight();
				repaint();
			}
		});
		
	}
	
	public LivePanel getInstance() {
		return instance;
	}
	
	//Get information of the simulation and update the ui
	public void update() {
		//The ship in the berth
		Ship shipInBerth = new Ship();
		if(!state.getShipQueue().isEmpty())
			shipInBerth = state.getShipQueue().peek();
		//The crane used in this simulation
		Crane crane = new Crane();
		if(!state.getQCArray().isEmpty())
			crane = state.getQCArray().get(0);
		//The vehicle in different positions
		/*YardVehicle laneVehicle = state.getVehicleAtLane();
		YardVehicle tPtVehicle = state.getVehicleAtTPt();
		YardVehicle vehicleToStack = state.getVehicleToStackQueue().get(0);
		YardVehicle vehicleToQuay = state.getVehicleToQuayQueue().get(0);*/
		//The stack used in this simulation
		
		ContainerStack containerStack;
		if(!state.getStackArray().isEmpty())
			containerStack = state.getStackArray().get(0);
		
		ship.move();
		
		System.out.println("==============Test===========");
		
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
		
		numShipWaiting.setText("Number of ships waiting: " + state.getShipQueue().size());
		numQC.setText("Number of Quay Cranes: " + state.getQCArray().size());
		String qcStatus = "";
		if(crane.getStatus() == Crane.IDLE) qcStatus = "IDLE";
		else if(crane.getStatus() == Crane.LOADING) qcStatus = "Loading";
		else if(crane.getStatus() == Crane.OCCUPIED) qcStatus = "Occupied";
		else qcStatus = "Unloading";
		QCStatus.setText("Quay Crane Status: " + qcStatus);
		
		revalidate();
		repaint();
		
	}
	
	/*public void update() {
		
		System.out.println("========Test=========");
		
		JLabel testLabel = new JLabel("Test Test Test");
		testLabel.setLocation(new Point(x+10, y+10));
		
		//this.invalidate();
		//this.paint(this.getGraphics());
		repaint(1000);
	}*/
	
	public void threadUpdate() {
		thread.start();
	}
	
	public void timerUpdate() {
		timer.start();
	}
}
