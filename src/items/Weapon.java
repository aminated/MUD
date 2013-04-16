package items;

import model.Living;

/**
 * Weapons can be used on Players and Mobs.
 */
public abstract class Weapon extends Item{

	public Weapon(String name, String description, int weight) {
		super(name, description, weight);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String useItem(Living source, Item tool) {
		// TODO Auto-generated method stub
		return "Attack "+ source.getName()+" by using " + tool.getName()+ " successfully!";
	}

}
