// Compares n input files, prints the lines that are not equal in all.

import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class CompareFiles {
	public static void main(String[] args) throws IOException {
		Scanner consoleScanner = new Scanner(System.in);
		int numberOfFiles;
		System.out.println("Please enter how many files are there. The" +
				"file names should be like: input1.txt input2.txt, etc.");
		numberOfFiles = consoleScanner.nextInt();
		
		ArrayList<Scanner> myScanners = new ArrayList<Scanner>();
		
		for (int k = 1; k <= numberOfFiles; k++)
			myScanners.add(new Scanner(new File("input" + k + ".txt")));
		
		// Find the file line counts.
		ArrayList<Integer> lineCounts = new ArrayList<Integer>();
		Integer lineCount;
		String increment;
		
		for (int i = 1; i <= numberOfFiles; i++) {
			lineCount = 0;
			
			while (myScanners.get(i - 1).hasNext()) {
				increment = myScanners.get(i - 1).nextLine();
				lineCount++;
			}
			
			lineCounts.add(lineCount);
		}
		
		// Find the minimum file count.
		int minLineCount = Collections.min(lineCounts);
		
		// Cleanup
		myScanners.clear();
		for (int k = 1; k <= numberOfFiles; k++)
			myScanners.add(new Scanner(new File("input" + k + ".txt")));
		
		// Compare files until minLineCount line by line
		// println all the unmatching lines from all files
		// jthLine holds the incremented lines from all files
		ArrayList<String> jthLine = new ArrayList<String>();
		boolean allMenAreTheSame;
		
		for (int j = 1; j <= minLineCount; j++) {
			allMenAreTheSame = true; // are all jth lines the same?
			
			for (int k = 1; k <= numberOfFiles; k++) {
				jthLine.add(myScanners.get(k - 1).nextLine());
			
				if (!jthLine.get(0).equals(jthLine.get(k - 1)))
					allMenAreTheSame = false;
			}
			
			if (!allMenAreTheSame) {
				System.out.println();
				System.out.println("Line number " + j + " is not the same " + 
				"across all files, printing the lines:");
				
				for (int k = 1; k <= numberOfFiles; k++) {
					System.out.println("File: \"input" + k + ".txt\":");
					System.out.println(jthLine.get(k - 1));
				}
			}
			
			jthLine.clear();
		}
	}
}