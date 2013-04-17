package model;
import items.Item;
import model.Targetable;

/**
 * The Living class pertains to any animate entity in the game. 
 */
public abstract class Living implements Targetable {
	protected int base_hp;
	protected int hp;
	private Room room;
	private String name;
	private Disposition disposition = null;
	public Living(String name, int base_hp){
		this.name = name;
		this.hp = this.base_hp = base_hp;
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public void setDisposition(Disposition d){
		disposition = d;
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
		// TODO Auto-generated method stub
		
	}
	public String getName(){
		return name;
	}
}
