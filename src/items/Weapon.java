package items;

import model.Living;
import model.Targetable;

/**
 * Weapons can be used on Players and Mobs.
 */
public abstract class Weapon extends Item {

	public Weapon(String name, String description, int weight, int usetime) {
		super(name, description, weight, usetime);
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
		if (usetime > 0) {
			target.useItem(source, this);
			usetime--;
			return "You use " + this.getName() + "!";
		} else {
			source.removeItem(this);
			return this.getName() + "has used up!";
		}

	}

}
