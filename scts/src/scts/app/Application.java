package scts.app;
import java.awt.BorderLayout;

import javax.swing.JFrame;

import scts.domain.ConfigValues;
import scts.simulations.UnloadingSimulation;
import scts.ui.ControlPanel;
import scts.ui.LivePanel;
import scts.ui.LivePanel2;
import scts.ui.MonitorPanel;
import scts.ui.TestUi;
import simulation.simulation.Simulation;


public class Application {
	
	public static void main(String args[]) {
		
		Simulation unloadingSimulation = new UnloadingSimulation();
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 700);
		frame.setTitle("SCTS");
		frame.setLayout(new BorderLayout());
		
		frame.add(new ControlPanel(unloadingSimulation), BorderLayout.NORTH);
		frame.add(new MonitorPanel(), BorderLayout.EAST);
		//frame.add(new LivePanel(unloadingSimulation), BorderLayout.CENTER);
		frame.add(new LivePanel2(unloadingSimulation), BorderLayout.CENTER);
		//frame.add(new TestUi(), BorderLayout.CENTER);
		
		frame.setVisible(true);
		
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			public void run() {
				Configuration configuration = new Configuration();
				configuration.reset();
			}
		}));
	}

}
