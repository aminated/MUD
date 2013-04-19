package items;

import model.Living;

/**
 * Weapons can be used on Players and Mobs.
 */
public abstract class Weapon extends Item {
	protected int atk;
	protected int usetime;

	public Weapon() {

		// TODO Auto-generated constructor stub
	}

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

	public int getAtkdmg() {
		return atk;
	}

	public int getUsetime() {
		return usetime;
	}

}
