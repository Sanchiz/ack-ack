package entity;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Muzzle {
	private Image muzzleModel = new ImageIcon("res/muzzle.png").getImage();
	private Image muzzleFireModel = new ImageIcon("res/muzzleFire.png").getImage();
	private boolean fire = false;
	private double angle;
	private AffineTransform trans;
	private int speed = 3;
	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public AffineTransform getTrans() {
		return trans;
	}
	public void setTrans(AffineTransform trans) {
		this.trans = trans;
	}
	public Muzzle() {
		this.setAngle(0);
	}
	public void paint(Graphics g, Dimension dim) {
		Graphics2D g2d = (Graphics2D) g;
		trans = new AffineTransform(1, 0.0, 0.0, 1, (dim.width / 2) - (muzzleModel.getWidth(null) / 2) + 10, dim.height - 220);
		trans.rotate(Math.toRadians(angle), muzzleModel.getWidth(null) / 2, muzzleModel.getHeight(null));
		if (fire) {
			g2d.drawImage(muzzleFireModel, trans, null);
		}
		else {
			g2d.drawImage(muzzleModel, trans, null);
		}
		setFire(false);
	}
	
	public void paintShot(Graphics g) {
		
	}
	public double getAngle() {
		return angle;
	}
	public void setAngle(double angle) {
		if (angle >= - 60 && angle <= 60) {
			this.angle = angle;	
		}
	}
	public boolean getFire() {
		return fire;
	}
	public void setFire(boolean fire) {
		this.fire = fire;
	}
}
