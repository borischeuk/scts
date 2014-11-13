package scts.ui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import scts.app.ReportGeneration;
import scts.domain.Stats;

public class ReportPanel{
	
	private JLabel title;
	private JLabel totalShips;
	private JLabel avgShips;
	private JLabel totalContainers;
	private JLabel avgContainers;
	private JLabel nonPriorityServiceTime;
	private JLabel maxNPShipServiceTime;
	private JLabel minNPShipServiceTime;
	private JLabel avgNPShipServiceTime;
	private JLabel priorityServiceTime;
	private JLabel maxPShipServiceTime;
	private JLabel minPShipServiceTime;
	private JLabel avgPShipServiceTime;
	private JLabel longestShipServiceTime;
	private JLabel longestShipQueue;
	private JLabel maxRoadVehicleQueue;
	private JLabel stackSize;
	private JLabel maxStackSize;
	private JLabel minStackSize;
	private JLabel avgStackSize;
	private JLabel yardVehiclePercentageTimeSpent;
	private JButton saveBtn;
	private Stats data;
	
	public ReportPanel(Stats stats) {
		data = stats;
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setSize(600, 600);
		frame.setTitle("SCTS Report");
		frame.setLayout(new FlowLayout());
		
		JPanel panel = new JPanel();
		BoxLayout layout = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(layout);
		frame.add(panel);
		
		title = new JLabel("Operational Statistics", JLabel.CENTER);
//		title.setPreferredSize(new Dimension(380, 20));
		panel.add(title);
		
		totalShips = new JLabel("Total Number of Ships Unloaded: " + stats.getTotalShips());
//		totalShips.setPreferredSize(new Dimension(380, 20));
		panel.add(totalShips);
		
		avgShips = new JLabel("Average Number of Ships Unloaded: " + stats.getAvgShips());
//		avgShips.setPreferredSize(new Dimension(380, 20));
		panel.add(avgShips);
		
		totalContainers = new JLabel("Total Number of Containers Transferred: " + stats.getTotalContainers());
//		totalContainers.setPreferredSize(new Dimension(380, 20));
		panel.add(totalContainers);
		
		avgContainers = new JLabel("Average Number of Containers Transferred: " + stats.getAvgContainers());
//		avgContainers.setPreferredSize(new Dimension(380, 20));
		panel.add(avgContainers);
		
		nonPriorityServiceTime = new JLabel("Service Time from Arrival to Departure (Non-priority Ships)");
//		nonPriorityServiceTime.setPreferredSize(new Dimension(380, 20));
		panel.add(nonPriorityServiceTime);
		
		maxNPShipServiceTime = new JLabel("Maximum: " + stats.getNPMaxServiceTime());
//		maxNPShipServiceTime.setPreferredSize(new Dimension(380, 20));
		panel.add(maxNPShipServiceTime);

		minNPShipServiceTime = new JLabel("Minimum: " + stats.getNPMinServiceTime());
//		minNPShipServiceTime.setPreferredSize(new Dimension(380, 20));
		panel.add(minNPShipServiceTime);
		
		avgNPShipServiceTime = new JLabel("Average: " + stats.getNPAvgServiceTime());
//		avgNPShipServiceTime.setPreferredSize(new Dimension(380, 20));
		panel.add(avgNPShipServiceTime);
		
		priorityServiceTime = new JLabel("Service Time from Arrival to Departure (Priority Ships)");
//		priorityServiceTime.setPreferredSize(new Dimension(380, 20));
		panel.add(priorityServiceTime);
		
		maxPShipServiceTime = new JLabel("Maximum: " + stats.getPMaxServiceTime());
//		maxPShipServiceTime.setPreferredSize(new Dimension(380, 20));
		panel.add(maxPShipServiceTime);

		minPShipServiceTime = new JLabel("Minimum: " + stats.getPMinServiceTime());
//		minPShipServiceTime.setPreferredSize(new Dimension(380, 20));
		panel.add(minPShipServiceTime);
		
		avgPShipServiceTime = new JLabel("Average: " + stats.getPAvgServiceTime());
//		avgPShipServiceTime.setPreferredSize(new Dimension(380, 20));
		panel.add(avgPShipServiceTime);
		
		longestShipServiceTime = new JLabel("Longest Service Time Experienced by a Ship: " + stats.getLongestServiceTime());
//		longestShipServiceTime.setPreferredSize(new Dimension(380, 20));
		panel.add(longestShipServiceTime);
		
		longestShipQueue = new JLabel("Largest Number of Ships Waiting for Unloading: " + stats.getLongestShipQueue());
//		longestShipQueue.setPreferredSize(new Dimension(380, 20));
		panel.add(longestShipQueue);
		
		maxRoadVehicleQueue = new JLabel("Maximum Length of Road Vehicle Queue: " + stats.getMaxRoadVehicleQueue());
//		maxRoadVehicleQueue.setPreferredSize(new Dimension(380, 20));
		panel.add(maxRoadVehicleQueue);
		
		stackSize = new JLabel("Stack Size");
//		stackSize.setPreferredSize(new Dimension(380, 20));
		panel.add(stackSize);
		
		maxStackSize = new JLabel("Maximum: " + stats.getMaxStackSize());
//		maxStackSize.setPreferredSize(new Dimension(380, 20));
		panel.add(maxStackSize);

		minStackSize = new JLabel("Minimum: " + stats.getMinStackSize());
//		minStackSize.setPreferredSize(new Dimension(380, 20));
		panel.add(minStackSize);
		
		avgStackSize = new JLabel("Average: " + stats.getAvgStackSize());
//		avgStackSize.setPreferredSize(new Dimension(380, 20));
		panel.add(avgStackSize);
		
		yardVehiclePercentageTimeSpent = new JLabel("Percentage of Time Spent by Yard Vehicles: " + stats.getYardVehiclePercentageTimeSpent());
//		yardVehiclePercentageTimeSpent.setPreferredSize(new Dimension(380, 20));
		panel.add(yardVehiclePercentageTimeSpent);
		
		saveBtn = new JButton("Save as Text File");
		panel.add(saveBtn);
		
		setListeners();
		
		frame.setVisible(true);
	}
	
	private void setListeners() {
		saveBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ReportGeneration rg = new ReportGeneration();
				rg.generateFile(data);
			}
		});
		
	}
}
