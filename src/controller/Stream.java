package controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Stream {
	// A socket that has already been connected and initialized as an object IO stream.
	// This is to avoid errors from initializing them twice. 
	public ObjectOutputStream out;
	public ObjectInputStream in;

	public Stream(ObjectOutputStream out, ObjectInputStream in) {
		super();
		this.out = out;
		this.in = in;
	}
	public void close(){
		try {
		out.close();
		in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
