package mob;

import disposition.Hostile;
import model.Mob;
/**
 * A Zombie is a weak Mob that will attack players in the same room. Easy to kill and few loot.
 * 
 */
public class Zombie extends Mob{

	public Zombie(String name, int base_hp, int base_atk, int money) {
		super(name, base_hp, base_atk, money);
		setDisposition(new Hostile(this));
	}
	public Zombie(){
		super("zombie",	15, 5, 5);
		setDisposition(new Hostile(this));
	}
	
	

}
