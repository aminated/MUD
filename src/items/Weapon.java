package items;

import model.Living;
import model.Mob;
import model.Targetable;

/**
 * Weapons can be used on Players and Mobs.
 */
public abstract class Weapon extends Item {

	public Weapon(String name, String description, int weight, int usetime, int value) {
		super(name, description, weight, usetime, value);
		// TODO Auto-generated constructor stub
	}

	public Weapon() {

	}

	protected int atk;

	public String use(Living source) {
		source.sendMessage("Weapons need a target to use!") ;
		return "";
	}

	public int getAtkdmg() {
		return atk;
	}

	public String use(Living source, Mob target) {
		if (source.hasItem(this)) {
			usetime--;
			if (usetime == 0)
				source.removeItem(this);
			source.sendMessage("You use " + this.getName() + "!") ;
			return "";
		} else
			source.sendMessage("You do not have this item!");
			return "";
	}
}
