package model;

import items.Hammer;
import items.Item;
import items.Sledgehammer;
import items.Weapon;
import items.Wood;


import disposition.Healer;
import disposition.Hostile;

/**
 * The Player is a user controlled Living being.
 */
public class Player extends Living{

	private String password;
	public boolean admin = false;
	public Player(String name, String password, int base_hp, int base_atk, int money) {
		super(name, base_hp, base_atk, money);
		this.password = password;
	}

	@Override
	public String getDescription() {
		return "Player \"" + getName() + "\" ("+hp+"/"+base_hp+")";
	}

	@Override
	public String activate(Living source) {
	
		if (source.getDisposition() instanceof Healer){
			heal(50);
			return source.getName() + " heals " + getName() + "50 HP";
		}
		else 
			if (source.getDisposition() instanceof Hostile){
				this.hp-=source.getAtkdmg();
				return source.getName() + "attack" + getName() + source.getAtkdmg();
			}
		source.sendMessage("You poke " + getName());
		return source.getName() + " pokes " + getName();
	}

	@Override
	public String useItem(Living source, Item tool) {
		source.sendMessage("You give " + tool.getName() + " to " + getName());
		source.removeItem(tool);
		this.addItem(tool);
		return ""; // Give actions aren't publicly visible. 
	}
	
	public String useItem(Item tool){
		tool.use(this);
		return "";
		
	}
	public String getPassword(){
		return password;
	}
	
	
//merge hammer and wood 
	public String useItem(Item tool1, Item tool2){
		if (tool1 instanceof Hammer && this.hasItem(tool1)){
			if(tool2 instanceof Wood && this.hasItem(tool2)){
			this.removeItem(tool1);
			this.removeItem(tool2);
			this.addItem(new Sledgehammer());
			return "Success to merge!";
			}
		}

		return "Fail to merge!";
	}

	
}
