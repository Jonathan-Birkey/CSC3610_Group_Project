package CSC3610_Group_Project;

import java.io.IOException;
import java.text.NumberFormat;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ReportsController {

	@FXML Button btnBack;
	@FXML TextField txtSearch;
	private AnchorPane userLayout;
	private ObservableList data;
    @FXML private TableView salesTable;
	@FXML
	private void initialize() {
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
	
}
