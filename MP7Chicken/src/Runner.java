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
	}

	

	/* Main control for game progress. */
	public static void main (String[] args) {
		intro();
	}

}
