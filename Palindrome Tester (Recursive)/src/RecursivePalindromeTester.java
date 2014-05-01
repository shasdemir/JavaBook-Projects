import java.util.Scanner;

public class RecursivePalindromeTester {
    private static boolean isPalindrome(String input) {
        if (input.length() == 1)
            return true;
        else if (input.length() == 2)
            return  (input.charAt(0) == input.charAt(1));
        else
            return isPalindrome("" + input.charAt(0) + input.charAt(input
                    .length()-1)) && isPalindrome(input.substring(1,
                    input.length()-1));
    }

    public static void main(String[] args) {
        Scanner mySc = new Scanner(System.in);
        System.out.println("Enter the text to be tested: ");
        String input = mySc.nextLine();

        System.out.println("Result: " + isPalindrome(input));
    }
}
