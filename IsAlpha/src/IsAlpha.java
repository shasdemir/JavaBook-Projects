// tests if the input is alphanumeric or not

import java.util.Scanner;

public class IsAlpha {
	public static void main(String[] args) {
		String goon = "y";
		Scanner myScan = new Scanner(System.in);
		
		while (goon.equalsIgnoreCase("y")) {
			System.out.print("Enter a single character:");
			char input = myScan.nextLine().charAt(0);
		
			if (Character.isLetter(input))
				System.out.println("YES");
			else
				System.out.println("NO");
			
			System.out.print("Another? (y/n)");
			goon = myScan.nextLine();
		}
		
		System.out.print("Good bye.");
	}
}
