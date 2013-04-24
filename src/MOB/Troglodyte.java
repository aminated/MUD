package mob;

import disposition.Hostile;
import model.Mob;

public class Troglodyte extends Mob{

	public Troglodyte(String name, int base_hp, int base_atk) {
		super(name, base_hp, base_atk);
		setDisposition(new Hostile(this));
	}
	public Troglodyte(){
		super("Troglodyte", 30, 5);
	}
	
	

}