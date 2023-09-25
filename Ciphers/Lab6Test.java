
/**
 * Program creates a menu system to encrypt and decrypt messages
 * Student Name: Sean Bradbury
 * Student Number: 041101614
 * Course: CST8132 Object Oriented Programming
 * Program: CET-CS-Level 2
 * Professor:  Fedor Ilitchev
 *
 */
import java.util.ArrayList;

import encryption.EncryptionType;
import encryption.ScannerUtils;

/** contains main method and methods for processing user input
 * 
 * @author Sean Bradbury
 *
 */
public class Lab6Test {


	/** asks for and returns an Encryptable object
	 * 
	 * @return either caesar or vigenere cipher object
	 */

	/** main method with a series of menus and prompts for encrypting and decrypting messages
	 *
	 */
	public static void main(String[] args) {
		System.out.println("Encryption tester");
		ArrayList<String> encryptedText = new ArrayList<>();
		int menuChoice;

		do {

			menuChoice = ScannerUtils.getMenuItem("Encrypt text", "Decrypt text", "Display encrypted text", "Exit");

			switch (menuChoice) {

			// encrypts text
			case 1:
				String text = ScannerUtils.getString("\nPlease enter text to be encrypted: ");
				EncryptionType encryptMethod = EncryptionType.getMethod();
				encryptedText.add(encryptMethod.encrypt(text));
				System.out.println("Encrypted value #" + encryptedText.size() + " is: "
						+ encryptedText.get(encryptedText.size() - 1));
				break;

			// decrypts text
			case 2:
				if (encryptedText.size() == 0) {
					System.out.println("Nothing to decrypt");
					break;
				}
				int messageChoice;
				do {
						messageChoice = ScannerUtils.getInt("Message number you want to decrypt: ", 1, encryptedText.size());
				} while (messageChoice == -1);
				EncryptionType decryptMethod = EncryptionType.getMethod();
				String decryptedText = decryptMethod.decrypt(encryptedText.get(messageChoice - 1));
				System.out.println("Decrypted value #" + messageChoice + " is: " + decryptedText);

				break;

			// displays encrypted texts
			case 3:
				if (encryptedText.size() == 0) {
					System.out.println("Nothing to display");
					break;
				}
				System.out.println("------------");
				for (int i = 0; i < encryptedText.size(); i++) {
					System.out.printf("#" + (i + 1) + ": %s%n", encryptedText.get(i));
				}
				System.out.println("------------");
				break;

			// exits program
			case 4:
				System.out.println("Good bye");
				break;
			default:
				menuChoice = -1;
				break;

			}

		}

		while (menuChoice != 4);
	}

}

