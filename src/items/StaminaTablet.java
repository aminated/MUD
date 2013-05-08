package items;

import model.Living;

public class StaminaTablet extends Item {

	public StaminaTablet() {
		name = "Stamina Tablet";
		description = "A Stamina tablet can increase player's 15 maxHP.";
		weight = 2;
		usetime = 1;
		value = 800;
	}

	@Override
	public String use(Living source) {
		source.increaseMaxHP(25);
		source.removeItem(this);
		source.sendMessage("Your MaxHP has increased 25!") ;
		return "";
		
	}

}
