package CSC3610_Group_Project;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class CartSceneController extends Application{
	// Variables
	private Stage primaryStage;
	private AnchorPane rootLayout;
	public static Car customizedCar;
	private AnchorPane userLayout;
	private AnchorPane carLayout;
	// Labels from fxml
	@FXML
	private Label lblModel, lblModelPrice, lblColor, lblColorPrice, lblInterior, lblInteriorPrice, 
	lblWheels, lblWheelsPrice, lblRoof, lblRoofPrice, lblTotal;
	@FXML
	private Button btnOrder;
	@FXML
	private Button btnEdit;
	private HashMap<String, Double> hMap = new HashMap<>();
	
	// This happens when you press the Order button
	@FXML
	private void purchase() throws AddressException, SQLException {
		// Create a transaction object to send into the database
		Transaction transaction = new Transaction(UserSceneController.loggedInUser.getFirstName() + " " + UserSceneController.loggedInUser.getLastName(),
				customizedCar, new Date(0));
		
		//System.out.println(transaction);
		Connect conn = new Connect();
		conn.initalizeDB();
		conn.addTransaction(transaction);

		final String email = "thefirstgroupcsc3610@gmail.com";
		final String password = "WeTheBest";
		
		//Value added: sending a confirmation email
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
			
		Session session = Session.getInstance(properties, new javax.mail.Authenticator(){
			protected PasswordAuthentication getPasswordAuthentication(){
				return new PasswordAuthentication(email, password);
			}
		});
			
			
		try{
			TransactionTable tt = conn.getUserTransaction();
			String orderNum = tt.getId().toString();
			String name = tt.getName();
			String model = tt.getModel();
			String submodel = tt.getSubmodel();
			String color = tt.getColor();
			String date = tt.getDate_bought().toString();
			String total = tt.getPrice().toString();

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("Tesla"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(conn.getUserEmail()));
			message.setSubject("Tesla Confirmation");
						
					
			message.setContent("<h:body style=background-color:white,font-family:verdana; color:#002>"
					+ "Congratulations on your order:<br/>"
					+ "Order Number: "+ orderNum + "<br/>"
					+ "Customer: : "+ name + "<br/>"
					+ "Model: "+ model + "<br/>"
					+ "Submodel: "+ submodel + "<br/>"
					+ "Color: "+ color + "<br/>"
					+ "Purcahse Date: "+ date + "<br/>"
					+ "Total: "+ total + "<br/>"
					+ "</body>", 
					"text/html; charset=utf-8");
			Transport.send(message);
			System.out.println("Email sent");
		}catch(MessagingException me){
			me.printStackTrace();
		}
	
			
			
		// Try to load the user scene
		try{
			FXMLLoader carLoader = new FXMLLoader();
			carLoader.setLocation(LogInController.class.getResource("HomeScene.fxml"));
			carLayout = (AnchorPane) carLoader.load();
			
			MasterPaneController.masterLayout.setCenter(carLayout);

		}catch (IOException ex){
			ex.printStackTrace();
		}
		
		conn.closeDB();
	}
	
	
	@FXML
	private void btnEditAction(ActionEvent e){
		FXMLLoader userLoader = new FXMLLoader();
		userLoader.setLocation(CarSceneController.class.getResource("CarScene.fxml"));
		try {
			userLayout = (AnchorPane) userLoader.load();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		MasterPaneController.masterLayout.setCenter(userLayout);
	}
	
	// Set up the labels to reflect what your car options were
	@FXML 
	private void initialize (){
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
		hMap.put("75D", 75000.0);
		hMap.put("100D", 98500.0);
		hMap.put("P100D", 136000.0);
		
		
		NumberFormat format = NumberFormat.getCurrencyInstance();
		
		// Set the labels
		lblModel.setText(customizedCar.getSubModel());
		lblModelPrice.setText(format.format(hMap.get(customizedCar.getSubModel())));
		lblColor.setText(customizedCar.getColor());
		lblColorPrice.setText(format.format(hMap.get(customizedCar.getColor())));
		lblInterior.setText(customizedCar.getInteriorType());
		lblInteriorPrice.setText(format.format(hMap.get(customizedCar.getInteriorType())));
		lblWheels.setText(customizedCar.getSizeOfWheels());
		lblWheelsPrice.setText(format.format(hMap.get(customizedCar.getSizeOfWheels())));
		lblRoof.setText(customizedCar.getRoof());
		lblRoofPrice.setText(format.format(hMap.get(customizedCar.getRoof())));
		
		
		lblTotal.setText(String.valueOf(format.format(customizedCar.getPrice())));
		
		System.out.println(customizedCar);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Log In");


		FXMLLoader logInLoader = new FXMLLoader();
		logInLoader.setLocation(CartSceneController.class.getResource("CartScene.fxml"));
		
		try{
			rootLayout = (AnchorPane) logInLoader.load();
		}catch (IOException e){
			e.printStackTrace();
		}
		
		
		Scene scene = new Scene(rootLayout);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

}
