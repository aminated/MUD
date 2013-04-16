package items;

import model.Living;


/**
 * A potion can heal the player 30HP who is injured.
 */
public class Potion extends Item{

	public Potion(String name, String description, int weight) {
		super(name, description, weight);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String useItem(Living source, Item tool) {
		// TODO Auto-generated method stub
		return null;
	}
}
