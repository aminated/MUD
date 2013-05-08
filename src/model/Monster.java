package model;

import items.Item;

public class Monster extends Living {

	public Monster(String name, int base_hp, int base_atk,int money) {
		super(name, base_hp, base_atk, money);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "A monster ";
	}

	@Override
	public String activate(Living source) {
		source.sendMessage("You attack the monster");
		hp--;
		if (hp == 0) {
			this.getRoom().remove(this);
			return getName() + " dies.";
		}
		return source.getName() + " attacks " + getName();
	}

	@Override
	public String useItem(Living source, Item tool) {

		source.sendMessage("You attack the monster with " + tool.getName());
		hp--;
		if (hp == 0) {
			this.getRoom().remove(this);
			return getName() + " dies.";
		}
		return source.getName() + " attacks " + getName() + " with "
				+ tool.getName(); // TODO Auto-generated method stub

	}

	@Override
	public String useItem(Item tool) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String useItem(Item tool1, Item tool2) {
		// TODO Auto-generated method stub
		return null;
	}

}