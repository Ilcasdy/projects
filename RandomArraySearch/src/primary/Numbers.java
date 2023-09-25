package primary;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * CET - CS Academic Level 3
 * Declaration: I declare that this is my own original work and is free from Plagiarism
 * This class contains the dynamically allocated array and it's processing	
 * Student Name: Sean Bradbury
 * Student Number: 041101614
 * Section #:312
 * Course: CST8130 - Data Structures
 * Professor: George Kriger.
 * 
 */
public class Numbers {
	/**
	 * Stores Float values.
	 */
	private Float [] numbers;
	
	/**
	 * stores the size of the array
	 */
	private int size;
	
	/**
	 * Store the number of items currently in the array.
	 */
	private int numItems;

	/**
	 * Default Constructor, intializes array to size 5
	 */
	public Numbers() {
		numbers = new Float[5];
		size = numbers.length;
	}

	/**
	 * Constructor that initializes the numbers array.
	 * @param size - Max size of the numbers array
	 */
	public Numbers(int size) {
		numbers = new Float[size];
		this.size = size;
	}
	
	/**
	 * Adds a value in the array
	 * @param num - float entered by user
	 */
	public void addValue(float num) {
		if (numItems >= size) {
			System.out.println("Array full");
		}
		else {
			numbers[numItems] = num;
			numItems++;
		}
	}
	/**
	 * Adds multiple values to an array either through user input or a file
	 * @param scanner either user input or a file
	 * @param numberOfValues the size of the array
	 * @param isUserInput if true then user input, if false it is from a file
	 */
	public void addValues(Scanner scanner, int numberOfValues, boolean isUserInput) {
		boolean validFloat = false;
		if ( numItems + numberOfValues > size ) {
			System.out.println("No room in array to add all values");
			return;
		}
		for (int i = 0; i < numberOfValues; i++) {
			do {
				try {
					if (isUserInput == true) {
					System.out.print("Enter value: ");
					}
					validFloat = false;
					addValue(scanner.nextFloat());
					scanner.nextLine();
					validFloat = true;
				}
				catch(Exception e) {
					scanner.nextLine();
					System.out.println("Please enter a number");
				}
			}
				while (validFloat == false);
		}
	}
	/**
	 * This method reads from a file and adds the values to the Numbers array
	 * @param keyboard Scanner(System.in) to get name of the file
	 * @throws Exception if the file does not exist will throw an exception
	 */
	public void readValues(Scanner keyboard) throws Exception {
		System.out.println("Name of the file to read from: ");
		File name = new File(keyboard.nextLine());
		Scanner file = new Scanner(name);
		addValues(file, file.nextInt(), false);
		file.close();
		
	}
	/**
	 * This method saves the current Numbers array into a file.
	 * The first line is the int size of the array, 
	 * and then each value of the array is printed on its own line
	 * @param keyboard should be a Scanner(System.in) object to take user input to name file
	 */
	public void saveValues(Scanner keyboard) {
		System.out.println("Name of the file to save to: ");
		String fileName = keyboard.nextLine();
		try {
			FileWriter file = new FileWriter(fileName);
			file.write(numItems + "\n");
			for (int i = 0; i < numItems; i++) {
				file.write(numbers[i] + "\n");
			}
			file.close();
			
		} catch (IOException e) {
			System.out.println("File not created");
		}
	}
	
	/**
	 * Calculates the average of all the values in the numbers array.
	 * @return float value that represents the average, if array is empty then returns 0
	 */
	public float calcAverage() {
		float temp = 0;
		for (int i = 0; i < numItems; i++) {
			temp += numbers[i];
		}
		if (numItems == 0) {
			return 0.0f;
		}
		else {
			return temp / numItems;
		}
	}
	/**
	 * returns the min and max value of array and the max value modulo min value
	 * @return minMax - a float array where index 0 is the min, 
	 * 			index 1 is the max, and index 2 is the modulo result
	 */
	public float[] findMinMax() {
		float[] minMax = new float[3];
		
		if (numItems == 0) {
			minMax[0] = 0;
			minMax[1] = 0;
		}
		else {
		
			// min value
			minMax[0] = Float.MAX_VALUE;
			// max value
			minMax[1] = -Float.MAX_VALUE;
			for (int i = 0; i < numItems; i++) {
				if (numbers[i] < minMax[0]) {
					minMax[0] = numbers[i];
				}
				if (numbers[i] > minMax[1]) {
					minMax[1] = numbers[i];
				}
			}
		}
		//max mod min value
		minMax[2] = minMax[1] % minMax[0];
		return minMax;
	}
	/**
	 * uses findMinMax() to get max value, drops the decimal, and calculates factorial
	 * @return answer - the factorial of the max value
	 */
	public int getfactorialMax() {
		int answer = 1;
		float[] minMax = findMinMax();
		int dropDecimal = (int) minMax[1];
		for (int i = dropDecimal; i > 1; i--) {
			answer *= i;
		}
		return answer;
}
	/**
	 * returns a string of the array values
	 */
	@Override
	public String toString() {
		String values = "Numbers are: \n";
		for (int i = 0; i < numItems; i++) {
			values = values + String.format("%.1f", numbers[i]) + "\n";
		}
		return values;
	}
	
}
// File file = new File(name)