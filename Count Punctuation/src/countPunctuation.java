// Counts the number of punctuation marks in an input file.
// The marks counted are: . , ! ? ' " ; :

import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class countPunctuation {
	public static void main(String[] args) throws IOException {
		Scanner fileScanner = new Scanner(new File("punctuatedFile.txt"));
		
		ArrayList<Integer> counts = new ArrayList<Integer>();
		for (int j = 0; j < 8; j++)
			counts.add(new Integer(0));
		
		// I could count this line by line instead of storing the whole file
		// in the memory, but cba.
		String theWholeFile = "";
		while (fileScanner.hasNextLine()) 
			theWholeFile += fileScanner.nextLine();
		
		for (int k = 0; k < theWholeFile.length(); k++) {
			switch (theWholeFile.charAt(k)) {
			case 46 :
				counts.set(0, counts.get(0) + 1); // lame
				break;
			case 44 :
				counts.set(1, counts.get(1) + 1);
				break;
			case 33 :
				counts.set(2, counts.get(2) + 1);
				break;
			case 63 :
				counts.set(3, counts.get(3) + 1);
				break;
			case 39 :
				counts.set(4, counts.get(4) + 1);
				break;
			case 34 :
				counts.set(5, counts.get(5) + 1);
				break;
			case 59 :
				counts.set(6, counts.get(6) + 1);
				break;
			case 58 :
				counts.set(7, counts.get(7) + 1);
				break;
			}
		}
		
		System.out.println("The following table shows the punctuation marks" +
		" used in the file:");
		System.out.println("_____");
		System.out.println("|.|" + counts.get(0) + "|");
		System.out.println("|,|" + counts.get(1) + "|");
		System.out.println("|!|" + counts.get(2) + "|");
		System.out.println("|?|" + counts.get(3) + "|");
		System.out.println("|'|" + counts.get(4) + "|");
		System.out.println("|\"|" + counts.get(5) + "|");
		System.out.println("|;|" + counts.get(6) + "|");
		System.out.println("|:|" + counts.get(7) + "|");
		System.out.println("-----");
		
	}
}
