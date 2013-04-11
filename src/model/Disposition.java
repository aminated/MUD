package model;

import java.util.LinkedList;
import java.util.List;

/**
 * A strategy for Mobs and players.
 * This is where all commands come from. This class is responsible for coming up with new Actions and adding them
 * to its private queue, to be executed on the next tick. How it comes up with the Actions is up to the specific subclass.
 * We may want subclasses of this to be separate threads so they can run concurrently with the timer. 
 */
public abstract class Disposition {
	protected List<Action> queue = new LinkedList<Action>();
	protected Living owner;
	public boolean hasNext(){
		return !queue.isEmpty();
	}
	public void doNext(){
		if(!queue.isEmpty()){
			Action action = queue.get(0);
			Room location = owner.getRoom();
			location.announce(action.execute());
		}
	}
}
