package scts.ui.view;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ShipView2 {

	final private int initialX = 10;
	final private int initialY = 10;
	private int x;
	private int y;
	private int moveX = 1;
	private int moveY = 0;
	private Image image;
	
	public ShipView2() {
		x = initialX;
		y = initialY;
		try {
			image = ImageIO.read(new File("src//scts//ui//view//ship.png"));
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public Image getImage() {
		return image;
	}

	
	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
}
