import java.util.Scanner;

public class TextLengthValidator {
    public static void main(String[] args) throws StringTooLongException {
        Scanner myScan = new Scanner(System.in);
        String entered;

        System.out.println("Enter some text to be validated. Enter \"DONE\" " +
                "to quit.");

        entered = myScan.nextLine();
        while (!entered.equals("DONE")) {
            try {
                if (entered.length() >= 20) throw new StringTooLongException("The" +
                        " text you entered has 20 or more characters.");
            } catch (StringTooLongException myEx) {
                System.out.println("The text you have entered has 20 or more " +
                        "characters.");
            }

            System.out.println("Enter some text to be validated. Enter \"DONE\" " +
                    "to quit.");

            entered = myScan.nextLine();
        }

        System.out.println("Good bye!");
    }
}
