package scts.ui.view;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ShipView extends JLabel {
	
	final private int initialX = 10;
	final private int initialY = 10;
	private int x;
	private int y;
	private String num = "0";
	private int moveX = 1;
	private int moveY = 0;
	private Dimension size;
	
	public ShipView() {
		super();
		ImageIcon imageicon = new ImageIcon(this.getClass().getResource("ship.png"));
		this.setText(num);
		this.setIcon(imageicon);
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
