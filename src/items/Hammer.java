package items;

import model.Living;
import model.Targetable;

/**
 * The Hammer is the worst melee Weapon in the game but it can also be used with
 * wood to block windows and door exits of buildings.
 */
public class Hammer extends Weapon {

	public Hammer(){
		
		name = "Hammer";
		description = "The Hammer is the worst melee Weapon in the game but it can also be used with wood to forge the sledgehammer.";
		weight = 20;
		atk = 8;
		usetime = 30;
		value = 50;
	}
	public String useItem(Living source, Item tool) {
		// TODO Auto-generated method stub
		if(source.hasItem(this)&&tool instanceof Wood){
			Wood wood = (Wood) tool;
			if(source.hasItem(wood)){
				source.removeItem(this);
				source.removeItem(wood);
				source.addItem(new Sledgehammer());
				source.sendMessage("Merge complete.");
				return "";
			}
		}
		return "";
	}
	}

	

