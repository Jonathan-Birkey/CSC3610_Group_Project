package CSC3610_Group_Project;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class stuff extends Application{

	@Override
	public void start(Stage primaryStage){
		ComboBox<String> cboState = new ComboBox<>();
		ObservableList<String> stateList = FXCollections.observableArrayList("AL", "AK", "AZ", "AR", "CA", "CO", "CT",
				"DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT",
				"NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT",
				"VA", "WA", "WV", "WI", "WY");
		
		
		
		cboState.setItems(stateList);
		cboState.setValue("AL");
		
		cboState.valueProperty().addListener(new ChangeListener<String>() {
	        @Override public void changed(ObservableValue ov, String t, String t1) {
	          System.out.println(ov);
	            System.out.println(t);
	            System.out.println(t1);
	        }    
	    });
		
		
		StackPane pane1 = new StackPane();
		pane1.getChildren().add(cboState);
		Scene scene01 = new Scene(pane1, 450, 150);
		primaryStage.setTitle("My Title");
		primaryStage.setScene(scene01);
		primaryStage.show();
	}
	
	
	
	public static void main(String[] args){
		Application.launch(args);
	}
}
