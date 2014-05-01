// Class describing the bank accounts

import java.text.NumberFormat;

public class Account {
	
	private String holderName;
	private int accountNumber;
	
	// totalTTax: total transactions tax accrued
	// totalVolume: total volume of transactions
	private double balance, totalVolume, totalTTax;
	private double iRate, tTaxRate; // interest rate, transaction tax rate
	private double interestTaxRate, totalIntTax;
	
	double totalFees; // total fee revenue for the period from this customer
	
	public Account(String holderName, int accountNumber, double initialBalance) {
		this.holderName = holderName;
		this.accountNumber = accountNumber;
		balance = 0;
		totalVolume = 0;
		totalTTax = 0;
		totalIntTax = 0;
		
		// set the variables and call deposit method for
		// initial balance
		
		/***********************************
		 ***** RATES ARE SET FROM HERE *****
		 ***********************************/
		iRate = 0.035;				// interest rate
		tTaxRate = 0.0002;			// transaction tax rate
		interestTaxRate = 0.15;		// interest tax rate
		/*********** UNTIL HERE ************/
		
		deposit(initialBalance); // oh yeah
	}
	
	public double deposit(double amountIn) {
		if (amountIn >= 0) {
			balance += amountIn;
			totalVolume += amountIn;
			totalTTax += amountIn * tTaxRate;
		}
		else
			System.out.println("ERROR: Cannot deposit a negative amount");
		
		return balance;
	}
	
	public double withdraw(double amountOut, double feeAmount) {
		
		/* would be more realistic if we calculated the fees from a fee
		   rate that would be multiplied by the amount withdrawn, but
		   the book does it with a fee amount input, so here we go... */
		if (balance >= (amountOut + feeAmount)) {
			balance -= (amountOut + feeAmount);
			
			totalVolume += amountOut;
			totalTTax += amountOut * tTaxRate;
			totalFees += feeAmount;
		}
		else
			System.out.println("ERROR: Cannot withdraw more than account balance.");

		return balance;
	}

	public void addInterest() {
		double interest = balance * iRate;
		balance += interest;
		totalIntTax += interest * interestTaxRate;
	}
	
	public void closeBooks() {
		NumberFormat fmtCurrency = NumberFormat.getCurrencyInstance();
		// report
		System.out.println();
		System.out.println("***Start closing of books***");
		System.out.println();
		System.out.println("Account number: " + "\t\t" + accountNumber);
		System.out.println("Account holder: " + "\t\t" + holderName);
		System.out.println("Account balance: " + "\t\t" + fmtCurrency.format(balance));
		System.out.println();
		System.out.println("Total transaction volume: " + "\t" + fmtCurrency.format(totalVolume));
		System.out.println("Total transaction taxes: " + "\t" + fmtCurrency.format(totalTTax));
		System.out.println("Total interest taxes: " + "\t\t" + fmtCurrency.format(totalIntTax));
		System.out.println("TOTAL FEE REVENUE: " + "\t\t" + fmtCurrency.format(totalFees));
		System.out.println("***End closing of books***");
		
		// close
		totalTTax = 0;
		totalIntTax = 0;
		totalFees = 0;
	}
	
	public String toString() {
		String returnString;
		NumberFormat fmtCurrency = NumberFormat.getCurrencyInstance();
		returnString = accountNumber + "\t" + holderName + "\t" +
						fmtCurrency.format(balance);
		
		return returnString;
	}
}
