package scts.ui;

import java.awt.Color;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import scts.simulations.Stats;
import scts.simulations.UnloadingSimulation;
import simulation.simulation.Simulation;

public class MonitorPanel extends JPanel{
	
	private static MonitorPanel instance;
	private Simulation simulation;
	
	private JButton configBtn;
	private JButton reportBtn;
	private Stats stats;
	
	public MonitorPanel(Simulation simulation) {
		
		if(instance == null)
			instance = this;
		
		this.simulation = simulation;
		this.stats = ((UnloadingSimulation)simulation).getStats();
		
		JPanel panel = new JPanel();
		LayoutManager layout = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(layout);
		panel.setBackground(Color.BLACK);
		
		configBtn = new JButton("Configuration");
		reportBtn = new JButton("Operation Report");
		
		panel.add(configBtn);
		panel.add(reportBtn);
		
		this.add(panel);
		this.setBackground(Color.BLACK);
		
		reportBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new ReportPanel(stats);
			}
		});
		
		configBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new ConfigurationPanel();
			}
		});
		
	}
	
	public static MonitorPanel getInstance() {
		return instance;
	}
	
	public void initialize() {
		this.stats = ((UnloadingSimulation)simulation).getStats();
	}

}
