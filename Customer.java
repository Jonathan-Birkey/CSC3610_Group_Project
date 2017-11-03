package CSC3610_Group_Project;

<<<<<<< HEAD
import java.sql.Date;
=======
import java.time.LocalDate;
import java.util.Date;
>>>>>>> origin/Car-Class

public class Customer extends Person {
	// Default Constructor
	public Customer(){}
	// Overloaded constructor
	public Customer(String firstName, String lastName, String phone, String email, String street, String zip, String state, String city, String userName,
<<<<<<< HEAD
			String password, Date dOB, String SSN){
=======
			String password, java.sql.Date dOB, String SSN){
>>>>>>> origin/Car-Class
		super(firstName, lastName, phone, email, userName, password, city, state, street, zip, dOB, SSN);
	}
	public void buyCar(){
		System.out.println("You have bought a car");
		System.out.println(getFirstName());
	}
	
}
