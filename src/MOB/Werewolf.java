package mob;

import disposition.Hostile;
import model.Mob;

public class Werewolf extends Mob{

	public Werewolf(String name, int base_hp, int base_atk) {
		super(name, base_hp, base_atk);
		setDisposition(new Hostile(this));
	}
	public Werewolf(){
		super("Werewolf", 100, 15);
	}
	

}