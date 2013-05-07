package items;

import model.Living;
import model.Targetable;
import items.Weapon;

/**
 * The baseball Bat is an average melee Weapon.
 */
public class Bat extends Weapon {

	
	public Bat() {
		name = "Bat";
		description = "The baseball Bat is an average melee Weapon.";
		weight = 10;
		usetime = 30;
		atk = 10;
		value= 50;
	}

	
	

}
