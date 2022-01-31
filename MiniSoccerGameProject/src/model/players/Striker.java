package model.players;

import model.SoccerBall;

import java.awt.*;


/**
 * Striker implementation class of GamePlayer. It defines the attributes and behavious of Striker.
 * @author Group 1
 *
 */
public class Striker extends GamePlayer {
	
	/**
	 * Constructor of Striker
	 * @param name Name of the Striker
	 * @param color Color of the Striker
	 */
	public Striker(String name, Color color) {
		super(name, color);
	}

	/**
	 * Moves the Striker left by 5
	 */
	@Override
	public void moveLeft() {
		if (getPlayerPosition().x - 10 > 0) {
			setPlayerPosition(new Point(getPlayerPosition().x - 5, getPlayerPosition().y));
		}
	}

	/**
	 * Moves the Striker right by 5
	 */
	@Override
	public void moveRight() {
		if (getPlayerPosition().x + 50 < 600) {
			setPlayerPosition(new Point(getPlayerPosition().x + 5, getPlayerPosition().y));
		}
	}

	/**
	 * Moves the Striker up by 5
	 */
	@Override
	public void moveUp() {
		if (getPlayerPosition().y - 5 > 200) {
			setPlayerPosition(new Point(getPlayerPosition().x, getPlayerPosition().y - 5));
		}
	}

	/**
	 * Moves the Striker down by 5
	 */
	@Override
	public void moveDown() {
		if (getPlayerPosition().y + 50 < 500) {
			setPlayerPosition(new Point(getPlayerPosition().x, getPlayerPosition().y + 5));
		}
	}

	/**
	 * Makes Striker shoot the soccer ball.
	 */
	@Override
	public void shootBall() {
		SoccerBall.getSoccerBall().moveBall(60, 5.0, 0.05);
	}

	/**
	 * Sets the Striker to its initial position
	 */
	@Override
	public void setInitialPosition() {
		setPlayerPosition(new Point(500, 450));
	}

	/**
	 * Returns the information of Striker.
	 * @return the information of Striker
	 */
	@Override
	public String toString() {
		return playerName + " scored " + playerStatistics.toString() + " goals";
	}
}
