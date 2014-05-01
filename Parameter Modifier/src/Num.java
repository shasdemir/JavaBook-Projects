// Represents a single integer as an object.
// WTF how does this make sense??? WHY do we do this?

public class Num {
	private int value;
	
	public Num(int update) {
		value = update;
	}
	
	
	public void setValue(int update) {
		value = update;
	}
	
	
	public String toString() {
		return value + "";
	}
}

// this is pointless