package CSC3610_Group_Project;

import java.io.IOException;
import java.sql.Date;
import java.text.NumberFormat;

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
		lblModel.setText(customizedCar.getModel());
		lblModelPrice.setText(customizedCar.getModel());
		lblColor.setText(customizedCar.getColor());
		lblColorPrice.setText(customizedCar.getModel());
		lblInterior.setText(customizedCar.getInteriorType());
		lblInteriorPrice.setText(customizedCar.getModel());
		lblWheels.setText(customizedCar.getSizeOfWheels());
		lblWheelsPrice.setText(customizedCar.getModel());
		lblRoof.setText(customizedCar.getModel());
		lblRoofPrice.setText(customizedCar.getModel());
		
		NumberFormat format = NumberFormat.getCurrencyInstance();
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
