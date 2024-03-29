package model;

import java.io.Serializable;

import items.Item;

public class Door implements Targetable, Serializable{
	private Room source;
	private Room dest; 
	private Direction sourceDir; // Door's position in the source room.
	private Direction destDir; // Door's position in the destination room. 
	public Room getDest(){
		return dest;
	}
	public Door(Room source, Room dest, Direction d){
		this.source = source;
		this.dest = dest;
		sourceDir = d;
		destDir = d.turnBack();
	}
	/**
	 * Specify the destination position explicitly. 
	 * For when you want to ignore the rules of geometry. Portals, elevators and such. 
	 * @param d The door's position in the destination room. 
	 */
	public void setDestDir(Direction d){
		destDir = d;
	}
	public String getName(){
		return sourceDir.toString() + "-door";
	}
	public String getDescription(){
		return "A door leading " + sourceDir.toString();
	}
	public String activate(Living creature){
		creature.setRoom(dest);
		creature.sendMessage("You go through the door leading " + sourceDir.toString());
		source.announce(creature.getName() + " left the room going " + sourceDir.toString());
		return creature.getName() + " entered the room from the " + destDir.toString();
	}
	public String useItem(Living creature, Item tool){
		return "";
	}
}
