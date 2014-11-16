package scts.ui.view;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
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
	private Image image;
	
	public ShipView() {
		super();
		ImageIcon imageicon = new ImageIcon(this.getClass().getResource("ship.png"));
		this.setText(num);
		this.setIcon(imageicon);
		x = initialX;
		y = initialY;
		size = this.getPreferredSize();
		try {
			image = ImageIO.read(new File("src//scts//ui//view//ship.png"));
		} catch (IOException e) {
			System.out.println(e);
		}
		this.setBounds(x, y, size.width, size.height);
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public Dimension getSize() {
		return size;
	}
	
	public Image getImage() {
		return image;
	}
	
	public void changeNum(String value) {
		this.num = value;
		this.setText(value);
	}
	
	public void move() {
		x = this.getX();
		y = this.getY();
		//this.setBounds(x+moveX, y+moveY, size.width, size.height);
		this.setLocation(new Point(x+moveX, y+moveY));
		//this.repaint();
	}
	
	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void move(int x, int y) {
		this.setPosition(x, y);
		this.setBounds(x, y, size.width, size.height);
		//this.setLocation(new Point(x, y));
	}
	
	public void move(Point newPoint) {
		this.setPosition(newPoint.x, newPoint.y);
		//this.setBounds(x, y, size.width, size.height);
		this.setLocation(newPoint);
	}
}
