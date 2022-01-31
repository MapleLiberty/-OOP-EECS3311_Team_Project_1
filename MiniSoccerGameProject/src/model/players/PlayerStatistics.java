package model.players;


/**
 * The class that represents the score of each GamePlayer object. The number of caught goal for Goalkeeper and the number of goal for Striker.
 * @author Group 1
 *
 */
public class PlayerStatistics {

	/**
	 * Number of goal(Striker) or caught ball(Goalkeeper)
	 */
	protected int stat = 0;
	
	/**
	 * Returns current statistics value.
	 * @return current statistics value
	 */
	public Integer getStatistics() {
		// TODO Auto-generated method stub
		return stat;
	}

	/**
	 * Sets the stat field to the parameter Integer value.
	 * @param newStatistics new stat to be set
	 */
	public void setStatistics(Integer newStatistics) {
		// TODO Auto-generated method stub
		stat = newStatistics;
	}
	
	/**
	 * Returns the information of PlayerStatistics
	 * @return the information of PlayerStatistics
	 */
	public String toString() {
		return String.format("%d", stat);
	}

}
