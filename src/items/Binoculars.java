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
	}


	

	
	@Override
	public String useItem(Living source, Item tool) {
		
		//source.getRoom()
		return null;
		
	}

}
