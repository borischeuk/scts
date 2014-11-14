package scts.ui.view;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class TruckView extends JLabel {
	
	final private int initialX = 10;
	final private int initialY = 550;
	private int x;
	private int y;
	private int moveX = 1;
	private int moveY = 1;
	private String num = "0";
	private Dimension size;
	
	public TruckView() {
		super();
		ImageIcon imageicon = new ImageIcon(this.getClass().getResource("truck.png"));
		this.setIcon(imageicon);
		this.setText(num);
		x = initialX;
		y = initialY;
		size = this.getPreferredSize();
		this.setBounds(x, y, size.width, size.height);
	}
	
	public void changeNum(String value) {
		this.num = value;
		this.setText(value);
	}
	
	public void move() {
		x = this.getX();
		y = this.getY();
		this.setBounds(x+moveX, y+moveY, size.width, size.height);
		this.repaint();
	}
}
