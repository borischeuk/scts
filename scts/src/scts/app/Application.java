package scts.app;
import java.awt.BorderLayout;

import javax.swing.JFrame;

import scts.simulations.UnloadingSimulation;
import scts.ui.ControlPanel;
import scts.ui.LivePanel;
import scts.ui.MonitorPanel;
import simulation.Simulation;


public class Application {
	
	public static void main(String args[]) {
		
		Simulation unloadingSimulation = new UnloadingSimulation();
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setTitle("SCTS");
		frame.setLayout(new BorderLayout());
		
		frame.add(new ControlPanel(unloadingSimulation), BorderLayout.NORTH);
		frame.add(new MonitorPanel(), BorderLayout.EAST);
		//frame.add(new LivePanel(), BorderLayout.CENTER);
		
		frame.setVisible(true);
	}

}
