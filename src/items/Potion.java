package items;

import model.Living;

/**
 * A potion can heal the player 50HP who is injured.
 */
public class Potion extends Item {

	public Potion() {
		name = "Potion";
		description = "A potion can heal the player 50HP who is injured.";
		weight = 3;
	}

	@Override
	public String useItem(Living source, Item tool) {
		// TODO Auto-generated method stub
		// Living's HP increases 50
		return "HP recovers 50!";
	}
}
