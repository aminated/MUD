package items;

import model.Living;

public class Wood extends Item {

	public Wood(){
		
		name = "Wood";
		description = "Wood can only be used with hammer to block windows and door exits of buildings.";
		weight = 1;
		usetime = 1;
		value = 30;
	}

	@Override
	public String use(Living source) {
		// TODO Auto-generated method stub
		source.sendMessage("Wood can only be used with hammer!") ;
		return "";
	}

	
	
}