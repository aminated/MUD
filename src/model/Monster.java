package model;

import items.Item;

public class Monster extends Living {

	public Monster(String name, int base_hp) {
		super(name, base_hp);
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
		if (tool.getUsetime() <= 0) {
			return "You cannot use this item to attack anymore!";
		} else {
			source.sendMessage("You attack the monster with " + tool.getName());
			hp--;
			if (hp == 0) {
				this.getRoom().remove(this);
				return getName() + " dies.";
			}
			return source.getName() + " attacks " + getName() + " with "
					+ tool.getName(); // TODO Auto-generated method stub

		}
	}

}
