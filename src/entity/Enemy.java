package entity;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Enemy {
	private ArrayList<Image> enemyModels;
	private int x;
	private int y;
	private int speed;
	private int state;
	private int stateCount = 9;
	private int reuse = 0;
	private boolean shotDown = false;
	
	public int getReuse() {
		return reuse;
	}

	public void setReuse(int reuse) {
		this.reuse = reuse;
	}

	public boolean isShotDown() {
		return shotDown;
	}

	public void setShotDown(boolean shotDown) {
		this.shotDown = shotDown;
	}

	public Enemy(int x, int y, int speed) {
		this.x = x;
		this.y = y;
		this.state = 0;
		this.speed = speed;
		enemyModels = new ArrayList<Image>();
		for(int i = 0; i < stateCount; i++) {
			enemyModels.add(new ImageIcon("res/enemy_" + i + ".png").getImage());
		}
	}
	
	public void paint(Graphics g, Dimension dim) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(enemyModels.get(state), x, y, null);
		if (!isShotDown()) {
			x += speed;
		}
	}
	
	public Rectangle getRect() {
		return new Rectangle(this.x, this.y, enemyModels.get(0).getWidth(null), enemyModels.get(0).getHeight(null));
	}
	
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
	
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	
	public int getStateCount() {
		return stateCount;
	}

	public void setStateCount(int stateCount) {
		this.stateCount = stateCount;
	}
}
