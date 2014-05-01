import java.util.ArrayList;

public class DiceAL {
	public static void main(String[] args) {
		ArrayList<Die> dice = new ArrayList<Die>();
		
		dice.add(new Die());
		dice.add(new Die());
		
		Die uberDie = new Die();
		dice.add(2, uberDie);
		
		for (int i = 1; i <= 15; i++) {
			dice.add(new Die());
		}
		
		dice.get(0).roll();
		dice.get(1).roll();
		
		for (Die tut : dice) {
			tut.roll();
		}
		
		String reportString = "The values of the dice are: ";
		
		for (int i = 0; i < dice.size(); i++) {
			reportString += "\n" + dice.get(i).getFaceValue();
		}
		
		System.out.println(reportString);
	}
}
