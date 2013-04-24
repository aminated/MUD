package mob;

import disposition.Hostile;
import model.Mob;

public class Troll extends Mob{

	public Troll(String name, int base_hp, int base_atk) {
		super(name, base_hp, base_atk);
		setDisposition(new Hostile(this));
	}
	public Troll(){
		super("Troll", 120, 15);
	}
	
	

}