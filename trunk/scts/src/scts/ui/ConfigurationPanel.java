package scts.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import scts.simulations.ConfigValues;
import simulation.utils.Configuration;

public class ConfigurationPanel{
	
	private JLabel title;
	private JButton defaultBtn;
	private JButton startBtn;
	private JLabel simulationSpeedLabel;
	private JLabel dockTime;
	private JLabel undockTime;
	private JLabel qcRemoveTime;
	private JLabel qcPlaceTime;
	private JLabel yvPickTime;
	private JLabel yvDropTime;
	private JLabel yvTravelToSeaSideTime;
	private JLabel yvTravelToQATime;
	private JLabel containers;
	private JLabel stackSize;
	private JLabel initialStackSizeLabel;
	private JLabel numQCLabel;
	private JLabel numYVLabel;
	private JLabel timeLimitLabel;
	private JLabel numShipsWaitingLabel;
	private JTextField simulationSpeed;
	private JTextField dockMinTime;
	private JTextField dockMaxTime;
	private JTextField undockMinTime;
	private JTextField undockMaxTime;
	private JTextField qcRemoveMinTime;
	private JTextField qcRemoveMaxTime;
	private JTextField qcPlaceMinTime;
	private JTextField qcPlaceMaxTime;
	private JTextField yvPickMinTime;
	private JTextField yvPickMaxTime;
	private JTextField yvDropMinTime;
	private JTextField yvDropMaxTime;
	private JTextField yvTravelToSeaSideMinTime;
	private JTextField yvTravelToSeaSideMaxTime;
	private JTextField yvTravelToQAMinTime;
	private JTextField yvTravelToQAMaxTime;
	private JTextField minContainers;
	private JTextField maxContainers;
	private JTextField maxStackSize;
	private JTextField initialStackSize;
	private JTextField numQC;
	private JTextField numYV;
	private JTextField timeLimit;
	private JTextField numShipsWaiting;
	private ConfigValues data;
	private Configuration configuration;
	private JFrame frame;
	
	public ConfigurationPanel() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setSize(600, 600);
		frame.setTitle("SCTS Configuration");
		frame.setLayout(new BorderLayout());
		
		// Separate Frame
		JPanel display = new JPanel();
		//display.setLayout(new FlowLayout());
		BoxLayout layout = new BoxLayout(display, BoxLayout.Y_AXIS);
		display.setLayout(layout);
		JPanel menu = new JPanel();
		menu.setLayout(new FlowLayout());
		
		// Panel "display"
		title = new JLabel("Simulation Settings");
		display.add(title);
		
		simulationSpeedLabel = new JLabel("Simulation Speed: ");
		simulationSpeed = new JTextField(5);
		JPanel simulationSpeedPanel = addLabelTextField(simulationSpeedLabel, simulationSpeed);
		display.add(simulationSpeedPanel);
		
		dockTime = new JLabel("Durations for ship to dock (mins): ");
		dockMinTime = new JTextField(5);
		dockMaxTime = new JTextField(5);
		JPanel dockTimePanel = addLabelTextField(dockTime, dockMinTime, dockMaxTime);
		display.add(dockTimePanel);
		
		undockTime = new JLabel("Durations for ship to undock (mins): ");
		undockMinTime = new JTextField(5);
		undockMaxTime = new JTextField(5);
		JPanel undockTimePanel = addLabelTextField(undockTime, undockMinTime, undockMaxTime);
		display.add(undockTimePanel);
		
		qcRemoveTime = new JLabel("Durations for Quay Crane to remove a container from a ship (mins): ");
		qcRemoveMinTime = new JTextField(5);
		qcRemoveMaxTime = new JTextField(5);
		JPanel qcRemoveTimePanel = addLabelTextField(qcRemoveTime, qcRemoveMinTime, qcRemoveMaxTime);
		display.add(qcRemoveTimePanel);
		
		qcPlaceTime = new JLabel("Durations for Quay Crane to place a container in the Quay Area (mins): ");
		qcPlaceMinTime = new JTextField(5);
		qcPlaceMaxTime = new JTextField(5);
		JPanel qcPlaceTimePanel = addLabelTextField(qcPlaceTime, qcPlaceMinTime, qcPlaceMaxTime);
		display.add(qcPlaceTimePanel);
		
		yvPickTime = new JLabel("Durations for Yard Vehicle to pick up a container (mins): ");
		yvPickMinTime = new JTextField(5);
		yvPickMaxTime = new JTextField(5);
		JPanel yvPickTimePanel = addLabelTextField(yvPickTime, yvPickMinTime, yvPickMaxTime);
		display.add(yvPickTimePanel);
		
