package items;

import model.Living;

/**
 * The Sword is the best melee Weapon in the game and has high chance to kill
 * with one hit.
 */
public class Sword extends Weapon {

	public Sword() {
		super();
		name = "Sword";
		description = "The Sword is the best melee Weapon in the game and has high chance to kill with one hit.";
		weight = 20;
		atk = 15;
		usetime = 30;
	}
	public String use(Living source) {
		// TODO Auto-generated method stub
			return null;
		}

	// public killwithonehit()

}
