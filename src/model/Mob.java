package model;

import items.Item;
import items.Weapon;

/**
 * A Mob is any mobile entity that is not controlled by a user. Mobs have a
 * Disposition strategy and can do most things that a Player can do.
 */
public class Mob extends Living{

	public Mob(String name, int base_hp, int base_atk, int money) {
		super(name, base_hp, base_atk, money);
		
	}
	
	
	@Override
	public String getDescription() {
		return "Mob \"" + getName() + "\" ("+hp+"/"+base_hp+")";
	}

	@Override
	public String activate(Living source) {
		//source.sendMessage("You poke " + getName());
		return attack(source);
	}

	@Override
	public String useItem(Living source, Item tool) {
		if (tool instanceof Weapon){
			return attack(source, (Weapon)tool);		// Don't give weapon to mobs, they will eat you
		}
		else{
			source.sendMessage("You give " + tool.getName() + " to " + getName());
			source.removeItem(tool);
			this.addItem(tool);
			return ""; // Give actions aren't publicly visible. 
		}
	}
	public String attack(Living source, Weapon tool){
		source.sendMessage("You attack " + getName() + "by " + tool.getName());
		this.hp-=tool.getAtkdmg();
		return source.getName() + " attack " + getName();
	}
	
	public String attack(Living source){
		source.sendMessage("You attack " + getName());
		this.hp-=source.getAtkdmg();
		return source.getName() + " attack " + getName();
	}
}
