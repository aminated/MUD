package items;

import model.Living;

/**
 * The Hammer is the worst melee Weapon in the game but it can also be used with
 * wood to block windows and door exits of buildings.
 */
public class Hammer extends Weapon {

	public Hammer(){
		
		name = "Hammer";
		description = "The Hammer is the worst melee Weapon in the game but it can also be used with wood to block windows and door exits of buildings.";
		weight = 20;
		atk = 10;
		usetime = 30;
	}
		// TODO Auto-generated constructor stub
	public String use(Living source) {
		// TODO Auto-generated method stub
			return null;
		}
}
