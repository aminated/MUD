package items;

import model.Living;

/**
 * The Rifle is the most accurate and powerful ranged Weapon, but has a small
 * magazine size, is loud, and is very rare.
 */
public class Rifle extends Weapon {

	public Rifle() {
		name = "Rifle";
		description = "The Rifle is the most accurate and powerful ranged Weapon, but has a small magazine size,is loud, and is very rare.";
		weight = 35;
		atk =50;
		usetime = 10;
		// TODO Auto-generated constructor stub
	}
	public String use(Living source) {
		// TODO Auto-generated method stub
			return null;
		}
}
