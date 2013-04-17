package controller;

import java.io.IOException;
import java.net.ServerSocket;
import model.Room;

public class Server implements Runnable {
	private ServerSocket sock; 
	private Room spawnpoint;
	private static int PORT_NUM = 10042;
	@Override
	public void run() {
		try {
			sock = new ServerSocket(10042);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		while(true){
			sock.accept();
		}
	}


}
