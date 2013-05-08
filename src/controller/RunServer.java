package controller;

/**
 * Runs the Server.
 */
public class RunServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Server server = Server.getServer();
		
		server.start();
	//	server.initializeRoomDatabase();
	//	server.initializePlayerDatabase();
		try{
		server.loadRoomDB();
		server.loadPlayerDB();
		}
		catch(Error e){
			System.out.println(e.getMessage() + "\n Creating new DB.");
			server.initializePlayerDatabase();
			server.initializeRoomDatabase();
		}
		server.runDemo();
	}
}
