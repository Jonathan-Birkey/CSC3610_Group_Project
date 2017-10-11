	package CSC3610_Group_Project;

import java.time.LocalDate;

public class Person {
	
	//Variables 
		private String firstName, lastName, phone, email, address, userName, password;
		private LocalDate DOB; 
		private String SSN;
		
		//constructor
		public Person(String firstName, String lastName, String phone, String email, String address, String userName,
				String password, LocalDate dOB2, String sSN2) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.phone = phone;
			this.email = email;
			this.address = address;
			this.userName = userName;
			this.password = password;
			this.DOB = dOB2;
			this.SSN = sSN2;
		}

		//Constructor
		public Person() {
			super();
		}
		
		// getters and setters
		protected String getFirstName() {
			return firstName;
		}	
		protected void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		protected String getLastName() {
			return lastName;
		}
		protected void setLastName(String lastName) {
			this.lastName = lastName;
		}
		protected String getPhone() {
			return phone;
		}
		protected void setPhone(String phone) {
			this.phone = phone;
		}
		protected String getEmail() {
			return email;
		}
		protected void setEmail(String email) {
			this.email = email;
		}
		protected String getAddress() {
			return address;
		}
		protected void setAddress(String address) {
			this.address = address;
		}
		protected String getUserName() {
			return userName;
		}
		protected void setUserName(String userName) {
			this.userName = userName;
		}
		protected String getPassword() {
			return password;
		}
		protected void setPassword(String password) {
			this.password = password;
		}
		protected LocalDate getDOB() {
			return DOB;
		}
		protected void setDOB(LocalDate localDate) {
			DOB = localDate;
		}
		protected String getSSN() {
			return SSN;
		}
		protected void setSSN(String sSN) {
			SSN = sSN;
		}

		@Override
		public String toString() {
			return firstName + "\n" + lastName + "\n" + phone + "\n" + email + "\n" + address 
					+ "\n" + userName + "\n" + password + "\n" + DOB + "\n" + SSN;
		}

	}