package controller;

import model.Room;
import model.Direction;
/**
 * Runs the Server.
 */
public class RunServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Server server = new Server();
		Room a = new Room("A blue-colored teleporter pad is on the west side of the room. \n Unfortunately, it's one-way.");
		Room b = new Room("A dimly lit hallway");
		Room c = new Room("A storage warehouse");
		Room d = new Room("A sign reading 'spawnpoint teleporter' hangs above the east door. ");
		a.connect(b, Direction.North); 
		b.connect(c, Direction.North);
		c.connect(d, Direction.East);
		d.connect(a, Direction.East);
		a.remove(a.getByName("West-door"));
		
		server.spawnpoint = a;
		
		server.start();
	}

}
