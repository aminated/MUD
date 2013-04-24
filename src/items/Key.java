package items;

import model.Living;

public class Key extends Item{
	public Key(){
		name = "Key";
		description = "The key can only open the door for the Boss Room.";
		weight = 5;
		usetime = 1;
	}


	@Override
	public String useItem(Living source, Item tool) {
		// TODO Auto-generated method stub
		return null;
	}
}
