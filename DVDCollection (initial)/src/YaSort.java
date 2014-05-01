// implements various sorting algorithms for the Comparable interface

import java.lang.reflect.Array;

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
	
	
	public static Comparable[] insertionSort(Comparable[] input) {
        Comparable temp;
        Comparable[] result;
        int nonEmptyInput = 0;

        for (int i = 0; i < input.length; i++) {
            if (input[i] != null)
                nonEmptyInput++;
        }

        result = (Comparable[]) Array.newInstance(
                input.getClass().getComponentType(), nonEmptyInput);

	    for (int m = 0; m < nonEmptyInput; m++)
            result[m] = input[m];

        if (result.length > 1) {
		    for (int k = 1; k < result.length; k++) {
			    for (int j = 1; j <= k; j++) {
				    if (result[k - j].compareTo(result[k - j +
                            1]) > 0) {
					    temp = result[k - j + 1];
					    result[k - j + 1] = result[k - j];
					    result[k - j] = temp;
				    }
			    }
		    }
        }

		return result;
	}
}
