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
	/* Game counter. */
	static int gameCount = 1;
	static Chicken chicken;
	static final int INIT_ENERGY = 50;

	/* Introduction to game. */
	public static void intro(final int e) {
		System.out.print("enter name: ");
		player = new Player(kb.next().toLowerCase(), e);
		potato = new Potato();
		potato.setName(reverseWord(player.getName()));
		Scenes.opening();

		System.out.println(player.getName() + " is the master of all chickens.");
		System.out.println(player.getName() + " has the energy to summon chickens!");
		Scenes.wait(4);
	}

	public static String reverseWord(final String w) {
		String rev = "";

		// implement method for reversing w
		

		/* if reversed word = player's name, return player.getName() + "'s angry grandpa" */
		if (rev == player.getName()) {
			return player.getName() + "'s angry grandpa";
		}
		return w + " reversed";
	}

	public static void setUpPotato() {
		potato.setName(potato.getName() + " " + gameCount);
		Scenes.revealPotato();
		System.out.println("the evil potato " + potato.getName() + " appears!");
		Scenes.wait(2);
	}

	public static void setUpChicken() {
		System.out.println("\n" + player.getName() + " summons a new chicken!");
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
				case 'c': 	if (player.useEnergy(30)) {
								chicken.setWeaponBonus(100);
								valid = true;
							} else {
								System.out.println("\n" + player.getName()
								+ " does not have enough energy to purchase a grenade.");
							}
							break;
				case 'd':	if (player.useEnergy(1000)) {
								chicken.setWeaponBonus(10000000);
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
		System.out.println("\n" + player.getName() + " energy: " + player.getEnergy());
		if (chicken.getDamage() != 0) {
			System.out.println("chicken damage capability: " + chicken.getDamage());
		}
		System.out.println("potato " + potato.getName() + " health: " + potato.getHealth());
	}

	public static void displayStyles() {
		System.out.println("\n    style:            damage:        cost:");
		System.out.println("(a) Fried Chicken:    10             10");
		System.out.println("(b) Grilled Chicken:  50             50");
		System.out.println("(c) Seasoned Chicken: 100            100");
	}

	public static void displayWeapons() {
		System.out.println("\n    weapon:           damage bonus:  cost:");
		System.out.println("(a) chicken only:     *1             0");
		System.out.println("(b) submachine gun:   *10            10");
		System.out.println("(c) grenade:          *100           30");
		System.out.println("(d) a nuclear rocket: *10000000      1000");
	}

	/* Main control for game progress. */
	public static void main(String[] args) {
		intro(INIT_ENERGY);


		setUpPotato();
		setUpChicken();
	}
}
