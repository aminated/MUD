package items;

import model.Living;
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
		return "Weapons need a target to use!";
	}

	public int getAtkdmg() {
		return atk;
	}

	public String use(Living source, Targetable target) {
		if (source.hasItem(this)) {
			target.useItem(source, this);
			usetime--;
			if (usetime == 0)
				source.removeItem(this);
			return "You use " + this.getName() + "!";
		} else
			return "You do not have this item!";
	}
}
