package items;

import model.Living;

/**
 * The Handgun deals the least amount of damage among all projectile based
 * Weapons but has a decent sized magazine and is the most common.
 */
public class Handgun extends Weapon {

	public Handgun(){

	
		name = "Handgun";
		description = "The Handgun deals the least amount of damage among all projectile based Weapons but has a decent sized magazine and is the most common.";
		weight = 15;
		atk = 20;
		usetime = 20;
	
	}
	public String use(Living source) {
		// TODO Auto-generated method stub
			return null;
		}
}
