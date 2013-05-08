package disposition;



import java.util.LinkedList;
import java.util.List;
import java.util.Random;
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
	private Random random = new Random();
	public Neutral(Living owner) {
		super(owner);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Alert this Disposition of an event that happened in the room. 
	 * @param event An Action just executed by another creature in the room. 
	 */
	public void notify(Action event){
		if(queue.size() == 0){
			Door choice = null;
			if(random.nextDouble() > 0.1) return; // Have it wait. 
			for(Targetable t : owner.getRoom().getContents())
				if(t instanceof Door)
					if(random.nextBoolean()){
						choice = (Door)t;
						break;
					}
			if(choice != null)
				addAction(new Action(owner, choice));
		}
	}
	
	/**
	 * Send this Disposition a string message. Not guaranteed to do anything. 
	 * @param message A string containing some kind of human readable text. 
	 */
	public void notify(String message){
		
	}
}


