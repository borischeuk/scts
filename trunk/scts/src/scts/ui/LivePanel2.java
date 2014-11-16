package scts.ui;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import scts.simulations.SimulationState;
import scts.ui.view.ShipView;
import scts.ui.view.ShipView2;
import simulation.simulation.Simulation;

public class LivePanel2 extends JPanel{
	
	private static LivePanel2 instance;
	
	private Simulation simulation;
	private SimulationState state;
	private Timer timer;
	
	private ShipView2 shipView;
	
	public LivePanel2(Simulation simulation) {
		if(instance == null)
			instance = this;
		this.simulation = simulation;
		
		timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Test Test Test");
				//revalidate();
				//repaint(1000);
				update(LivePanel2.getInstance().getGraphics());
				paint(LivePanel2.getInstance().getGraphics());
			}
			
		});
		
		shipView = new ShipView2();
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		int x = shipView.getX();
		int y = shipView.getY();
		
		g.drawImage(shipView.getImage(), x, y, null);
		shipView.setPosition(x + 10, y + 10);
		
	}
	
	public static LivePanel2 getInstance() {
		return instance;
	}
	
	public void timerUpdate() {
		
		timer.start();
	}

}
