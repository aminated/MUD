package model;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import disposition.Disposition;

import items.Item;
import items.Weapon;
import model.Targetable;

/**
 * The Living class pertains to any animate entity in the game. 
 */
public abstract class Living implements Targetable, Serializable{
	protected int base_hp;
	protected int hp;
	protected int base_atk;
	protected Item equipped = null;
	protected int money;
	private GiveAction getting = null;
	private GiveAction giving = null;
	public GiveAction getGetAction() {
		return getting;
	}

	public void setGetAction(GiveAction getting) {
		this.getting = getting;
	}

	public GiveAction getGiveAction() {
		return giving;
	}

	public void setGiveAction(GiveAction giving) {
		this.giving = giving;
	}


	private Room room;
	private String name;
	private Disposition disposition = null;
	private List<Item> items = new LinkedList<Item>();
	public Living(String name, int base_hp, int base_atk, int money){
		this.name = name;
		this.hp = this.base_hp = base_hp;
		this.base_atk = base_atk;
		this.money = money;
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		if(this.room != null) this.room.remove(this);
		this.room = room;
		this.room.add(this);
	}
	public void setDisposition(Disposition d){
		disposition = d;
	}
	public Disposition getDisposition(){
		return disposition;
	}
	/**
	 * Tells this Living entity that an event occurred in its room.
	 * @param event An Action executed by someone in the room.
	 */
	public void sendMessage(Action event){
		if(disposition != null)
		disposition.notify(event);
	}
	/**
	 * Sends this Living entity a human-readable message. May be ignored by MOBs. 
	 * @param message A human-readable message.
	 */
	public void sendMessage(String message){
		if(disposition != null)
		disposition.notify(message);
	}
	
	public void addItem(Item item) {
		items.add(item);		
	}
	public void removeItem(Item item){
		items.remove(item);
	}
	public Item getItem(String itemName){
		for(Item item : items){
			if(item.getName().toLowerCase().equals(itemName.toLowerCase()))
				return item;
		}
		throw new InvalidNameException(itemName);
	}
	public boolean hasItem(Item item){
		return items.contains(item);
	}
	public List<Item> getItems(){
		return items;
	}
	public String getName(){
		return name;
	}
	public int getHp(){
		return hp;
	}
	public int getMaxhp(){
		return base_hp;
	}
	public int getAtkdmg(){
		return base_atk;
	}
	public void heal(int heal){
		hp+=heal;
		if (hp>base_hp)
			hp=base_hp;
	}

	public void increaseMaxHP(int increase){
		base_hp+=increase;
		hp+=increase;
	}
	public int getMoney(){
		return money;
	}
	public void addMoney(int value){
		money+=value;
	}
	public String useItem(Living source, Item tool){
		if(tool instanceof Weapon){
			Weapon weapon = (Weapon) tool;
			int damage=source.getAtkdmg()+(int) Math.round(weapon.getAtkdmg()*0.4);
			 hp -= damage;
			String message = source.getName() + " attacks " + this.getName() + " with " + tool.getName()
					+ " for " + damage + " damage.\n";
			if(hp <= 0)
				message += die(source) + "\n";
			return message;
			 

		}
		else{
			source.sendMessage("Cannot use this item on a living creature. Do you mean 'give'? ");
			return "";
		}
	}
	/*
	 * Source kills this Object and loot all things
	 */
	public String die(Living source){
		getRoom().remove(this);
		source.addMoney(this.getMoney());
		for(Item thing: items){
			source.addItem(thing);
		}
		return source.getName() + " kills " + getName();

	}

	//public String useItem(Item tool) {
	
	
	//public String useItem(Item tool, Item tool2){
	
}
