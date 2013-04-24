package items;

import model.Living;

public class StaminaTablet extends Item {

	public StaminaTablet() {
		name = "Stamina Tablet";
		description = "A Stamina tablet can increase player's 15 maxHP.";
		weight = 2;
		usetime =1;
	}

	@Override
	public String useItem(Living source, Item tool) {
		// TODO Auto-generated method stub
		// Living's HP increases 25
		return "HP recovers 25!";
	}

}
