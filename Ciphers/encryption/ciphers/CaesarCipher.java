/**
 * Encrypts and decrypts messages using Caesar Cipher
 * Student Name: Sean Bradbury
 * Student Number: 041101614
 * Course: CST8132 Object Oriented Programming
 * Program: CET-CS-Level 2
 * Professor:  Fedor Ilitchev
 *
 */
package encryption.ciphers;

import encryption.EncryptionType;

/** class uses Caesar Cipher to encrypt and decrypt messages
 * @author Sean Bradbury
 */
public class CaesarCipher extends EncryptionType {

	// key used as cipher shift
	private int key;

	/** CaesarCipher constructor
	 * @param shift the number of places to shift the letter
	 */
	public CaesarCipher(int shift) {

		this.key = shift;
	}

	/** encrypts message using key to shift letters
	 * @param input the string to be encrypted
	 * @return the encrypted string
	 */
	@Override
	public String encrypt(String input) {
		char[] splitString = input.toCharArray();

		for (int i = 0; i < splitString.length; i++) {
			
			splitString[i] = shiftChar(splitString[i], key);

		}

		String encrypted = new String(splitString);
		return encrypted;
	}

	/** decrypts message using key to shift letters back
	 * @param input the string to be decrypted
	 * @return the decrypted string
	 */
	@Override
	public String decrypt(String input) {

		char[] splitString = input.toCharArray();

		for (int i = 0; i < splitString.length; i++) {

			splitString[i] = shiftChar(splitString[i], (0 - key));

		}
		String decrypted = new String(splitString);
		return decrypted;
	}

}
