/******************************************************************************
 	countIntegers counts the number of integers and impure integers
 	in an input string. If printInts is true, it primts the integers.

 	isPureInteger determines if the input is a pure integer, like "30,000". It
 	also printlns the input if printInts is true.

 	isImpureInteger determines if the input is sufficiently integer-like. It
 	also printlns the integers if printInts input is true.

 	main takes an input file, passes it to countIntegers, printlns the result.
 	
 	Integer-like strings are a subset of those that include integers, but also 
 	other characters without whitespace. They are currently counted as an 
 	integer. Some examples: "f(5)", "{300}", "$1000", "42.", "f($10,000).",
 	"62?", "[34]", "Var(23X)", "([(5".
 	Currently, the follwing types are NOT counted as integer: "6th", "30Rock",
 	")])5, "\"23\"", which is "23" as String.
 	
 	Also, only the contents of the first innermost pair of brackets is checked,
 	for example "{[f(5)/(y+7)]+8}" will only check if "5" is an integer, and
 	return 1. I may implement multi-level brackets in the future, but cba now.
 	Note that "{[f(5) / (y + 7)] + 8}" will correctly return 3 because of the
 	proper use of whitespace.
 	
 	This could also have been implemented with characterwise logic, but I chose
	not to. Because I didn't want to deal with the logic for 1000s separator 
	commas and decimal points.
	
	The next iteration could be to modify reduceBrackets so that it would
	separate each level of brackets and return them as arrays. Then, all of
	arrays would be processed regularly.
******************************************************************************/

