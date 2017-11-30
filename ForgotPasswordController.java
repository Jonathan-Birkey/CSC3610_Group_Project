package CSC3610_Group_Project;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ForgotPasswordController extends Application {
	
	private Stage primaryStage;
	private AnchorPane rootLayout;
	private AnchorPane registerLayout;
	private AnchorPane userLayout;
	private AnchorPane forgotLayout;
	protected static String userName;
	@FXML
	private TextField txtUsername;
	@FXML
	private PasswordField txtPassword;
	@FXML
	private Button btnLogIn;
	@FXML
	private Button btnRegister;
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Forgot Password");
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(UserSceneController.class.getResource("ForgotPasswordScene.fxml"));
		
		try{
			rootLayout = (AnchorPane) loader.load();
		}
		catch(IOException e){
			e.printStackTrace();			
		}
		
		Scene scene = new Scene(rootLayout);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	@FXML
	public void btRegisterAction(ActionEvent e){
		try{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(LogInController.class.getResource("RegisterScene.fxml"));
			registerLayout = (AnchorPane) loader.load();
			MasterPaneController.masterLayout.setCenter(registerLayout);
			
			
		}catch (IOException ex){
			ex.printStackTrace();
		}
		
	}
	
		@FXML
	public void btLogInAction(ActionEvent e){
		// Attempt to log in by creating a connect object
		Connect conn = new Connect();
		// Initialize the DB and grab the username and password
		conn.initalizeDB();
		userName = txtUsername.getText();
		
		String password = HashPassword.hashPassword(txtPassword.getText());		
		//validate if admin
		if(conn.validateAdmin(userName, password)) {
			
		// Set a fake "cookie" as loggedInUser that will be used later
		Person loggedInUser = conn.createPerson(userName);
		System.out.println("Welcome, " + loggedInUser.getFirstName() + "!");
		// Try to load the user scene
		try{
			UserSceneController.loggedInUser = loggedInUser;
			FXMLLoader userLoader = new FXMLLoader();
			userLoader.setLocation(LogInController.class.getResource("AdminScene.fxml"));
			adminLayout = (AnchorPane) userLoader.load();
						
			MasterPaneController.masterLayout.setCenter(adminLayout);
					
					}catch (IOException ex){
						ex.printStackTrace();
					}
		}
		// If validate returns true, that means that the user is found in the database and their password is correct
		else if(conn.validate(userName,password)) {
			// Set a fake "cookie" as loggedInUser that will be used later
			Person loggedInUser = conn.createPerson(userName);
			System.out.println("Welcome, " + loggedInUser.getFirstName() + "!");
			// Try to load the user scene
			try{
				UserSceneController.loggedInUser = loggedInUser;
				FXMLLoader userLoader = new FXMLLoader();
				userLoader.setLocation(LogInController.class.getResource("HomeScene.fxml"));
				userLayout = (AnchorPane) userLoader.load();
				
				MasterPaneController.masterLayout.setCenter(userLayout);
				

//				MasterPaneController.masterLayout.setMinHeight(740.0);
//				MasterPaneController.masterLayout.setMinWidth(471.0);

			
			}catch (IOException ex){
				ex.printStackTrace();
			}
		// If the user is not found in the database OR if the password is incorrect
		} else {
		
			try{
				FXMLLoader userLoader = new FXMLLoader();
				userLoader.setLocation(ForgotPasswordController.class.getResource("ForgotPasswordScene.fxml"));
				forgotLayout = (AnchorPane) userLoader.load();
				MasterPaneController.masterLayout.setCenter(forgotLayout);
			
			}catch (IOException ex){
				ex.printStackTrace();
			}		
		}
		conn.closeDB();				}			
	}
