// Input is a sentence, counts uppercase and lowercase letters and outputs the
// number each letter is used in the sentence.

import java.util.Scanner;

public class LettersList {
	public static void main(String[] args) {
		final int NUMLETTERS = 26;
		int[] upperCounts = new int[NUMLETTERS];
		int[] lowerCounts = new int[NUMLETTERS];
		int nonLetters = 0;
		Scanner lineScanner = new Scanner(System.in);
		
		System.out.println("Enter a sentence:");
		String input = lineScanner.nextLine();
		
		for (int k = 0; k < input.length(); k++) {
			char currentChar = input.charAt(k);
			
			if (currentChar >= 'A' && currentChar <= 'Z')
				upperCounts[currentChar - 'A']++;
			else if (currentChar >= 'a' && currentChar <= 'z')
				lowerCounts[currentChar - 'a']++;
			else
				nonLetters++;
		}
		
		System.out.println("There are " + nonLetters + 
				" non-letter characters. The letter counts are: ");
		System.out.println();
		
		for (int i = 0; i < NUMLETTERS; i++)
			System.out.println((char)('A' + i) + ": " + upperCounts[i] + "\t" +
				(char)('a' + i) + ": " + lowerCounts[i]);
	}
}