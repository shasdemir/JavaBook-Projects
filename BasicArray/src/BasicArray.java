// Basic array use.

public class BasicArray {
	public static void main(String[] args) {
		final int LIMIT = 15, MULTIPLE = 10;
		
		int[] list = new int[LIMIT];
		
		for (int k = 0; k < LIMIT; k++)
			list[k] = k * MULTIPLE;
		
		list[5] = 999;
		
		for (int value : list)
			System.out.print(value + " ");
	}
}
