package model;

import items.Item;

import java.util.LinkedList;
import java.util.List;

/**
 * Hostile Mobs will always attack
 */
public class Hostile extends Disposition {
	protected List<Action> queue = new LinkedList<Action>();
	protected Living owner;
	protected void addAction(Action todo){
		queue.add(todo);
	}
	public Hostile(Living owner){
		super(owner);
	}
	public boolean hasNext(){
		return !queue.isEmpty();
	}
	public void doNext(){
		if(!queue.isEmpty()){
			Action action = queue.get(0);
			Room location = owner.getRoom();
			action.execute();
			queue.remove(0);
			location.announce(action);
		}
		else{
			attack();	// If action list is empty, attack something in the room.
		}
	}
	/**
	 * Look for Mobs or player in the same room to attack.
	 * 
	 */
	public void attack(){
		Targetable prey=owner.getRoom().seek();
		if (prey==null || prey instanceof Item)
			leave();	// If the room is empty (A room without door, weird) or prey is not living thing, Mob leaves this room.
		else{
			addAction( new Action(owner, prey));
		}
	}
	public void leave(){
		Targetable target=owner.getRoom().seek();
		if (target instanceof Door)
			addAction( new Action(owner, target));	// If Mob find a door, it can leave. Otherwise, it stays in the room
	}
	
	/**
	 * Alert this Disposition of an event that happened in the room. 
	 * @param event An Action just executed by another creature in the room. 
	 */
	public void notify(Action event){
		if(event.getSource() instanceof Player && event.getTarget() instanceof Door) // Otherwise Mobs will fight each other
			  if( event.getSource().getRoom().equals(owner.getRoom() ) )// Make sure it's not them leaving the room.
				  addAction( new Action(owner, event.getSource()));  // Attack whoever entered the room
	}
	
	/**
	 * Send this Disposition a string message. Not guaranteed to do anything. 
	 * @param message A string containing some kind of human readable text. 
	 */
	public void notify(String message){
		
	}
}

