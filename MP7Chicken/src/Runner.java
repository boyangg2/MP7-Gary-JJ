// Gary, JJ 2017

import java.util.Scanner;

/* Class that implements a coordinated game of chickens and potatos.
 * 
 * Oversees overall progress of game.
 */
public class Runner {
	/* Input Scanner */
	static Scanner kb = new Scanner(System.in);
	/* Player object. */
	static Player player;
	/* Potatos object (enemy). */
	static Potato potato;
	static Chicken chicken;
	static final int INIT_ENERGY = 50;

	/* Introduction to game. */
	public static void intro(final int e) {
		System.out.print("enter name: ");
		player = new Player(kb.next().toLowerCase(), e);
		potato = new Potato();
		potato.setName(player.getName() + "'s angry grandpa");
		Scenes.opening();

		System.out.println(player.getName() + " is the master of all chickens.");
		System.out.println(player.getName() + " has the energy to summon chickens!");
		Scenes.wait(4);
	}

	public static void setUp() {
		Scenes.revealPotato();
		System.out.println("wild aggressive potato: " + potato.getName() + " appears!");
		Scenes.wait(2);

		System.out.println("\n" + player.getName() + " summons a chicken!");
		chicken = new Chicken();

		Scenes.wait(1);

		boolean valid = false;

		while (!valid) {
			displayStats();
			displayStyles();
			System.out.print("style (a, b, or c): ");
			char choice = kb.next().toLowerCase().charAt(0);

			switch (choice) {
				case 'a': 	if (player.useEnergy(10)) {
								chicken.setDamage(10);
								valid = true;
							} else {
								System.out.println("\n" + player.getName()
								+ " does not have enough energy to purchase Fried Chicken.");
							}
							break;
				case 'b': 	if (player.useEnergy(50)) {
								chicken.setDamage(50);
								valid = true;
							} else {
								System.out.println("\n" + player.getName()
								+ " does not have enough energy to purchase Grilled Chicken.");
							}
							break;
				case 'c': 	if (player.useEnergy(100)) {
								chicken.setDamage(100);
								valid = true;
							} else {
								System.out.println("\n" + player.getName()
								+ " does not have enough energy to purchase Seasoned Chicken.");
							}
							break;
				default: 	System.out.println("\ninvalid choice.");
							break;
			}

			Scenes.wait(1);
		}

		System.out.println("\n" + player.getName() + " decides what he wants with his chicken.");
		Scenes.wait(1);

		valid = false;

		while (!valid) {
			displayStats();
			displayWeapons();
			System.out.print("style (a, b, c, or d): ");
			char choice = kb.next().toLowerCase().charAt(0);

			switch (choice) {
				case 'a': 	valid = true;
							break;
				case 'b': 	if (player.useEnergy(10)) {
								chicken.setWeaponBonus(10);
								valid = true;
							} else {
								System.out.println("\n" + player.getName()
								+ " does not have enough energy to purchase a submachine gun.");
							}
							break;
				case 'c': 	if (player.useEnergy(20)) {
								chicken.setWeaponBonus(50);
								valid = true;
							} else {
								System.out.println("\n" + player.getName()
								+ " does not have enough energy to purchase a grenade.");
							}
							break;
				case 'd':	if (player.useEnergy(100)) {
								chicken.setWeaponBonus(100);
								valid = true;
							} else {
								System.out.println("\n" + player.getName()
								+ " does not have enough energy to purchase a nuclear rocket.");
							}
							break;
				default: 	System.out.println("\ninvalid choice.");
							break;
			}

			Scenes.wait(1);
			System.out.println();
			Scenes.preBattle();
			Scenes.wait(1);
			displayStats();
		}
	}

	public static void displayStats() {
		System.out.println("\n" + player.getName() + "'s energy: " + player.getEnergy());
		if (chicken.getDamage() != 0) {
			System.out.println("chicken's damage capability: " + chicken.getDamage());
		}
		System.out.println("potato, " + potato.getName() + "'s health: " + potato.getHealth());
	}

	public static void displayStyles() {
		System.out.println("\n    style:            damage:     cost:");
		System.out.println("(a) Fried Chicken:    10          10");
		System.out.println("(b) Grilled Chicken:  50          50");
		System.out.println("(c) Seasoned Chicken: 100         100");
	}

	public static void displayWeapons() {
		System.out.println("\n    weapon:           damage:     cost:");
		System.out.println("(a) chicken only:     +0          0");
		System.out.println("(b) submachine gun:   +10         10");
		System.out.println("(c) grenade:          +20         20");
		System.out.println("(d) a nuclear rocket: +100        100");
	}

	/* Main control for game progress. */
	public static void main(String[] args) {
		intro(INIT_ENERGY);
		setUp();
	}

}
