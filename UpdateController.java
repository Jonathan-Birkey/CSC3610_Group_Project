package CSC3610_Group_Project;



import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class UpdateController extends Application{
	
	

	private Stage primaryStage;
	private AnchorPane updateLayout;
	private AnchorPane LogIinLayout;
	@FXML
	private TextField txtFirstName;
	@FXML
	private TextField txtLastName;
	@FXML
	private TextField txtPhoneNumber;
	@FXML
	private TextField txtEmail;
	@FXML
	private DatePicker dpDOB;
	@FXML
	private TextField txtSocialSecurityNumber;
	@FXML
	private TextField txtUsername;
	@FXML
	private PasswordField txtPassword;
	@FXML
	private TextField txtStreet;
	@FXML
	private TextField txtCity;
	@FXML
	private ComboBox<String> cboState;
	@FXML
	private TextField txtZip;
	@FXML
	private Button btnSave;
	@FXML
	private MenuBar mbMenu;
	@FXML
	private Menu mFile;
	@FXML
	private Menu mEdit;
	@FXML
	private Menu mHelp;
	@FXML
	private MenuItem miClose;
	@FXML
	private MenuItem miDelete;
	@FXML
	private MenuItem miAbout;
	@FXML
	private Label lblFName;
	@FXML
	private Label lblLName;
	@FXML
	private Label lblPhone;
	@FXML
	private Label lblEmail;
	@FXML
	private Label lblDOB;
	@FXML
	private Label lblSSN;
	@FXML
	private Label lblStreet;
	@FXML
	private Label lblCity;
	@FXML
	private Label lblZip;
	@FXML
	private Label lblUserName;
	@FXML
	private Label lblPassword;
	@FXML
	private Label lblState;
	
	private ObservableList<String> stateList = FXCollections.observableArrayList("AL", "AK", "AZ", "AR", "CA", "CO", "CT",
			"DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT",
			"NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT",
			"VA", "WA", "WV", "WI", "WY"); 
	
	@FXML
	public void initialize(){
		cboState.setItems(stateList);	
	
		 txtFirstName.setText(UserSceneController.loggedInUser.getFirstName());
		 txtLastName.setText(UserSceneController.loggedInUser.getLastName());
		 txtEmail.setText(UserSceneController.loggedInUser.getEmail());
		 txtUsername.setText(UserSceneController.loggedInUser.getUserName());
		 txtPhoneNumber.setText(UserSceneController.loggedInUser.getPhone());
		 txtSocialSecurityNumber.setText(UserSceneController.loggedInUser.getSSN());
		 cboState.setValue(UserSceneController.loggedInUser.getState());
		 txtStreet.setText(UserSceneController.loggedInUser.getStreet());
		 txtCity.setText(UserSceneController.loggedInUser.getcity());
		 txtZip.setText(UserSceneController.loggedInUser.getZip());
		 dpDOB.setPromptText(UserSceneController.loggedInUser.getDOB().toString());
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Update Information");


		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(UpdateController.class.getResource("UpdateScene.fxml"));
		
		try{
			updateLayout = (AnchorPane) loader.load();
		}catch (IOException e){
			e.printStackTrace();
		}
		
		Scene scene = new Scene(updateLayout);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		}
		
		

	@FXML
	public void btSaveAction(ActionEvent e){
		if(!txtFirstName.getText().equals("") && !txtLastName.getText().equals("") && !txtPhoneNumber.getText().equals("") && !txtEmail.getText().equals("")
				&& dpDOB.getValue() != null && !txtSocialSecurityNumber.getText().equals("") && !txtUsername.getText().equals("") && !txtPassword.getText().equals("")
				&& !txtStreet.getText().equals("") && !txtCity.getText().equals("") && !cboState.getSelectionModel().isEmpty() && !txtZip.getText().equals("")){
			boolean onlyNumbers = true; 
			// Checks for phone number
			if(txtPhoneNumber.getText().matches("[a-zA-Z]+")){
				onlyNumbers = false;
				// Show alert
				Alert alert = new Alert(Alert.AlertType.ERROR);
			    alert.setTitle("Error");
			    alert.setHeaderText(" Error");
			    alert.setContentText("Please only use numbers for your Phone number");
			    alert.showAndWait();	
			    txtPhoneNumber.setStyle("-fx-background-color: #FFF0F0; -fx-prompt-text-fill: red");
			    txtPhoneNumber.setText("");
			 } else {
				txtPhoneNumber.setStyle(null);
			 }
			// Checks the value for SSN to make sure its a number
			if(txtSocialSecurityNumber.getText().matches("[a-zA-Z]+")){
				onlyNumbers = false;
				// Show alert
				Alert alert = new Alert(Alert.AlertType.ERROR);
			    alert.setTitle("Error");
			    alert.setHeaderText(" Error");
			    alert.setContentText("Please only use numbers for your Social Security Number");
			    alert.showAndWait();	
				txtSocialSecurityNumber.setStyle("-fx-background-color: #FFF0F0; -fx-prompt-text-fill: red");
				txtSocialSecurityNumber.setText(null);
			 }  else {
				txtSocialSecurityNumber.setStyle("");
			 }
			// Checks the value for zip code to make sure its a number
			if(txtZip.getText().matches("[a-zA-Z]+")){
				onlyNumbers = false;
				// Show alert
				Alert alert = new Alert(Alert.AlertType.ERROR);
			    alert.setTitle("Error");
			    alert.setHeaderText(" Error");
			    alert.setContentText("Please only use numbers for your Zip Code");
			    alert.showAndWait();	
				txtZip.setStyle("-fx-background-color: #FFF0F0; -fx-prompt-text-fill: red");
				txtZip.setText(null);
			 } else {
				txtZip.setStyle("");
			 }
			// Only goes through if onlyNumbers stayed true
			if(onlyNumbers){
				Customer customer = new Customer();
				customer.setStreet(txtStreet.getText());
				customer.setZip(txtZip.getText());
				customer.setcity(txtCity.getText());
				customer.setState(cboState.getValue());
				customer.setDOB(java.sql.Date.valueOf(dpDOB.getValue()));
				customer.setEmail(txtEmail.getText());
				customer.setFirstName(txtFirstName.getText());
				customer.setLastName(txtLastName.getText());
				customer.setPassword(HashPassword.hashPassword(txtPassword.getText()));
				customer.setUserName(txtUsername.getText());
				customer.setPhone(txtPhoneNumber.getText());
				customer.setSSN(txtSocialSecurityNumber.getText());
				
				// Send in customer to register
				Connect conn = new Connect();
				conn.initalizeDB();
				System.out.println("Updating customer");
				conn.updateUser(customer);
				conn.closeDB();
				//MasterPaneController.userMap.put(customer.getUserName(), customer);
				// Send it back to the log in scene
				try{
					FXMLLoader loader = new FXMLLoader();
					loader.setLocation(LogInController.class.getResource("LogInScene.fxml"));
					LogIinLayout = (AnchorPane) loader.load();
					MasterPaneController.masterLayout.setCenter(LogIinLayout);
					
				}catch (IOException ex){
					ex.printStackTrace();
				}
			}
		// If a field is missing
		} else {
			// Show alert
			Alert alert = new Alert(Alert.AlertType.ERROR);
		    alert.setTitle("Error");
		    alert.setHeaderText(" Error");
		    alert.setContentText("Please fill out the selected values");
		    alert.showAndWait();
		    // Check each individual fields
			if(txtFirstName.getText().equals("")){
				txtFirstName.setStyle("-fx-background-color: #FFF0F0; -fx-prompt-text-fill: red");
			} else {
				txtFirstName.setStyle("");
			}
			if(txtLastName.getText().equals("")){
				txtLastName.setStyle("-fx-background-color: #FFF0F0; -fx-prompt-text-fill: red");
			} else {
				txtLastName.setStyle("");
			}
			if(txtPhoneNumber.getText().equals("")){
				txtPhoneNumber.setStyle("-fx-background-color: #FFF0F0; -fx-prompt-text-fill: red");
			} else {
				txtPhoneNumber.setStyle("");
			}
			if(txtEmail.getText().equals("")){
				txtEmail.setStyle("-fx-background-color: #FFF0F0; -fx-prompt-text-fill: red");
			} else {
				txtEmail.setStyle("");
			}
			if(dpDOB.getValue() == null){
				dpDOB.setStyle("-fx-background-color: #FFF0F0; -fx-prompt-text-fill: red");
			} else {
				dpDOB.setStyle("");
			}
			if(txtSocialSecurityNumber.getText().equals("")){
				txtSocialSecurityNumber.setStyle("-fx-background-color: #FFF0F0; -fx-prompt-text-fill: red");
			} else {
				txtSocialSecurityNumber.setStyle("");
			}
			if(txtUsername.getText().equals("")){
				txtUsername.setStyle("-fx-background-color: #FFF0F0; -fx-prompt-text-fill: red");
			} else {
				txtUsername.setStyle("");
			}
			if(txtPassword.getText().equals("")){
				txtPassword.setStyle("-fx-background-color: #FFF0F0; -fx-prompt-text-fill: red");
			} else {
				txtPassword.setStyle("");
			}
			if(txtStreet.getText().equals("")){
				txtStreet.setStyle("-fx-background-color: #FFF0F0; -fx-prompt-text-fill: red");
			} else {
				txtStreet.setStyle("");
			}
			if(txtCity.getText().equals("")){
				txtCity.setStyle("-fx-background-color: #FFF0F0; -fx-prompt-text-fill: red");
			} else {
				txtCity.setStyle("");
			}
			if(cboState.getSelectionModel().isEmpty()){
				cboState.setStyle("-fx-background-color: #FFF0F0; -fx-prompt-text-fill: red");
			} else {
				cboState.setStyle("");
			}
			if(txtZip.getText().equals("")){
				txtZip.setStyle("-fx-background-color: #FFF0F0; -fx-prompt-text-fill: red");
			} else {
				txtZip.setStyle("");
			}
		}
	} 
	
	@FXML
	public void miCloseAction(ActionEvent e){
		System.exit(0);
	}
	
	
	@FXML
	public void miDeleteAction(ActionEvent e){
		clear();
	}
	
	public void clear(){
		txtFirstName.setText(null);
		txtLastName.setText(null);
		txtPhoneNumber.setText(null);
		txtEmail.setText(null);
		dpDOB.setValue(null);
		txtSocialSecurityNumber.setText(null);
		txtUsername.setText(null);
		txtPassword.setText(null);
		txtStreet.setText(null);
		txtCity.setText(null);
		cboState.setValue(null);
		txtZip.setText(null);
	}
}
