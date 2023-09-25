/**
 * encrypts and decrypts messages using Vigenere Cipher
 * Student Name: Sean Bradbury
 * Student Number: 041101614
 * Course: CST8132 Object Oriented Programming
 * Program: CET-CS-Level 2
 * Professor:  Fedor Ilitchev
 *
 */
package encryption.ciphers;

import encryption.EncryptionType;

/** uses Vigenere Cipher to encrypt and decrypt messages
 * @author Sean Bradbury
 */
public class VigenereCipher extends EncryptionType {

	private String key;
	private int keyLength;

	/**VigenereCipher constructor
	 * @param password the string used as the password phrase
	 */
	public VigenereCipher(String password) {

		this.key = password;
		this.keyLength = password.length();
	}

	/** encrypts message, loops password as necessary
	 * @param input - the string to be encrypted
	 * @return the encrypted string
	 */
	@Override
	public String encrypt(String input) {
		char[] passwordLoop = new char[input.length()];
		char[] splitString = input.toCharArray();

		for (int i = 0; i < input.length(); i++) {
			int divisor = i / keyLength;
			passwordLoop[i] = key.charAt(i - (keyLength * divisor));
		}

		for (int i = 0; i < splitString.length; i++) {

			splitString[i] = shiftChar(splitString[i], (passwordLoop[i] - START_CHAR));
		}

		String encrypted = new String(splitString);
		return encrypted;
	}

	/** decrypts message
	 * @param input - the string to be decrypted
	 * @return the decrypted string
	 */
	@Override
	public String decrypt(String input) {

		char[] passwordLoop = new char[input.length()];
		char[] splitString = input.toCharArray();

		// loops password to size of input
		for (int i = 0; i < input.length(); i++) {
			int divisor = i / keyLength;
			passwordLoop[i] = key.charAt(i - (keyLength * divisor));
		}

		for (int i = 0; i < splitString.length; i++) {

			splitString[i] = shiftChar(splitString[i], (START_CHAR - passwordLoop[i]));
		}

		String decrypted = new String(splitString);
		return decrypted;
	}

}
