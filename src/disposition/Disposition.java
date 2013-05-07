package disposition;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import model.Action;
import model.Living;
import model.Room;

/**
 * A strategy for Mobs and players.
 * This is where all commands come from. This class is responsible for coming up with new Actions and adding them
 * to its private queue, to be executed on the next tick. How it comes up with the Actions is up to the specific subclass.
 * The disposition will be notified of Actions that take place in the room by notify() method. 
 * We may want subclasses of this to be separate threads so they can run concurrently with the timer. 
 */
public abstract class Disposition implements Serializable{
	protected List<Action> queue = new LinkedList<Action>();
	protected Living owner;
	protected void addAction(Action todo){
		queue.add(todo);
	}
	public Disposition(Living owner){
		this.owner = owner;
	}
	
	public Living getOwner(){
		return owner;
	}
	public boolean hasNext(){
		return !queue.isEmpty();
	}
	public void doNext(){
		if(!queue.isEmpty()){
			Action action = queue.get(0);
			Room location = owner.getRoom();
			action.execute();
			Room new_location = owner.getRoom();
			queue.remove(0);
			location.announce(action);
			
			if(!new_location.equals(location)) new_location.announce(action);
		}
	}
	/**
	 * Alert this Disposition of an event that happened in the room. 
	 * @param event An Action just executed by another creature in the room. 
	 */
	public abstract void notify(Action event);
	
	/**
	 * Send this Disposition a string message. Not guaranteed to do anything. 
	 * @param message A string containing some kind of human readable text. 
	 */
	public abstract void notify(String message);
}
