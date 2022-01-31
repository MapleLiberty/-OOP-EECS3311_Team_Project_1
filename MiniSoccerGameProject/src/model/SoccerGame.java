package model;

import java.util.Timer;
import java.util.TimerTask;

import model.players.*;

/**
 * Class that represents SoccerGame.
 * @author Group 1
 *
 */
public class SoccerGame {

	/**
	 * Time remaining in a game session
	 */
	private Integer timeRemaining;

	/**
	 * Number of goal in a game session
	 */
	private Integer goal;

	/**
	 * Paused state of a game session
	 */
	private Boolean isPaused;

	/**
	 * Game over state of a game session
	 */
	private Boolean isOver;

	/**
	 * Collection of gamePlayers in a game session
	 */
	private final PlayerCollection gamePlayers;

	/**
	 * Constructor of SoccerGame
	 */
	public SoccerGame() {
		timeRemaining = 60;
		goal = 0;
		isPaused = false;
		isOver = false;
		SoccerBall.getSoccerBall().resetSoccerBall();
		PlayerFactory playerFactory = new PlayerFactory();
		gamePlayers = new PlayerCollection();
		gamePlayers.add(playerFactory.getPlayer("striker"));
		gamePlayers.add(playerFactory.getPlayer("goalkeeper"));
		startGame();
	}

	/**
	 * Initiates the soccer game.
	 */
	private void startGame() {
		Timer timer = new Timer();
		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				if (!isPaused()) {
					if (getTimeRemaining() <= 0) {
						setOver(true);
						timer.cancel();
					} else {
						setTimeRemaining(getTimeRemaining() - 1);
					}
					if (isScored()) {
						setPaused(true);
						setGoal(getGoal() + 1);
						getActivePlayer().setPlayerStatistics(getActivePlayer().getPlayerStatistics() + 1);
						getGamePlayers().get("Striker").setInitialPosition();
						SoccerBall.getSoccerBall().resetSoccerBall();
					} else {
						automateGoalkeeper();
					}
				}
			}
		};
		timer.schedule(timerTask, 1000, 1000);
	}

	/**
	 * Returns the time remaining.
	 * @return the time remaining.
	 */
	public Integer getTimeRemaining() {
		return timeRemaining;
	}

	/**
	 * Sets the time remaining to the parameter value
	 * @param timeRemaining the time remaining to set
	 */
	public void setTimeRemaining(Integer timeRemaining) {
		this.timeRemaining = timeRemaining;
	}

	/**
	 * Returns the number of goal.
	 * @return the number of goal
	 */
	public Integer getGoal() {
		return goal;
	}

	/**
	 * Set the number of goal to the parameter value
	 * @param newGoal new goal number to set
	 */
	public void setGoal(Integer newGoal) {
		goal = newGoal;
	}

	/**
	 * Returns true if the game is in paused state.
	 * @return true if the game is in paused state
	 */
	public Boolean isPaused() {
		return isPaused;
	}

	/**
	 * Set the paused state to the parameter boolean value
	 * @param paused boolean value to set paused state
	 */
	public void setPaused(Boolean paused) {
		isPaused = paused;
	}

	/**
	 * Returns the game over state.
	 * @return the game over state
	 */
	public Boolean isOver() {
		return isOver;
	}

	/**
	 * Set the game over state to the parameter boolean value
	 * @param over boolean value to set game over state
	 */
	public void setOver(Boolean over) {
		isOver = over;
	}

	/**
	 * Returns gamePlayers PlayerCollection.
	 * @return gamePlayers PlayerCollection
	 */
	public PlayerCollection getGamePlayers() {
		return gamePlayers;
	}

	/**
	 * Automates Goalkeeper to grab and shoot the soccer ball back if the ball is caught and score or to keep moving
	 */
	public void automateGoalkeeper() {
		SoccerBall soccerBall = SoccerBall.getSoccerBall();
		Goalkeeper goalkeeper = (Goalkeeper) gamePlayers.get("Goalkeeper");
		if (soccerBall.onGoalkeeperSide()) {
			goalkeeper.grabsBall();
			goalkeeper.shootBall();
			goalkeeper.setPlayerStatistics(goalkeeper.getPlayerStatistics() + 1);
		} else {
			goalkeeper.moveRandomly();
		}
	}

	/**
	 * Returns true if the soccer ball is in gate.
	 * @return true if the soccer ball is in gate
	 */
	public boolean isScored() {
		return SoccerBall.getSoccerBall().inGate();
	}

	/**
	 * Returns the Striker object in gamePlayers PlayerCollection.
	 * @return the Striker object in gamePlayers PlayerCollection
	 */
	public GamePlayer getActivePlayer() {
		return gamePlayers.get("Striker");
	}
}
