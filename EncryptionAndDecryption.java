import java.util.Random;
import java.util.Scanner;

public class EncryptionAndDecryption {

	// global random class for RNG
	public static Random rand = new Random();

	// global scanner class for user input
	public static Scanner in = new Scanner(System.in);

	// main method
	public static void main(String[] args) {

		// declare some variables for future use
		String text;
		int key;
		int choice;

		// system prompt for choice
		System.out.println("Hello! We value your privacy above all at Adriel Enterprises."
				+ "\nWhat can we do for you today?: " + "\n  ---> (1)  Encrypt  \n  ---> (2)  Decrypt ");

		// read the choice
		while (!in.hasNextInt()) {
			System.out.println("That is not a choice. Please try again.");
			System.out.println("\n  ---> (1)  Encrypt  \n  ---> (2)  Decrypt ");
			in.next(); // Discard invalid input
		}
		choice = in.nextInt();

		// check if choice is within range
		while (choice < 1 || choice > 2) {
			System.out.println("That is not a choice. Please try again.");
			System.out.println("\n  ---> (1)  Encrypt  \n  ---> (2)  Decrypt ");
			while (!in.hasNextInt()) {
				System.out.println("That is not a choice. Please try again.");
				System.out.println("\n  ---> (1)  Encrypt  \n  ---> (2)  Decrypt ");
				in.next(); // Discard invalid input
			}
			choice = in.nextInt();
		}

		// system prompt for message to be encrypted or decrypted
		System.out.println("Enter a message: ");
		in.nextLine(); // Consume newline character left by previous nextInt()
		text = in.nextLine();

		// place message into a an array of characters
		char[] textArray = text.toCharArray();

		// choices for encryption or decryption process
		if (choice == 1) {
			encryptHelper(textArray);
		} else {
			// prompt user for key to decrypt
			System.out.println("Please input the key: ");
			key = in.nextInt();

			decryptHelper(textArray, key);
		}

	}// end main

	/*
	 * encryptHelper(char[] array): takes an array of characters as a parameter
	 * generates a random key to cipher and encrypt the user message.
	 */
	public static void encryptHelper(char[] array) {
		// RNG for key
		int key = -1 * (rand.nextInt(25) - 1);

		// for loop to print every character in the
		// array while moving it up/down the ASCII
		for (char x : array) {
			x += key;
			System.out.print(x);

		}
		// print statement to give user the key for decryption
		System.out.println("\nYour key is: " + key);

	}// end encryptHelper

	/*
	 * dencryptHelper(char[] array, int key ): takes an array of characters as a
	 * parameter and a key to decipher and decrypt the user message.
	 */
	public static void decryptHelper(char[] array, int key) {

		// print statement using for loop and key
		System.out.println("Decrypted Message: ");
		for (char x : array) {
			x -= key;
			System.out.print(x);

		}

	}// end decryptHelper

}//end EncryptionAndDecryption
