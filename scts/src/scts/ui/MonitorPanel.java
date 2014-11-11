package scts.ui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		
		super(new FlowLayout());
		
		configBtn = new JButton("Configuration");
		reportBtn = new JButton("Operation Report");
		quitBtn = new JButton("Quit");
		
		this.add(configBtn);
		this.add(reportBtn);
		this.add(quitBtn);
		
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

}
