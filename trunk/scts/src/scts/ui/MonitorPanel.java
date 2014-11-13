package scts.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import scts.app.Configuration;
import scts.domain.*;
import scts.ui.*;

public class MonitorPanel extends JPanel{
	
	private JButton configBtn;
	private JButton reportBtn;
	private JButton quitBtn;
	private Stats stats;
	
	public MonitorPanel() {
		
		//super(new FlowLayout());
		
		JPanel panel = new JPanel();
		LayoutManager layout = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(layout);
		panel.setBackground(Color.BLACK);
		
		configBtn = new JButton("Configuration");
		reportBtn = new JButton("Operation Report");
		quitBtn = new JButton("Quit");
		
		panel.add(configBtn);
		panel.add(reportBtn);
		panel.add(quitBtn);
		
		this.add(panel);
		this.setBackground(Color.BLACK);
		
		reportBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				stats = new Stats();
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

}
