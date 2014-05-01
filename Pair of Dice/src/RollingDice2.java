// class to use PairOfDice

public class RollingDice2 {
	public static void main(String[] args) {
		PairOfDice onikilik = new PairOfDice();
		
		onikilik.roll();
		
		System.out.println("I just rolled two dice!");
		System.out.println("And the sum of the values is " +
		onikilik.getSum() + ".");
		
		System.out.println("Because, the first die is " + 
		onikilik.getFirstDieFaceValue() + " and the second one is " +
		onikilik.getSecondDieFaceValue() + ".");
	}
}
