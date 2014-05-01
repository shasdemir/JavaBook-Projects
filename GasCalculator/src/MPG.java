/* MPG Calculator
 * MPG: Miles per gallon of fuel
 */

import java.util.Scanner;

public class MPG
{
	public static void main(String[] args)
	{
		double miles;
		double gallons;
		double mpg;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter the distance travelled in miles:");
		miles =  scan.nextDouble();
		
		System.out.print("Enter the amount of fuel spent in gallons:");
		gallons = scan.nextDouble();
		
		mpg = miles / gallons;
		System.out.println("You've made " + mpg + " miles per gallon.");
	}
}
