package scts.ui.view;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class YardVehicleView extends JLabel {
	
	final private int initialX = 10;
	final private int initialY = 200;
	private int x;
	private int y;
	private int moveX = 1;
	private int moveY = 1;
	private String num = "0";
	private Dimension size;
	
	public YardVehicleView() {
		super();
		ImageIcon imageicon = new ImageIcon(this.getClass().getResource("yardVehicle.png"));
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
	
	public void moveRight() {
		x = this.getX();
		y = this.getY();
		moveX = 1;
		moveY = 0;
		this.setBounds(x+moveX, y+moveY, size.width, size.height);
		this.repaint();
	}
	
	public void moveDown() {
		x = this.getX();
		y = this.getY();
		moveX = 0;
		moveY = 1;
		this.setBounds(x+moveX, y+moveY, size.width, size.height);
		this.repaint();
	}
	
	public void moveLeft() {
		x = this.getX();
		y = this.getY();
		moveX = -1;
		moveY = 0;
		this.setBounds(x+moveX, y+moveY, size.width, size.height);
		this.repaint();
	}
	
	public void moveUp() {
		x = this.getX();
		y = this.getY();
		moveX = 0;
		moveY = -1;
		this.setBounds(x+moveX, y+moveY, size.width, size.height);
		this.repaint();
	}
}
