package items;

import model.Living;

/**
 * A large potion can heal the player 50HP who is injured.
 */
public class LargePotion extends Item {

	public LargePotion() {
		name = "Large Potion";
		description = "A large potion can heal the player 50HP who is injured.";
		weight = 5;
		usetime = 1;
	}

	@Override
	public String useItem(Living source, Item tool) {
		// TODO Auto-generated method stub
		// Living's HP increases 50
		return "HP recovers 50!";
	}

	
}
