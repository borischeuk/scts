package scts.ui;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ControlPanel extends JPanel{
	
	private JButton startBtn;
	private JButton pauseBtn;
	private JButton stopBtn;
	
	public ControlPanel() {
		super(new FlowLayout());
		
		startBtn = new JButton("Start");
		pauseBtn = new JButton("Pause");
		stopBtn = new JButton("Stop");
		
		this.add(startBtn);
		this.add(pauseBtn);
		this.add(stopBtn);
	}

}
