package items;

import model.Targetable;

/**
 * An Item is any non-Living object in the game that may be picked up. 
 */
public abstract class Item implements Targetable {
	private String name;
	private String description;
	public String activate(Living source){
		source.addItem(this);
	}
}
