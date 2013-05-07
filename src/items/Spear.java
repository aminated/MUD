package items;

import model.Living;
import model.Targetable;

public class Spear extends Weapon {

	public Spear() {
		name = "Spear";
		description = "Spear is a disposable weapon which can cause little damage.";
		weight = 10;
		usetime = 1;
		atk = 25;
		value = 150;
	}
}
