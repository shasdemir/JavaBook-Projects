// Driver to test some rational numbers

public class RationalTester {
	public static void main(String[] args) {
		RationalNumber r1 = new RationalNumber(6, 8);
		RationalNumber r2 = new RationalNumber(1, 3);
		RationalNumber r3, r4, r5, r6, r7;
		
		System.out.println("First rational number: " + r1);
		System.out.println("Second rational number: " + r2);
		
		if (r1.isLike(r2))
			System.out.println("r1 and r2 are equal.");
		else
			System.out.println("r1 and r2 are NOT equal.");
		
		r3 = r1.reciprocal();
		System.out.println("The reciprocal of r1 is: " + r3);
		
		r4 = r1.add(r2);
		r5 = r1.subtract(r2);
		r6 = r1.multiply(r2);
		r7 = r1.divide(r2);
		
		System.out.println("r1 + r2: " + r4);
		System.out.println("r1 - r2: " + r5);
		System.out.println("r1 * r2: " + r6);
		System.out.println("r1 / r2: " + r7);
		System.out.println();
		System.out.println();
		System.out.println("NEW TEST BEGINS HERE!!!");
		RationalNumber rn = new RationalNumber(3, 5);
		RationalNumber rn2 = new RationalNumber(7, 2);
		System.out.println("rk: " + rn);
		System.out.println("rk2: " + rn2);
		System.out.println(rn.compareTo(rn2));
	}
}
