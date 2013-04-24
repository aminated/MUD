package mob;

import disposition.Hostile;
import model.Mob;

public class Drow extends Mob{

	public Drow(String name, int base_hp, int base_atk) {
		super(name, base_hp, base_atk);
		setDisposition(new Hostile(this));
	}
	public Drow(){
		super("Drow", 50, 20);
	}
	


}