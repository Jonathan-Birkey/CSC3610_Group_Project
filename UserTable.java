package CSC3610_Group_Project;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class UserTable {
	public SimpleStringProperty firstName = new SimpleStringProperty();
	public SimpleStringProperty lastName = new SimpleStringProperty();
	public SimpleStringProperty phone = new SimpleStringProperty();
	public SimpleStringProperty SSN = new SimpleStringProperty();
	public SimpleStringProperty userName = new SimpleStringProperty();
	public SimpleIntegerProperty zip = new SimpleIntegerProperty();
	public SimpleStringProperty street = new SimpleStringProperty();
	public SimpleStringProperty state = new SimpleStringProperty();
	public SimpleStringProperty email = new SimpleStringProperty();
	public SimpleStringProperty city = new SimpleStringProperty();
	public SimpleStringProperty DOB = new SimpleStringProperty();
	
	
	
	public String getCity() {
		return city.get();
	}
	public String getFirstName() {
		return firstName.get();
	}
	public String getLastName() {
		return lastName.get();
	}
	public String getPhone() {
		return phone.get();
	}
	public String getSSN() {
		return SSN.get();
	}
	public String getUserName() {
		return userName.get();
	}
	public int getZip() {
		return zip.get();
	}
	public String getStreet() {
		return street.get();
	}
	public String getState() {
		return state.get();
	}
	public String getEmail() {
		return email.get();
	}
	public String getDOB() {
		return DOB.get();
	}
}