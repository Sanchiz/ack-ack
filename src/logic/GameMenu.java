package logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;


public class GameMenu implements ActionListener,ItemListener {
	private JMenuBar menuBar;

	public GameMenu() {
		menuBar = new JMenuBar();
		JMenu gameMenu = new JMenu("Game");
		
		JMenuItem startItem = new JMenuItem("Start");
		startItem.addActionListener(this);
		gameMenu.add(startItem);
		
		JMenuItem pauseItem = new JMenuItem("Pause");
		pauseItem.addActionListener(this);
		gameMenu.add(pauseItem);
		
		JMenuItem resumeItem = new JMenuItem("Continue");
		resumeItem.addActionListener(this);
		gameMenu.add(resumeItem);
		
		JMenuItem helpItem = new JMenuItem("Rules");
		helpItem.addActionListener(this);
		gameMenu.add(helpItem);
		
		JMenuItem exitItem = new JMenuItem("Exit");
		exitItem.addActionListener(this);
		
		menuBar.add(gameMenu);
		menuBar.add(exitItem);
	}
	
	public JMenuBar getMenuBar() {
		return menuBar;
	}
	public void setMenuBar(JMenuBar menuBar) {
		this.menuBar = menuBar;
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
			case "Start":
				Handler.game.startGame();
				break;
			case "Pause":
				Handler.game.pauseGame();
				break;
			case "Continue":
				Handler.game.resumeGame();
				break;
			case "Rules":
				Handler.game.helpGame();
				break;
			case "Exit":
				System.exit(0);
				break;
		}
	}
}
