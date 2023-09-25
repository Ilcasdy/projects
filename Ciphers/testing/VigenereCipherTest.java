/**
 * Vigenere Cipher JUnit test
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

class VigenereCipherTest {

	/**
	 * tests encrpyt method for Vigenere Cipher
	 */
	@Test
	void testEncrypt() {
		// basic test
		VigenereCipher test1 = new VigenereCipher("test");
		assertEquals("ZL[]^", test1.encrypt("abcde"));
		// complicated test with looped password
		VigenereCipher test2 = new VigenereCipher("Soundgarden");
		assertEquals("u`[VTg.fUOn+ih", test2.encrypt("Black Hole Sun"));
		// tests readable shift with same size password
		VigenereCipher test3 = new VigenereCipher("aaaaa");
		assertEquals("GHIJK", test3.encrypt("abcde"));
		// tests password longer than text to be encrypted
		VigenereCipher test4 = new VigenereCipher("Dazed and Confused");
		assertEquals("oGrRViX", test4.encrypt("Kashmir"));
	}
	/**
	 * tests decrypt method for Vigenere Cipher
	 */
	@Test
	void testDecrypt() {
		// basic test
		VigenereCipher test1 = new VigenereCipher("test");
		assertEquals("abcde", test1.decrypt("ZL[]^"));
		// complicated test with looped password
		VigenereCipher test2 = new VigenereCipher("Soundgarden");
		assertEquals("Black Hole Sun", test2.decrypt("u`[VTg.fUOn+ih"));
		// tests readable shift with same size password
		VigenereCipher test3 = new VigenereCipher("aaaaa");
		assertEquals("abcde", test3.decrypt("GHIJK"));
		// tests password longer than test to be encrypted
		VigenereCipher test4 = new VigenereCipher("Dazed and Confused");
		assertEquals("Kashmir", test4.decrypt("oGrRViX"));
	}

}
