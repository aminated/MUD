package test;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import items.Bat;
import items.FullHealthPotion;
import items.Grenade;
import items.Hammer;
import items.Handgun;
import items.Item;
import items.LargePotion;
import items.Rifle;
import items.Shotgun;
import items.Sledgehammer;
import items.SmallPotion;
import items.StaminaTablet;
import items.Sword;
import items.Weapon;
import items.Wood;

import model.Living;
import model.Mob;
import model.Monster;
import model.Player;

import org.junit.Test;

import disposition.Disposition;
import disposition.Hostile;

public class ItemTest {

	@Test
	public void testBat() {
		Weapon a = new Bat();
		assertEquals("Bat", a.getName());
		assertEquals(10, a.getWeight());
		assertEquals("The baseball Bat is an average melee Weapon.",
				a.getDescription());
		assertEquals(10, a.getAtkdmg());
		assertEquals(30, a.getUsetime());
		Living source = new Mob("Mob", 50, 5, 100);
		Living source1 = new Player("Wang", "a", 50, 10, 0);
		assertEquals("", a.activate(source));
		source1.addItem(a);
		assertEquals("Wang attacks Mob by Bat", source.useItem(source1, a));

		assertEquals(29, a.getUsetime());
		assertEquals(36, source.getHp());
		source.activate(source1);
		assertEquals(26, source.getHp());
	}

	@Test
	public void testHammer() {
		Hammer a = new Hammer();
		assertEquals("Hammer", a.getName());
		assertEquals(20, a.getWeight());
		assertEquals(
				"The Hammer is the worst melee Weapon in the game but it can also be used with wood to forge the sledgehammer.",
				a.getDescription());
		assertEquals(8, a.getAtkdmg());
		assertEquals(30, a.getUsetime());
	}

	@Test
	public void testHandgun() {
		Handgun a = new Handgun();
		assertEquals("Handgun", a.getName());
		assertEquals(15, a.getWeight());
		assertEquals(
				"The Handgun deals the least amount of damage among all projectile based Weapons but has a decent sized magazine and is the most common.",
				a.getDescription());
		assertEquals(20, a.getAtkdmg());
		assertEquals(20, a.getUsetime());
	}

	@Test
	public void testRifle() {
		Rifle a = new Rifle();
		assertEquals("Rifle", a.getName());
		assertEquals(35, a.getWeight());
		assertEquals(
				"The Rifle is the most accurate and powerful ranged Weapon, but has a small magazine size,is loud, and is very rare.",
				a.getDescription());
		assertEquals(50, a.getAtkdmg());
		assertEquals(10, a.getUsetime());
	}

	@Test
	public void testShotgun() {
		Shotgun a = new Shotgun();
		assertEquals("Shotgun", a.getName());
		assertEquals(30, a.getWeight());
		assertEquals(
				"The Shotgun is very powerful, but is almost useless when firing in to a nearby Room.",
				a.getDescription());
		assertEquals(40, a.getAtkdmg());
		assertEquals(10, a.getUsetime());
	}

	@Test
	public void testSword() {
		Sword a = new Sword();
		assertEquals("Sword", a.getName());
		assertEquals(20, a.getWeight());
		assertEquals(
				"The Sword is the best melee Weapon in the game.",
				a.getDescription());
		assertEquals(15, a.getAtkdmg());
		assertEquals(30, a.getUsetime());
	}

	@Test
	public void testHealthpotion() {
		Item small = new SmallPotion();
		Item large = new LargePotion();
		Item full = new FullHealthPotion();
		Item stamina = new StaminaTablet();
		assertEquals("Small Potion", small.getName());
		assertEquals(2, small.getWeight());
		assertEquals(
				"A small potion can heal the player's 25HP who is injured.",
				small.getDescription());
		assertEquals(1, small.getUsetime());
		assertEquals(50, small.getValue());

		Living source = new Mob("Mob", 50, 30, 0);
		Living source1 = new Player("Wang", "a", 200, 10, 0);
		source1.addItem(small);
		source1.addItem(large);
		source1.addItem(full);
		source1.addItem(stamina);

		Disposition d = new Hostile(null);
		source.setDisposition(d);
		source1.activate(source);
		source1.activate(source);
		source1.activate(source);

		assertEquals(110, source1.getHp());
		small.use(source1);
		assertEquals(135, source1.getHp());
		large.use(source1);
		assertEquals(185, source1.getHp());
		stamina.use(source1);
		assertEquals(210, source1.getHp());
		assertEquals(225, source1.getMaxhp());
		full.use(source1);
		assertEquals(225, source1.getHp());

	}

	@Test
	public void testGrenade() {
		Weapon Grenade = new Grenade();
		assertEquals("Grenade", Grenade.getName());
		assertEquals(5, Grenade.getWeight());
		assertEquals(
				"Grenade is a disposable weapon which can cause huge damage.",
				Grenade.getDescription());
		assertEquals(45, Grenade.getAtkdmg());
		assertEquals(1, Grenade.getUsetime());
		assertEquals(100, Grenade.getValue());

		Living source = new Mob("Mob", 100, 5, 100);
		Living source1 = new Player("Wang", "a", 50, 10, 0);

		source1.addItem(Grenade);
		source.activate(source1);
		assertEquals(90, source.getHp());
		assertEquals("Wang attacks Mob by Grenade",
				source.useItem(source1, Grenade));
		assertEquals(62, source.getHp());
		assertFalse(source1.hasItem(Grenade));

	}

	@Test
	public void testFight() {
		Item a = new Bat();
		Item b = new Rifle();
		Living c1w = new Player("c1w", "", 100, 10, 0);
		Living fd = new Player("Otacon", "", 100, 10, 0);
		c1w.addItem(a);
		fd.addItem(b);	
		c1w.useItem(fd, b);
		assertEquals(70,c1w.getHp());
		fd.useItem(c1w,a);
		assertEquals(86,fd.getHp());

	}
	
	@Test 
	public void testMergeItem(){
		Item a = new Hammer();
		Item b = new Wood();
		Living fd = new Player("Otacon", "", 100, 100, 0);
		assertEquals("Fail to merge!",a.useItem(fd,b));
		fd.addItem(a);
		assertEquals("Fail to merge!",fd.useItem(a,b));
		fd.addItem(b);
		assertEquals("Success to merge!",fd.useItem(a,b));
		assertFalse(fd.hasItem(a));
		assertFalse(fd.hasItem(b));
	}

}