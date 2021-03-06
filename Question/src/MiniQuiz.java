// MiniQuiz: Demos the use of a class that implements an interface.

import java.util.Scanner;

public class MiniQuiz {
	public static void main(String[] args) {
		Question q1, q2;
		String possible;
		
		Scanner myScanner = new Scanner(System.in);
		
		q1 = new Question("What is the capital of Jamaica?", "Kingston");
		q1.setComplexity(4);
		
		q2 = new Question("Which is worse, ignorance or apathy?",
				"I don't know and I don't care.");
		q2.setComplexity(10);
		
		System.out.print(q1.getQuestion());
		System.out.println(" (Level: " + q1.getCompexity() + ")");
		
		possible = myScanner.nextLine();
		if (q1.isAnswerCorrect(possible))
			System.out.println("Correct!");
		else
			System.out.println("No, the answer is " + q1.getAnswer());
		
		System.out.println();
		System.out.print(q2.getQuestion());
		System.out.println(" (Level: " + q2.getCompexity() + ")");
		
		possible = myScanner.nextLine();
		if (q2.isAnswerCorrect(possible))
			System.out.println("Correct!");
		else
			System.out.println("No, the answer is " + q2.getAnswer());
	}
}
