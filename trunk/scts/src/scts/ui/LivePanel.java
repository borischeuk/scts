package scts.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import scts.domain.ConfigValues;
import scts.domain.Stats;
import scts.ui.view.*;

public class LivePanel extends JPanel {
	
	
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
	
	public LivePanel() {
		//super();
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
				ship.move();
				yardVehicle.moveRight();
				repaint();
			}
		});
		
	}
	
	
	
}
