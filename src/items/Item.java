package items;

import java.io.Serializable;

import model.Living;
import model.Targetable;

/**
 * An Item is any non-Living object in the game that may be picked up.
 */
public abstract class Item implements Targetable, Serializable {
	protected String name;
	protected String description;
	protected int weight;
	protected int usetime;
	private int value;

	public Item(String name, String description, int weight, int usetime, int value) {

		this.name = name;
		this.description = description;
		this.weight = weight;
		this.usetime = usetime;
		this.value = value;
	}

	public Item() {

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

	public int getUsetime() {
		return usetime;
	}

	public int getValue() {
		return value;
	}
	public String activate(Living source) {
		if (!source.hasItem(this)) {
			return "You do not have this item!";
		} else {
			return use(source);

		}
	}

	public String dropItem(Living source) {
		source.removeItem(this);
		return "Drop " + name + " successfully!";
	}

	public String addItem(Living source) {
		source.addItem(this);
		return "Add " + name + " successfully!";
	}

	@Override
	public String useItem(Living source, Item tool) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * When someone types "use" with an item in their inventory. Ex: use
	 * Health-potion
	 * 
	 * @param source
	 *            The owner of the item
	 * @return A public string about what happened.
	 */
	public abstract String use(Living source);

}
