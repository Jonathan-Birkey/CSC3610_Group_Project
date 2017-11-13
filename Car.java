package CSC3610_Group_Project;

public class Car {
	// Create attributes
	String color;
	String model;
	int year;
	int sizeOfWheels;
	String interiorType;
	double price;
	String subModel;
	
	// Default constructor when creating a new car object
	public Car() {
		color = "Black";
		year = 2017;
		model = "Model S";
		subModel = "75";
		sizeOfWheels = 20;
		interiorType = "Black";
		price = 75000.00;
	}
	// Constructor to be used with parameters
	public Car(String color, String model, int year, int sizeOfWheels, String interiorType,
			double price, String subModel) {
		super();
		this.color = color;
		this.model = model;
		this.year = year;
		this.sizeOfWheels = sizeOfWheels;
		this.interiorType = interiorType;
		this.price = price;
		this.subModel = subModel;
	}
	// Setters/Getters
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getSizeOfWheels() {
		return sizeOfWheels;
	}
	public void setSizeOfWheels(int sizeOfWheels) {
		this.sizeOfWheels = sizeOfWheels;
	}
	public String getInteriorType() {
		return interiorType;
	}
	public void setInteriorType(String interiorType) {
		this.interiorType = interiorType;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getSubModel() {
		return subModel;
	}
	public void setSubModel(String subModel) {
		this.subModel = subModel;
	}
	// Override toString method to display the object
	@Override
	public String toString() {
		return "Car [color=" + color + ", model=" + model + ", year=" + year + ", sizeOfWheels=" + sizeOfWheels
				+ ", interiorType=" + interiorType + ", price=" + price + ", subModel=" + subModel + "]";
	}
	
}