		yvDropTime = new JLabel("Durations for Yard Vehicle to drop a container (mins): ");
		yvDropMinTime = new JTextField(5);
		yvDropMaxTime = new JTextField(5);
		JPanel yvDropTimePanel = addLabelTextField(yvDropTime, yvDropMinTime, yvDropMaxTime);
		display.add(yvDropTimePanel);
		
		yvTravelToSeaSideTime = new JLabel("Durations for Yard Vehicle to travel to the sea-side transfer point (mins): ");
		yvTravelToSeaSideMinTime = new JTextField(5);
		yvTravelToSeaSideMaxTime = new JTextField(5);
		JPanel yvTravelToSeaSideTimePanel = addLabelTextField(yvTravelToSeaSideTime, yvTravelToSeaSideMinTime, yvTravelToSeaSideMaxTime);
		display.add(yvTravelToSeaSideTimePanel);
		
		yvTravelToQATime = new JLabel("Durations for Yard Vehicle to travel to the Quay Area queue (mins): ");
		yvTravelToQAMinTime = new JTextField(5);
		yvTravelToQAMaxTime = new JTextField(5);
		JPanel yvTravelToQATimePanel = addLabelTextField(yvTravelToQATime, yvTravelToQAMinTime, yvTravelToQAMaxTime);
		display.add(yvTravelToQATimePanel);
		
		containers = new JLabel("Number of containers (TEU): ");
		minContainers = new JTextField(5);
		maxContainers = new JTextField(5);
		JPanel containersPanel = addLabelTextField(containers, minContainers, maxContainers);
		display.add(containersPanel);
		
		stackSize = new JLabel("Maximum allowable size of stack (TEU): ");
		maxStackSize = new JTextField(5);
		JPanel stackSizePanel = addLabelTextField(stackSize, maxStackSize);
		display.add(stackSizePanel);
		
		initialStackSizeLabel = new JLabel("Initial Stack Size (TEU): ");
		initialStackSize = new JTextField(5);
		JPanel initialStackSizePanel = addLabelTextField(initialStackSizeLabel, initialStackSize);
		display.add(initialStackSizePanel);
		
		numQCLabel = new JLabel("Number of Quay Cranes: ");
		numQC = new JTextField(5);
		JPanel numQCPanel = addLabelTextField(numQCLabel, numQC);
		display.add(numQCPanel);
		
		numYVLabel = new JLabel("Number of Yard Vehicles: ");
		numYV = new JTextField(5);
		JPanel numYVPanel = addLabelTextField(numYVLabel, numYV);
		display.add(numYVPanel);
		
		numShipsWaitingLabel = new JLabel("Initial number of Ships already waiting to be unloaded: ");
		numShipsWaiting = new JTextField(5);
		JPanel numShipsWaitingPanel = addLabelTextField(numShipsWaitingLabel, numShipsWaiting);
		display.add(numShipsWaitingPanel);
		
		timeLimitLabel = new JLabel("Simulated time limit for a run (days): ");
		timeLimit = new JTextField(5);
		JPanel timeLimitPanel = addLabelTextField(timeLimitLabel, timeLimit);
		display.add(timeLimitPanel);
		
		defaultBtn = new JButton("Default");
		menu.add(defaultBtn);
		startBtn = new JButton("OK");
		menu.add(startBtn);
		
		frame.add(display, BorderLayout.CENTER);
		frame.add(menu, BorderLayout.SOUTH);
		frame.setVisible(true);

