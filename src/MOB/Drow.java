package mob;

import disposition.Hostile;
import model.Mob;

public class Drow extends Mob{

	public Drow(String name, int base_hp, int base_atk, int money) {
		super(name, base_hp, base_atk, money);
		setDisposition(new Hostile(this));
	}
	public Drow(){
		super("Drow", 50, 20, 50);
	}
	


}