import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class NumIntegers {
	public static int countIntegers(String inputString, boolean printInts) {
		Scanner inputScan = new Scanner(inputString);
		
		int nIntegers = 0;
		int temp; // the only purpose of temp is to increment the scanner
		String filler;

		while (inputScan.hasNext()) { //the default delimiter is whitespace
			if (inputScan.hasNextInt()) {
				temp = inputScan.nextInt();
				nIntegers++;
				
				if (printInts)
					System.out.println(temp);
			}
			
			else {	
				filler = inputScan.next(); 
				
				if (isImpureInteger(filler, printInts))
					nIntegers++;
				
/******************************************************************************
  		filler is the String token that is not a pure integer, but it can still 
  		be like the following, each representing integers:
		f(5) {300} $1000 42. f($10,000). 62? [34]
				
		To test for these, I've defined 3 basic string reductions:
		reduceDollarSign takes a string, checks if its first character is a 
		dollar sign $, removes it if it is so, then returns the remaining 
		string. For example, reduceDollarSign("$500") would return "500". If 
		the first character is not "$", or the input is empty or has only a 
		single character then the input string is returned untouched.
				
		reduceEndingChar simply removes the last character of a string. If the 
		input is empty or has only a single charzcter, it returns the input.
				
		reduceBrackets returns the string inside the innermost brackets pair.
		For example: reduceBrackets("m{f(g(23))}") would return "23". If there 
		are more than one substrings with the highest bracket depth, the first
		one is returned. For example: reduceBrackets("FV(k)+PV(500)") would
		return "k", missing the integer.
		Different bracket types are INTERCHANGEABLE so "(100]" returns "100"
		In the future, an ArrayList of these "k", "500" may be returned.
				
		The current algorithm of checking if a filler token should be counted 
		as integer is as follows:
		1. Apply reduceBrackets once
		2. Apply reduceDollarSign until the output is the same as input 
		(so $$$500 will be counted as an integer
		3. Apply reduceEndingChar once
		4. Check the resulting string is a "pure integer" (ie like "500",
		"60,000", etc) if yes, increment nIntegers, if no, don't.
				
		This is implemented in boolean method isImpureInteger(String input). 
		filler is passed to it and if the result is true, we increment nInteger.
******************************************************************************/
			}
		}
		
		return nIntegers;
	}
	
	
	public static boolean isImpureInteger(String input, boolean printInts) {
		
		/* Checks if the input string is sufficiently integer-like. */
		String output;
		
		output = reduceBrackets(input); // (1)st step in the algorithm in the 
		// comments to countIntegers
		
		while (output != reduceDollarSign(output))
			output = reduceDollarSign(output); 		// (2)
		
		output = reduceEndingChar(output); 			// (3)
			
		return isPureInteger(output, printInts); 	// (4)
	}
	
	
	public static boolean isPureInteger(String input, boolean printInts) {
		
		/* This method determines if the input string is a pure integer (ie has
		   no punctuation marks)
		   except commas like in 4,000,000. */
		Scanner integerScanner = new Scanner(input);
		
		boolean isPure = integerScanner.hasNextInt();
		
		if (printInts && isPure)
			System.out.println(integerScanner.nextInt());
		
		return isPure;
	}
		
	
	private static String reduceEndingChar(String input) {
		
		// For an explanation of this method, check the large comment in 
		// countIntegers method.
		String output;
		
		if (input.length() == 0 || input.length() == 1)
			return input;
		
		if (!Character.isDigit(input.charAt(input.length() - 1)))
			output = input.substring(0, input.length() - 1);
		else
			output = input;
		
		return output;
	}
	
	
	private static String reduceDollarSign(String input) {
		
		// For an explanation of this method, check the large comment in 
		// countIntegers method.
		String output;
		
		if (input.length() == 0 || input.length() == 1)
			return input;
		
		if (input.charAt(0) == "$".charAt(0))
			output = input.substring(1, input.length());
		else
			output = input;
		
		return output;
	}
	
	
	private static String reduceBrackets(String input) {
		// This method would probably be more efficient if I used ints and
		// arrays instead of Integers and ArrayLists, but I cba.
	
		// At any point inside a noninteger string, these Integers will 
		// represent the number of brackets that are opened but not closed.
		// We will find THE FIRST innermost bracket pair and return contents.
		Integer dBrackets = 0;	// these are things like { [ (
		
		// Different bracket types are INTERCHANGEABLE so "(100]" returns "100"
		
		// We will define an ArrayList to store the bracket depth at each
		// location of the input string.
		ArrayList<Integer> mapBrackets = new ArrayList<Integer>();

		for (int k = 0; k < input.length(); k++) {
			mapBrackets.add(dBrackets);
		
			if (input.charAt(k) == "{".charAt(0) ||
				input.charAt(k) == "[".charAt(0) ||
				input.charAt(k) == "(".charAt(0))
				dBrackets++;
			
			if (input.charAt(k) == "}".charAt(0) ||
				input.charAt(k) == "]".charAt(0) ||
				input.charAt(k) == ")".charAt(0))
				dBrackets--;
			
			// Example: input = "y=Var[500*g(2)]"
			// 	  mapBrackets = {000000111111221}
		}
		
		// Return the contents of the deepest brackets encountered.
		// If there are more than one places with the deepest bracket level,
		// return the first one.
		int maxDepth = Collections.max(mapBrackets);
		
		String output = "";
		boolean atTheFirstDip = true; // whether we are at the first occurance
		// of the highest bracket depth
		boolean haveBeenToTheFirstDip = false;
		
		for (int i = 0; i < input.length(); i++) {	
			if (mapBrackets.get(i) == (maxDepth) && atTheFirstDip) {
				output += Character.toString(input.charAt(i));
				haveBeenToTheFirstDip = true;
			}
			else {
				if (haveBeenToTheFirstDip)
					atTheFirstDip = false;
			}
		}
		
		if (maxDepth != 0) // remove the last closing bracket if it exists
			output = reduceEndingChar(output); 
		
		return output;
	}
	

	public static void main(String[] args) throws IOException {
		Scanner fileScanner = new Scanner(new File("integers.dat"));
		
		// doing it line by line
		int nInt = 0;
		while (fileScanner.hasNextLine()) {
			String toBeCounted = fileScanner.nextLine();
			nInt += countIntegers(toBeCounted, true); // Do print the integers.
		}
		
		System.out.println("There are " + nInt + " integers in the file.");
	}
}