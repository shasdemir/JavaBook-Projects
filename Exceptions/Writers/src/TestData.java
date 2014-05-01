import java.util.Random;
import java.io.*;

public class TestData {
    public static void main(String[] args) throws IOException {
        final int MAX = 10;
        int value;
        String file = "test.dat";
        Random myRand = new Random();

        FileWriter myFW = new FileWriter(file);
        BufferedWriter myBW = new BufferedWriter(myFW);
        PrintWriter outFile = new PrintWriter(myBW);

        for (int line = 1; line <= MAX; line++) {
            for (int num = 1; num <= MAX; num++) {
                value = myRand.nextInt(90) + 10;
                outFile.print(value + " ");
            }
            outFile.println();
        }

        outFile.close();
        System.out.println("Output file has been created: " + file);
    }
}
