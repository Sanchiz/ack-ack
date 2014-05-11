package logic;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import entity.Battlefield;



public class Handler {
	private JFrame mainFrame;
	public static Game game;
	/**
	 * not = not gaming
	 * pause = game pause
	 * play = playing
	 * help = show game help
	 */
	public static String pause = "not";
	public Handler() throws FileNotFoundException, IOException {
		// Game configuration.
		game = new Game(new GameMenu(), new Battlefield());
		
		// Main frame.
		mainFrame = new JFrame("Ack-ack");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setResizable(false);
		mainFrame.setSize(900, 600);
		mainFrame.setBackground(new Color(252, 233, 192));
		mainFrame.setJMenuBar(game.getMenuBar());
		mainFrame.add(game.getBattlefield());
		mainFrame.setVisible(true);
		game.pauseGame();
	}
}
