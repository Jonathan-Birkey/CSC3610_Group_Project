package CSC3610_Group_Project;

import java.io.IOException;
import java.time.LocalDate;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class UserInforamtionController extends Application {
	
	public static String firstName, lastName, phone, email, address, userName, password;
	public static Person loggedInUser;
	public static LocalDate DOB; 
	public static String SSN;
	
	private Stage primaryStage;
	private AnchorPane controlsData;
	private AnchorPane updateLayout;
	private AnchorPane homeLayout;
	private AnchorPane userLayout;
	
	@FXML
	private TextArea txtDisplayArea; 
		
	@FXML
	private Button btnUpdateInfo;
	
	@FXML
	private Label lblFirstName;
	
	@FXML
	private Label lblLastName;
	
	@FXML
	private Label lblPhoneNumber;
	
	@FXML
	private Label lblusername;
	
	@FXML
	private Label lblCity;
	
	@FXML
	private Label lblSocialSecurity;
	
	@FXML
	private Label lblDOB;
	
	@FXML
	private Label lblEmail;
	
	@FXML
	private Button btnCustomize;
	
	@FXML
	private Button btnHome;
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Tesla: Customer Info");
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(UserInforamtionController.class.getResource("UserScene.fxml"));
		
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
	
	//closes program
	btnUpdateInfo.setOnAction((event) ->{
			
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(LogInController.class.getResource("UpdateScene.fxml"));
			try {
				updateLayout = (AnchorPane) loader.load();
			} catch (IOException e) {
				e.printStackTrace();
			}
			MasterPaneController.masterLayout.setCenter(updateLayout);
	});
	
	btnHome.setOnAction((Event) ->{
		FXMLLoader userLoader = new FXMLLoader();
		userLoader.setLocation(LogInController.class.getResource("HomeScene.fxml"));
		try {
			homeLayout = (AnchorPane) userLoader.load();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		MasterPaneController.masterLayout.setCenter(homeLayout);
	});

	 lblFirstName.setText(UserSceneController.loggedInUser.getFirstName() +" "+ UserSceneController.loggedInUser.getLastName());
	 lblEmail.setText(UserSceneController.loggedInUser.getEmail());
	 lblusername.setText(UserSceneController.loggedInUser.getUserName());
	 lblPhoneNumber.setText(UserSceneController.loggedInUser.getPhone());
	 lblSocialSecurity.setText(UserSceneController.loggedInUser.getSSN());
	 lblDOB.setText(UserSceneController.loggedInUser.getDOB().toString());
	 lblCity.setText(UserSceneController.loggedInUser.getStreet() + "\n" + UserSceneController.loggedInUser.getcity() 
	 			+ " " + UserSceneController.loggedInUser.getState() + ", " + UserSceneController.loggedInUser.getZip());
}
	 @FXML
	 public void btnCustomize(ActionEvent e){	
			FXMLLoader userLoader = new FXMLLoader();
			userLoader.setLocation(CarSceneController.class.getResource("CarScene.fxml"));
			try {
				userLayout = (AnchorPane) userLoader.load();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			MasterPaneController.masterLayout.setCenter(userLayout);
	 }
	 

	 public static void main(String[] args){
		launch(args);
	 }
}





