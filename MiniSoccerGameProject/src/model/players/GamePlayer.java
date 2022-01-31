package model.players;

import model.SoccerBall;

import java.awt.*;


/**
 * 
 * The parent of class of GamePlayer hierarchy. It provides common fields and methods for the player objects (Striker and GoalKeeper).
 * @author Group 1
 *
 */
public abstract class GamePlayer implements Comparable<GamePlayer> {

	/**
	 * Name of the game player
	 */
	protected final String playerName;

	/**
	 * Color of the game player
	 */
	protected final Color playerColor;

	/**
	 * Position of the game player
	 */
	protected Point playerPosition;

	/**
	 * Player Statstics of the game player
	 */
	protected final PlayerStatistics playerStatistics;

	/**
	 * Constructor of GamePlayer class
	 * @param name name of the GamePlayer
	 * @param color color of the GamePlayer to be shown on the screen
	 */
	public GamePlayer(String name, Color color) {
		playerName = name;
		playerColor = color;
		playerStatistics = new PlayerStatistics();
		setInitialPosition();
	}

	/**
	 * Returns true if the soccer ball is within the GamePlayer's range.
	 * @return true if the soccer ball is within the GamePlayer's range
	 */
	public boolean isPlayerHasBall() {
		Point playerPositionCenter = new Point(getPlayerPosition().x + 15, getPlayerPosition().y + 30);
		return playerPositionCenter.distance(SoccerBall.getSoccerBall().getPosition()) < 55;
	}

	/**
	 * Sets the soccerball's position to GamePlayer's position if the ball is within the range of the GamePlayer
	 */
	public void grabsBall() {
		SoccerBall ball = SoccerBall.getSoccerBall();
		if (getPlayerPosition().x + 15 > ball.getPosition().x) {
			ball.setPosition(new Point(getPlayerPosition().x - 10, getPlayerPosition().y + 55));
		} else {
			ball.setPosition(new Point(getPlayerPosition().x + 20, getPlayerPosition().y + 55));
		}
	}

	/**
	 * Abstract method of moveLeft()
	 */
	public abstract void moveLeft();

	/**
	 * Abstract method of moveRight()
	 */
	public abstract void moveRight();

	/**
	 * Abstract method of moveUp()
	 */
	public abstract void moveUp();

	/**
	 * Abstract method of moveDown()
	 */
	public abstract void moveDown();

	/**
	 * Abstract method of shootBall()
	 */
	public abstract void shootBall();

	/**
	 * Returns the playerName of the GamePlayer instance.
	 * @return the playerName of the GamePlayer instance.
	 */
	public String getPlayerName() {
		return playerName;
	}

	/**
	 * Returns the playerColor of the GamePlyaer instance.
	 * @return the playerColor of the GamePlayer instance.
	 */
	public Color getPlayerColor() {
		return playerColor;
	}

	/**
	 * Returns the playerPosition of the GamePlayer instance.
	 * @return the playerPosition of the GamePlayer instance.
	 */
	public Point getPlayerPosition() {
		return playerPosition;
	}

	/**
	 * Abstract method of setInitialPosition()
	 */
	public abstract void setInitialPosition();

	/**
	 * Moves the GamePlayer to the new position.
	 * @param newPosition a new position to move the GamePlayer
	 */
	public void setPlayerPosition(Point newPosition) {
		playerPosition = newPosition;
		if (isPlayerHasBall()) {
			grabsBall();
		}
	}

	/**
	 * Returns the playerStatistics of the GamePlayer instance.
	 * @return the playerStatistics of the GamePlayer instance
	 */
	public Integer getPlayerStatistics() {
		return playerStatistics.getStatistics();
	}

	/**
	 * Sets the new playerStatistics of the GamePlayer.
	 * @param newStatistics a new playerStatistics of the GamePlayer
	 */
	public void setPlayerStatistics(Integer newStatistics) {
		playerStatistics.setStatistics(newStatistics);
	}

	/**
	 * Returns 1 if current GamePlayer's playerStatistics is more than the parameter GamePlayer's playerStatistics, 0 if equal, -1 if less.
	 * @return 1 if current GamePlayer's playerStatistics is more than the parameter GamePlayer's playerStatistics, 0 if equal, -1 if less
	 */
	@Override
	public int compareTo(GamePlayer otherPlayer) {
		return otherPlayer.getPlayerStatistics().compareTo(this.getPlayerStatistics());
	}

	/**
	 * Abstract method of toString()
	 */
	@Override
	public abstract String toString();
}
