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
	protected int usetime;

	public Item(String name, String description, int weight, int usetime){
		this.name = name;
		this.description = description;
		this.weight = weight;
		this.usetime = usetime;
	}
	public Item(){
		
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

	public String activate(Living source) {
		source.addItem(this);
		return "Add " + name + " successfully!";
	}
	public String dropItem(Living source){
		source.removeItem(this);
		return "Drop "+ name + " successfully!";
	}
	public String useItem(Living source, Item tool) {
		// TODO Auto-generated method stub
		if(tool.getUsetime()!=0){
			usetime--;
			return "You use "+ tool.getName()+ " !";}
			else
				return "You cannot use it!";
		}
	}

