package model.players;

import java.util.ArrayList;
import java.util.Iterator;


/**
 * The Iterator class that provides iterator for PlayerCollection class.
 * @author Group 1
 *
 */
public class PlayerCollectionIterator implements Iterator<GamePlayer>  {

	/**
	 *  ArrayList of game players to be iterated
	 */
	private ArrayList<GamePlayer> gamePlayers;
	
	/**
	 * Int value position of current iterator
	 */
	private int position = 0;
	
	/**
	 * Constructor of PlayerCollectionIterator
	 * @param p ArrayList to be iterated
	 */
	public PlayerCollectionIterator(ArrayList<GamePlayer> p) {
		gamePlayers = p;
	}
	
	/**
	 * Returns true if next element in the ArrayList exists.
	 * @return true if next element in the ArrayList exists.
	 */
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		if (position < gamePlayers.size()) {
			return true;
		} 
		else {
			return false;
		}
	}

	/**
	 * Returns next GamePlayer element in the ArrayList.
	 * @return next GamePlayer element in the ArrayList
	 */
	@Override
	public GamePlayer next() {
		// TODO Auto-generated method stub
		if (this.hasNext()) {
			return gamePlayers.get(position++);
		}
		return null;
	}


}
