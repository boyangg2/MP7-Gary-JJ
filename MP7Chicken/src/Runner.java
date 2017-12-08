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
	static Player player = new Player();
	/* Potatos object (enemy). */
	static Potato potato = new Potato();

	/* Introduction to game. */
	public static void intro() {
		Scenes.opening();
		System.out.println("What is your name?");
		player.setName(kb.next().toLowerCase());
		potato.setName(player.getName()+"'s angry grandpa");

		System.out.println("Your name is " + player.getName());
		System.out.println("The Evil potato's name: " + potato.getName());
		
		System.out.println("Now. your health is 100 Js");
		int health =100; 
		while(player.getEnergy()>0) {
			potato.setHealth(health);
			System.out.println("Your Evil potato's health is"+ health+"Js");
			System.out.println("Now, the battle begins: What kind of chicken do you wanna use? Type in"
					+ " (Fried (10J) /Grilled (50J) /Seasoned (100J))");
			String chickenType = kb.next().toLowerCase(); 
			int damage;
			if(chickenType.equals("fried")) {
				damage=10;
			}else if(chickenType.equals("grilled")) {
				damage=50;
			}else {
				damage=100;
			}
				
			System.out.println("Do you want to use any weapon bonus? Alert: the weapon bonus may cost you more energy."
					+ "You make have a risk of dying by using this. Type in (Basic(0)/submachine(10)/Grenade(20)/"
					+ "Nuclear Rockets(100)");
			String weaponType = kb.next().toLowerCase();
			int weaponBonus;
			if(weaponType.equals("basic")) {
				weaponBonus=0;
			}else if(weaponType.equals("submachine")) {
				weaponBonus=10;
			}else if(weaponType.equals("grenade")) {
				weaponBonus=20;
			}else {
				weaponBonus=100;
			}
			Chicken chick = new Chicken(damage,weaponBonus);
			}
		}
		
		
		
	}

	

	/* Main control for game progress. */
	public static void main (String[] args) {
		intro();
	}

}
