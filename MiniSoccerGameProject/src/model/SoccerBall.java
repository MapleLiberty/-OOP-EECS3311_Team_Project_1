package model;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Singleton class that represents a SoccerBall object. It is the participant class of Singleton pattern of the project.
 * @author Group 1
 *
 */
public class SoccerBall {

	/**
	 * Singleton SoccerBall object
	 */
	private static final SoccerBall soccerBall = new SoccerBall();

	/**
	 * Position of the soccer ball
	 */
	private Point position;

	/**
	 * Velocity of the soccer ball
	 */
	private double velocity;

	/**
	 * Color of the soccer ball
	 */
	private final Color color;

	/**
	 * Constructor of SoccerBall
	 */
	private SoccerBall() {
		color = Color.white;
		resetSoccerBall();
	}

	/**
	 * Singleton method of getting a SoccerBall object.
	 * @return soccerBall object of SoccerBacll Singleton class
	 */
	public static SoccerBall getSoccerBall() {
		return soccerBall;
	}

	/**
	 * Moves the soccer ball according to the parameters.
	 * @param initialDistance initial distance of soccerBall
	 * @param initialVelocity initial velocity of soccerBall
	 * @param acceleration acceleration of soccerBall
	 */
	public void moveBall(int initialDistance, double initialVelocity, double acceleration) {
		moveBallY(initialDistance);
		setVelocity(initialVelocity);
		Timer timer = new Timer();
		TimerTask repaintTask = new TimerTask() {
			@Override
			public void run() {
				if (Math.abs(velocity) < 2) {
					velocity = 0.0;
					timer.cancel();
				} else {
					velocity = velocity - acceleration;
				}
				moveBallY((int) velocity);
			}
		};
		timer.schedule(repaintTask, 0, 10);
	}

	/**
	 * Moves the soccer ball to y axis according to the amount of parameter distance
	 * @param distance moving distance 
	 */
	public void moveBallY(int distance) {
		if (getPosition().y + distance < 510 && getPosition().y - distance > 20) {
			setPosition(new Point(getPosition().x, getPosition().y - distance));
		} else {
			setVelocity(0.0);
		}
	}

	/**
	 * Resets the position of soccer ball
	 */
	public void resetSoccerBall() {
		setVelocity(0.0);
		setPosition(new Point(480, 500));
	}

	/**
	 * Returns true if the soccer ball is on Goalkeeper side.
	 * @return true if the soccer ball is on Goalkeeper side
	 */
	public boolean onGoalkeeperSide() {
		return getPosition().y < 200;
	}

	/**
	 * Return true if the soccer ball is in gate.
	 * @return true if the soccer ball is in gate.
	 */
	public boolean inGate() {
		return getPosition().x > 180 && getPosition().x < 400 && getPosition().y > 10 && getPosition().y < 60;
	}

	/**
	 * Set the soccer ball's velocity to the parameter velocity
	 * @param velocity velocity to set 
	 */
	public void setVelocity(double velocity) {
		this.velocity = velocity;
	}

	/**
	 * Returns the position of the soccer ball.
	 * @return the position of the soccer ball
	 */
	public Point getPosition() {
		return position;
	}

	/**
	 * Set the position of the soccer ball to the parameter position
	 * @param position position of soccer ball to set 
	 */
	public void setPosition(Point position) {
		this.position = position;
	}

	/**
	 * Returns the color of the soccer ball.
	 * @return the color of the soccer ball
	 */
	public Color getColor() {
		return color;
	}
}
