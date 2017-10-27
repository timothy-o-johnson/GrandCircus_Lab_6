/*
Tim Johnson
10/26/17
Grand Circus
Lab 6
*/

//Application will:
// 1. prompt user for a word
// 2. translate text to Pig Latin and display on the console
// 3. ask the user if whether to translate another word

import java.util.Scanner;

public class TranslateEnglishToPigLatin {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String userInput = "default";

		System.out.print("Hey, you! Enter a line to be translated: ");

		userInput = convertWordToLowercase(sc.nextLine()); // converts word to lowercase

		if (isBeginningOfWordAVowel(userInput)) { //checks if beginning of word is a vowel
			System.out.println(addWay(userInput)); //if begins with a vowel adds "-ay"
		} else {
			System.out.println(translateToPigLatin(userInput)); //translates a word that begins with a consonant to PigLatin
		}

		/*
		 * convertWordToLowercase(userInput); // convert each word to lowercase before
		 * translating isBeginningOfWordAVowel(userInput); addWay(userInput); // add
		 * "way" onto any word starting with a vowel moveConsonantsAndAddAy(userInput);
		 * // if word starts with consonant, move all //consonants that appear before
		 * the // first vowel to the end of the word and then add "ay" to the end of the
		 * word
		 */

	}

	public static String convertWordToLowercase(String string) {
		// convert each word to lowercase before translating
		return string = string.toLowerCase();
	}

	public static boolean isBeginningOfWordAVowel(String userInput) {
		// takes in a String and checks that the first letter is a vowel
		return isCharAVowel(userInput.charAt(0));

	}

	public static String addWay(String userInput) {
		// takes a String and adds "-way"
		return userInput.concat("way");
	}

	public static String translateToPigLatin(String userInput) {
		// take in a String
		// find the ConstantsBeforeVowel
		// find index of the vowel, use this to
		// return just the letters of after the vowel
		// add the beggingConstantBeforeVowel to end of costantsAfterVowel and add "-ay"
		
		String beggingConstantsBeforeVowel = returnConsonantsBeforeVowel(userInput);
		int indexOfVowel = beggingConstantsBeforeVowel.length();
		String lettersAfterVowel = returnLettersAfterTheVowel(userInput, indexOfVowel);

		String ordwayInwayIgpayAtinlay = lettersAfterVowel + beggingConstantsBeforeVowel + "ay";

		return ordwayInwayIgpayAtinlay;


	}

	public static boolean isCharAVowel(char character) {
		// take a character and return true if vowel or false if not
		switch (character) {
		case 'a':
		case 'e':
		case 'i':
		case 'o':
		case 'u':
			return true;
		default:
			return false;
		}
	}

	public static String returnConsonantsBeforeVowel(String userInput) {
		// take in a String return the consonants before the first vowel
		
		String newWord = "";
		String tempChar;

		for (int i = 0; i < userInput.length(); i++) { // loop through each char in the String
			if (!isCharAVowel(userInput.charAt(i))) {  // check that the char is a vowel
				tempChar = String.valueOf(userInput.charAt(i)); // if not a vowel, save char as string
				newWord = newWord + tempChar; // add character to list of consonants before vowel
			} else {
				return newWord; // when it reaches a vowel return the collect of consonants
			}
		}
		
		return newWord;

	}

	public static String returnLettersAfterTheVowel(String userInput, int indexOfVowel) {
		// take an int that is the index of the vowel 
		return userInput.substring(indexOfVowel); // return the the vowel and the letters after that vowel
	}
}