package disposition;



import java.util.LinkedList;
import java.util.List;

import model.Action;
import model.Door;
import model.Living;
import model.Player;
import model.Room;
import model.Targetable;


/**
 * Neutral Mobs wander the World and don't attack unless provoked.
 */
public class Neutral extends Disposition {
	protected List<Action> queue = new LinkedList<Action>();
	protected Living owner;
	protected void addAction(Action todo){
		queue.add(todo);
	}
	public Neutral(Living owner){
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
		else 
			leave();
	}
	/**
	 * Look for Mobs or player in the same room to attack.
	 * 
	 */
	
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


