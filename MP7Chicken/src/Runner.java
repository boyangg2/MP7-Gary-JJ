// Gary, JJ 2017

import java.util.Scanner;

public class Runner {
	static Scanner kb;
	private static String playerName;
	private static String potatoName;

	// introduction, ask name
	public static void intro() {
		System.out.println("What is your name?");
		playerName = kb.next().toLowerCase();
		potatoName = substringPalindrome(playerName);


		System.out.println("Your name is " + playerName);
		System.out.println("The Evil potato's name: " + potatoName);
	}

	public static String substringPalindrome(String w) {
		// return the longest substring of w that is a palindrome
		return w;
	}



	// begin real stuff

	public static void main (String[] args) {
		kb = new Scanner(System.in);
		intro();
	}

}
