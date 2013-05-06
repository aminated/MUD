package model;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import disposition.Disposition;

import items.Item;
import model.Targetable;

/**
 * The Living class pertains to any animate entity in the game. 
 */
public abstract class Living implements Targetable, Serializable{
	protected int base_hp;
	protected int hp;
	protected int base_atk;
	private int money;


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
	public boolean hasItem(Item item){
		return items.contains(item);
	}
	public List<Item> getItems(){
		return items;
	}
	public String getName(){
		return name;
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
}
