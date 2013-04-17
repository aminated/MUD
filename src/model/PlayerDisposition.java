package model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class PlayerDisposition extends Disposition {
	private ClientListener listener;
	private class ClientListener extends Thread{
		public ObjectInputStream stream;
		public void run(){
			while(true){
				String command = "";
				try {
					command = (String) stream.readObject();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Handle dropped connection.
					e.printStackTrace();
				}
				queue.add(new Action(owner, command));
			}
		}
	}
	public PlayerDisposition(Socket client, Player player){
		super(player);
		this.listener = new ClientListener();
		try {
			listener.stream = new ObjectInputStream( client.getInputStream() );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
