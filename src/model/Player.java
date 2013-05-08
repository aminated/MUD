package model;

import items.Item;
import items.Weapon;


import disposition.Healer;
import disposition.Hostile;

/**
 * The Player is a user controlled Living being.
 */
public class Player extends Living{

	private String password;
	private GiveAction receiving = null;
	private GiveAction giving = null;
	public GiveAction getReceiving() {
		return receiving;
	}

	public void setReceiving(GiveAction receiving) {
		this.receiving = receiving;
	}

	public GiveAction getGiving() {
		return giving;
	}

	public void setGiving(GiveAction giving) {
		this.giving = giving;
	}

	private boolean admin = false;
	
	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

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


	
    // UseItem(Living, Item) means someone else used the item on the player.
	// if the player uses an item, that's item.use(player). s
	public String getPassword(){
			return "";
		}


	
}
