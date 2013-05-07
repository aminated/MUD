package test;

import static org.junit.Assert.*;
import mob.Dragon;
import model.Mob;

import org.junit.Test;

public class TestMob {
	@Test
	public void testDragon() {
		Mob dragon= new Dragon();
		System.out.print(dragon.getDisposition());
		System.out.print(dragon.getDisposition().getOwner());
		System.out.print(dragon.getDisposition().getOwner().getName());
		assertEquals(dragon.getDisposition().getOwner().getName(),"Dragon");
	}
}
