// Represents a generic staff member

abstract public class StaffMember {
	protected String name;
	protected String address;
	protected String phone;
	
	public StaffMember(String eName, String eAddress, String ePhone) {
		name = eName;
		address = eAddress;
		phone = ePhone;
	}
	
	// returns basic employee info
	public String toString() {
		String result = "Name: " + name + "\n";
		result += "Address: " + address + "\n";
		result += "Phone: " + phone;
		return result;
	}
	
	// children must implement the pay method
	public abstract double pay();
}
