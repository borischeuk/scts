package scts.ui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import scts.events.StopEvent;
import scts.events.TestEvent;
import scts.simulations.UnloadingSimulation;
import simulation.simulation.Simulation;

public class ControlPanel extends JPanel{
	
	private JButton startBtn;
	private JButton pauseBtn;
	private JButton resumeBtn;
	private JButton stopBtn;
	Simulation simulation;
	Thread simulationThread;
	
	public ControlPanel(Simulation simulation) {
		super(new FlowLayout());

		this.simulation = simulation;
		
		startBtn = new JButton("Start");
		startBtn.addActionListener(new startListener());
		
		pauseBtn = new JButton("Pause");
		pauseBtn.addActionListener(new pauseListener());
		
		resumeBtn = new JButton("Resume");
		resumeBtn.addActionListener(new resumeListener());
		
		stopBtn = new JButton("Stop");
		stopBtn.addActionListener(new stopListener());
		
		this.add(startBtn);
		this.add(pauseBtn);
		this.add(resumeBtn);
		this.add(stopBtn);
		
		this.setBackground(Color.BLACK);
	}

	public class startListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent a) {
			
			if(((UnloadingSimulation)simulation).getStatus() == UnloadingSimulation.STOP) {
			
				((UnloadingSimulation)simulation).initialize();
			
				((UnloadingSimulation)simulation).setStatus(UnloadingSimulation.RUNNING);
			
				Thread simulationThread = new Thread(new Runnable() {

					@Override
					public void run() {
						simulation.run();
					}
				
				});
			
				simulationThread.start();
			}
		}	
	}
	
	public class pauseListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			System.out.println("============== Pause ==============");
			
			if(((UnloadingSimulation)simulation).getStatus() == UnloadingSimulation.RUNNING) {
			
				((UnloadingSimulation)simulation).setStatus(UnloadingSimulation.PAUSE);
			
				Thread thread = new Thread(new Runnable() {

					@Override
					public void run() {
						simulation.schedule(new StopEvent(simulation, 0));
					}
				
				});
			
				thread.run();
			}
			
		}
		
	}
	
	public class resumeListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("============== Pause ==============");
			int status = ((UnloadingSimulation)simulation).getStatus();
			
			if(status == UnloadingSimulation.PAUSE) {
				System.out.println("============== Inside Pause ==============");
				Thread thread = new Thread(new Runnable() {

					@Override
					public void run() {
						((UnloadingSimulation)simulation).resume();
					}
					
				});
				thread.start();

			}
			
		}
	}
	
	public class stopListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent a) {
			
			((UnloadingSimulation)simulation).setStatus(UnloadingSimulation.STOP);
			
			Thread thread = new Thread(new Runnable() {

				@Override
				public void run() {
					simulation.schedule(new StopEvent(simulation, 0));
					
				}
				
			});
				
			thread.run();
		}
	}
	
}
