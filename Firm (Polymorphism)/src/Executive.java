// an employee who can earn a bonus

public class Executive extends Employee {
	private double bonus;
	
	public Executive(String eName, String eAddress, String ePhone,
			String socSecNumber, double rate) {
		super(eName, eAddress, ePhone, socSecNumber, rate);
		bonus = 0; // init here, change later
	}
	
	
	public void awardBonus(double execBonus) {
		bonus = execBonus;
	}
	
	
	public double pay() {
		double payment = super.pay() + bonus;
		bonus = 0;
		
		return payment;
	}
}
