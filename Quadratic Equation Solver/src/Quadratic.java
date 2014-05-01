// Quadratic equation solver
import java.util.Scanner;

public class Quadratic
{
	public static void main(String[] args)
	{
		double a, b, c; // a^2 +bx + c = 0
		double discriminant, root1, root2;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter the coefficient of x squared: ");
		a = scan.nextDouble();
		
		System.out.print("Enter the coefficient of x: ");
		b = scan.nextDouble();
		
		System.out.print("Enter the constant: ");
		c = scan.nextDouble();
		
		discriminant = Math.pow(b,2) - (4*a*c); // assuming positive discriminant
		root1 = ((-1*b) + Math.sqrt(discriminant)) / (2*a);
		root2 = ((-1*b) - Math.sqrt(discriminant)) / (2*a);
		
		System.out.println("Root 1: " + root1);
		System.out.println("Root #2: " + root2);
		
		double result;
		result = Math.pow(5, 2.5);
		System.out.println("5 to the 2.5 is: " + result);
	}
}
