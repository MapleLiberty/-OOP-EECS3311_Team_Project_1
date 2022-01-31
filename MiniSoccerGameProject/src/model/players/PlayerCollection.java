package model.players;
import java.util.*;


/**
 * The Collection class that handles multiple GamePlayer objects.
 * @author Group 1
 *
 */
public class PlayerCollection implements Collection<GamePlayer>{

	/**
	 * ArrayList of game players.
	 */
	private ArrayList<GamePlayer> gamePlayers;
	
	/**
	 * Constructor of PlayerCollection
	 */
	public PlayerCollection() {
		this.gamePlayers = new ArrayList<GamePlayer>();
	}
	
	/**
	 * Returns the GamePlayer object in the ArrayList that matches that parameter name
	 * @param playerName Name of the target game player
	 * @return the GamePlayer object in the ArrayList that matches that parameter name
	 */
	public GamePlayer get(String playerName) {
		int i;
		int index = 0;
		for(i = 0; i < gamePlayers.size(); i++) 
			if(gamePlayers.get(i).getPlayerName() == playerName) {
				index = i;
				break;
			}
			
		return gamePlayers.get(index);
	}
	
	/**
	 * Returns the gamePlayers ArrayList.
	 * @return the gamePlayers ArrayList
	 */
	public ArrayList<GamePlayer> getGamePlayers(){
		return this.gamePlayers;
	}

	/**
	 * Returns the iterator, PlayerCollectionIterator instance, of PlayerCollection.
	 * @return the iterator, PlayerCollectionIterator instance, of PlayerCollection
	 */
	public Iterator<GamePlayer> iterator() {
		return new PlayerCollectionIterator(getGamePlayers());
	}
	
	/**
	 * Sorts the gamePlayers ArrayList according to the PlayerStatistics of GamePlayer instances in descending order
	 */
	public void sort() {
		for(int i = 0; i < gamePlayers.size(); i++)
			for(int j = 0; j < gamePlayers.size() - 1 - i; j++)
				if(gamePlayers.get(j).compareTo(gamePlayers.get(j+1)) == 1) 
					Collections.swap(gamePlayers, j, j+1);
	}
	
	/**
	 * Returns the number of gamePlayer objects in the gamePlayers arrayList.
	 * @return the number of gamePlayer objects in the gamePlayers arrayList
	 */
	public int size() {
		return this.gamePlayers.size();
	}
	
	/**
	 * Returns the target gamePlayer object in the gamePlayers arrayList according to the parameter index.
	 * @param i the target index of gamePlayer object in the gamePlayers arrayList
	 * @return the target gamePlayer object in the gamePlayers arrayList according to the parameter index
	 */
	public GamePlayer getGamePlayer(int i) {
		return this.gamePlayers.get(i);
	}

	/**
	 * Adds an GamePlayer object to the arrayList and returns true if the parameter object is sueccessfully added to the arrayList.
	 * @return true if the parameter object is successfully added to the arrayList
	 */
	@Override
	public boolean add(GamePlayer e) {
		return this.gamePlayers.add(e);
	}

	/**
	 * Adds a collection to the arrayList and returns true if the parameter collection is successfully added to the arrayList
	 * @return true if the parameter collection is successfully added to the arrayList
	 */
	@Override
	public boolean addAll(Collection<? extends GamePlayer> c) {
		return this.gamePlayers.addAll(c);
	}

	/**
	 * remove all objects in the gamePlayers ArrayList
	 */
	@Override
	public void clear() {
		this.gamePlayers.clear();
	}

	/**
	 * Returns true if gamePlayers ArrayList contains the parameter object.
	 * @return true if gamePlayers ArrayList contains the parameter object
	 */
	@Override
	public boolean contains(Object o) {
		return this.gamePlayers.contains(o);
	}

	/**
	 * Returns true if gamePlayers ArrayList contains all objects in the parameter collection.
	 * @return true if gamePlayers ArrayList contains all objects in the parameter collection
	 */
	@Override
	public boolean containsAll(Collection<?> c) {
		return this.gamePlayers.containsAll(c);
	}

	/**
	 * Returns true if gamePlayers ArrayList has no elements.
	 * @return true if gamePlayers ArrayList has no elements
	 */
	@Override
	public boolean isEmpty() {
		return this.gamePlayers.isEmpty();
	}

	/**
	 * Removes the parameter object from the gamePlayers ArrayList and returns true if the parameter object is successfully removed from the gamePlayers ArrayList
	 * @return true if the parameter object is successfully removed from the gamePlayers ArrayList
	 */
	@Override
	public boolean remove(Object o) {
		return this.gamePlayers.remove(o);
	}

	/**
	 * Removes all objects in the parameter collection from the gamePlayers ArrayList and returns true if all objects are successfully removed from the gamePlayers ArrayList
	 * @return true if all objects in the parameter collection are successfully removed from the gamePlayers ArrayList
	 */
	@Override
	public boolean removeAll(Collection<?> c) {
		return this.gamePlayers.removeAll(c);
	}

	/**
	 * Removes all objects that are not in the parameter collection from the gamePlayers ArrayList and returns true if all objects are successfully removed from the gamePlayers ArrayList
	 * @return true if all objects that are not in the parameter collection are successfully removed from the gamePlayers ArrayList
	 */
	@Override
	public boolean retainAll(Collection<?> c) {
		return this.gamePlayers.retainAll(c);
	}

	/**
	 * Converts the gamePlayers ArrayList to an array and return it
	 * @return the array converted from the gamePlayers ArrayList
	 */
	@Override
	public Object[] toArray() {
		return this.gamePlayers.toArray();
	}

	/**
	 * Put objects in the gamePlayers ArrayList in the parameter array and return it
	 * @return the parameter array that objects in the gamePlayers ArrayList are added
	 */
	@Override
	public <T> T[] toArray(T[] a) {
		return this.gamePlayers.toArray(a);
	}

}
