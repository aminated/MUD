package items;

import model.Living;


/**
 * Binoculars allow someone to view any room nearby.
 */
public class Binoculars extends Item{

	

	public Binoculars(String name, String description, int weight) {
		super(name, description, weight);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String useItem(Living source, Item tool) {
		// TODO Auto-generated method stub
		return null;
	}
}
