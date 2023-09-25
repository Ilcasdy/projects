package primary;
import java.util.Scanner;
/**
 * CET - CS Academic Level 3
 * Declaration: I declare that this is my own original work and is free from Plagiarism
 * This is the driver class for lab 1 	
 * Student Name: Sean Bradbury
 * Student Number: 041101614
 * Section #:312
 * Course: CST8130 - Data Structures
 * Professor: George Kriger. 
 * 
 */
public class Lab2 {
	
	/**
	 * displays menu options
	 */
	public static void displayMainMenu() {
		System.out.print("Please select one of the following:\n"
				+ "1: Initialize a default array\n"
				+ "2: To specift the max size of the array\n"
				+ "3: Add value to the array\n"
				+ "4: Display values in the array\n"
				+ "5: Display average of the values, minimum value, maximum value, max mod min, factorialMax\n"
				+ "6: Enter multiple values\n"
				+ "7: Read values from file\n"
				+ "8: Save values to file\n"
				+ "9: To Exit\n"
				+ "> ");
	}
	/**
	 * main method to run menu
	 * @param args - not used
	 */
	public static void main(String[] args) {
		
		Numbers numbers = new Numbers();
		boolean run = true;
		boolean validFloat = false;
		boolean validInt = false;
		int numberOfValues = 0;
		
		Scanner keyboard = new Scanner(System.in);
		
		do {
			int choice;
			
			displayMainMenu();
			
			try {
				choice = keyboard.nextInt();
				keyboard.nextLine();
			}
			catch (Exception e) {
				keyboard.nextLine();
				choice = -1;
			}
			
			switch(choice) {
			
			case 1:
				numbers = new Numbers();
				break;
			case 2:
				System.out.print("Enter new size of array: ");
				boolean validInput = false;
				do {
					try {
						numbers = new Numbers(keyboard.nextInt());
						validInput = true;
					}
					catch(Exception e) {
						keyboard.nextLine();
						System.out.println("Enter a positive integer");
					}
				}
				while(validInput == false);
				break;
			case 3:
				validFloat = false;
				do {
					try {
						System.out.print("Enter value: ");
						numbers.addValue(keyboard.nextFloat());
						validFloat = true;
					}
					catch(Exception e) {
						keyboard.nextLine();
						System.out.println("Please enter a number");
					}
				}
					while (validFloat == false);
				
				break;
			case 4:
				System.out.println(numbers.toString());
				break;
			case 5:
				float average = numbers.calcAverage();
				float[] minMax = numbers.findMinMax();
				float min = minMax[0];
				float max = minMax[1];
				float mod = minMax[2];
				float factorial = numbers.getfactorialMax();
				System.out.printf("Average is %.2f, Minimum value is %.1f, Maximum value is %.1f, max mod min is %.2f, factorial of Max is %.0f%n%n"
						, average, min, max, mod, factorial);
				break;
			case 6:
				validInt = false;
				numberOfValues = 0;
				System.out.print("How many values do you wish to add? ");
				do {
					try {
						numberOfValues = keyboard.nextInt();
						if (numberOfValues < 0) {
							throw new Exception();
						}
						keyboard.nextLine();
						validInt = true;
					}
					catch (Exception e) {
						keyboard.nextLine();
						System.out.println("Please enter a positive integer");
					}
				} while (validInt == false);
				numbers.addValues(keyboard, numberOfValues, true);
				break;
			case 7:
				try {
					numbers.readValues(keyboard);
				} catch (Exception e) {
					System.out.println("File cannot be read");
				}
				break;
			case 8:
				numbers.saveValues(keyboard);	
				break;
			case 9:
				System.out.println("Exiting...");
				keyboard.close();
				run = false;
				break;
			default:
				System.out.println("invalid input, enter options 1-9");
				break;
			}
			
		}
		while(run == true);

	}

}
