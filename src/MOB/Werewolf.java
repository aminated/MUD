package mob;

import disposition.Hostile;
import model.Mob;

public class Werewolf extends Mob{

	public Werewolf(String name, int base_hp, int base_atk, int money) {
		super(name, base_hp, base_atk, money);
		setDisposition(new Hostile(this));
	}
	public Werewolf(){
		super("Werewolf", 100, 15, 30);
	}
	

}