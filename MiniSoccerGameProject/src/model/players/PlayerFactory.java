package model.players;

import java.awt.*;


/**
 * Factory class of GamePlayer. It creates GamePlayer objects.
 * @author Group 1
 *
 */
public class PlayerFactory {
	/**
	 * Returns the GamePlayer object that matches the parameter GamePlayer type.
	 * @param player type of GamePlayer to be created
	 * @return the GamePlayer object that matches the parameter GamePlayer type.
	 */
	public GamePlayer getPlayer(String player) {
		if (player == null) {
			return null;
		}
		
		if (player.equalsIgnoreCase("STRIKER")) {
			return new Striker("Striker", Color.blue);
		}
		
		if (player.equalsIgnoreCase("GOALKEEPER")) {
			return new Goalkeeper("Goalkeeper", Color.yellow);
		}
		
		return null;
	}
}
