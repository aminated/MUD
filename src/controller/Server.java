package controller;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import model.Room;

public class Server implements Runnable {
	private ServerSocket sock; 
	private Room spawnpoint;
	private static int PORT_NUM = 10042;
	@Override
	public void run() {
		try {
			sock = new ServerSocket(PORT_NUM);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		while(true){
			Socket client;
			try {
				client = sock.accept();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}


}
