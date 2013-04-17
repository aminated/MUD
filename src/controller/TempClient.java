package controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TempClient {

	public TempClient() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args){
		Socket sock = null;
		ObjectInputStream netIn = null;
		ObjectOutputStream netOut = null;
		Scanner in = new Scanner(System.in);
		try {
			sock = new Socket("localhost", 10042);
			netIn = new ObjectInputStream(sock.getInputStream());
			netOut = new ObjectOutputStream(sock.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(true){
			String input = in.nextLine();
			try {
			netOut.writeObject(input);
			System.out.println( (String) netIn.readObject() );
			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
