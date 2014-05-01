// Test if an input word is a palindrome
// ...with nested while loops.

import java.util.Scanner;

public class PalindromeTester {
	public static void main(String[] args) {
		String input, another = "y";
		int left, right;
		
		Scanner scan = new Scanner(System.in);
		
		while (another.equalsIgnoreCase("y")) {
			System.out.println("Enter a potential palindrome: ");
			input = scan.nextLine();
			
			input = ReduceString(input);
			
			left = 0;
			right = input.length() - 1;
			
			while (input.charAt(left) == input.charAt(right) && left <= right) {
				left++;
				right--;
			}
			
			System.out.println();
			if (left < right)
				System.out.println("That string is NOT a palindrome.");
			else
				System.out.println("That string IS a palindrome.");
			
			System.out.println();
			System.out.print("Test another palindrome (y/n)? ");
			another = scan.nextLine();
		}
		
		System.out.println("Goodbye.");
	}
	
	private static String ReduceString(String rawString) {
		String output = "";
		char test;
		
		for (int i = 0; i < rawString.length(); i++) {
			test = rawString.charAt(i);
			
			if (Character.isLetter(test)) {
				output += Character.toLowerCase(test);
			}
		}
		
		return output;
	}
}
