// implements a pair of dice using 2 Die objects

public class PairOfDice {
	private Die Die1;
	private Die Die2;

	public PairOfDice() {
		Die1 = new Die();
		Die2 = new Die();
	}
	
	public void roll() {
		Die1.roll();
		Die2.roll();
	}
	
	public int getSum() {
		return Die1.getFaceValue() + Die2.getFaceValue();
	}
	
	public void setFirstDie(int value) {
		Die1.setFaceValue(value);
	}
	
	public void setSecondDie(int value) {
		Die2.setFaceValue(value);
	}

	public int getFirstDieFaceValue() {
		return Die1.getFaceValue();
	}
	
	public int getSecondDieFaceValue() {
		return Die2.getFaceValue();
	}
	
	public String toString() {
		return Integer.toString(getFirstDieFaceValue()) + " " +
				Integer.toString(getSecondDieFaceValue());
	}
}