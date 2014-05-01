import java.util.Scanner;

public class ReverseOrder {
	public static void main(String[] args) {
		final int numberCount = 10;
		
		Scanner myScanner = new Scanner(System.in);
		int[] numbers = new int[numberCount];
		
		for (int k = 1; k <= numberCount; k++) {
			System.out.print("Enter the number " + k + ": ");
			numbers[numberCount - k] = myScanner.nextInt();
		}
		
		for (int j = 1; j <= numberCount; j++)
			System.out.println(numbers[j - 1]);
	}
}
