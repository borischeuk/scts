package scts.ui;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import scts.domain.Stats;

public class ReportPanel extends JPanel {
	
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
	
	public ReportPanel(Stats stats) {
		stats = new Stats();
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setSize(400, 400);
		frame.setTitle("SCTS Report");
		frame.setLayout(new FlowLayout());
		
		title = new JLabel("Operational Statistics", JLabel.CENTER);
		title.setPreferredSize(new Dimension(380, 20));
		frame.add(title);
		
		totalShips = new JLabel("Total Number of Ships Unloaded: " + stats.getTotalShips());
		totalShips.setPreferredSize(new Dimension(380, 20));
		frame.add(totalShips);
		
		avgShips = new JLabel("Average Number of Ships Unloaded: " + stats.getAvgShips());
		avgShips.setPreferredSize(new Dimension(380, 20));
		frame.add(avgShips);
		
		totalContainers = new JLabel("Total Number of Containers Transferred: " + stats.getTotalContainers());
		totalContainers.setPreferredSize(new Dimension(380, 20));
		frame.add(totalContainers);
		
		avgContainers = new JLabel("Average Number of Containers Transferred: " + stats.getAvgContainers());
		avgContainers.setPreferredSize(new Dimension(380, 20));
		frame.add(avgContainers);
		
		nonPriorityServiceTime = new JLabel("Service Time from Arrival to Departure (Non-priority Ships)");
		nonPriorityServiceTime.setPreferredSize(new Dimension(380, 20));
		frame.add(nonPriorityServiceTime);
		
		maxNPShipServiceTime = new JLabel("Maximum: " + stats.getNPMaxServiceTime());
		maxNPShipServiceTime.setPreferredSize(new Dimension(380, 20));
		frame.add(maxNPShipServiceTime);

		minNPShipServiceTime = new JLabel("Mininum: " + stats.getNPMinServiceTime());
		minNPShipServiceTime.setPreferredSize(new Dimension(380, 20));
		frame.add(minNPShipServiceTime);
		
		avgNPShipServiceTime = new JLabel("Average: " + stats.getNPAvgServiceTime());
		avgNPShipServiceTime.setPreferredSize(new Dimension(380, 20));
		frame.add(avgNPShipServiceTime);
		
		priorityServiceTime = new JLabel("Service Time from Arrival to Departure (Priority Ships)");
		priorityServiceTime.setPreferredSize(new Dimension(380, 20));
		frame.add(priorityServiceTime);
		
		maxPShipServiceTime = new JLabel("Maximum: " + stats.getPMaxServiceTime());
		maxPShipServiceTime.setPreferredSize(new Dimension(380, 20));
		frame.add(maxPShipServiceTime);

		minPShipServiceTime = new JLabel("Mininum: " + stats.getPMinServiceTime());
		minPShipServiceTime.setPreferredSize(new Dimension(380, 20));
		frame.add(minPShipServiceTime);
		
		avgPShipServiceTime = new JLabel("Average: " + stats.getPAvgServiceTime());
		avgPShipServiceTime.setPreferredSize(new Dimension(380, 20));
		frame.add(avgPShipServiceTime);
		
		longestShipServiceTime = new JLabel("Largest Number of Ships Waiting for Unloading: " + stats.getLongestServiceTime());
		longestShipServiceTime.setPreferredSize(new Dimension(380, 20));
		frame.add(longestShipServiceTime);
		
		longestShipQueue = new JLabel("Largest Number of Ships Waiting for Unloading: " + stats.getLongestShipQueue());
		longestShipQueue.setPreferredSize(new Dimension(380, 20));
		frame.add(longestShipQueue);
		
		maxRoadVehicleQueue = new JLabel("Maximum Length of Road Vehicle Queue: " + stats.getMaxRoadVehicleQueue());
		maxRoadVehicleQueue.setPreferredSize(new Dimension(380, 20));
		frame.add(maxRoadVehicleQueue);
		
		stackSize = new JLabel("Stack Size");
		stackSize.setPreferredSize(new Dimension(380, 20));
		frame.add(stackSize);
		
		maxStackSize = new JLabel("Maximum: " + stats.getMaxStackSize());
		maxStackSize.setPreferredSize(new Dimension(380, 20));
		frame.add(maxStackSize);

		minStackSize = new JLabel("Mininum: " + stats.getMinStackSize());
		minStackSize.setPreferredSize(new Dimension(380, 20));
		frame.add(minStackSize);
		
		avgStackSize = new JLabel("Average: " + stats.getAvgStackSize());
		avgStackSize.setPreferredSize(new Dimension(380, 20));
		frame.add(avgStackSize);
		
		yardVehiclePercentageTimeSpent = new JLabel("Percentage of Time Spent by Yard Vehicles: " + stats.getYardVehiclePercentageTimeSpent());
		yardVehiclePercentageTimeSpent.setPreferredSize(new Dimension(380, 20));
		frame.add(yardVehiclePercentageTimeSpent);
		frame.setVisible(true);
	}
}
