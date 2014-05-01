// 6-faced die class

public class Die {

private final int MAX = 6; // maximum face value
private int faceValue;

	public Die() { // constructor
		faceValue = 1;
	}
	
	public int roll() { // on a roll!
		faceValue = (int)(Math.random() * MAX) + 1;
		return faceValue;
	}
	
	public int getFaceValue() { // get method
		return faceValue;
	}
	
	public void setFaceValue(int input) { // set method
		faceValue = input;
	}
	
	// toString: to use it like println("bla bla" + die1.roll());
	public String toString() {
		String result = Integer.toString(faceValue);
		return result;
	}
}
