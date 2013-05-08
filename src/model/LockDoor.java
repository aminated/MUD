package model;

import items.DoorKey;
import items.Item;

public class LockDoor extends Door {
	private String label;
	private boolean locked;
	public String getName(){
		return super.getName() + "-" + label;
	}
	public String getDescription(){
		return super.getDescription() + " with a " + label + " lock. ";
	}
	public LockDoor(Room source, Room dest, Direction d, String label) {
		super(source, dest, d);
		locked = true;
		// TODO Auto-generated constructor stub
	}
	public String activate(Living source){
		if(!locked)
			return super.activate(source);
		else{
			source.sendMessage("The door is locked. Find a " + label + " key.");
			return "";
		}
	}
	public String useItem(Living source, Item tool){
		if(tool instanceof DoorKey){
			DoorKey key = (DoorKey) tool;
			if(key.getLabel().equals(label)){
			locked = (!locked);
			String word = locked ? " locked " : " unlocked ";
			return source.getName() + word + getName();
			}
			else
				source.sendMessage("Wrong key.");
		}
		else{
			source.sendMessage("Only keys can be used on doors.");
		}
		return "";
	}
}
