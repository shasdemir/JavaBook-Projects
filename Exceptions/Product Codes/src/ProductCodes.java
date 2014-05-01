import java.util.Scanner;

public class ProductCodes {
    // Counts the # of product codes entered with a zone of R and district
    // greater than 2000.
    public static void main(String[] args) {
        String code;
        char zone;
        int distrct, valid = 0, banned = 0;

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter product code (XXX to quit): ");
        code = scan.nextLine();

        while (!code.equals("XXX")) {
            try {
                zone = code.charAt(9);
                distrct = Integer.parseInt(code.substring(3, 7));
                valid++;
                if (zone == 'R' && distrct > 2000)
                    banned++;
            } catch (StringIndexOutOfBoundsException exception) {
                System.out.println("Improper code length: " + code);
            } catch (NumberFormatException exception) {
                System.out.println("District is not numeric: " + code);
            }

            System.out.println("Enter product code (XXX to quit): ");
            code = scan.nextLine();
        }

        System.out.println("# of valid codes entered: " + valid);
        System.out.println("# of banned codes entered: " + banned);
    }
}
