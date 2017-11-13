package CSC3610_Group_Project;

import java.io.IOException;
import java.text.NumberFormat;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class CartSceneController extends Application{

	private Stage primaryStage;
	private AnchorPane rootLayout;
	public static Car customizedCar;
	
	@FXML
	private Label lblModel, lblModelPrice, lblColor, lblColorPrice, lblInterior, lblInteriorPrice, 
	lblWheels, lblWheelsPrice, lblRoof, lblRoofPrice, lblTotal;
	
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
