package scts.ui;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MonitorPanel extends JPanel{
	
	private JButton configBtn;
	private JButton quitBtn;
	
	public MonitorPanel() {
		
		super(new FlowLayout());
		
		configBtn = new JButton("Configuration");
		quitBtn = new JButton("Quit");
		
		this.add(configBtn);
		this.add(quitBtn);
		
	}

}
