// Represents a rational number.

// !! combine the 2 reduce methods

public class RationalNumber {
	private int num, denom;
	
	public RationalNumber(int numerator, int denominator) {
		num = numerator;
		denom = denominator;
		
		if (denom == 0)
			denom = 1; // why? why not an error?
		
		if (denom < 0) {
			num *= -1;
			denom *= -1;
		}
		
		reduce(); // crashes if used with returning reduce method
	}
	
	
	public int getNumerator() {
		return num;
	}
	
	
	public int getDenominator() {
		return denom;
	}
	
	
	public void setNumerator(int numerator) {
		num = numerator;
	}
	
	
	public void setDenominator(int denominator) {
		if (denominator != 0)
			denom = denominator;
	}
	
	
	public RationalNumber reciprocal() {
		return new RationalNumber(denom, num);
	}
	
	
	public RationalNumber add(RationalNumber op2) {
		int commonDenominator = denom * op2.getDenominator();
		int numerator1 = num * op2.getDenominator();
		int numerator2 = op2.getNumerator() * denom;
		int sum = numerator1 + numerator2;
		
		return new RationalNumber(sum, commonDenominator);
	}
	
	
	public RationalNumber subtract(RationalNumber op2) {
		int commonDenominator = denom * op2.getDenominator();
		int numerator1 = num * op2.getDenominator();
		int numerator2 = op2.getNumerator() * denom;
		int diff = numerator1 - numerator2;
		return new RationalNumber(diff, commonDenominator);
	}
	
	
	public RationalNumber multiply(RationalNumber op2) {
		int num1 = num * op2.getNumerator();
		int denom1 = denom * op2.getDenominator();
		return new RationalNumber(num1, denom1);
	}
	
	
	public RationalNumber divide(RationalNumber op2) {
		return multiply(op2.reciprocal());
	}
	
	
	public boolean isLike(RationalNumber op2) {
		
		// This actually checks if the numbers are mathematically equal
		return (reducedForm().getNumerator() == 
				op2.reducedForm().getNumerator()
				&& reducedForm().getDenominator() ==
				op2.reducedForm().getDenominator());
	}
	
	
	public String toString() {
		String result;
		
		if (num == 0)
			result = "0";
		else if (denom == 1)
			result = Integer.toString(num);
		else
			result = num + "/" + denom;
		
		return result;
	}
	
	
	public static int gcd(int num1, int num2) { // recheck this
		while (num1 != num2) {
			if (num1 > num2)
				num1 -= num2;
			else
				num2 -= num1;
		}
		
		return num1;
	}
	
	// Returns the reduced form, doesnt update this
	private RationalNumber reducedForm() {
		int newNum = num, newDenom = denom;
		
		if (num != 0) {
			int common = gcd(Math.abs(num), denom);
			
			newNum = num / common;
			newDenom = denom / common;
		}
		
		return new RationalNumber(newNum, newDenom);
	}
	
	// Updates this, doesnt return
	private void reduce() {
		if (num != 0) {
			int common = gcd(Math.abs(num), denom);
			
			num = num / common;
			denom = denom / common;
		}
	}
}