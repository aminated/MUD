package model;

/**
 * A very simple example disposition. Follows the player around wherever he/she goes. 
 * @author Andrey
 *
 */
public class CompanionDisposition extends Disposition {

	public CompanionDisposition(Living owner) {
		super(owner);
	}

	@Override
	public void notify(Action event) {
		// Get properties of the event(Action). 
		Living source = event.getSource();
		Targetable target = event.getTarget();
		// Is the event the player going through a door? 
		if(source instanceof Player && target instanceof Door){
			// Did they leave? (are they now in another room?)
			if(!source.getRoom().equals(owner.getRoom())){
				// Follow them. 
				this.addAction(new Action(owner, target));
			}
		}
	}

	@Override
	public void notify(String message) {
		// Do nothing. MOBs can't read strings. 
	}

}
