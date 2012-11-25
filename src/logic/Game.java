package logic;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import entity.Battlefield;
import entity.Muzzle;
import entity.Whizbang;

public class Game {
	private GameMenu menu;
	private Battlefield battlefield;
	
	
	AudioPlayer p = AudioPlayer.player;
	AudioStream as;
	
	public Game(GameMenu menu, Battlefield battlefield) throws FileNotFoundException, IOException {
		this.menu = menu;
		this.setBattlefield(battlefield);
		try { 
			AudioPlayer p = AudioPlayer.player;
			AudioStream as = new AudioStream(new FileInputStream("sound/music.wav"));
			p.start(as);
		}
		catch(IOException IOE){
			JOptionPane.showMessageDialog(null, "Error sound!");
		} 
	}
	
	public void startGame() {
		battlefield.start();
		Handler.pause = "playing";
	}
	
	public void pauseGame() {
		battlefield.pause();
		Handler.pause = "pause";
	}
	
	public void resumeGame() {
		battlefield.start();
		Handler.pause = "playing";
	}
	
	public void helpGame() {
		battlefield.pause();
		Handler.pause = "help";
	}
	
	public void cancelGame() {
		
	}
	
	public JMenuBar getMenuBar() {
		return menu.getMenuBar();
	}
	
	public GameMenu getMenu() {
		return menu;
	}

	public Battlefield getBattlefield() {
		return battlefield;
	}

	public void setBattlefield(Battlefield battlefield) {
		this.battlefield = battlefield;
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_LEFT) {
			battlefield.getMuzzle().setAngle(battlefield.getMuzzle().getAngle() - battlefield.getMuzzle().getSpeed());
		}
		else if (key == KeyEvent.VK_RIGHT) {
			battlefield.getMuzzle().setAngle(battlefield.getMuzzle().getAngle() + battlefield.getMuzzle().getSpeed());
		}
		else if (key == KeyEvent.VK_CONTROL) {
			Muzzle muzzle = getBattlefield().getMuzzle();
			if (battlefield.getShotFreq() <= battlefield.getCurrentShot()) {
				battlefield.getMuzzle().setFire(true);
				try {
					as = new AudioStream(new FileInputStream("sound/shot.wav"));
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				p.start(as);
				getBattlefield().getWhizbangs().add(new Whizbang(muzzle.getTrans(), muzzle.getAngle()));
				//JOptionPane.showMessageDialog(null, "POW POW!");
				battlefield.setCurrentShot(0);
			}
		}
	}
	
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {

		}
	}
}
