// driver class for Cars
public class CarDriver {
	public static void main(String[] args) {
		Car beemer1 = new Car("BMW", "320d", 2009);
		Car merso = new Car("Mercedes-Benz", "c180k", 2011);
		Car audi1 = new Car("Audi", "A4", 2010);
		
		beemer1.setDate(2012);
		
		System.out.println(audi1.getModel());
		System.out.println("The cars are:\n" + beemer1 + merso + audi1);
	}
}
