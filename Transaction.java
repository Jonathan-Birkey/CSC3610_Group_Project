package CSC3610_Group_Project;

import java.util.Date;

public class Transaction {
	// Set variables for dates and other things
	private Date datePurchased;
	private Date dateShipped;
	private Date dateDelivered;
	private boolean orderConfirmation;
	private double price;
	
	// Default constructor, not exaclty sure if this will ever be used
	public Transaction(){
		
	}
	// Constructor with full parameters
	public Transaction(Date datePurchased, Date dateShipped, Date dateDelivered, boolean orderConfirmation,
			double price) {
		this.datePurchased = datePurchased;
		this.dateShipped = dateShipped;
		this.dateDelivered = dateDelivered;
		this.orderConfirmation = orderConfirmation;
		this.price = price;
	}
	// Constructor to be used for first purchase
	public Transaction(Date datePurchased, double price) {
		this.datePurchased = datePurchased;
		this.price = price;
	}
	// Getters/Setters
	public Date getDatePurchased() {
		return datePurchased;
	}

	public void setDatePurchased(Date datePurchased) {
		this.datePurchased = datePurchased;
	}

	public Date getDateShipped() {
		return dateShipped;
	}

	public void setDateShipped(Date dateShipped) {
		this.dateShipped = dateShipped;
	}

	public Date getDateDelivered() {
		return dateDelivered;
	}

	public void setDateDelivered(Date dateDelivered) {
		this.dateDelivered = dateDelivered;
	}

	public boolean isOrderConfirmation() {
		return orderConfirmation;
	}

	public void setOrderConfirmation(boolean orderConfirmation) {
		this.orderConfirmation = orderConfirmation;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	// Overriden toString Method
	@Override
	public String toString() {
		return "Transaction [datePurchased=" + datePurchased + ", dateShipped=" + dateShipped + ", dateDelivered="
				+ dateDelivered + ", orderConfirmation=" + orderConfirmation + ", price=" + price + "]";
	}
	
	
}
