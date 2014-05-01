import java.text.DecimalFormat;
import java.util.Scanner;

public class Fibonacci {
    private static long Fibo(int n) { // calculates nth fibonacci
    // number
        long result;
        if (n == 1)
            result = 0;
        else if (n == 2)
            result = 1;
        else
            result = Fibo(n - 1) + Fibo(n - 2);

        return result;
    }


    public static void main(String[] args) {
        Scanner mySc = new Scanner(System.in);

        System.out.println("Which Fibonacci number do you want? Enter 1, " +
                "2, ... :");
        int n = mySc.nextInt();

        DecimalFormat myForm = new DecimalFormat("###,###,###,###");
        System.out.println(n + "th Fibonacci number is: " + myForm.format
                (Fibo(n)) + ".");
    }
}
