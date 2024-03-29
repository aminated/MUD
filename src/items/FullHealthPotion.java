package items;

import model.Living;

/**
 * A Full health potion can heal the player 50HP who is injured.
 */
public class FullHealthPotion extends Item {

	public  FullHealthPotion() {
		name = " Full Health Potion";
		description = "A  FullHealth Potion can heal the player's full health who is injured.";
		weight = 5;
		usetime = 1;
		value = 200;
	}

	@Override
	public String use(Living source) {
		int heal = source.getMaxhp();
			source.heal(heal);
			source.removeItem(this);
			source.sendMessage("You HP is full!") ;
			return "";
		}
		
	}
	