package entity;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;

import javax.swing.ImageIcon;

public class Whizbang {
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	private double angle;
	private AffineTransform muzzleTrans;
	private AffineTransform trans;
	private Image whizbangModel = new ImageIcon(this.getClass().getClassLoader().getResource("whizbang.png")).getImage();
	private int speed;
	private int muzzleX;
	private int muzzleY;
	private int x;
	private int y;
	private int way;

	public Whizbang(AffineTransform trans, double angle) {
		this.angle = angle;
		this.muzzleTrans = trans;
		this.setSpeed(4);
		this.way = 0;
		muzzleX = (int) muzzleTrans.getTranslateX() + 20;
		muzzleY = (int) muzzleTrans.getTranslateY();
	}
	
	public void paint (Graphics g, Dimension dim) {
		Graphics2D g2d = (Graphics2D) g;
		int correctX = 0;
		int correctY = 0;
		if (angle > -20 && angle < 20) {
			correctX = -20;
			correctY = 25;
		}
		x = (int) (correctX + muzzleX + way * 2 * Math.cos(Math.toRadians(angle + 270)));
		y = (int) (correctY + muzzleY + way * 2 * Math.sin(Math.toRadians(angle + 270)));
		trans = new AffineTransform(1, 0.0, 0.0, 1, x, y);
		trans.rotate(Math.toRadians(angle), whizbangModel.getWidth(null) / 2, whizbangModel.getHeight(null));
		g2d.drawImage(whizbangModel, trans, null);
		way += speed;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public Rectangle getRect() {
		return new Rectangle(this.x, this.y, whizbangModel.getWidth(null), whizbangModel.getHeight(null));
	}

}
