package entity;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Enemy {
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

	private Image enemyMainModel = new ImageIcon("res/enemy.png").getImage();
	private int x;
	private int y;
	private int speed;
	
	public Enemy(int x, int y, int speed) {
		this.x = x;
		this.y = y;
		this.speed = speed;
	}
	
	public void paint(Graphics g, Dimension dim) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(enemyMainModel, x, y, null);
		x += speed;
	}
	public Rectangle getRect() {
		return new Rectangle(this.x, this.y, enemyMainModel.getWidth(null), enemyMainModel.getHeight(null));
	}
}
