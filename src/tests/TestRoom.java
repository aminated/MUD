package tests;

import static org.junit.Assert.*;

import model.Direction;
import model.Room;

import org.junit.Test;

public class TestRoom {

	@Test
	public void test() {
		Room a = new Room("A");
		Room b = new Room("B");
		a.connect(b, Direction.North);
		System.out.println(a.describe());
		System.out.println(b.describe());
	 	assertTrue( a.getByName("North-door") != null);
	 	assertTrue( b.getByName("South-door") != null);
	}

}
