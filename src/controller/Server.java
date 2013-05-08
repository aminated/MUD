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

import disposition.Hostile;

import mob.Dragon;

import model.CompanionDisposition;
import model.Direction;
import model.Mob;
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

	public GameTimer getTimer() {
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

		while (true) {
			Socket client = null;
			try {
				client = sock.accept();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// New Client has connected
			if (client != null)
				requestLogin(client);

		}
	}

	/**
	 * Creates a new Player, adds it to a Room, and adds it to the playerDB.
	 */
	public void createPlayer(String name, String password, Socket client) {
		Player player = new Player(name, password, 1, 1, 1);
		PlayerDisposition disposition = new PlayerDisposition(client, player);
		player.setDisposition(disposition);
		player.setRoom(spawnpoint);
		roomDB.get(1).add(player);
		timer.add(player);
	}

	private class Login extends Thread {
		private ObjectInputStream istream;
		private ObjectOutputStream ostream;
		private String response;
		boolean loginFlag = false;
		private Socket client;

		public Login(Socket client) {
			this.client = client;
			try {
				istream = new ObjectInputStream(client.getInputStream());
				ostream = new ObjectOutputStream(client.getOutputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		@Override
		public void run() {

			while (!loginFlag) {
				String name = null;
				String password = null;
				response = null;
				try {
					ostream.writeObject("Login or New?\n");
				} catch (IOException e) {
					System.out.print("write object fail");
				}
			
				
				try {
					response = (String) istream.readObject();
				} catch (ClassNotFoundException e) {
					System.out.print("Class not found");
				} catch (IOException e) {
					System.out.print("read fail");
				}
				
				
				try {
					ostream.writeObject("Name?\n");
				} catch (IOException e) {
					System.out.print("write Name? fail");
				}
			
				try {
					name = (String) istream.readObject();
				} catch (ClassNotFoundException e) {
					System.out.print("Class not found");
				} catch (IOException e) {
					System.out.print("read name fail");
				}
			
				try {
					ostream.writeObject("Password?\n");
				} catch (IOException e) {
					System.out.print("write Password? fail");
				}
			
				try {
					name = (String) istream.readObject();
				} catch (ClassNotFoundException e) {
					System.out.print("Class not found");
				} catch (IOException e) {
					System.out.print("read Password fail");
				}
			
				if (response!=null)
				if (response.equals("Login")) {
					if (loadPlayer(name, password, client))
						loginFlag = true;
				} else if (response.equals("New")) {
					System.out.println("New");
					createPlayer(name, password, client);
					loginFlag = true;
				}
			}
		}
	}

	/**
	 * Asks user for a player name and password
	 */
	public void requestLogin(Socket client) {
		Login aLogin = new Login(client);
		aLogin.start();
	}

	/**
	 * Searches the playerDB for a given name and password and loads player if
	 * found. Otherwise, returns false.
	 * 
	 * @param name
	 *            , password: A user's name and password
	 */
	public Boolean loadPlayer(String name, String password, Socket client) {
		for (Player player : playerDB) {
			// Check playerDB for given name and password
			if (player.getName().equals(name)
					& player.getPassword().equals(password)) {
				// Place player in the room and add to loggedIn List
				player.getRoom().add(player);
				loggedIn.add(player);
				player.setDisposition(new PlayerDisposition(client, player));
				return true;
			}
		}
		// Player was not found
		return false;
	}

	/**
	 * Creates a file for containing all of the Players
	 */
	public void initializePlayerDatabase() {
		try {
			FileOutputStream bytesToDisk = new FileOutputStream("PlayerDB");
			ObjectOutputStream outFile = new ObjectOutputStream(bytesToDisk);

			List<Player> players = new ArrayList<Player>();

			// Adding a Player to use as a test
			Player test = new Player("TEST", "password", 1, 1, 1);
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
	public void initializeRoomDatabase() {
		try {
			FileOutputStream bytesToDisk = new FileOutputStream("RoomDB");
			ObjectOutputStream outFile = new ObjectOutputStream(bytesToDisk);

			// Construct the world and assign to 'rooms'
			roomDB = constructWorld();

			outFile.writeObject(roomDB);
			outFile.close();
		} catch (IOException ioe) {
			System.out.println("Writing Room database: FAILED");
		}
		System.out.println("Writing Room dababase: SUCCESS");
	}

	/**
	 * Constructs the Rooms and returns them in a List<Room>
	 * 
	 * @return List<Room> is a list of all the Rooms in the game
	 */
	private List<Room> constructWorld() {
		List<Room> rooms = new ArrayList<Room>();

		// Create the Rooms
		Room one = new Room(
				"A blue-colored teleporter pad is on the west side of the room. \n Unfortunately, it's one-way.");
		Room two = new Room("A dimly lit hallway");
		Room three = new Room("A storage warehouse");
		Room four = new Room(
				"A sign reading 'spawnpoint teleporter' hangs above the east door. ");

		// Connect the Rooms
		one.connect(two, Direction.North);
		two.connect(three, Direction.North);
		three.connect(four, Direction.East);
		four.connect(one, Direction.East);

		// Modify the Rooms
		one.remove(one.getByName("West-door"));

		// Add them to the List
		rooms.add(one);
		rooms.add(two);
		rooms.add(three);
		rooms.add(four);

		return rooms;
	}

	/*
	 * Creates a few MOBs to demo the game
	 */
	public void runDemo() {
		Mob robot = new Mob("Dog", 50, 1, 0);
		robot.setDisposition(new CompanionDisposition(robot));
		robot.setRoom(roomDB.get(1));
		Mob dragon = new Dragon();
		dragon.setRoom(roomDB.get(2));
		dragon.setDisposition(new Hostile(dragon));
		System.out.print(dragon.getDisposition().getOwner());
		getTimer().add(dragon);
		getTimer().add(robot); // TODO: figure out a way to do this
								// automatically
		spawnpoint = roomDB.get(1);
	}

	/**
	 * Reads the List of Rooms from the RoomDB file and assigns it to Server's
	 * roomDB
	 */
	public void loadRoomDB() {
		FileInputStream rawBytes;
		try {
			rawBytes = new FileInputStream("RoomDB");
			ObjectInputStream inFile = new ObjectInputStream(rawBytes);

			// Reads the List of Rooms
			roomDB = (List<Room>) inFile.readObject();

			inFile.close();
		} catch (FileNotFoundException e) {
			// If RoomDB file does not exist, initialize it and try loading
			// again
			initializeRoomDatabase();
			loadRoomDB();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Reads the List of Players from the PlayerDB file and assigns it to
	 * Server's playerDB
	 */
	public void loadPlayerDB() {
		FileInputStream rawBytes;
		try {
			rawBytes = new FileInputStream("PlayerDB");
			ObjectInputStream inFile = new ObjectInputStream(rawBytes);

			// Reads the List of Players
			playerDB = (List<Player>) inFile.readObject();

			inFile.close();
		} catch (FileNotFoundException e) {
			// If PlayerDB file does'nt exist, initialize it and try loading
			// again
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
	public void savePlayers() {
		try {
			FileOutputStream bytesToDisk = new FileOutputStream(
					"PlayerDatabase");
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
	public void saveRooms() {
		try {
			FileOutputStream bytesToDisk = new FileOutputStream(
					"PlayerDatabase");
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
	public void displayHelp(ClientGUI client) {
		client.displayGameOutput("\n\nHELP GOES HERE\n\n");
	}
}