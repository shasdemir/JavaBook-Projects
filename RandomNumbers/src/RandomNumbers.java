// Randoms
import java.util.Random;

public class RandomNumbers
{
	public static void main(String[] args)
	{
		Random rng = new Random();
		int num1;
		float num2;
		
		num1 = rng.nextInt();
		System.out.println("A random integer: " + num1);
		
		num1 = rng.nextInt(10);
		System.out.println("From 0 to 9: " + num1);
		
		num2 = rng.nextFloat()*6;
		num1 = (int)num2 + 1;
		System.out.println("From 1 to 6: " + num1);
		
		// cba with others 
	}
}