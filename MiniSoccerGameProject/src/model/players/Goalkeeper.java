package model.players;

import model.SoccerBall;

import java.awt.*;
import java.util.Random;


/**
 * Goalkeeper class that inherits GamePlayer class. It defines the attributes and behaviours of Goalkeeper.
 * @author Group 1
 *
 */
public class Goalkeeper extends GamePlayer {

	/**
	 * Moving distance of one movement
	 */
	private int movementStep;

	/**
	 * Constructor of Goalkeeper class.
	 * @param name name of Goalkeeper
	 * @param color color of Goalkeeper to be shown on the screen
	 */
	public Goalkeeper(String name, Color color) {
		super(name, color);
		movementStep = 10;
	}

	/**
	 * Moves Goalkeeper to the left by 5.
	 */
	@Override
	public void moveLeft() {
		if (getPlayerPosition().x - 5 - movementStep > 0) {
			setPlayerPosition(new Point(getPlayerPosition().x - movementStep, getPlayerPosition().y));
		}
	}

	/**
	 * Moves Goalkeeper to the right by 5.
	 */
	@Override
	public void moveRight() {
		if (getPlayerPosition().x + 50 + movementStep < 600) {
			setPlayerPosition(new Point(getPlayerPosition().x + movementStep, getPlayerPosition().y));
		}
	}

	/**
	 * Moves Goalkeeper up by 5.
	 */
	@Override
	public void moveUp() {
		if (getPlayerPosition().y - 5 > 0) {
			setPlayerPosition(new Point(getPlayerPosition().x, getPlayerPosition().y - 5));
		}
	}

	/**
	 * Moves Goalkeeper down by 5.
	 */
	@Override
	public void moveDown() {
		if (getPlayerPosition().y + 50 < 300) {
			setPlayerPosition(new Point(getPlayerPosition().x, getPlayerPosition().y + 5));
		}
	}

	/**
	 * Makes Goalkeeper shoot the soccer ball.
	 */
	@Override
	public void shootBall() {
		SoccerBall.getSoccerBall().moveBall(-20, -5.0, -0.05);
	}

	/**
	 * Makes Goalkeeper move randomly to left or right.
	 */
	public void moveRandomly() {
		Random random = new Random();
		double playerCurrentXPosition = (double) getPlayerPosition().x + 15;
		double chanceOfMovingLeft = (playerCurrentXPosition - 300) / 100 - (random.nextGaussian());
		movementStep = (int) Math.abs(30 * chanceOfMovingLeft);
		if (chanceOfMovingLeft > 0) {
			moveLeft();
		} else {
			moveRight();
		}
	}

	/**
	 * Sets the Goalkeeper to the initial point.
	 */
	@Override
	public void setInitialPosition() {
		setPlayerPosition(new Point(280, 70));
	}

	/**
	 * Returns the information of Goalkeeper, name and number of caugh balls.
	 * @return the information of Goalkeeper, name and number of caugh balls
	 */
	@Override
	public String toString() {
		return playerName + " caught " + playerStatistics.toString() + " balls";
	}
}
