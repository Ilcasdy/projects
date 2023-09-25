/**
 * Scanner utlities with static scanner to be used with other programs
 * Student Name: Sean Bradbury
 * Student Number: 041101614
 * Course: CST8132 Object Oriented Programming
 * Program: CET-CS-Level 2
 * Professor:  Fedor Ilitchev
 *
 */

package encryption;

import java.util.Scanner;

public class ScannerUtils {
	
	private static Scanner scanner = new Scanner(System.in);
	
	/** method prints menu items and receives user input
	 * 
	 * @param options - vararg of strings with each string as a menu item
	 * @return int choice - menu item number chosen by user
	 */
	public static int getMenuItem(String... options) {
		int choice;
		for (int i = 0; i < options.length; i++) {
			System.out.printf("\t" + (i + 1) + " - %s%n", options[i]);
		}
		
		try {
			choice = getInt("Select action: ", 1, options.length);
		} catch (Exception e) {
			scanner.nextLine();
			System.out.println("Please enter an integer");
			scanner.close();
			return getMenuItem(options);
		}
		return choice;
	}

	/** gets a string from the user
	 * 
	 * @param prompt - string used to direct the user
	 * @return string of text from user
	 */
	public static String getString(String prompt) {
		String choice;
		System.out.print(prompt);
		choice = scanner.nextLine();
		return choice;
	}

	/** gets an int from the user
	 * 
	 * @param prompt - string used to direct user
	 * @param min - the minimum allowed int choice by user
	 * @param max - the maximum allowed int choice by user
	 * @return - int inputted by user
	 * @throws Exception - if user inputs !int then exception thrown
	 */
	public static int getInt(String prompt, int min, int max) {
		int choice;

		System.out.print(prompt);
		
		try {
		choice = scanner.nextInt();
		} catch(Exception e) {
			scanner.nextLine();
			System.out.println("Please enter an integer");
			return -1;
		}
		scanner.nextLine();
		if (choice < min || choice > max) {
			System.out.println("Please select a number in the range");
			choice = -1;
		}
		return choice;
	}


}
