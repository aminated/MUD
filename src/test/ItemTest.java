package test;

import static org.junit.Assert.*;
import items.Bat;

import model.Living;

import org.junit.Test;

public class ItemTest {

	@Test
	public void test() {
		Bat a = new Bat();
		assertEquals("Bat",a.getName());
		assertEquals(10, a.getWeight());
		assertEquals("The baseball Bat is an average melee Weapon.", a.getDescription());
	
	}

}
