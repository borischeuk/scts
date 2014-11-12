package scts.ui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import simulation.Simulation;

public class ControlPanel extends JPanel{
	
	private JButton startBtn;
	private JButton pauseBtn;
	private JButton stopBtn;
	Simulation simulation;
	
	public ControlPanel(Simulation simulation) {
		super(new FlowLayout());

		this.simulation = simulation;
		
		startBtn = new JButton("Start");
		startBtn.addActionListener(new startListener());
		
		pauseBtn = new JButton("Pause");
		stopBtn = new JButton("Stop");
		
		this.add(startBtn);
		this.add(pauseBtn);
		this.add(stopBtn);
		
		this.setBackground(Color.BLUE);
	}

	public class startListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent a) {
			
			simulation.run();
		}
		
	}
	
}
