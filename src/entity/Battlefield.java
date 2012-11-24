package entity;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import logic.EnemyFabric;
import logic.Handler;

public class Battlefield extends JPanel implements ActionListener {
	private Cannon cannon;
	private Muzzle muzzle;
	
	private ArrayList<Whizbang> whizbangs;
	private ArrayList<Enemy> enemies;
	
	private Image battlefieldBg = new ImageIcon(/*getClass().getClassLoader().getResource(*/"res/bg_battlefield.png"/*)*/).getImage();
	private Image battlefieldClouds = new ImageIcon("res/battlefield_clouds.png").getImage();
	private Image menuLogo = new ImageIcon("res/menu_logo.png").getImage();
	private Timer cloudTimer = new Timer(10, this);
	
	private int cloudX = 0;
	private int cloudY = 0;
	private int cloud2X = battlefieldClouds.getWidth(null);
	private int cloudSpeed = 1;
	
	public Battlefield() {
		cloudTimer.start();
		cannon = new Cannon();
		muzzle = new Muzzle();
		enemies = new ArrayList<Enemy>();
		new EnemyFabric(enemies);
		setWhizbangs(new ArrayList<Whizbang>());
		addKeyListener(new GameKeyAdapter());
		setFocusable(true);
	}
	
	public Cannon getCannon() {
		return cannon;
	}
	
	public Muzzle getMuzzle() {
		return muzzle;
	}

	public void setCannon(Cannon cannon) {
		this.cannon = cannon;
	}

	public void setMuzzle(Muzzle muzzle) {
		this.muzzle = muzzle;
	}
	
	private class GameKeyAdapter extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			if (!Handler.pause.equals("pause") && !Handler.pause.equals("help")) {
				Handler.game.keyPressed(e);
			}
		}
		public void keyReleased(KeyEvent e) {
			if (!Handler.pause.equals("pause") && !Handler.pause.equals("help")) {
				Handler.game.keyReleased(e);
			}
		}
	}
	
	 private void drawString(Graphics g, String text, int x, int y) {
        for (String line : text.split("\n"))
            g.drawString(line, x, y += g.getFontMetrics().getHeight());
    }
	
	public void paint(Graphics g) {
		g = (Graphics2D) g;
		g.drawImage(battlefieldBg, 0, 0, null);
		g.drawImage(battlefieldClouds, cloudX, cloudY, null);
		g.drawImage(battlefieldClouds, cloud2X, cloudY, null);
		if (Handler.pause.equals("pause")) {
			g.setColor(new Color(0, 0, 0, 0.6f));
			g.fillRect(0, 0, 1000, 1000);
			Dimension dim = getSize();
			g.drawImage(menuLogo, (dim.width / 2) - menuLogo.getWidth(null) / 2, (dim.height / 2) - menuLogo.getHeight(null) / 2, null);
		}
		else if (Handler.pause.equals("help")) {
			g.setColor(new Color(0, 0, 0, 0.6f));
			g.fillRect(0, 0, 1000, 1000);
			Dimension dim = getSize();
			g.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 19));
			g.setColor(Color.WHITE);
			((Graphics2D) g).setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
			g.drawString("Правила игры", (dim.width / 2) - 100, 50);
			g.setFont(new Font("Serif", 0, 17));
			drawString(g, "1) 3 уровня \n2) Нельзя пропустить самолеты", 200, 100);
		}
		else {
			muzzle.paint(g, getSize());
			cannon.paint(g, getSize());
			Iterator<Whizbang> iWhzbng = whizbangs.iterator();
			while(iWhzbng.hasNext()) {
				Whizbang whzbng = iWhzbng.next();
				if (whzbng.getX() < -100 || whzbng.getX() > 1500 || whzbng.getY() < -100) {
					iWhzbng.remove();
				}
				whzbng.paint(g, getSize());
			}
			Iterator<Enemy> iEnm = enemies.iterator();
			while(iEnm.hasNext()) {
				Enemy enm = iEnm.next();
				if (enm.getX() < -100 || enm.getX() > 1500) {
					iEnm.remove();
				}
				enm.paint(g, getSize());
			}
			checkHit();
		}
	}
	
	private void checkHit() {
		Iterator<Whizbang> iWhzbng = whizbangs.iterator();
		while(iWhzbng.hasNext()) {
			Whizbang whzbng = iWhzbng.next();
			Iterator<Enemy> iEnm = enemies.iterator();
			while(iEnm.hasNext()) {
				Enemy enm = iEnm.next();
				if (whzbng.getRect().intersects(enm.getRect())) {
					iEnm.remove();
					iWhzbng.remove();
				}
			}
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (cloud2X - cloudSpeed <= 0) {
			this.cloudX = 0;
			this.cloud2X = battlefieldClouds.getWidth(null);
		}
		else {
			this.cloudX -= cloudSpeed;
			this.cloud2X -= cloudSpeed;
		}
		repaint();
	}
	
	public void pause() {
		cloudSpeed = 0;
	}
	
	public void start() {
		cloudSpeed = 1;
	}

	public ArrayList<Whizbang> getWhizbangs() {
		return whizbangs;
	}

	public void setWhizbangs(ArrayList<Whizbang> whizbangs) {
		this.whizbangs = whizbangs;
	}
}
