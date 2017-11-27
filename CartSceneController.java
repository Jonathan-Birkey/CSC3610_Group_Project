package CSC3610_Group_Project;

import java.io.IOException;
import java.sql.Date;
import java.text.NumberFormat;
import java.util.HashMap;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class CartSceneController extends Application{
	// Variables
	private Stage primaryStage;
	private AnchorPane rootLayout;
	public static Car customizedCar;
	private AnchorPane userLayout;
	// Labels from fxml
	@FXML
	private Label lblModel, lblModelPrice, lblColor, lblColorPrice, lblInterior, lblInteriorPrice, 
	lblWheels, lblWheelsPrice, lblRoof, lblRoofPrice, lblTotal;
	private HashMap<String, Double> hMap = new HashMap<>();
	
	// This happens when you press the Order button
	@FXML
	private void purchase() {
		// Create a transaction object to send into the database
		Transaction transaction = new Transaction(UserSceneController.loggedInUser.getFirstName() + " " + UserSceneController.loggedInUser.getLastName(),
				customizedCar, new Date(0));
		
//		System.out.println(transaction);
		Connect conn = new Connect();
		conn.initalizeDB();
		conn.addTransaction(transaction);
		conn.closeDB();
		// Try to load the user scene
		try{
			FXMLLoader userLoader = new FXMLLoader();
			userLoader.setLocation(LogInController.class.getResource("HomeScene.fxml"));
			userLayout = (AnchorPane) userLoader.load();
			
			MasterPaneController.masterLayout.setCenter(userLayout);

		}catch (IOException ex){
			ex.printStackTrace();
		}
	}
	// Set up the labels to reflect what your car options were
	@FXML 
	private void initialize (){
		// populate the hashMap
		hMap.put("Black", 0.0);
		hMap.put("Silver", 1000.0);
		hMap.put("Blue", 1000.0);
		hMap.put("Red", 1500.0);
		hMap.put("White", 1500.0);
		hMap.put("Black Premium", 1500.0);
		hMap.put("White Premium", 1500.0);
		hMap.put("Cream Premium", 1500.0);
		hMap.put("Black Standard", 1500.0);
		hMap.put("Clasic Black", 3200.0);
		hMap.put("19\" Silver Slipstream", 0.0);
		hMap.put("19\" Grey Slipstream", 2500.0);
		hMap.put("21\" Grey Turbine", 4500.0);
		hMap.put("Glass", 0.0);
		hMap.put("Sunroof", 2000.0);
		hMap.put("75D", 75000.0);
		hMap.put("100D", 98500.0);
		hMap.put("P100D", 136000.0);
		
		
		NumberFormat format = NumberFormat.getCurrencyInstance();
		
		// Set the labels
		lblModel.setText(customizedCar.getSubModel());
		lblModelPrice.setText(format.format(hMap.get(customizedCar.getSubModel())));
		lblColor.setText(customizedCar.getColor());
		lblColorPrice.setText(format.format(hMap.get(customizedCar.getColor())));
		lblInterior.setText(customizedCar.getInteriorType());
		lblInteriorPrice.setText(format.format(hMap.get(customizedCar.getInteriorType())));
		lblWheels.setText(customizedCar.getSizeOfWheels());
		lblWheelsPrice.setText(format.format(hMap.get(customizedCar.getSizeOfWheels())));
		lblRoof.setText(customizedCar.getRoof());
		lblRoofPrice.setText(format.format(hMap.get(customizedCar.getRoof())));
		
		
		lblTotal.setText(String.valueOf(format.format(customizedCar.getPrice())));
		
		System.out.println(customizedCar);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Log In");


		FXMLLoader logInLoader = new FXMLLoader();
		logInLoader.setLocation(CartSceneController.class.getResource("CartScene.fxml"));
		
		try{
			rootLayout = (AnchorPane) logInLoader.load();
		}catch (IOException e){
			e.printStackTrace();
		}
		
		
		Scene scene = new Scene(rootLayout);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

}
