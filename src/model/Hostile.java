package model;

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
	}
	/**
	 * Alert this Disposition of an event that happened in the room. 
	 * @param event An Action just executed by another creature in the room. 
	 */
	public void notify(Action event){
		
	}
	
	/**
	 * Send this Disposition a string message. Not guaranteed to do anything. 
	 * @param message A string containing some kind of human readable text. 
	 */
	public void notify(String message){
		
	}
}
