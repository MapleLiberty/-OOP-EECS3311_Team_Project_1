package controller;

import model.SoccerGame;
import view.GamePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controller class for GameMenuBar(View class)
 * @author Group 1
 *
 */
public class MenubarListener implements ActionListener {

	/**
	 * GamePanel object that is final
	 */
	private final GamePanel gamePanel;

	/**
	 * Constructor of MenubarListener
	 * @param panel GamePanel object to initizalize gamePanel field
	 */
	public MenubarListener(GamePanel panel) {
		gamePanel = panel;
	}

	/**
	 * Manages game according to the action events. New game is initiated at "NEW" event, game closes at "EXIT" event, game stops at "PAUSE" event, and game resumes at "RESUME" event. 
	 * @param e action event parameter
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		SoccerGame soccerGame = gamePanel.getGame();
		switch (e.getActionCommand()) {
			case "NEW":
				gamePanel.setupSoccerGame();
				break;
			case "EXIT":
				System.exit(0);
				break;
			case "PAUSE":
				if (!soccerGame.isPaused() && !soccerGame.isOver()) {
					soccerGame.setPaused(true);
				} else if (soccerGame.isPaused()) {
					System.out.println("game is already on pause!");
				} else if (soccerGame.isOver()) {
					System.out.println("game is over, please start a new game.");
				}
				break;
			case "RESUME":
				if (soccerGame.isPaused() && !soccerGame.isOver()) {
					soccerGame.setPaused(false);
				} else if (!soccerGame.isPaused()) {
					System.out.println("game is already running!");
				} else if (soccerGame.isOver()) {
					System.out.println("game is over, please start a new game.");
				}
				break;
			default:
				throw new RuntimeException("Invalid action command " + e.getActionCommand());
		}
	}
}
