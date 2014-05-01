// implements various sorting algorithms for the Comparable interface

import java.util.ArrayList;

public class YaSort {
	public static Comparable[] selectionSort(Comparable[] input) {
		int largestOne;
		Comparable temp;
		Comparable[] result;
		result = input.clone();
		
		for (int k = 0; k < result.length - 1; k++) {
			largestOne = k;
			
			for (int j = k + 1; j < result.length; j++) {
				if (result[largestOne].compareTo(result[j]) < 0) {
					largestOne = j;
				}
			}
			
			temp = result[k];
			result[k] = result[largestOne];
			result[largestOne] = temp;
		}
		
		return result;
	}
	
	
	public static <T extends Comparable<? super T>> ArrayList<T> insertionSort(
            ArrayList<T> input) {
        T temp;
		ArrayList<T> result = new ArrayList<T>(input);

        if (result.size() > 1) {
		    for (int k = 1; k < result.size(); k++) {
			    for (int j = 1; j <= k; j++) {
				    if (result.get(k - j).compareTo(result.get(k - j + 1)) >0){
					    temp = result.get(k - j + 1);
					    result.set(k - j + 1, result.get(k - j));
					    result.set(k - j, temp);
				    }
			    }
		    }
        }

		return result;
	}
}
