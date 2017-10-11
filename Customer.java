package CSC3610_Group_Project;

import java.time.LocalDate;

public class Customer extends Person {
	// Default Constructor
	public Customer(){}
	// Overloaded constructor
	public Customer(String firstName, String lastName, String phone, String email, String address, String userName,
			String password, LocalDate dOB, String SSN){
		super(firstName, lastName, phone, email, address, userName, password,dOB, SSN);
	}
	public void buyCar(){
		System.out.println("You have bought a car");
		System.out.println(getFirstName());
	}
	
}