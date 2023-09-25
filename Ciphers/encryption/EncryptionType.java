/**
 * Abstract class for encryptions
 * Student Name: Sean Bradbury
 * Student Number: 041101614
 * Course: CST8132 Object Oriented Programming
 * Program: CET-CS-Level 2
 * Professor:  Fedor Ilitchev
 *
 */
package encryption;

import encryption.ciphers.CaesarCipher;
import encryption.ciphers.VigenereCipher;

/**
*  abstract class with encrypt and decrypt methods and contains range of characters allowed.
*  START_CHAR is the space character, 
*  END_CHAR is z in ascii
*  RANGE is END_CHAR - START_CHAR
* 
*  @author - Sean Bradbury
*/
public abstract class EncryptionType {
	public final static int START_CHAR = 32;
	public final static int END_CHAR = 122;
	public final static int RANGE = 91;

	public abstract String encrypt(String input);

	public abstract String decrypt(String input);
	
	/**
	 * @param letter - starting character
	 * @param shift - amount to shift character
	 * @return - shifted character
	 */
	public char shiftChar(char letter, int shift) {
		
		int coded = letter + shift;
		
		while (coded > END_CHAR || coded < START_CHAR) {

			if (coded < START_CHAR) {
				coded = coded + RANGE;
			}
			if (coded > END_CHAR) {
				coded = coded - RANGE;
			}
			
		}
		return (char) coded;
	}
	
	/** prompts for and returns an encryptyionType object
	 * @return - the selected encryption type
	 */
	public static EncryptionType getMethod() {

		System.out.println("Encryption method");
		int menuChoice = ScannerUtils.getMenuItem("Caesar", "Vigenere");
		if (menuChoice == 1) {
			int shift;
			do {
					shift = ScannerUtils.getInt("Shift value: ", 1, Integer.MAX_VALUE);
			} while (shift == -1);
			CaesarCipher caesar = new CaesarCipher(shift);
			return caesar;
		}
		if (menuChoice == 2) {
			String password = ScannerUtils.getString("Password: ");
			VigenereCipher vigenere = new VigenereCipher(password);
			return vigenere;
		}
		return getMethod();
	}

}
