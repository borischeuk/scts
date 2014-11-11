package scts.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import scts.app.*;

public class ConfigurationPanel{
	
	private JLabel title;
	private JButton defaultBtn;
	private JButton startBtn;
	private JLabel dockTime;
	private JLabel undockTime;
	private JTextField dockMinTime;
	private JTextField dockMaxTime;
	private JTextField undockMinTime;
	private JTextField undockMaxTime;
	private Configuration configuration;
	
	public ConfigurationPanel() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setSize(400, 400);
		frame.setTitle("SCTS Configuration");
		frame.setLayout(new BorderLayout());
		
		// Separate Frame
		JPanel display = new JPanel();
		display.setLayout(new FlowLayout());
		JPanel menu = new JPanel();
		menu.setLayout(new FlowLayout());
		
		// Panel "display"
		title = new JLabel("Simulation Settings", JLabel.CENTER);
		title.setPreferredSize(new Dimension(380, 20));
		display.add(title);
		
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
		
		defaultBtn = new JButton("Default Settings");
		menu.add(defaultBtn);
		startBtn = new JButton("Start");
		menu.add(startBtn);
		
		frame.add(display, BorderLayout.CENTER);
		frame.add(menu, BorderLayout.SOUTH);
		frame.setVisible(true);
		
		configuration = new Configuration();
		setListeners();
	}
	
	private void setListeners() {
		
		defaultBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//dockMaxTime.setText("20");
			}
		});
		
		startBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String[] data = null;
				configuration = new Configuration(data);
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
}
