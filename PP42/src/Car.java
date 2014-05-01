// Car class for pp 4-2

public class Car {
	private String make;
	private String model;
	private int date;
	
	public Car(String Make, String Model, int Date) { // constructor
		make = Make;
		model = Model;
		date = Date;
	}
	
	// setters and getters
	public void setMake(String Make) { // Make setter
		make = Make;
	}
	
	public String getMake() { // Make getter
		return make;
	}
	
	public void setModel(String Model) {
		model = Model;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setDate(int Date) {
		date = Date;
	}
	
	public int getDate() {
		return date;
	}

	public String toString() {
		return make + " " + model + ", made in " + date + "\n";
	}
}
