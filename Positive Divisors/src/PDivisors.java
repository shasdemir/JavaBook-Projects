// Prints out all the positive divisors of thr input integer.

import java.util.Scanner;

public class PDivisors {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		long input = 1;
		
		System.out.print("Enter a positive integer to factor, 0 to quit: ");
		input = scan.nextInt();
		while (input != 0) {
			String answer = "The positive divisors of " + input + " are:";
		
			long index = 1;
			while (index <= input) {
				if ((input % index) == 0) {
					answer += (" " + Long.toString(index));
				}
				index++;
			}
			
			System.out.println();
			System.out.println(answer);
			System.out.println();
			System.out.print("Enter a positive integer to factor, 0 to quit: ");
			input = scan.nextInt();
		}
		
		if (input == 0)
			System.out.println("Bye bye.");
	}
}
