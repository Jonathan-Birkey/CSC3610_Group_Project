package CSC3610_Group_Project;

import java.sql.Date;

public class Customer extends Person {
	// Default Constructor
	public Customer(){}
	// Overloaded constructor
	public Customer(String firstName, String lastName, String phone, String email, String street, String zip, String state, String city, String userName,
			String password, Date dOB, String SSN){
		super(firstName, lastName, phone, email, userName, password, city, state, street, zip, dOB, SSN);
	}
	public void buyCar(){
		System.out.println("You have bought a car");
		System.out.println(getFirstName());
	}
	
}
