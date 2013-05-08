package items;

import model.Living;

public class TeleportationScroll extends Item{

	public TeleportationScroll(){
		name = "Teleportation Scroll";
		description = "Teleportation Scroll can teleport a player to a random room";
		weight = 5;
		usetime = 1;
		value = 150;
	}

	// teleport to a random room
	@Override
	public String use(Living source) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
