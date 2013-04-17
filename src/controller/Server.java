package controller;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import model.Player;
import model.PlayerDisposition;
import model.Room;

public class Server extends Thread {
	private ServerSocket sock; 
	public Room spawnpoint;
	private static int PORT_NUM = 10042;
	private int playerCount = 0; 
	private GameTimer timer = new GameTimer();
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
			String playerName = "Player-" + ++playerCount;
			Player player = new Player(playerName,50);
			PlayerDisposition disposition = new PlayerDisposition(client, player);
			player.setDisposition(disposition);
			player.setRoom(spawnpoint);
			timer.add(player);
			
			
		}
	}


}
