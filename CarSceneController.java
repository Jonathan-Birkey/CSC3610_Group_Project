package CSC3610_Group_Project;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.HashMap;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class CarSceneController extends Application {

	public static Person loggedInUser;

	
	private AnchorPane userLayout;

	@FXML
	private Button btnCart;
	@FXML
	private Button btnBack;
	@FXML
	private Button btn75D;
	@FXML
	private Button btn100D;
	@FXML
	private Button btnP100D;
	@FXML
	private ComboBox<String> cboColor;
	@FXML
	private ComboBox<String> cboInterior;
	@FXML
	private ComboBox<String> cboWheels;
	@FXML
	private ComboBox<String> cboRoof;
	@FXML
	private Label lblPrice;
	@FXML
	private ImageView carPicture;

	private String battery;
	private double price = 75000.00;
	private double priceColor = 0.0;
	private double priceInterior = 0.0;
	private double priceWheels = 0.0;
	private double priceRoof = 0.0;
	private double totalPrice;

	// pupulate the combo boxes
	private ObservableList<String> colorList = FXCollections.observableArrayList("Black", "Red", "Silver", "Blue",
			"White");
	private ObservableList<String> interiorList = FXCollections.observableArrayList("Black Premium", "White Premium",
			"Cream Premium", "Black Standard", "Clasic Black");
	private ObservableList<String> wheelList = FXCollections.observableArrayList("19\" Silver Slipstream",
			"19\" Grey Slipstream", "21\" Grey Turbine");
	private ObservableList<String> roofList = FXCollections.observableArrayList("Glass", "Sunroof");

	private HashMap<String, Double> hMap = new HashMap<>();

	// Update Info button
	@FXML
	private void initialize() {
		cboColor.setItems(colorList);
		cboInterior.setItems(interiorList);
		cboWheels.setItems(wheelList);
		cboRoof.setItems(roofList);
		carPicture.setImage(new Image("CSC3610_Group_Project/modelSGray.png"));
		cboColor.setValue("Black");
		cboInterior.setValue("Black Premium");
		cboWheels.setValue("19\" Silver Slipstream");
		cboRoof.setValue("Glass");
		
		

		// populate the hashMap
		hMap.put("Black", 0.0);
		hMap.put("Silver", 1000.0);
		hMap.put("Blue", 1000.0);
		hMap.put("Red", 1500.0);
		hMap.put("White", 1500.0);
		hMap.put("Black Premium", 1500.0);
		hMap.put("White Premium", 1500.0);
		hMap.put("Cream Premium", 1500.0);
		hMap.put("Black Standard", 1500.0);
		hMap.put("Clasic Black", 3200.0);
		hMap.put("19\" Silver Slipstream", 0.0);
		hMap.put("19\" Grey Slipstream", 2500.0);
		hMap.put("21\" Grey Turbine", 4500.0);
		hMap.put("Glass", 0.0);
		hMap.put("Sunroof", 2000.0);

		NumberFormat format = NumberFormat.getCurrencyInstance();
		btn75D.setStyle("-fx-background-color: #c2c2c2");
		btn100D.setStyle("-fx-background-color: #ffffff");
		btnP100D.setStyle("-fx-background-color: #ffffff");
		
		price = 75000.0;
		battery = "75D";
		totalPrice = price + priceRoof + priceWheels + priceInterior + priceColor;
		lblPrice.setText(format.format(price + priceRoof + priceWheels + priceInterior + priceColor));
		
		
		// listener for Color options
		cboColor.valueProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue ov, String t, String t1) {
				priceColor = hMap.get(t1);
				totalPrice = price + priceRoof + priceWheels + priceInterior + priceColor;
				lblPrice.setText(format.format(price + priceRoof + priceWheels + priceInterior + priceColor));

				// change picture as the user picks the color
				switch (t1) {
				case "Black":
					carPicture.setImage(new Image("CSC3610_Group_Project/black.jpg"));
					break;
				case "Silver":
					carPicture.setImage(new Image("CSC3610_Group_Project/silver.jpg"));
					break;
				case "Blue":
					carPicture.setImage(new Image("CSC3610_Group_Project/blue.jpg"));
					break;
				case "Red":
					carPicture.setImage(new Image("CSC3610_Group_Project/red.jpg"));
					break;
				case "White":
					carPicture.setImage(new Image("CSC3610_Group_Project/white.jpg"));
					break;
				}
			}
		});

		// listener for Interior options
		cboInterior.valueProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue ov, String t, String t1) {
				priceInterior = hMap.get(t1);
				totalPrice = price + priceRoof + priceWheels + priceInterior + priceColor;
				lblPrice.setText(format.format(price + priceRoof + priceWheels + priceInterior + priceColor));

				// change picture as the user picks the interior color
				switch (t1) {
				case "Black Premium":
					carPicture.setImage(new Image("CSC3610_Group_Project/Black Premium.jpg"));
					break;
				case "White Premium":
					carPicture.setImage(new Image("CSC3610_Group_Project/White Premium.jpg"));
					break;
				case "Cream Premium":
					carPicture.setImage(new Image("CSC3610_Group_Project/Cream Premium.jpg"));
					break;
				case "Black Standard":
					carPicture.setImage(new Image("CSC3610_Group_Project/Black Standard.jpg"));
					break;
				case "Clasic Black":
					carPicture.setImage(new Image("CSC3610_Group_Project/Clasic Black.jpg"));
					break;
				}
			}
		});

		// listener for Wheels options
		cboWheels.valueProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue ov, String t, String t1) {
				priceWheels = hMap.get(t1);
				totalPrice = price + priceRoof + priceWheels + priceInterior + priceColor;
				lblPrice.setText(format.format(price + priceRoof + priceWheels + priceInterior + priceColor));
			}
		});

		// listener for Roof options
		cboRoof.valueProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue ov, String t, String t1) {
				priceRoof = hMap.get(t1);
				totalPrice = price + priceRoof + priceWheels + priceInterior + priceColor;
				lblPrice.setText(format.format(price + priceRoof + priceWheels + priceInterior + priceColor));
			}
		});
	}

	@FXML
	public void model75D(ActionEvent e) {
		btn75D.setStyle("-fx-background-color: #c2c2c2");
		btn100D.setStyle("-fx-background-color: #ffffff");
		btnP100D.setStyle("-fx-background-color: #ffffff");
		
		price = 75000.0;
		battery = "75D";
		NumberFormat format = NumberFormat.getCurrencyInstance();
		totalPrice = price + priceRoof + priceWheels + priceInterior + priceColor;
		lblPrice.setText(format.format(price + priceRoof + priceWheels + priceInterior + priceColor));
	}

	@FXML
	public void btn100D(ActionEvent e) {
		btn100D.setStyle("-fx-background-color: #c2c2c2");
		btn75D.setStyle("-fx-background-color: #ffffff");
		btnP100D.setStyle("-fx-background-color: #ffffff");
		price = 98500.0;
		battery = "100D";
		NumberFormat format = NumberFormat.getCurrencyInstance();
		totalPrice = price + priceRoof + priceWheels + priceInterior + priceColor;
		lblPrice.setText(format.format(price + priceRoof + priceWheels + priceInterior + priceColor));
	}

	@FXML
	public void btnP100Daction(ActionEvent e) {
		btnP100D.setStyle("-fx-background-color: #c2c2c2");
		btn100D.setStyle("-fx-background-color: #ffffff");
		btn75D.setStyle("-fx-background-color: #ffffff");
		price = 136000.0;
		battery = "P100D";
		NumberFormat format = NumberFormat.getCurrencyInstance();
		totalPrice = price + priceRoof + priceWheels + priceInterior + priceColor;
		lblPrice.setText(format.format(price + priceRoof + priceWheels + priceInterior + priceColor));
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
	public void btnCart(ActionEvent e) {
		Car car = new Car(cboColor.getValue(), "Model S", 2018, cboWheels.getValue(), cboInterior.getValue(),totalPrice, battery, cboRoof.getValue());
		CartSceneController.customizedCar = car;
		FXMLLoader userLoader = new FXMLLoader();
		userLoader.setLocation(LogInController.class.getResource("CartScene.fxml"));
		try {
			userLayout = (AnchorPane) userLoader.load();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		MasterPaneController.masterLayout.setCenter(userLayout);
		
		System.out.println(car);
	}
	
	@Override
	public void start(Stage arg0) throws Exception {
	}
}

/*
 * public void initialize(URL location, ResourceBundle resources) { File file =
 * new File("teslaProfile.jpg"); Image image = new
 * Image(file.toURI().toString()); carPicture.setImage(image); }
 * 
 * // carPicture.setOnAction(new EventHandler<ActionEvent>() { // public void
 * handle(ActionEvent e) { // // } // }); //
 */
