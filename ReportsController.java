package CSC3610_Group_Project;

import java.io.IOException;
import java.sql.Date;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class ReportsController {

	@FXML 
	private Button btnBack;
	@FXML
	private Button btnSearch;
	@FXML
	private TextField txtSearch;
	private AnchorPane userLayout;
	private ObservableList<TransactionTable> data;
    @FXML 
    private TableView<TransactionTable> salesTable;
    @FXML 
    private TableColumn<TransactionTable, Integer> col_id;
    @FXML 
    private TableColumn<TransactionTable, String> col_name;
    @FXML 
    private TableColumn<TransactionTable, String> col_model;
    @FXML 
    private TableColumn<TransactionTable, String> col_submodel;
    @FXML 
    private TableColumn<TransactionTable, String> col_color;
    @FXML 
    private TableColumn<TransactionTable, Date> col_date_bought;
    @FXML 
    private TableColumn<TransactionTable, Double> col_price;
    
    
	@FXML
	private void initialize() {
		
        col_name.setCellValueFactory(
        		new PropertyValueFactory<TransactionTable, String>("name"));
        col_model.setCellValueFactory(
        		new PropertyValueFactory<TransactionTable, String>("model"));
        col_submodel.setCellValueFactory(
        		new PropertyValueFactory<TransactionTable, String>("submodel"));
        col_color.setCellValueFactory(
        		new PropertyValueFactory<TransactionTable, String>("color"));
        col_date_bought.setCellValueFactory(
        		new PropertyValueFactory<TransactionTable, Date>("date_bought"));
        col_price.setCellValueFactory(
        		new PropertyValueFactory<TransactionTable, Double>("price"));
        col_id.setCellValueFactory(
        		new PropertyValueFactory<TransactionTable, Integer>("id"));
        
        Connect conn = new Connect();
		conn.initalizeDB();
		// Get table data and set it to the table view
        data = conn.getTableData();
        salesTable.setItems(data);

	}
	
	@FXML
	public void goBack(ActionEvent e) {
		FXMLLoader userLoader = new FXMLLoader();
		userLoader.setLocation(LogInController.class.getResource("HomeScene.fxml"));
		try {
			userLayout = (AnchorPane) userLoader.load();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		MasterPaneController.masterLayout.setCenter(userLayout);
	}
	
	@FXML
	public void btnSearchAction(ActionEvent e){
		 if(TeslaBinarySearch.binarySearch(data, Double.parseDouble(txtSearch.getText())) != null) {
				Alert alert = new Alert(Alert.AlertType.ERROR);
			    alert.setTitle("FOUND");
			    alert.setHeaderText(" FOUND");
			    alert.setContentText("That transaction was found in the database with the use of binary search!!!\nYay First Group!");
			    alert.showAndWait();
   		  System.err.println("Found");
   	  } else {
   		  // This is where the incorrect password alert should pop up
   		//Alert User of missing fields
				Alert alert = new Alert(Alert.AlertType.ERROR);
			    alert.setTitle("WAS NOT FOUND");
			    alert.setHeaderText(" WAS NOT FOUND");
			    alert.setContentText("That transaction was not found in the database");
			    alert.showAndWait();
   		  System.err.println("Not found");
   	  }
	}
	
}
