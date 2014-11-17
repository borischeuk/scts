package scts.ui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayDeque;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JPanel;

import scts.events.StopEvent;
import scts.simulations.UnloadingSimulation;
import simulation.event.ScheduledEvent;
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
				
				LivePanel.getInstance().initialize();
				MonitorPanel.getInstance().initialize();
			
				Thread simulationThread = new Thread(new Runnable() {

					@Override
					public void run() {
						LivePanel.getInstance().startTimer();
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
			
			if(((UnloadingSimulation)simulation).getStatus() == UnloadingSimulation.RUNNING) {
				((UnloadingSimulation)simulation).setStatus(UnloadingSimulation.PAUSE);
				Thread thread = new Thread(new Runnable() {

					@Override
					public void run() {
						LivePanel.getInstance().stopTimer();
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
			int status = ((UnloadingSimulation)simulation).getStatus();

			if(status == UnloadingSimulation.PAUSE) {
				
				Thread thread = new Thread(new Runnable() {

					@Override
					public void run() {
						
						ArrayDeque<ScheduledEvent> scheduleQueue = ((UnloadingSimulation)simulation).getScheduleQueue();
						
						//Reset the startTime of the events in the event queue.
						for(ScheduledEvent event : scheduleQueue) {
							long timeOfOccurance = event.getTimeOfOccurance();
							long newTime = Calendar.getInstance().getTimeInMillis() - timeOfOccurance;
							Date newStartTime = new Date(newTime);
							event.setStartTime(newStartTime);
						}
						
						((UnloadingSimulation)simulation).setStatus(UnloadingSimulation.RUNNING);
						LivePanel.getInstance().startTimer();
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
					LivePanel.getInstance().stopTimer();
					simulation.schedule(new StopEvent(simulation, 0));
					
				}
				
			});
				
			thread.run();
		}
	}
	
}
