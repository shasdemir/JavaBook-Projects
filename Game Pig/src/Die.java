// 6-faced die class

public class Die {

private final int MAX = 6; // maximum face value
private int faceValue;

	public Die() { // constructor
		faceValue = 1;
	}
	
	public int roll() { // roll the dice!
		faceValue = (int)(Math.random() * MAX) + 1;
		return faceValue;
	}
	
	public int getFaceValue() { // get method
		return faceValue;
	}
	
	public void setFaceValue(int input) { // set method
		if (input < 7 && input > 0)
		faceValue = input;
	}
	
	public boolean compareTo(Die theOther) {
		return (this.faceValue == theOther.getFaceValue());
	}
	
	// toString: to use it like println("bla bla " + die1.roll());
	public String toString() {
		String result = Integer.toString(faceValue);
		return result;
	}
}