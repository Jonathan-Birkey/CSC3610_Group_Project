package CSC3610_Group_Project;

import java.sql.Date;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class TransactionTable implements Comparable<TransactionTable>{
	public SimpleIntegerProperty id = new SimpleIntegerProperty();
	public SimpleStringProperty name = new SimpleStringProperty();
	public SimpleStringProperty model = new SimpleStringProperty();
	public SimpleStringProperty submodel = new SimpleStringProperty();
	public SimpleStringProperty color = new SimpleStringProperty();
	public SimpleObjectProperty<Date> date_bought = new SimpleObjectProperty<Date>();
	public SimpleDoubleProperty price = new SimpleDoubleProperty();
	
	public Integer getId() {
		return id.get();
	}
	public String getName() {
		return name.get();
	}
	public String getModel() {
		return model.get();
	}
	public String getSubmodel() {
		return submodel.get();
	}
	public String getColor() {
		return color.get();
	}
	public Date getDate_bought() {
		return date_bought.get();
	}
	public Double getPrice() {
		return price.get();
	}

	@Override
	public int compareTo(TransactionTable tt) {
		if(price.doubleValue() > tt.getPrice())
			return 1;
		else if(price.doubleValue() < tt.getPrice())
			return -1;
		else
			return 0;
	}
	@Override
	public String toString() {
		return "\nOrder Number: " + id + "\nCustomer: " + name + "\nModel: " + model + "\nSubmodel: " + submodel
				+ "\nColor: " + color + "\nPurchase Date: " + date_bought + "\nTotal: " + price;
	}
	

}
