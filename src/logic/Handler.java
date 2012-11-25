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
		//конфигурация игры
		game = new Game(new GameMenu(), new Battlefield());
		
		//основной фрейм
		mainFrame = new JFrame("Зенитка");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setResizable(false);
		mainFrame.setSize(900, 600);
		mainFrame.setBackground(new Color(252, 233, 192));
		mainFrame.setJMenuBar(game.getMenuBar());
		mainFrame.add(game.getBattlefield());

		/*mainFrame.setPreferredSize(new Dimension(900, 500));
		mainFrame.pack();*/
		mainFrame.setVisible(true);
		game.pauseGame();
	}
}
