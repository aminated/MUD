package model;

import java.util.LinkedList;
import java.util.List;

import items.Item;

public class Chest implements Targetable {
	private List<Item> items = new LinkedList<Item>();
	private String contentsToString(){
		String output = "";
		for(Item item : items){
			output += item.getName() + ", ";
		}
		output= output.substring(output.length() - 2) + "."; // Remove last comma. 
		return output;
	}
	@Override
	public String getName() {
		return "chest";
	}
	@Override
	public String getDescription() {
		String description = "A chest containing: " + contentsToString();
		return description;
		// Remove last comma. 
	}

	@Override
	public String activate(Living source) {
		for(Item item: items)
		source.addItem(item);
		items = new LinkedList<Item>();
		return " picked up: " + contentsToString();
	}

	@Override
	public String useItem(Living source, Item tool) {
		source.removeItem(tool);
		items.add(tool);
		return "You added " + tool.getName() + " to the chest.";
	}

}
