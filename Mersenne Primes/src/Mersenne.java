import java.math.BigInteger;
import java.util.Scanner; // SH

public class Mersenne
{
 
    public static boolean isPrime(int p) {
        if (p == 2)
            return true;
        else if (p <= 1 || p % 2 == 0)
            return false;
        else {
            int to = (int)Math.sqrt(p);
            for (int i = 3; i <= to; i += 2)
                if (p % i == 0)
                    return false;
            return true;
        }
    }
 
    public static boolean isMersennePrime(int p) {
        if (p == 2)
            return true;
        else {
            BigInteger m_p = BigInteger.ONE.shiftLeft(p).subtract(BigInteger.ONE);
            BigInteger s = BigInteger.valueOf(4);
            for (int i = 3; i <= p; i++)
                s = s.multiply(s).subtract(BigInteger.valueOf(2)).mod(m_p);
            return s.equals(BigInteger.ZERO);
        }
    }
 
    // an arbitrary upper bound can be given as an argument
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in); // SH
        
    	int upb;
        if (args.length == 0) {
            //upb = 500;
        	System.out.println("Enter the upper bound (?th Mersenne number): "); //
        	upb = keyboard.nextInt();
        }
        else
            upb = Integer.parseInt(args[0]);
 
        System.out.print(" Finding Mersenne primes in M[2.." + upb + "]:\nM2 ");
        for (int p = 3; p <= upb; p += 2)
            if (isPrime(p) && isMersennePrime(p))
        	//if (isMersennePrime(p))
                System.out.print(" M" + p);
        System.out.println();
    }
}