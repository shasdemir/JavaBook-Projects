// Determines if the input year is a leap year

import java.util.Scanner;

public class LeapYear {
	public static void main(String[] args) {
		Scanner myScan = new Scanner(System.in);
		int input;
		boolean result; // if input is leap year or not
		
		System.out.println("Enter the year, enter 0 to exit.");
		input = myScan.nextInt();
		
		while (input != 0) {
			while (input < 1582){
				System.out.println("ERROR: Year should be after 1582");
				System.out.println("Enter the year, enter 0 to exit.");
				input = myScan.nextInt();
			}
			
			if ((input % 4 == 0) && !((input % 100 == 0) && !(input % 400 == 0)))
				System.out.println("Leap year.");
			else
				System.out.println("NOT leap year.");
			
			System.out.println("Enter the year, enter 0 to exit.");
			input = myScan.nextInt();
		}
		
		System.out.println("Good bye.");
	}
}
