// NumberFormat exercise

import java.util.Scanner;
import java.text.NumberFormat;

public class Purchase {
	public static void main(String[] args) {
		final double TAX_RATE = 0.06;
		
		int quantity;
		double subtotal, tax, totalCost, unitPrice;
		
		Scanner mySc = new Scanner(System.in);
		
		NumberFormat fmtCurrency = NumberFormat.getCurrencyInstance();
		NumberFormat fmtPercent = NumberFormat.getPercentInstance();
		
		System.out.println("Enter the price of one unit: ");
		unitPrice = mySc.nextDouble();
		
		System.out.println("Enter the number of units: ");
		quantity = mySc.nextInt();
		
		subtotal = quantity * unitPrice;
		tax = subtotal * TAX_RATE;
		totalCost = subtotal + tax;
		
		System.out.println("Subtotal before tax is: " + fmtCurrency.format(subtotal));
		System.out.println("Taxes paid: " + fmtCurrency.format(tax) + ", at rate: " + fmtPercent.format(TAX_RATE));
		System.out.println("Total cost is: " + fmtCurrency.format(totalCost));
	}
}
