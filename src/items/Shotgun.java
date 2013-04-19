package items;

import model.Living;

/**
 * The Shotgun is very powerful, but is almost useless when firing in to a
 * nearby Room.
 */
public class Shotgun extends Weapon {

	public Shotgun() {
		// TODO Auto-generated constructor stub
		name = "Shotgun";
		description = "The Shotgun is very powerful, but is almost useless when firing in to a nearby Room.";
		weight = 30;
		atk = 40;
		usetime = 10;
	}
	
}
