package mob;

import disposition.Hostile;
import model.Mob;

public class Vampire extends Mob{

	public Vampire(String name, int base_hp, int base_atk) {
		super(name, base_hp, base_atk);
		setDisposition(new Hostile(this));
	}
	public Vampire(){
		super("Vampire", 100, 15);
	}
	


}