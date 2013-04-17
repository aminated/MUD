package items;

import model.Living;

/**
 * Binoculars allow someone to view any room nearby.
 */
public class Binoculars extends Item {

	public Binoculars() {
		// TODO Auto-generated constructor stub
		name = "Binoculars";
		description = " Binoculars allow someone to view any room nearby.";
		weight = 5;
	}

	@Override
	public String useItem(Living source, Item tool) {
		// TODO Auto-generated method stub
		return null;
	}
}
