package mob;

import disposition.Hostile;
import model.Mob;

public class Tauren extends Mob{

	public Tauren(String name, int base_hp, int base_atk, int money) {
		super(name, base_hp, base_atk, money);
		setDisposition(new Hostile(this));
	}
	public Tauren(){
		super("Tauren", 200, 20, 50);
		setDisposition(new Hostile(this));
	}

}