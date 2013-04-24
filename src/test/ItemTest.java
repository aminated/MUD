package test;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import items.Bat;
import items.Hammer;
import items.Handgun;
import items.Item;
import items.Rifle;
import items.Shotgun;
import items.Sword;

import model.Living;
import model.Player;

import org.junit.Test;

public class ItemTest {

	@Test
	public void testBat() {
		Bat a = new Bat("Bat", "The baseball Bat is an average melee Weapon.", 10, 30);
		assertEquals("Bat",a.getName());
		assertEquals(10, a.getWeight());
		assertEquals("The baseball Bat is an average melee Weapon.", a.getDescription());
		assertEquals(5, a.getAtkdmg());
		assertEquals(30,a.getUsetime());
		Living source = new Monster("Monster",50);
		Living source1 = new Monster("Wang",50);
		assertEquals("Add Bat successfully!", a.activate(source));
		assertEquals("Wang attacks Monster with Bat", source.useItem(source1, a));
	}
	@Test
	public void testHammer() {
		Hammer a = new Hammer();
		assertEquals("Hammer",a.getName());
		assertEquals(20, a.getWeight());
		assertEquals("The Hammer is the worst melee Weapon in the game but it can also be used with wood to block windows and door exits of buildings.", a.getDescription());
		assertEquals(10, a.getAtkdmg());
		assertEquals(30,a.getUsetime());
	}
	@Test
	public void testHandgun() {
		Handgun a = new Handgun();
		assertEquals("Handgun",a.getName());
		assertEquals(15, a.getWeight());
		assertEquals("The Handgun deals the least amount of damage among all projectile based Weapons but has a decent sized magazine and is the most common.", a.getDescription());
		assertEquals(20, a.getAtkdmg());
		assertEquals(20,a.getUsetime());
}
	@Test
	public void testRifle() {
		Rifle a = new Rifle();
		assertEquals("Rifle",a.getName());
		assertEquals(35, a.getWeight());
		assertEquals("The Rifle is the most accurate and powerful ranged Weapon, but has a small magazine size,is loud, and is very rare.", a.getDescription());
		assertEquals(55, a.getAtkdmg());
		assertEquals(10,a.getUsetime());
}
	@Test
	public void testShotgun() {
		Shotgun a = new Shotgun();
		assertEquals("Shotgun",a.getName());
		assertEquals(30, a.getWeight());
		assertEquals("The Shotgun is very powerful, but is almost useless when firing in to a nearby Room.", a.getDescription());
		assertEquals(40, a.getAtkdmg());
		assertEquals(10,a.getUsetime());
}
	@Test
	public void testSword() {
		Sword a = new Sword();
		assertEquals("Sword",a.getName());
		assertEquals(20, a.getWeight());
		assertEquals("The Sword is the best melee Weapon in the game and has high chance to kill with one hit.", a.getDescription());
		assertEquals(15, a.getAtkdmg());
		assertEquals(30,a.getUsetime());
}

}