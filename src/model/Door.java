package model;

public class Door implements Targetable {
	private Room source;
	private Room dest; 
	private Direction sourceDir; // Door's position in the source room.
	private Direction destDir; // Door's position in the destination room. 
	public Door(Room source, Room dest, Direction d){
		sourceDir = d;
		destDir = d.turnBack();
	}
	/**
	 * For when you want to ignore the rules of geometry. Portals, elevators and such. 
	 * @param d The door's position in the destination room. 
	 */
	public void setDestDir(Direction d){
		destDir = d;
	}
	public String getName(){
		return sourceDir.toString() + "-door";
	}
	public String getDescription(){
		return "A door leading " + sourceDir.toString();
	}
	public String activate(Living creature){
		creature.setRoom(dest);
		creature.sendMessage("");
	}
}
