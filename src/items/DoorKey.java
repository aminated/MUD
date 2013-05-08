package items;

import model.Living;

public class DoorKey extends Item {
	private String label;
	public String getLabel(){
		return label;
	}
// Example: DoorKey("red").getDescription = "A red key". Opens LockDoor("red").
	public DoorKey(String label) {
		this.label = label;
		name = label + "-key";
		description = "A " + label + "key.";
		weight = 1;
		usetime = 1;
		value = 20;
	}

	@Override
	public String use(Living source) {
		source.sendMessage("Keys can only be used on doors");
		return "";
	}

}
