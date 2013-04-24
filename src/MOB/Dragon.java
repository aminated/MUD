package mob;

import disposition.Hostile;
import model.Mob;

/**
 * A Dragon is a very strong Mob that will attack players in the same room. Rich loot.
 * 
 */
public class Dragon extends Mob{

	public Dragon(String name, int base_hp, int base_atk, int money) {
		super(name, base_hp, base_atk, money);
		setDisposition(new Hostile(this));
	}
	public Dragon(){
		super("Dragon",	500, 50, 500);
	}
	
	

}
