package model;

import items.Item;

import java.io.Serializable;

import disposition.Healer;

/**
 * The Player is a user controlled Living being.
 */
public class Player extends Living implements Serializable{

	private String password;

	public Player(String name, String password, int base_hp, int base_atk) {
		super(name, base_hp, base_atk);
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
	
	public String getPassword(){
		return password;
	}

}
