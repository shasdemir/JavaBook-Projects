// OK, that's better

public class Contact implements Comparable {
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