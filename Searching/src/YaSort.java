// implements various sorting algorithms for the Comparable interface

public class YaSort {
	public static Comparable[] selectionSort(Comparable[] input) {
		int smallestOne;
		Comparable temp;
		Comparable[] result;
		result = input.clone();
		
		for (int k = 0; k < result.length - 1; k++) {
			smallestOne = k;
			
			for (int j = k + 1; j < result.length; j++) {
				if (result[smallestOne].compareTo(result[j]) > 0) {
					smallestOne = j;
				}
			}
			
			temp = result[k];
			result[k] = result[smallestOne];
			result[smallestOne] = temp;
		}
		
		return result;
	}
	
	
	public static Comparable[] insertionSort(Comparable[] input) {
		Comparable temp;
		Comparable[] result;
		result = input.clone();
		
		for (int k = 1; k < result.length; k++) {
			for (int j = 1; j <= k; j++) {
				if (result[k - j].compareTo(result[k - j + 1]) > 0) {
					temp = result[k - j + 1];
					result[k - j + 1] = result[k - j];
					result[k - j] = temp;
				}
			}
		}
		
		return result;
	}
}
