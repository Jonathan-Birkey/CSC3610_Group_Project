package CSC3610_Group_Project;

import java.io.IOException;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AdminController extends Application {
	
	private Stage primaryStage;
	private AnchorPane adminLayout;
	private AnchorPane userLayout;

	@FXML
	private TextField txtUsername;
	@FXML
	private PasswordField txtPassword;
	@FXML
	private Button btnSave;
	@FXML
	private Button btnDelete;
	@FXML
	private Button btnBack;
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
	
	private ObservableList<UserTable> user;
    @FXML 
    private TableView<UserTable> UserTable;
    @FXML 
    private TableColumn<UserTable, String> FirstName;
    @FXML 
    private TableColumn<UserTable, String> LastName;
    @FXML 
    private TableColumn<UserTable, String> Phone;
    @FXML 
    private TableColumn<UserTable, String> SSN;
    @FXML
    private TableColumn<UserTable, String> UserName;
    @FXML
    private TableColumn<UserTable, Integer> Zip;
    @FXML
    private TableColumn<UserTable, String> Street;
    @FXML
    private TableColumn<UserTable, String> State;
    @FXML
    private TableColumn<UserTable, String> City;
    @FXML
    private TableColumn<UserTable, String> Email;
    @FXML
    private TableColumn<UserTable, String> DOB;
	
	@FXML
	public void initialize(){
		
		FirstName.setCellValueFactory(
        		new PropertyValueFactory<UserTable, String>("firstName"));
        LastName.setCellValueFactory(
        		new PropertyValueFactory<UserTable, String>("lastName"));
        UserName.setCellValueFactory(
        		new PropertyValueFactory<UserTable, String>("userName"));
        Phone.setCellValueFactory(
        		new PropertyValueFactory<UserTable, String>("phone"));
        Zip.setCellValueFactory(
        		new PropertyValueFactory<UserTable, Integer>("zip"));
        City.setCellValueFactory(
        		new PropertyValueFactory<UserTable, String>("city"));
        Street.setCellValueFactory(
        		new PropertyValueFactory<UserTable, String>("street"));
        State.setCellValueFactory(
        		new PropertyValueFactory<UserTable, String>("state"));
        Email.setCellValueFactory(
        		new PropertyValueFactory<UserTable, String>("Email"));
        DOB.setCellValueFactory(
        		new PropertyValueFactory<UserTable, String>("DOB"));
       
        System.out.println();
        Connect conn = new Connect();
		conn.initalizeDB();
		// Get table data and set it to the table view
        user = conn.getUserData();
        UserTable.setItems(user);

	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Update Information");


		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(UpdateController.class.getResource("AdminScene.fxml"));
		
		try{
			adminLayout = (AnchorPane) loader.load();
		}catch (IOException e){
			e.printStackTrace();
		}
		
		Scene scene = new Scene(adminLayout);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		}

	@FXML
	public void btSaveAction(ActionEvent e){

		Customer customer = new Customer();
		
			customer.setPassword(HashPassword.hashPassword(txtPassword.getText()));
			customer.setUserName(txtUsername.getText());
	
			
			// Send in customer to register
			Connect conn = new Connect();
			conn.initalizeDB();
			System.out.println("Sending in customer");
			conn.updateUserPassword(customer);
			conn.closeDB();
	}
	
	@FXML
	public void btSDeletection(ActionEvent e){
		Customer customer = new Customer();
			customer.setUserName(txtUsername.getText());
	
			
			// Send in customer to register
			Connect conn = new Connect();
			conn.initalizeDB();
			System.out.println("Customer Deleted");
			conn.deleteUser(customer);
			conn.closeDB();
			
			FirstName.setCellValueFactory(
	        		new PropertyValueFactory<UserTable, String>("firstName"));
	        LastName.setCellValueFactory(
	        		new PropertyValueFactory<UserTable, String>("lastName"));
	        UserName.setCellValueFactory(
	        		new PropertyValueFactory<UserTable, String>("userName"));
	        Phone.setCellValueFactory(
	        		new PropertyValueFactory<UserTable, String>("phone"));
	        Zip.setCellValueFactory(
	        		new PropertyValueFactory<UserTable, Integer>("zip"));
	        City.setCellValueFactory(
	        		new PropertyValueFactory<UserTable, String>("city"));
	        Street.setCellValueFactory(
	        		new PropertyValueFactory<UserTable, String>("street"));
	        State.setCellValueFactory(
	        		new PropertyValueFactory<UserTable, String>("state"));
	        Email.setCellValueFactory(
	        		new PropertyValueFactory<UserTable, String>("Email"));
	        DOB.setCellValueFactory(
	        		new PropertyValueFactory<UserTable, String>("DOB"));
	       
	        System.out.println();
	        Connect conn1 = new Connect();
			conn1.initalizeDB();
			// Get table data and set it to the table view
	        user = conn1.getUserData();
	        UserTable.setItems(user);
	}
	
	
	@FXML
	public void goBack(ActionEvent e) {
		FXMLLoader userLoader = new FXMLLoader();
		userLoader.setLocation(LogInController.class.getResource("LogInScene.fxml"));
		try {
			userLayout = (AnchorPane) userLoader.load();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		MasterPaneController.masterLayout.setCenter(userLayout);
	}	
}
