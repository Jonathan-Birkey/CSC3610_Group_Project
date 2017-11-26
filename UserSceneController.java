package CSC3610_Group_Project;

import java.io.IOException;
import java.time.LocalDate;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class UserSceneController extends Application {
	
	public static String firstName, lastName, phone, email, address, userName, password;
	public static Person loggedInUser;
	public static LocalDate DOB; 
	public static String SSN;
	
	private Stage primaryStage;
	private AnchorPane controlsData;
	private AnchorPane userLayout;
	private AnchorPane infoLayout;
	private AnchorPane cartLayout;
	
	
	@FXML
	private Button btnCart;
	@FXML
	private Button btnBack;
	@FXML
	private Button btnGetStarted;
	@FXML
	private Button btnProfile;
	@FXML
	private Button btnSales;
	@FXML
	private ComboBox<String> cboColor;
	@FXML
	private ComboBox<String> cboInterior;
	@FXML
	private ComboBox<String> cboWheels;
	@FXML
	private ComboBox<String> cboRoof;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Tesla: Customer Info");
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(UserSceneController.class.getResource("HomeScene.fxml"));
		
		try{
			controlsData = (AnchorPane) loader.load();
		}
		catch(IOException e){
			e.printStackTrace();			
		}
		
		Scene scene = new Scene(controlsData);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	//Update Info button
	 @FXML
	private void initialize() {
		 
		
	 }
	 @FXML
	 public void getStarted(ActionEvent e){	
			FXMLLoader userLoader = new FXMLLoader();
			userLoader.setLocation(LogInController.class.getResource("CarScene.fxml"));
			try {
				userLayout = (AnchorPane) userLoader.load();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			MasterPaneController.masterLayout.setCenter(userLayout);
	 }
	 @FXML
	 public void getSales(ActionEvent e){	
			FXMLLoader userLoader = new FXMLLoader();
			userLoader.setLocation(LogInController.class.getResource("ReportsScene.fxml"));
			try {
				userLayout = (AnchorPane) userLoader.load();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			MasterPaneController.masterLayout.setCenter(userLayout);
	 }
	 @FXML
	 public void btnProfile(ActionEvent e){	
			FXMLLoader userinfoLoader = new FXMLLoader();
			userinfoLoader.setLocation(UserInforamtionController.class.getResource("UserScene.fxml"));
			try {
				infoLayout = (AnchorPane) userinfoLoader.load();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			MasterPaneController.masterLayout.setCenter(infoLayout);
	 }
	 
	 @FXML
	 public void btnCart(ActionEvent e){	
			FXMLLoader cartLoader = new FXMLLoader();
			cartLoader.setLocation(CartSceneController.class.getResource("CartScene.fxml"));
			try {
				cartLayout = (AnchorPane) cartLoader.load();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			MasterPaneController.masterLayout.setCenter(cartLayout);
	 }
}
