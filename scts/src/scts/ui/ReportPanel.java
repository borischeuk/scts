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
	private JLabel totalContainers;
	private JLabel shipServiceTime;
	private JLabel quayCraneUnloadTime; 
	private JLabel longestShipQueue;
	private JLabel maxRoadVehicleQueue;
	private JLabel yardVehiclePercentageTimeSpentInQA;
	private JLabel yardVehiclePercentageTimeSpentInSeaside;
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
		panel.add(title);
		
		totalShips = new JLabel("Total Number of Ships Unloaded: " + stats.getTotalShips());
		panel.add(totalShips);
		
		totalContainers = new JLabel("Total Number of Containers Transferred: " + stats.getTotalContainers());
		panel.add(totalContainers);
		
		shipServiceTime = new JLabel("Service Time Experienced by the Ship: " + stats.getShipServiceTime());
		panel.add(shipServiceTime);
		
		quayCraneUnloadTime= new JLabel("Service Time of Quay Crane: " + stats.getQuayCraneUnloadTime());
		panel.add(quayCraneUnloadTime);
		
		longestShipQueue = new JLabel("Largest Number of Ships Waiting for Unloading: " + stats.getLongestShipQueue());
		panel.add(longestShipQueue);
		
		maxRoadVehicleQueue = new JLabel("Maximum Length of Road Vehicle Queue: " + stats.getMaxRoadVehicleQueue());
		panel.add(maxRoadVehicleQueue);
		
		yardVehiclePercentageTimeSpentInQA = new JLabel("Percentage of Time Spent by Yard Vehicles In Quay Area: " + stats.getYardVehiclePercentageTimeSpentInQA() + "%");
		panel.add(yardVehiclePercentageTimeSpentInQA);
		
		yardVehiclePercentageTimeSpentInSeaside = new JLabel("Percentage of Time Spent by Yard Vehicles In Seaside Transfer Point: " + stats.getYardVehiclePercentageTimeSpentInSeaside() + "%");
		panel.add(yardVehiclePercentageTimeSpentInSeaside);
		
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
