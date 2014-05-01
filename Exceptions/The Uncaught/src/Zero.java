public class Zero {
    public static void main(String[] args) {
        int numerator = 10;
        int denominator = 0;

        try {
            System.out.println(numerator / denominator);
        } catch (NumberFormatException except) {
            System.out.println("Caught!");
        } finally {
           System.out.println("Finally!");
        }

        System.out.println("This text will not be printed :(");
    }
}
