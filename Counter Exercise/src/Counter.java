
public class Counter {
	public static void main(String[] args) {
		int count = 50;
		
		while (count <= 60) {		
			System.out.println (count);
			count = count + 1;
			
			if (count == 100)
				break;
		}
	}
}
