package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import model.Direction;
import model.Player;
import model.PlayerDisposition;
import model.Room;
import view.ClientGUI;

public class Server extends Thread {
	private ServerSocket sock; 
	public Room spawnpoint;
	private static int PORT_NUM = 10042;
	private int playerCount = 0;
	private GameTimer timer = new GameTimer();
	private List<Player> loggedIn;
	private List<Player> playerDB;
	private List<Room> roomDB;
	
	public GameTimer getTimer(){
		return timer;
	}
	
	@Override
	public void run() {
		try {
			sock = new ServerSocket(PORT_NUM);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		timer.start();
		
		while(true){
			Socket client = null;
			try {
				client = sock.accept();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// New Client has connected
			Player player = new Player("temp", 50, 2);
			PlayerDisposition disposition = new PlayerDisposition(client, player);
			player.setDisposition(disposition);
			player.setRoom(spawnpoint);
			roomDB.get(1).add(player);
			timer.add(player);
		}
	}
	
	/**
	 * Creates a new Player, adds it to a Room, and adds it to the playerDB.
	 */
	public void createPlayer(String name, String password, Socket client){
		
	}
	
	/**
	 * Asks user for a player name and password
	 */
	public void requestLogin(ClientGUI client){
		
	}
	
	/**
	 * Searches the playerDB for a given name and password and loads player if found.
	 * Otherwise, returns false.
	 * @param name, password: A user's name and password
	 */
	public Boolean loadPlayer(String name, String password){
		for (Player player : playerDB) {
			// Check playerDB for given name and password
			if(player.getName().equals(name) & player.getPassword().equals(password)){
	        	// Place player in the room and add to loggedIn List
				player.getRoom().add(player);
				loggedIn.add(player);
				return true;
	        }
	    }
		// Player was not found
		return false;
	}
	
	/**
	 * Creates a file for containing all of the Players
	 */
	public void initializePlayerDatabase(){	
		try {
			FileOutputStream bytesToDisk = new FileOutputStream("PlayerDB");
		    ObjectOutputStream outFile = new ObjectOutputStream(bytesToDisk);
		    
		    List<Player> players = new ArrayList<Player>();
		    
		    // Adding a Player to use as a test
		    Player test = new Player("TEST", "password", 1, 1);
		    test.setRoom(roomDB.get(1));
		    players.add(test);
		    
		    outFile.writeObject(players);
		    outFile.close();
		} catch (IOException ioe) {
			System.out.println("Writing Player database: FAILED");
		}
		System.out.println("Writing Player dababase: SUCCESS");
	}
	
	/**
	 * Creates a file containing all of the Rooms
	 */
	public void initializeRoomDatabase(){	
		try {
			FileOutputStream bytesToDisk = new FileOutputStream("RoomDB");
		    ObjectOutputStream outFile = new ObjectOutputStream(bytesToDisk);
		    
		    List<Room> rooms = new ArrayList<Room>();
		    
		    // CREATE THE ROOMS HERE
		    Room one = new Room("a forested area");
		    Room two = new Room("a cabin");
		    one.connect(two, Direction.North);
		    
		    rooms.add(one);
		    rooms.add(two);
		    
		    outFile.writeObject(rooms);
		    outFile.close();
		} catch (IOException ioe) {
			System.out.println("Writing Room database: FAILED");
		}
		System.out.println("Writing Room dababase: SUCCESS");
	}
	
	/**
	 * Reads the List of Rooms from the RoomDB file and assigns it to Server's roomDB
	 */
	public void loadRoomDB(){
		FileInputStream rawBytes;
	    try {
	    	rawBytes = new FileInputStream("RoomDB");
	    	ObjectInputStream inFile = new ObjectInputStream(rawBytes);

	    	// Reads the List of Players
	    	List<Player> roomDB = (ArrayList<Player>) inFile.readObject();
	    	
	    	inFile.close();
	    } catch (FileNotFoundException e) {
	    	// If RoomDB file does not exist, initialize it and try loading again
	    	initializeRoomDatabase();
	    	loadRoomDB();
	    } catch (IOException e) {
	    	e.printStackTrace();
	    } catch (ClassNotFoundException e) {
	    	e.printStackTrace();
	    }
	}
	
	/**
	 * Reads the List of Players from the PlayerDB file and assigns it to Server's playerDB
	 */
	public void loadPlayerDB(){
		FileInputStream rawBytes;
	    try {
	    	rawBytes = new FileInputStream("PlayerDB");
	    	ObjectInputStream inFile = new ObjectInputStream(rawBytes);

	    	// Reads the List of Players
	    	List<Player> playerDB = (ArrayList<Player>) inFile.readObject();   	
	    	
	    	inFile.close();
	    } catch (FileNotFoundException e) {
	    	// If PlayerDB file does'nt exist, initialize it and try loading again
	    	initializePlayerDatabase();
	    	loadPlayerDB();
	    } catch (IOException e) {
	    	e.printStackTrace();
	    } catch (ClassNotFoundException e) {
	    	e.printStackTrace();
	    }
	}
	
	/**
	 * Writes the playerDB to the PlayerDB file
	 */
	public void savePlayers(){
		try {
			FileOutputStream bytesToDisk = new FileOutputStream("PlayerDatabase");
		    ObjectOutputStream outFile = new ObjectOutputStream(bytesToDisk);
		    outFile.writeObject(playerDB);
		    outFile.close();
		} catch (IOException ioe) {
			System.out.println("Writing Player database: FAILED");
		}
		System.out.println("Writing Player dababase: SUCCESS");
	}
	
	/**
	 * Writes the roomDB to the RoomDB file
	 */
	public void saveRooms(){
		try {
			FileOutputStream bytesToDisk = new FileOutputStream("PlayerDatabase");
		    ObjectOutputStream outFile = new ObjectOutputStream(bytesToDisk);
		    outFile.writeObject(roomDB);
		    outFile.close();
		} catch (IOException ioe) {
			System.out.println("Writing Room database: FAILED");
		}
		System.out.println("Writing Room dababase: SUCCESS");
	}
	
	/**
	 * Displays a help menu for the user
	 */
	public void displayHelp(ClientGUI client){
		client.displayGameOutput("\n\nHELP GOES HERE\n\n");
	}
}