/**
 * Caesar Cipher JUnit tests
 * Student Name: Sean Bradbury
 * Student Number: 041101614
 * Course: CST8132 Object Oriented Programming
 * Program: CET-CS-Level 2
 * Professor:  Fedor Ilitchev
 *
 */
package testing;

import encryption.ciphers.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CaesarCipherTest {
	/**
	 * tests encrypt method for Caesar Cipher
	 */
	@Test
	void testEncrypt() {
		// simple test with no wraparound
		CaesarCipher test1 = new CaesarCipher(5);
		assertEquals("fghij", test1.encrypt("abcde"));
		// test for large shift
		CaesarCipher test2 = new CaesarCipher(500);
		assertEquals("34567", test2.encrypt("abcde"));
		// tests many characters
		CaesarCipher test3 = new CaesarCipher(12);
		assertEquals("_ yq%tuzs,uz,%tq,(m*,$tq,y 'q$", test3.encrypt("Something in the way she moves"));
		// test large shift with many characters
		CaesarCipher test4 = new CaesarCipher(311);
		assertEquals("gF/,DF49F?30F7410", test4.encrypt("A day in the life"));
	}
	/**
	 * tests decrypt method for Caesar Cipher
	 */
	@Test
	void testDecrypt() {
		// simple test with no wraparound
		CaesarCipher test1 = new CaesarCipher(5);
		assertEquals("abcde", test1.decrypt("fghij"));
		// tests large shift
		CaesarCipher test2 = new CaesarCipher(500);
		assertEquals("abcde", test2.decrypt("34567"));
		//test with many characters
		CaesarCipher test3 = new CaesarCipher(12);
		assertEquals("Something in the way she moves", test3.decrypt("_ yq%tuzs,uz,%tq,(m*,$tq,y 'q$"));
		// test large shift with many characters
		CaesarCipher test4 = new CaesarCipher(311);
		assertEquals("A day in the life", test4.decrypt("gF/,DF49F?30F7410"));
	}

}
