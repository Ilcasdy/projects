package numtesting;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import primary.*;

/**
 * CET - CS Academic Level 3
 * Declaration: I declare that this is my own original work and is free from Plagiarism
 * This Junit test case tests the Numbers class methods	
 * Student Name: Sean Bradbury
 * Student Number: 041101614
 * Section #:312
 * Course: CST8130 - Data Structures
 * Professor: George Kriger. 
 * 
 */
class TestNumbers {
	
	public final static float EPSILON = .00001f;
	static Numbers test;
	static Numbers test2;
	static Numbers test3;
	static Numbers test4;
	/**
	 * Sets up Float arrays to be used for tests 
	 */
	@BeforeEach
	void beforeAllTests() {
		test = new Numbers();
		test2 = new Numbers();
		test3 = new Numbers(1);
		test4 = new Numbers(10);
		// 2.2, 1.1, 3.3 4
		test2.addValue(2.2f);
		test2.addValue(1.1f);
		test2.addValue(3.3f);
		test2.addValue(4);
		// 7
		test3.addValue(7);
		// -5.6453, 1000, 0 ,2, 6.49999
		test4.addValue(-5.6453f);
		test4.addValue(1000);
		test4.addValue(0);
		test4.addValue(2);
		test4.addValue(6.49999f);
		
	}
	
	/**
	 * Tests addValue() method
	 */
	@Test
	public void testAddValue() {
		//default constructor makes array of size 5
		Numbers nums = new Numbers();
		//6 inputs: 3, 2.5, -1.2, 4.65767, 0, 2
		
		//checks simple integer
		nums.addValue(3);
		assertEquals("Numbers are: \n3.0\n", nums.toString());
		//checks decimal number
		nums.addValue(2.5f);
		assertEquals("Numbers are: \n3.0\n2.5\n", nums.toString());
		//checks negative number
		nums.addValue(-1.2f);
		assertEquals("Numbers are: \n3.0\n2.5\n-1.2\n", nums.toString());
		//checks rounding
		nums.addValue(4.65767f);
		assertEquals("Numbers are: \n3.0\n2.5\n-1.2\n4.7\n", nums.toString());
		//checks 0
		nums.addValue(0);
		assertEquals("Numbers are: \n3.0\n2.5\n-1.2\n4.7\n0.0\n", nums.toString());
		//checks when trying to add too many elements
		nums.addValue(2);
		assertEquals("Numbers are: \n3.0\n2.5\n-1.2\n4.7\n0.0\n", nums.toString());
	}
		
