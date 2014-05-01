import java.util.*;

public class Decode {
    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);

        Stack word = new Stack();

        String message;
        int index = 0;

        System.out.println("Enter the coded message:");
        message = myScan.nextLine();
        System.out.println("The decoded message is:");

        while (index < message.length()) {
            // Push word onto the stack
            while (index < message.length() && message.charAt(index) != ' ') {
                word.push(new Character(message.charAt(index)));
                index++;
            }

            while (!word.empty())
                System.out.print(((Character)word.pop()).charValue());
            System.out.print(" ");
            index++;
        }

        System.out.println();
    }
}
