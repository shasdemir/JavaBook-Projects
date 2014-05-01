// Sums up the integers taken from the command line arguments.

public class clsum {
	public static void main(String[] args) {
		int sum = 0;
		
		for (int k = 0; k < args.length; k++)
			sum += Integer.valueOf(args[k]);
		
		System.out.println(sum);
	}
}