		@Test
		void testCalcAverage() {
			//tests for an empty array
			assertEquals(test.calcAverage(), 0);
			//tests values 2.2 1.1 3.3 4
			assertTrue(test2.calcAverage() - 2.65 < EPSILON);
			//tests a single number
			assertEquals(test3.calcAverage(), 7);
			//tests negative numbers, 0, decimal and large numbers
			assertTrue(test4.calcAverage() - 200.570938 < EPSILON);
		}
		/**
		 * Tests that the function is correctly grabbing the minimum value
		 */
		@Test
		void testFindMinMaxMin() {
			// tests empty array
			assertEquals(test.findMinMax()[0], 0);
			//tests values 2.2 1.1 3.3 4
			assertTrue(test2.findMinMax()[0] - 1.1 < EPSILON);
			//tests a single value
			assertEquals(test3.findMinMax()[0], 7);
			//tests negative numbers, 0 , decimals and large integers
			assertTrue(test4.findMinMax()[0] + 5.6453 < EPSILON);
		}
		/**
		 * Tests if function is correctly grabbing largest number
		 */
		@Test
		void testFindMinMaxMax() {
		// tests empty array
		assertEquals(test.findMinMax()[1], 0);
		//tests values 2.2 1.1 3.3 4
		assertTrue(test2.findMinMax()[1] - 4 < EPSILON);
		//tests a single value
		assertEquals(test3.findMinMax()[1], 7);
		//tests negative numbers, 0 , decimals and large integers
		assertEquals(test4.findMinMax()[1], 1000);
		}
		/**
		 * Tests if function is correctly calculating max mod min
		 */
		@Test
		void testFindMinMaxMod() {
		// tests empty array
		assertEquals(test.findMinMax()[2], Float.NaN);
		//tests values 2.2 1.1 3.3 4
		assertTrue(test2.findMinMax()[2] - .7 < EPSILON);
		//tests a single value
		assertEquals(test3.findMinMax()[2], 0);
		//tests negative numbers, 0 , decimals and large integers
		assertTrue(test4.findMinMax()[2] - 3.402823 < EPSILON);
		}
		/**
		 * Tests if function is correctly calculating factorial
		 */
		@Test
		void testGetFactorialMax() {
			// tests empty array
			assertEquals(test.getfactorialMax(), 1);
			// tests max of 4
			assertEquals(test2.getfactorialMax(), 24);
			// tests single element array 7
			assertEquals(test3.getfactorialMax(), 5040);
			// tests 1000, does not calculate correctly since number is too large, gives a 0
			assertEquals(test4.getfactorialMax(), 0);
			
		}
		/**
		 * tests addValues() method for adding multiple values
		 */
		@Test
		void testAddValues() {
			// tests adding 4 values to size 5 array
			Scanner scanner = new Scanner("2.2\n1.1\n3.3\n4\n");
			test.addValues(scanner, 4, false);
			assertEquals(test.toString(), "Numbers are: \n2.2\n1.1\n3.3\n4.0\n");
			// tests adding 4 values to a size 5 array with 4 values already in it
			Scanner scanner2 = new Scanner("2.2\n1.1\n3.3\n4\n");
			test2.addValues(scanner2, 4, false);
			assertEquals(test.toString(), "Numbers are: \n2.2\n1.1\n3.3\n4.0\n");
			// tests adding 4 values to a size 10 array with 5 values already in it
			Scanner scanner3 = new Scanner("2.2\n1.1\n3.3\n4\n");
			test4.addValues(scanner3, 4, false);
			assertEquals(test4.toString(), "Numbers are: \n-5.6\n1000.0\n0.0\n2.0\n6.5\n2.2\n1.1\n3.3\n4.0\n");
		}
		/**
		 *  tests saveValues() method; must save a file with correct data
		 */
		@Test
		void testSaveValues() {
			//tests if file is created and if the values of the object are correctly inputed
			Scanner scanner = new Scanner("testSaveValues.txt\n");
			test2.saveValues(scanner);
			File file = new File("testSaveValues.txt");
			Scanner readFile;
			try {
				readFile = new Scanner(file);
				int numberOfItems = readFile.nextInt();
				for ( int i = 0; i < numberOfItems; i++) {
					test.addValue(readFile.nextFloat());
				}
			} catch (FileNotFoundException e) {
				System.out.println("file not found");
			}
			assertTrue(file.isFile());
			assertEquals(test.toString(), "Numbers are: \n2.2\n1.1\n3.3\n4.0\n");

		}
		/**
		 *  tests the readValues() method. An error message should appear if the file does not exist
		 *  If the file exists with proper values, it should add the values to the array.
		 */
		@Test
		void testReadValues() {
			// tests if file does not exist
			Boolean fileRead = true;
			Scanner scanner = new Scanner("thisisnotafile.oops");
			try {
				test.readValues(scanner);
			} catch (Exception e) {
				fileRead = false;
			}
			assertEquals(fileRead, false);
			// tests correctly reading a file and adding the values to the array
			Scanner scanner2 = new Scanner("testSaveValues.txt\n");
			try {
				test.readValues(scanner2);
				fileRead = true;
			} catch (Exception e) {
				fileRead = false;
			}
			assertEquals(fileRead, true);
			assertEquals(test.toString(), "Numbers are: \n2.2\n1.1\n3.3\n4.0\n");
			
		}
		
		

}
