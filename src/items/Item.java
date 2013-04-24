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
	public Item(){
		
	}
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
		if(!source.hasItem(this)){
			source.addItem(this);
			return "Add " + name + " successfully!";
		}
		else{
			return use(source);
		}
	}
	public String dropItem(Living source){
		source.removeItem(this);
		return "Drop "+ name + " successfully!";
	}
	/**
	 * When someone types "use" with an item in their inventory. 
	 * Ex: use Health-potion
	 * @param source The owner of the item
	 * @return A public string about what happened.
	 */
	public abstract String use(Living source);
	
}
