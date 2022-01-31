package controller;

import model.SoccerGame;
import view.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Controller class for GamePanel(View class)
 * @author Group 1
 *
 */
public class GameListener implements KeyListener {

	/**
	 * GamePanel object that is final.
	 */
	private final GamePanel gamePanel;

	/**
	 * Constructor of GameListener 
	 * @param panel GamePanel object to initizalize gamePanel field 
	 */
	public GameListener(GamePanel panel) {
		gamePanel = panel;
	}

	/**
	 * Event of the key typed
	 * @param e key event parameter
	 */
	@Override
	public void keyTyped(KeyEvent e) {

	}

	/**
	 * Triggers events of the program according to the key pressed. GamePlayer moves according to the arrow key pressed and shoot ball when space bar is pressed.
	 * @param e key event parameter
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		SoccerGame soccerGame = gamePanel.getGame();
		if (!soccerGame.isPaused() && !soccerGame.isOver()) {
			switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					soccerGame.getActivePlayer().moveLeft();
					break;
				case KeyEvent.VK_RIGHT:
					soccerGame.getActivePlayer().moveRight();
					break;
				case KeyEvent.VK_UP:
					soccerGame.getActivePlayer().moveUp();
					break;
				case KeyEvent.VK_DOWN:
					soccerGame.getActivePlayer().moveDown();
					break;
				case KeyEvent.VK_SPACE:
					if (soccerGame.getActivePlayer().isPlayerHasBall()) {
						soccerGame.getActivePlayer().shootBall();
					}
					break;
			}
		}
	}

	/**
	 * Event of the key released
	 * @param e key event parameter
	 */
	@Override
	public void keyReleased(KeyEvent e) {

	}
}
