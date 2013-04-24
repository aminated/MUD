package mob;

import disposition.Hostile;
import model.Mob;

public class Tauren extends Mob{

	public Tauren(String name, int base_hp, int base_atk) {
		super(name, base_hp, base_atk);
		setDisposition(new Hostile(this));
	}
	public Tauren(){
		super("Tauren", 200, 20);
	}

}