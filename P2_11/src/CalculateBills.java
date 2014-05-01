/* Problem 2-11, from
    Lewis-Loftus	*/

import java.util.Scanner;

public class CalculateBills
{
	public static void main(String[] args)
	{
		double money;
		
		Scanner myScanner = new Scanner(System.in);
		System.out.print("Enter the amount of money to be calculated: ");
		money = myScanner.nextDouble();
		
		int tens, fives, ones;
		int quarters, dimes, nickles, pennies;
		double remainder;
		
		/* Assuming: quarter = $0.25
		 * 			 dime 	 = $0.10
		 * 			 nickle	 = $0.05
		 *			 penny 	 = $0.01 */
		
		remainder = money;
		
		tens = (int)((remainder - remainder % 10) / 10);
		remainder %= 10;
		
		fives = (int)((remainder - (remainder % 5)) / 5);
		remainder %= 5;
		
		ones = (int)((remainder - (remainder % 1)) / 1);
		remainder %= 1;
		
		quarters = (int)((remainder - (remainder % 0.25)) / 0.25);
		remainder %= 0.25;
		
		dimes = (int)((remainder - (remainder % 0.1)) / 0.1);
		remainder %= 0.1;
		
		nickles = (int)((remainder - (remainder % 0.05)) / 0.05);
		remainder %= 0.05;
		
		pennies = (int)((remainder - (remainder % 0.01)) / 0.01);
		//remainder %= 0.01;
			
		System.out.println("You have entered: " + money + 
				" which is equal to:");
		System.out.println(tens + " ten dollar bills,");
		System.out.println(fives + " five dollar bills,");
		System.out.println(ones + " one dollar bills.");
		System.out.println(quarters + " quarters,");
		System.out.println(dimes + " dimes,");
		System.out.println(nickles + " nickles,");
		System.out.println(pennies + " pennies.");
	}
}



