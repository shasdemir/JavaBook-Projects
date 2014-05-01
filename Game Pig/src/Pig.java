// Plays the game Pig
// sorry for the inelegant design, i dont have time to do better now

// the text is too long in single println lines...

import java.util.Scanner;
import java.util.ArrayList;

public class Pig {
	public static void main(String[] args) {
		
		// variables and objects
		PairOfDice theDice = new PairOfDice();
		
		ArrayList<Integer> accPoints = new ArrayList<Integer>();
		accPoints.add(0);
		accPoints.add(0);
		
		int roundsPoints = 0; // this round's points
		boolean isPlayersTurn = true;
		boolean wannaQuit = false;
		boolean someoneHasWon = false;
		int die1; // the face values of the dies
		int die2;
		
		// text
		System.out.println("Welcome to the game of Pig!");
		System.out.println();
		System.out.println("The rules are: You roll 2 dice, gain the sum as " +
		"points. If one of the dice is 1, you give the dice to the computer " +
		"and lose all points gained in that turn. If both are 1, you lose " +
		"your accumulated points and lose the control of the dice.");
		System.out.println("The first player to reach 100 points wins.");
		System.out.println("At any time, you can relinquish the control of " +
		"the dice to the computer in order to add the points gathered in the" +
		" current round to your accumulated points.");
		System.out.println();
		System.out.println("The game has begun!");
				
		Scanner myScanner = new Scanner(System.in);
		
		while ((wannaQuit == false) && (!someoneHasWon)) {
			System.out.println();
			System.out.println("Points accumulated so far: Human: " +
					accPoints.get(0) + " Computer: " + accPoints.get(1)	+ " ");
			
			if (isPlayersTurn) {
				System.out.println("Type r to roll, g to give the dice to " + 
						"the computer, q to quit the game.");
				String input = myScanner.nextLine();
				
				if (input.compareTo("r") == 0) {		
					theDice.roll();
					die1 = theDice.getFirstDieFaceValue();
					die2 = theDice.getSecondDieFaceValue();
					
					System.out.println();
					System.out.println("You rolled: " + die1 + " " + die2);
					
					if (die1 == 1 && die2 == 1) {
						System.out.println("You lose all your points and " + 
								"it's the computer's turn now.");
						
						roundsPoints = 0;
						accPoints.set(0, 0);
						isPlayersTurn = false;
					}
					else if (die1 == 1 || die2 == 1) {
						System.out.println("You lose this round's points and" +
								" it's the computer's turn now.");
						
						roundsPoints = 0;
						isPlayersTurn = false;
					}
					else {
						roundsPoints += theDice.getSum();
						
						System.out.println("Grats. This round's total points " +
								"are: " + roundsPoints);
						
						if (accPoints.get(0) + roundsPoints >= 100) {
							someoneHasWon = true;
							System.out.println("CONGRATULATIONS! You win!");
						}
					}
				}
				else if (input.compareTo("g") == 0) {
					accPoints.set(0, accPoints.get(0) + roundsPoints);
					
					roundsPoints = 0;
					isPlayersTurn = false;
				}
				
				else if (input.compareTo("q") == 0) {
					wannaQuit = true;
				}
			}
			else { // it is the computer's turn
				boolean doesCompWinNow = 
						(accPoints.get(1) + roundsPoints >= 100);
				
				if ((roundsPoints > 20) || doesCompWinNow) {
					System.out.println("The computer has ended its turn.");
					
					accPoints.set(1, accPoints.get(1) + roundsPoints);
					roundsPoints = 0;
					isPlayersTurn = true;
					
					if (accPoints.get(1) >= 100) {
						someoneHasWon = true;
						System.out.println();
						System.out.println("The computer wins!");
					}
				}
				else {
					theDice.roll();
					die1 = theDice.getFirstDieFaceValue();
					die2 = theDice.getSecondDieFaceValue();
					System.out.println("The computer rolled: " 
							+ die1 + " " + die2);
					if (die1 == 1 && die2 == 1) {
						System.out.println("The computer has lost all its" +
					" points and it's your turn now.");
						
						accPoints.set(1, 0);
						roundsPoints = 0;
						isPlayersTurn = true;
					}
					else if (die1 == 1 || die2 == 1) {
						System.out.println("The computer has lost this " +
								"round's points and it's your turn now.");
						
						roundsPoints = 0;
						isPlayersTurn = true;
					}
					else {
						roundsPoints += theDice.getSum();
					}
				}
			}
		}
		
		System.out.println();
		System.out.println("Good bye.");
	}
}