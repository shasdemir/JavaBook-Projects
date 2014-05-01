// defines Contact class, sorts some of them in main

public class yaSortDriver {
	public yaSortDriver() {
		Contact[] friends = new Contact[8];
		
		friends[0] = new Contact ("John", "Smith", "610-555-7384");
		friends[1] = new Contact ("Sarah", "Barnes", "215-555-3827");
		friends[2] = new Contact ("Mark", "Riley", "733-555-2969");
		friends[3] = new Contact ("Laura", "Getz", "663-555-3984");
		friends[4] = new Contact ("Larry", "Smith", "464-555-3489");
		friends[5] = new Contact ("Frank", "Phelps", "322-555-2284");
		friends[6] = new Contact ("Mario", "Guzman", "804-555-9066");
		friends[7] = new Contact ("Marsha", "Grant", "243-555-2837");
		
		Contact[] toBePrinted;
		toBePrinted = (Contact[]) YaSort.selectionSort(friends);
		
		for (Contact friend : toBePrinted)
			System.out.println(friend);
		
		System.out.println("---");
		
		toBePrinted = (Contact[]) YaSort.insertionSort(friends);
		
		for (Contact friend : toBePrinted)
			System.out.println(friend);
		
	}
	
	
	public static void main(String[] args) {
		yaSortDriver theDriver = new yaSortDriver(); // it will also print
	}
	
	
	private class Contact implements Comparable {
		private String firstName, lastName, phone;
		
		public Contact(String firstName, String lastName, String phone) {
			this.firstName = firstName;
			this.lastName = lastName;
			this.phone = phone;
		}
		
		
		public String toString() {
			return lastName + ", " + firstName + "\t" + phone;
		}
		
		
		public boolean equals(Object other) {
			String otherLastName = ((Contact)other).getLastName();
			String otherFirstName = ((Contact)other).getFirstName();
			
			return lastName.equals(otherLastName) &&
					firstName.equals(otherFirstName);
		}
		
		
		public int compareTo(Object other) {
			int result;
			
			String otherLastName = ((Contact)other).getLastName();
			String otherFirstName = ((Contact)other).getFirstName();
			
			if (lastName.equals(otherLastName))
				result = firstName.compareTo(otherFirstName);
			else
				result = lastName.compareTo(otherLastName);
			
			return result;
		}
		
		public String getFirstName() {
			return firstName;
		}
		
		
		public String getLastName() {
			return lastName;
		}
	}
}
