package entity;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Muzzle {
	private ArrayList<Image> muzzleModels;
	private boolean fire = false;
	private double angle;
	private AffineTransform trans;
	private int speed = 3;
	private int state;
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	private int stateCount = 7;
	public int getStateCount() {
		return stateCount;
	}

	public void setStateCount(int stateCount) {
		this.stateCount = stateCount;
	}
	private int reuse = 0;
	
	public int getReuse() {
		return reuse;
	}

	public void setReuse(int reuse) {
		this.reuse = reuse;
	}

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
		this.state = 0;
		muzzleModels = new ArrayList<Image>();
		for(int i = 0; i < stateCount; i++) {
			muzzleModels.add(new ImageIcon("res/muzzle_" + i + ".png").getImage());
		}
	}
	public void paint(Graphics g, Dimension dim) {
		Graphics2D g2d = (Graphics2D) g;
		trans = new AffineTransform(1, 0.0, 0.0, 1, (dim.width / 2) - (muzzleModels.get(state).getWidth(null) / 2) + 10, dim.height - 220);
		trans.rotate(Math.toRadians(angle), muzzleModels.get(state).getWidth(null) / 2, muzzleModels.get(state).getHeight(null));
		g2d.drawImage(muzzleModels.get(state), trans, null);
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
