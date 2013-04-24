package mob;

import disposition.Hostile;
import model.Mob;

public class Chimaera extends Mob{

	public Chimaera(String name, int base_hp, int base_atk) {
		super(name, base_hp, base_atk);
		setDisposition(new Hostile(this));
	}
	public Chimaera(){
		super("CHimaera", 150, 25);
	}

}