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
		JMenu gameMenu = new JMenu("Игра");
		
		JMenuItem startItem = new JMenuItem("Начать");
		startItem.addActionListener(this);
		gameMenu.add(startItem);
		
		JMenuItem pauseItem = new JMenuItem("Пауза");
		pauseItem.addActionListener(this);
		gameMenu.add(pauseItem);
		
		JMenuItem resumeItem = new JMenuItem("Продолжить");
		resumeItem.addActionListener(this);
		gameMenu.add(resumeItem);
		
		JMenuItem helpItem = new JMenuItem("Правила игры");
		helpItem.addActionListener(this);
		gameMenu.add(helpItem);
		
		JMenuItem exitItem = new JMenuItem("Выход");
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
		//JOptionPane.showMessageDialog(null, e.getActionCommand());
		switch (e.getActionCommand()) {
			case "Начать":
				Handler.game.startGame();
				break;
			case "Пауза":
				Handler.game.pauseGame();
				break;
			case "Продолжить":
				Handler.game.resumeGame();
				break;
			case "Правила игры":
				Handler.game.helpGame();
				break;
			case "Выход":
				System.exit(0);
				break;
		}
	}
}
