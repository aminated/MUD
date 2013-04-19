package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

class Listener extends Thread{
	public ObjectInputStream netIn;
	public Socket sock;
	public void run(){
		try {
			netIn = new ObjectInputStream(sock.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(true){
			String input = null;
			try {
				input = (String) netIn.readObject();
			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(input);
			System.out.print(">");
		}
	}
}

public class TempClient {
	static ObjectInputStream netIn = null;
	static ObjectOutputStream netOut = null;
	static Socket sock = null;

	public TempClient() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args){
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try {
			sock = new Socket("localhost", 10042);
			netOut = new ObjectOutputStream(sock.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Listener listener = new Listener();
		listener.sock = sock;
		listener.start();
		System.out.print(">");
		while(true){
			String input = null;
			try {
				input = in.readLine();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
			netOut.writeObject(input);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
