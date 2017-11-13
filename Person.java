package CSC3610_Group_Project;

import java.sql.Date;

public class Person {
	
	//Variables 
		private String firstName, lastName, phone, email, street, city, state, zip, userName, password;
		private Date DOB; 
		private String SSN;
		
		//constructor
		public Person(String firstName, String lastName, String phone, String email,String street, String state, String city, String zip, String userName,
				String password, Date dOB2, String sSN2) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.phone = phone;
			this.email = email;
			this.city = city;
			this.state =street;
			this.state = state;
			this.zip = zip;
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
		protected String getcity() {
			return city;
		}
		protected void setcity(String address) {
			this.city = address;
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
		protected Date getDOB() {
			return DOB;
		}
		protected void setDOB(Date date) {
			this.DOB = date;
		}
		protected String getSSN() {
			return SSN;
		}
		protected void setSSN(String sSN) {
			SSN = sSN;
		}
		
		public String getStreet() {
			return street;
		}

		public void setStreet(String street) {
			this.street = street;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public String getZip() {
			return zip;
		}

		public void setZip(String zip) {
			this.zip = zip;
		}

		@Override
		public String toString() {
			return "Name: " + firstName + " " + lastName + "\nPhone Number: " + phone + "\nEmail: " + email + "\nAddress: " + street + "\n" 
					+ city + "\n" + state + "," + zip + "\nUsername: " + userName + "\nPassword: " + password + "\nDOB: " + DOB + "\nSSN: " + SSN;
		}
	}
