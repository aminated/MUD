package items;

import model.Living;

public class Potion extends Item {

	public Potion(String name, String description, int weight, int usetime,
			int value) {
		super(name, description, weight, usetime, value);
		// TODO Auto-generated constructor stub
	}

	public Potion() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String use(Living source) {
		// TODO Auto-generated method stub
		return null;
	}

}
