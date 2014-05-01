// various search algorithms over Comparable
// these return a reference to the found object, null if not found

import java.util.*;

public class YaSearch {
  public static Comparable linearSearch(Comparable[] list, Comparable target) {
		boolean found = false;
		int searchIndex = 0;
		
		while ((found == false) && (searchIndex < list.length)) {
			if (list[searchIndex].compareTo(target) == 0)
				found = true;
			
			searchIndex++;
		}
		
		if (found)
			return list[searchIndex - 1];
		else
			return null;
	}
  
  
  public static Comparable binarySearch(Comparable[] list, Comparable target) {
	  
	  // Assuming the input list is ordered
	  Comparable result;
	  result = null;
	  
	  int xPosition = list.length / 2;
	  
	  if (xPosition == 0) {
		  if (list[xPosition].compareTo(target) == 0)
			  result = list[xPosition];
		  else
			  return result;
	  }
	  
	  int midCompare = list[xPosition].compareTo(target);
	  
	  switch (midCompare) {
	  	case 0: result = list[xPosition];
	  			break;
	  			
	  	case 1: result = binarySearch
	  			(Arrays.copyOfRange(list, 0, xPosition), target);
	  			break;
	  	
	  	case -1: result = binarySearch
	  			(Arrays.copyOfRange(list, xPosition, list.length -1), target);
	  			break;
	  }
	  
	  return result;
  }
}
