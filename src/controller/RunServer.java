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
		Room a = new Room("A teleporter exit pad");
		Room b = new Room("A dimly lit hallway");
		Room c = new Room("A storage warehouse");
		a.connect(b, Direction.North); 
		b.connect(c, Direction.North);
		
		server.spawnpoint = a;
		
		server.start();
	}

}
