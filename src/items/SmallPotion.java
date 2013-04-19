package items;

import model.Living;

/**
 * A small potion can heal the player 25HP who is injured.
 */
public class SmallPotion extends Item {

	public SmallPotion() {
		name = "Small Potion";
		description = "A small potion can heal the player 25HP who is injured.";
		weight = 2;
	}

	@Override
	public String useItem(Living source, Item tool) {
		// TODO Auto-generated method stub
		// Living's HP increases 25
		return "HP recovers 25!";
	}

	
}
