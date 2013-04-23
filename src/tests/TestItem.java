package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Room;


public class TestItem {
	protected Room start;
	@Before
	public void setUp() throws Exception {
		start = new Room("testRoom");
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
