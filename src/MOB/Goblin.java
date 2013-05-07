package mob;

import disposition.Hostile;
import model.Mob;

public class Goblin extends Mob{

	public Goblin(String name, int base_hp, int base_atk, int money) {
		super(name, base_hp, base_atk, money);
		setDisposition(new Hostile(this));
	}
	public Goblin(){
		super("Goblin", 15, 5, 10);
		setDisposition(new Hostile(this));
	}

}