package disposition;

import items.Item;
import model.Action;
import model.Door;
import model.Living;
import model.Player;
import model.Targetable;

public class Healer extends Friendly{

	public Healer(Living owner) {
		super(owner);
		// TODO Auto-generated constructor stub
	}
	/**
	 * Look for Mobs or player in the same room to attack.
	 * 
	 */
	@Override
	public void attack(){
		Targetable prey=owner.getRoom().seek();
		if (prey==null || prey instanceof Item)
			leave();	// If the room is empty (A room without door, weird) or prey is not living thing, Mob leaves this room.
		else
		if (prey instanceof Living)
			if (prey instanceof Player)
				addAction( new Action(owner, prey));
			else
				if (((Living) prey).getDisposition() instanceof Hostile)
					addAction( new Action(owner, prey));
		
	}
	
	/**
	 * Alert this Disposition of an event that happened in the room. 
	 * @param event An Action just executed by another creature in the room. 
	 */
	@Override
	public void notify(Action event){
		if(event.getSource().getDisposition() instanceof Hostile && event.getTarget() instanceof Door) // Otherwise Mobs will fight each other
			  if( event.getSource().getRoom().equals(owner.getRoom() ) )// Make sure it's not them leaving the room.
				  addAction( new Action(owner, event.getSource()));  // Attack whoever entered the room
	}

}
