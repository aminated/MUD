package model;

import java.util.List;

/**
 * A strategy for Mobs
 */
public abstract class Disposition {
	private List<Action> queue;
	private Living owner;
	public void doNext(){
		if(!queue.isEmpty()){
			Action action = queue.get(0);
			Room location = owner.getRoom();
			location.announce(action.execute());
		}
	}
}
