package model;
import items.Item;
import items.Weapon;
/**
 * Something that exists in a room but may not be picked up. e.g. door, chest, button, living creatures. 
 * 
 * @author Andrey Kuklev
 * @author Jeremy Bratton
 * @author Xiaoming Zhou
 * @author Zian Wang
 */
public interface Targetable{
	/**
	 * @return A single word naming the object. Used by players to reference it in the game. 
	 */
	public String getName();
	
	/**
	 * @return A description of the object. Printed when the room is looked at. 
	 */
	public String getDescription();
	
	
	
	/**
	 * Called when a creature activates the object. Changes object state and possibly creature state.
	 * To notify the creature of what happened in private, use source.sendMessage() 
	 * @return A brief message of what happened, directed to everyone. 
	 */
	public String activate(Living source);
	
	/**
	 * Called when a creature uses an item on the object. 
	 * @return A brief message of what happened, directed to everyone.
	 */
	public String useItem(Living source, Item tool);
	
	//public String useItem(Item tool);
	//Targetables and items cannot be expected to do things on their own. Need a Living for that.
	//Example: Door.useItem(Key)? Who opened it?
}
