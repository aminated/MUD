package items;

import model.Living;

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

	protected int usetime;

	@Override
	public String useItem(Living source, Item tool) {
		// TODO Auto-generated method stub
		if (usetime != 0) {
			usetime--;
			return "Attack " + source.getName() + " by using " + tool.getName()
					+ " successfully!";
		} else
			return "You cannot use this item to attack anymore!";
	}

	public String use(Living source) {
		return "Weapons need a target to use";
	}

	public int getAtkdmg() {
		return atk;
	}

}
