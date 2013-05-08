package items;

import model.Living;

public class DoorKey extends Item {

	public DoorKey(String name, String description, int weight, int usetime,
			int value) {
		super(name, description, weight, usetime, value);
		// TODO Auto-generated constructor stub
	}

	public DoorKey(String label) {
		name = label + "-key";
		description = "A " + label + "key.";
		weight = 1;
		usetime = 1;
		value = 20;
	}

	@Override
	public String use(Living source) {
		// TODO Auto-generated method stub
		return null;
	}

}
