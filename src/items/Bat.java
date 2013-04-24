package items;

import model.Living;

/**
 * The baseball Bat is an average melee Weapon.
 */
public class Bat extends Weapon {

	public Bat() {
		// TODO Auto-generated constructor stub
		name = "Bat";
		description = "The baseball Bat is an average melee Weapon.";
		weight = 10;
		atk = 5;
		usetime = 30;
	}

	@Override
	public String use(Living source) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
