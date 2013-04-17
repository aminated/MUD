package model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class PlayerDisposition extends Disposition{
	private ClientConnection listener;
	private class ClientConnection extends Thread{
		public ObjectInputStream istream;
		public ObjectOutputStream ostream;
		public void run(){
			while(true){
				String command = "";
				try {
					command = (String) istream.readObject();
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
		public void puts(String message){
			try {
				ostream.writeObject(message);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public PlayerDisposition(Socket client, Player player){
		super(player);
		this.listener = new ClientConnection();
		try {
			listener.istream = new ObjectInputStream( client.getInputStream() );
			listener.ostream = new ObjectOutputStream( client.getOutputStream() );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		listener.start();
	}
	@Override
	public void notify(Action event) {
		listener.puts(event.describe() + "\n");
	}
	@Override
	public void notify(String message) {
		listener.puts(message+ "\n");
	}

}
