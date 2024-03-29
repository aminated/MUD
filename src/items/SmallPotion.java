package items;

import model.Living;

/**
 * A small potion can heal the player 25HP who is injured.
 */
public class SmallPotion extends Item {

	public SmallPotion() {
		name = "Small Potion";
		description = "A small potion can heal the player's 25HP who is injured.";
		weight = 2;
		usetime =1;
		value = 50;
	}


	@Override
	public String use(Living source) {
			source.heal(25);
			source.removeItem(this);
			source.sendMessage("You recover 25HP!") ;
			return "";
	}
	
}
