package mob;

import disposition.Hostile;
import model.Mob;

public class Troglodyte extends Mob{

	public Troglodyte(String name, int base_hp, int base_atk, int money) {
		super(name, base_hp, base_atk, money);
		setDisposition(new Hostile(this));
	}
	public Troglodyte(){
		super("Troglodyte", 30, 5, 5);
		setDisposition(new Hostile(this));
	}
	
	

}