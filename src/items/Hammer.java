package items;

import model.Living;
import model.Targetable;

/**
 * The Hammer is the worst melee Weapon in the game but it can also be used with
 * wood to block windows and door exits of buildings.
 */
public class Hammer extends Weapon {

	private Sledgehammer Sledgehammer;
	public Hammer(){
		
		name = "Hammer";
		description = "The Hammer is the worst melee Weapon in the game but it can also be used with wood to forge the sledgehammer.";
		weight = 20;
		atk = 8;
		usetime = 30;
		value = 50;
	}
	public String useItem(Living source, Wood Wood) {
		source.removeItem(this);
		source.removeItem(Wood);
		source.addItem(Sledgehammer);
		return "You forged items successfully!";
	}

	
}
