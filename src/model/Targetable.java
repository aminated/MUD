package model;
import items.Item;
/**
 * Something that exists in a room but may not be picked up. e.g. door, chest, button, living creatures. 
 * 
 * @author Andrey Kuklev
 * @author Jeremy Bratton
 * @author Xiaoming Zhou
 * @author Zian Wang
 */
public interface Targetable {
	/**
	 * @return A single word naming the object. Used by players to reference it in the game. 
	 */
	public String getName();
	
	/**
	 * @return A description of the object. Printed when the room is looked at. 
	 */
	public String getDescription();
	
	/**
	 * Called when a player activates the object. Changes object state and possibly player state. 
	 * @return A brief message of what happened.
	 */
	public String activate(Player source);
	
	/**
	 * Called when a player uses an item on the object. 
	 * @return A brief message of what happened.
	 */
	public String useItem(Player source, Item tool);
	
}
