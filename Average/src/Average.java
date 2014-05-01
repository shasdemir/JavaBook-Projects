// Computes the average of the numbers entered by the user.
// Enter 0 to stop inputs.

import java.util.Scanner;

public class Average {
	public static void main(String[] args) {
		double nextInput;
		double sum = 0;
		int inputnumber = 0;
		
		Scanner scan = new Scanner(System.in);
		
		nextInput = 1; // just to start the loop
		
		while (nextInput != 0) {
			System.out.print("Enter a number to the sample, enter 0 to stop: ");
			nextInput = scan.nextDouble();
			sum += nextInput;
			inputnumber++;
		}
		
		if ((inputnumber - 1) != 0) {
			double average = sum/(inputnumber -1);
			System.out.println("The average is: " + average);
		}
		else {
			System.out.println("No valid input entered.");
		}
	}
}
