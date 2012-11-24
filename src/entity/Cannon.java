package entity;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

import logic.Handler;

public class Cannon {
	private Image cannonModel = new ImageIcon("res/cannon.png").getImage();

	public void paint(Graphics g, Dimension dim) {
		g.drawImage(cannonModel, (dim.width / 2) - cannonModel.getWidth(null) / 2, dim.height - 100, null);
	}
	
	public Image getCannonModel() {
		return cannonModel;
	}

	public void setCannonModel(Image cannonModel) {
		this.cannonModel = cannonModel;
	}
}
