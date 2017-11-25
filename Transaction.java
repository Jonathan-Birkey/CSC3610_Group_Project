package CSC3610_Group_Project;

import java.sql.Date;

public class Transaction {
	// Transaction variables
	private String cust_name;
	private Car customized_car;
	private Date date_bought;
	// Default constructor
	public Transaction() {
		
	}
	// Constructor with parameters
	public Transaction(String cust_name, Car customized_car, Date date_bought) {
	
		this.cust_name = cust_name;
		this.customized_car = customized_car;
		this.date_bought = date_bought;
	}

	// Getters and setters
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	public Car getCustomized_car() {
		return customized_car;
	}
	public void setCustomized_car(Car customized_car) {
		this.customized_car = customized_car;
	}
	public Date getDate_bought() {
		return date_bought;
	}
	public void setDate_bought(Date date_bought) {
		this.date_bought = date_bought;
	}
	@Override
	public String toString() {
		return "Transaction [cust_name=" + cust_name + ", customized_car=" + customized_car
				+ ", date_bought=" + date_bought + "]";
	}
	
	
}
