package scts.ui.view;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class QuayCraneView extends JLabel {
	
	final private int initialX = 300;
	final private int initialY = 60;
	private int x;
	private int y;
	private int moveX = 1;
	private int moveY = 1;
	private Dimension size;
	
	public QuayCraneView() {
		super();
		ImageIcon imageicon = new ImageIcon(this.getClass().getResource("quayCrane.png"));
		this.setIcon(imageicon);
		x = initialX;
		y = initialY;
		size = this.getPreferredSize();
		this.setBounds(x, y, size.width, size.height);
	}
	
}
