package model;
import model.Targetable;

/**
 * The Living class pertains to any animate entity in the game. 
 */
public abstract class Living implements Targetable {
	private int base_hp;
	private int hp;
	private Room room;
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	/**
	 * Tells this Living entity something. May be ignored by MOBs. 
	 * @param message A human-readable message. 
	 */
	public void sendMessage(String message){
		
	}
	public void addItem(Item item) {
		// TODO Auto-generated method stub
		
	}
	
}
