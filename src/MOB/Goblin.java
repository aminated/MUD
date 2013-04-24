package mob;

import disposition.Hostile;
import model.Mob;

public class Goblin extends Mob{

	public Goblin(String name, int base_hp, int base_atk) {
		super(name, base_hp, base_atk);
		setDisposition(new Hostile(this));
	}
	public Goblin(){
		super("Goblin", 150, 25);
	}

}