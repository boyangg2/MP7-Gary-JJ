// Gary, JJ 2017

import java.util.Scanner;

public class Runner {
	static Scanner kb = new Scanner(System.in);
	static Player player = new Player();
	static Potato potato = new Potato();

	// introduction, ask name
	public static void intro() {
		System.out.println("What is your name?");
		player.setName(kb.next().toLowerCase());
		potato.setName(substringPalindrome(player.getName()));

		System.out.println("Your name is " + player.getName());
		System.out.println("The Evil potato's name: " + potato.getName());
	}

	public static String substringPalindrome(final String w) {
		// return the longest substring of w that is a palindrome
		return w;
	}



	// begin real stuff

	public static void main (String[] args) {
		intro();
	}

}