		// SetValues
		configuration = new Configuration();
		data = configuration.getData();
		setValues(data);
		setListeners();
	}
	
	private void setValues(ConfigValues data) {
		simulationSpeed.setText(Integer.toString(data.getSimulationSpeed()));
		dockMinTime.setText(Integer.toString(data.getDockMinTime()));
		dockMaxTime.setText(Integer.toString(data.getDockMaxTime()));
		undockMinTime.setText(Integer.toString(data.getUndockMinTime()));
		undockMaxTime.setText(Integer.toString(data.getUndockMaxTime()));
		qcRemoveMinTime.setText(Integer.toString(data.getqcRemoveMinTime()));
		qcRemoveMaxTime.setText(Integer.toString(data.getqcRemoveMaxTime()));
		qcPlaceMinTime.setText(Integer.toString(data.getqcPlaceMinTime()));
		qcPlaceMaxTime.setText(Integer.toString(data.getqcPlaceMaxTime()));
		yvPickMinTime.setText(Integer.toString(data.getyvPickMinTime()));
		yvPickMaxTime.setText(Integer.toString(data.getyvPickMaxTime()));
		yvDropMinTime.setText(Integer.toString(data.getyvDropMinTime()));
		yvDropMaxTime.setText(Integer.toString(data.getyvDropMaxTime()));
		yvTravelToSeaSideMinTime.setText(Integer.toString(data.getyvTravelToSeaSideMinTime()));
		yvTravelToSeaSideMaxTime.setText(Integer.toString(data.getyvTravelToSeaSideMaxTime()));
		yvTravelToQAMinTime.setText(Integer.toString(data.getyvTravelToQAMinTime()));
		yvTravelToQAMaxTime.setText(Integer.toString(data.getyvTravelToQAMaxTime()));
		minContainers.setText(Integer.toString(data.getMinContainers()));
		maxContainers.setText(Integer.toString(data.getMaxContainers()));
		maxStackSize.setText(Integer.toString(data.getMaxStackSize()));
		initialStackSize.setText(Integer.toString(data.getInitialStackSize()));
		numQC.setText(Integer.toString(data.getNumQC()));
		numYV.setText(Integer.toString(data.getNumYV()));
		timeLimit.setText(Integer.toString(data.getTimeLimit()));
		numShipsWaiting.setText(Integer.toString(data.getNumShipsWaiting()));
		
	}

	private void setListeners() {
		
		defaultBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				configuration.readValues("\\default.txt");
				data = configuration.getData();
				setValues(data);
			}
		});
		
		startBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					data.setConfigValues("simulationSpeed", Integer.parseInt(simulationSpeed.getText()));
					data.setConfigValues("dockMinTime", Integer.parseInt(dockMinTime.getText()));
					data.setConfigValues("dockMaxTime", Integer.parseInt(dockMaxTime.getText()));
					data.setConfigValues("undockMinTime", Integer.parseInt(undockMinTime.getText()));
					data.setConfigValues("undockMaxTime", Integer.parseInt(undockMaxTime.getText()));
					data.setConfigValues("qcRemoveMinTime", Integer.parseInt(qcRemoveMinTime.getText()));
					data.setConfigValues("qcRemoveMaxTime", Integer.parseInt(qcRemoveMaxTime.getText()));
					data.setConfigValues("qcPlaceMinTime", Integer.parseInt(qcPlaceMinTime.getText()));
					data.setConfigValues("qcPlaceMaxTime", Integer.parseInt(qcPlaceMaxTime.getText()));
					data.setConfigValues("yvPickMinTime", Integer.parseInt(yvPickMinTime.getText()));
					data.setConfigValues("yvPickMaxTime", Integer.parseInt(yvPickMaxTime.getText()));
					data.setConfigValues("yvDropMinTime", Integer.parseInt(yvDropMinTime.getText()));
					data.setConfigValues("yvDropMaxTime", Integer.parseInt(yvDropMaxTime.getText()));
					data.setConfigValues("yvTravelToSeaSideMinTime", Integer.parseInt(yvTravelToSeaSideMinTime.getText()));
					data.setConfigValues("yvTravelToSeaSideMaxTime", Integer.parseInt(yvTravelToSeaSideMaxTime.getText()));
					data.setConfigValues("yvTravelToQAMinTime", Integer.parseInt(yvTravelToQAMinTime.getText()));
					data.setConfigValues("yvTravelToQAMaxTime", Integer.parseInt(yvTravelToQAMaxTime.getText()));
					data.setConfigValues("maxContainers", Integer.parseInt(maxContainers.getText()));
					data.setConfigValues("minContainers", Integer.parseInt(minContainers.getText()));
					data.setConfigValues("maxStackSize", Integer.parseInt(maxStackSize.getText()));
					data.setConfigValues("initialStackSize", Integer.parseInt(initialStackSize.getText()));
					data.setConfigValues("numQC", Integer.parseInt(numQC.getText()));
					data.setConfigValues("numYV", Integer.parseInt(numYV.getText()));
					data.setConfigValues("timeLimit", Integer.parseInt(timeLimit.getText()));
					data.setConfigValues("numShipsWaiting", Integer.parseInt(numShipsWaiting.getText()));
					
					configuration.setData(data);
					frame.dispose();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		});
		
	}

	private JPanel addLabelTextField(JLabel label, JTextField textfieldMin, JTextField textfieldMax) {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.add(label);
		panel.add(textfieldMin);
		JLabel connector = new JLabel("-");
		panel.add(connector);
		panel.add(textfieldMax);
		return panel;
	}
	
	private JPanel addLabelTextField(JLabel label, JTextField textfield) {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.add(label);
		panel.add(textfield);
		return panel;
	}
}
