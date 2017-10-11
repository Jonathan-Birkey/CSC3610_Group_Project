package CSC3610_Group_Project;



import java.io.IOException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class RegisterController extends Application{

	private Stage primaryStage;
	private AnchorPane rootLayout;
	private AnchorPane logInLayout;
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
	private TextField txtPassword;
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
	
	private ObservableList<String> stateList = FXCollections.observableArrayList("AL", "AK", "AZ", "AR", "CA", "CO", "CT",
			"DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT",
			"NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT",
			"VA", "WA", "WV", "WI", "WY"); 
	
	@FXML
	public void initialize(){
		cboState.setItems(stateList);
	}
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Register");


		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(RegisterController.class.getResource("RegisterScene.fxml"));
		
		try{
			rootLayout = (AnchorPane) loader.load();
		}catch (IOException e){
			e.printStackTrace();
		}
		
		Scene scene = new Scene(rootLayout);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	@FXML
	public void btSaveAction(ActionEvent e){
		if(txtFirstName.getText() != null && txtLastName.getText() != null && txtPhoneNumber.getText() != null && txtEmail.getText() != null
				&& dpDOB.getValue() != null && txtSocialSecurityNumber.getText() != null && txtUsername.getText() != null && txtPassword.getText() != null
				&& txtStreet.getText() != null && txtCity.getText() != null && cboState.getValue() != null && txtZip.getText() != null){
			
			Customer customer = new Customer();
			customer.setAddress(txtStreet.getText() + "\t" + txtCity.getText() + "\t" + cboState.getValue().toString() + "\t" + txtZip.getText());
			customer.setDOB(dpDOB.getValue());
			customer.setEmail(txtEmail.getText());
			customer.setFirstName(txtFirstName.getText());
			customer.setLastName(txtLastName.getText());
			customer.setPassword(txtPassword.getText());
			customer.setUserName(txtUsername.getText());
			customer.setPhone(txtPhoneNumber.getText());
			customer.setSSN(txtSocialSecurityNumber.getText());
			
			MasterPaneController.userMap.put(customer.getUserName(), customer);
			
			try{
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(LogInController.class.getResource("LogInScene.fxml"));
				logInLayout = (AnchorPane) loader.load();
				MasterPaneController.masterLayout.setCenter(logInLayout);
				
			}catch (IOException ex){
				ex.printStackTrace();
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

	
	public static void main(String[] args){
		launch(args);
	}
	
}