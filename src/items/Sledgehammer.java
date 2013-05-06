package items;

import model.Living;

public class Sledgehammer extends Weapon{
public Sledgehammer(){
		
		name = "Sledgehammer";
		description = "The sledgehammer is a combining item which can cause huge damage and can also be used to escape the building.";
		weight = 20;
		atk = 40;
		usetime = 30;
	}

//escape the dungeon
@Override
public String use(Living source) {
	// TODO Auto-generated method stub
	return null;
}

}
