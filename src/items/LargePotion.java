package items;

import model.Living;

/**
 * A large potion can heal the player 50HP who is injured.
 */
public class LargePotion extends Item {

	public LargePotion() {
		name = "Large Potion";
		description = "A large potion can heal the player's 50HP who is injured.";
		weight = 5;
		usetime = 1;
		value = 100;
	}

	@Override
	public String use(Living source) {
			source.heal(50);
			source.removeItem(this);
			source.sendMessage("You recover 50HP!") ;
			return "";
		}
		
	}
	