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
	static final long INIT_ENERGY = 50;

	/* Introduction to game. */
	public static void intro() {
		System.out.print("enter name: ");
		player = new Player(kb.next().toLowerCase(), INIT_ENERGY);
		potato = new Potato(reverseWord(player.getName()) + " 1", INIT_ENERGY);
		
		Scenes.opening();
		System.out.println(player.getName() + " is the master of all chickens.");
		System.out.println(player.getName() + " has the energy to summon chickens!");
		Scenes.wait(4);
	}

	public static String reverseWord(final String w) {
		String rev = "";
		for(int i = w.length() - 1; i >= 0; i--) {
			rev = rev + w.charAt(i);
		}

		
		/* if reversed word = player's name, return player.getName() + "'s angry grandpa" */
		if (rev == w) {
			return w + "'s angry grandpa";
		}
		return rev;
	}

	public static void createChicken() {
		System.out.println("\n" + player.getName() + " summons a new chicken!");
		chicken = new Chicken();

		Scenes.wait(1);

		boolean valid = false;
		char choice;

		while (!valid) {
			displayStats();
			Scenes.displayStyles();
			choice = kb.next().toLowerCase().charAt(0);
			switch (choice) {
				case 'a': 	if (player.useEnergy(10)) {
								chicken.setDamage(10);
								valid = true;
							} else {
								System.out.println("\n" + player.getName()
								+ " does not have enough energy to create Fried Chicken.");
								Scenes.wait(1);
							}
							break;
				case 'b': 	if (player.useEnergy(50)) {
								chicken.setDamage(50);
								valid = true;
							} else {
								System.out.println("\n" + player.getName()
								+ " does not have enough energy to create Grilled Chicken.");
								Scenes.wait(1);
							}
							break;
				case 'c': 	if (player.useEnergy(100)) {
								chicken.setDamage(100);
								valid = true;
							} else {
								System.out.println("\n" + player.getName()
								+ " does not have enough energy to create Seasoned Chicken.");
								Scenes.wait(1);
							}
							break;
				default: 	System.out.println("\ninvalid choice.");
							Scenes.wait(1);
							break;
			}
		}

		System.out.println("\n" + player.getName() + " decides what he wants with the chicken.");
		Scenes.wait(1);

		valid = false;

		while (!valid) {
			displayStats();
			Scenes.displayWeapons();
			choice = kb.next().toLowerCase().charAt(0);
			switch (choice) {
				case 'a': 	valid = true;
							break;
				case 'b': 	if (player.useEnergy(20)) {
								chicken.setWeaponBonus(10);
								valid = true;
							} else {
								System.out.println("\n" + player.getName()
								+ " does not have enough energy to use a submachine gun.");
								Scenes.wait(1);
							}
							break;
				case 'c': 	if (player.useEnergy(1000)) {
								chicken.setWeaponBonus(100);
								valid = true;
							} else {
								System.out.println("\n" + player.getName()
								+ " does not have enough energy to use a grenade.");
								Scenes.wait(1);
							}
							break;
				case 'd':	if (player.useEnergy(10000)) {
								chicken.setWeaponBonus(1000);
								valid = true;
							} else {
								System.out.println("\n" + player.getName()
								+ " does not have enough energy to use a nuclear rocket.");
								Scenes.wait(1);
							}
							break;
				default: 	System.out.println("\ninvalid choice.");
							Scenes.wait(1);
							break;
			}
		}
	}

	public static void prepareBattle() {
		System.out.println();
		Scenes.preBattle();
		Scenes.wait(1);
		displayStats();
		System.out.println();
		Scenes.wait(2);
	}

	public static void displayStats() {
		System.out.println("\n" + player.getName() + "'s energy: " + player.getEnergy());
		if (chicken.getDamage() != 0) {
			System.out.println("chicken damage capability: " + chicken.getDamage());
		}
		System.out.println("potato " + potato.getName() + "'s health: " + potato.getHealth());
	}

	public static void reset() {
		gameCount++;
		player.setEnergy(player.getEnergy() + chicken.getDamage());

		potato.upgrade(gameCount);
		potato.setName(potato.getName().substring(0, potato.getName().length() - 1) 
			+ gameCount);
		Scenes.revealPotato();
		System.out.println("a new evil potato named " + potato.getName() + " appears!");
		Scenes.wait(1);
	}

	public static void gameOver() {
		System.out.println("\n" + player.getName() + " has no energy to summon a chicken.");
		System.out.println(player.getName() + " collapses.\n");
		Scenes.wait(2);
		Scenes.youDied();
	}

	/* Main control for game progress. */
	public static void main(String[] args) {
		intro();
		while (player.isAlive()) {
			createChicken();
			prepareBattle();
			if (chicken.attack(potato)) {
				reset();
			}
			Scenes.wait(1);
		}
		gameOver();
	}
}
