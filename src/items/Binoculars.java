package items;

import model.Living;
import model.Room;

/**
 * Binoculars allow someone to view any room nearby.
 */
public class Binoculars extends Item {



	
		
	public Binoculars(){
		name = "Binoculars";
		description = "Binoculars allow someone to view any room nearby.";
		weight = 5;
		usetime = 5;
		value = 100;
	}

// view any room nearby
	@Override
	public String use(Living source) {
		// TODO Auto-generated method stub
		return null;
	}

}
