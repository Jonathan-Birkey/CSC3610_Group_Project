package CSC3610_Group_Project;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LogInController extends Application{

	private Stage primaryStage;
	private AnchorPane rootLayout;
	private AnchorPane registerLayout;
	private AnchorPane userLayout;
	private AnchorPane forgotLayout;
	protected static String userName;
	@FXML
	private TextField txtUsername;
	@FXML
	private TextField txtPassword;
	@FXML
	private Button btnLogIn;
	@FXML
	private Button btnRegister;
	@FXML
	private Label lblForgotPassword;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Log In");


		FXMLLoader logInLoader = new FXMLLoader();
		logInLoader.setLocation(LogInController.class.getResource("LogInScene.fxml"));
		
		try{
			rootLayout = (AnchorPane) logInLoader.load();
		}catch (IOException e){
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
		if(MasterPaneController.userMap.containsKey(txtUsername.getText())){
				userName = txtUsername.getText();
				try{
					FXMLLoader userLoader = new FXMLLoader();
					userLoader.setLocation(LogInController.class.getResource("UserScene.fxml"));
					userLayout = (AnchorPane) userLoader.load();
					MasterPaneController.masterLayout.setCenter(userLayout);
				
				}catch (IOException ex){
					ex.printStackTrace();
				}
	
		}
		else{
			try{
				FXMLLoader userLoader = new FXMLLoader();
				userLoader.setLocation(ForgotPasswordController.class.getResource("ForgotPasswordScene.fxml"));
				forgotLayout = (AnchorPane) userLoader.load();
				MasterPaneController.masterLayout.setCenter(forgotLayout);
			
			}catch (IOException ex){
				ex.printStackTrace();
			}		}
}
	public static void main(String[] args){
		launch(args);
	}
	
}
