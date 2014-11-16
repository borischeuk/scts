package scts.ui.view;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class YardVehicleView2 {

	final private int initialX = 10;
	final private int initialY = 200;
	private int x;
	private int y;
	private Image image;
	
	public YardVehicleView2() {
		x = initialX;
		y = initialY;
		try {
			image = ImageIO.read(new File("src//scts//ui//view//yardVehicle.png"));
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
