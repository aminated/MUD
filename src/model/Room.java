package model;

import java.util.LinkedList;
import java.util.List;

/**
 * A Room is exactly that, a room. It can hold Living and Items and can have
 * up to four exits.
 */
public class Room {
	private List<Targetable> contents = new LinkedList<Targetable>();
	private String description;
	public Room(String description){
		this.description = description;
	}
	public String describe(){
		String output = description;
		output += "The room has: \n";
		for(Targetable thing: contents){
			output += thing.getName() + ":" + thing.getDescription() + "\n";
		}
		return output;
	}
	public void add(Targetable thing){
		contents.add(thing);
	}
	public void remove(Targetable thing){
		contents.remove(thing);
	}
	public void connect(Room other, Direction d){
		Door exit = new Door(this, other, d);
		Door entrance = new Door(other, this, d.turnBack());
		this.add(exit);
		other.add(entrance);
	}
	public Targetable getByName(String name){
		for(Targetable thing: contents){
			if(thing.getName().equals(name))
				return thing;
		}
		return null;
	}
	/**
	 * Notifies everyone in the room of something. 
	 * @param event An action that was executed by someone in the room. 
 	 */
	public void announce(Action event){
		for(Targetable thing: contents){
			// TODO : Make this more typesafe. 
			if(thing instanceof Living){
				Living creature = (Living) thing;
				creature.sendMessage(event);
			}
		}
	}
	public void announce(String message){
		for(Targetable thing: contents){
			// TODO : Make this more typesafe. 
			if(thing instanceof Living){
				Living creature = (Living) thing;
				creature.sendMessage(message);
			}
		}
	}
}
