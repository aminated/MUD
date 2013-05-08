package model;

public class InvalidNameException extends RuntimeException {



	public InvalidNameException(String name) {
		super("Nothing named " + name + " was found.");
		// TODO Auto-generated constructor stub
	}

	

}
