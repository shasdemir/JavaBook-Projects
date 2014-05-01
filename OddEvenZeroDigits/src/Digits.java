// Takes an integer and counts odd even and zero digits

import java.util.Scanner;

public class Digits {
	public static void main(String[] args) {
		String input;
		Scanner myScan = new Scanner(System.in);
		
		System.out.println("Enter the integer to be counted: ");
		input = myScan.nextLine();
		
		int zeros = 0, evens = 0, odds = 0;
		int digit;
		
		for (int k = 0; k < input.length(); k++) {
			digit = Character.getNumericValue(input.charAt(k));
			
			if (digit == 0)
				zeros++;
			
			if (digit % 2 == 0)
				evens++;
			else
				odds++;
		}
		
		System.out.println("Number of zeros: " + zeros);
		System.out.println("Number of even digits: " + evens);
		System.out.println("Number of odd digits: " + odds);
	}
}
