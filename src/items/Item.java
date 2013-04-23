package items;

import model.Living;
import model.Targetable;

/**
 * An Item is any non-Living object in the game that may be picked up.
 */
public abstract class Item implements Targetable {
	protected String name;
	protected String description;
	protected int weight;
	public Item(String name, String description, int weight){
		this.name = name;
		this.description = description;
		this.weight = weight;
	}
	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public int getWeight() {
		return weight;
	}

	public String activate(Living source) {
		source.addItem(this);
		return "Add " + name + " successfully!";
	}
	public String dropItem(Living source){
		source.removeItem(this);
		return "Drop "+ name + " successfully!";
	}
}
