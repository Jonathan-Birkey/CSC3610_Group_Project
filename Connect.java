// Connect Class
package CSC3610_Group_Project;

import java.sql.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

public class Connect {
	Connection connection;
	PreparedStatement preparedStatement;
	//List (ArrayList)
	List<TransactionTable> list = new ArrayList<>();
	//Stack (Stack)
	Stack<TransactionTable> stack = new Stack<>();	
	//Queue (PriorityQueue)
	PriorityQueue<TransactionTable> queue = new PriorityQueue<>();
	
	
	
	// Start the database.  Run this method everytime you need to connect to it
	public void initalizeDB(){
		try {
			// Load the driver
			Class.forName("com.mysql.jdbc.Driver"); System.out.println("Driver Loaded");
			
			
			//Connect to the database.  Make sure you have a user called "csc_student" with password "csc3610" or this wont work!
			connection = DriverManager.getConnection("jdbc:mysql://localhost/java3Final","csc_student","csc3610");
			System.out.println("Database connected"); 
		
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	// Log in validation
	public boolean validate(String username, String password){
		// Create the query that will be filled in later
		 String queryString = "select userName, password from user " +
	    			"where userName = ? ";
	    			
		// Create a statement
		try {
			// Prepare the statement and set the ? to the username
			preparedStatement = connection.prepareStatement(queryString);
			preparedStatement.setString(1, username);
		    ResultSet rset = preparedStatement.executeQuery();
		    // Once user is found, check the password
		    if (rset.next()) {
		    		System.out.println("Checking password");
		    	  if(rset.getString(2).equals(password)) {
		    		  // Only return true if the password is the same
		    		  return true;
		    	  } else {
		    		  // This is where the incorrect password alert should pop up
		    		//Alert User of missing fields
						Alert alert = new Alert(Alert.AlertType.ERROR);
					    alert.setTitle("Error");
					    alert.setHeaderText(" Error");
					    alert.setContentText("Incorrect Username or Password");
					    alert.showAndWait();
		    		  System.err.println("incorrect password");
		    	  }
		    } else { 
		    	  // Throw new exception and alert
			    	Alert alert = new Alert(Alert.AlertType.ERROR);
				    alert.setTitle("Error");
				    alert.setHeaderText(" Error");
				    alert.setContentText("Incorrect Username or Password");
				    alert.showAndWait();
		    	  System.out.println("Not found in database");
		    }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean validateAdmin(String userName, String password){
		// Create the query that will be filled in later
		 String queryString = "select userName, password from user " +
	    			"where userName = ? ";
	    			
		// Create a statement
		try {
			// Prepare the statement and set the ? to the username
			preparedStatement = connection.prepareStatement(queryString);
			preparedStatement.setString(1, "admin");
		    ResultSet rset = preparedStatement.executeQuery();
		    // Once user is found, check the password
		    if (rset.next()) {
		    		System.out.println("Checking password");
		    	  if(rset.getString(2).equals(password)) {
		    		  // Only return true if the password is the same
		    		  return true;
		    	  } 
		    } 
		    else {
		    }
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	// Create customer object
	public Person createPerson(String loggedInUser){
		String username = loggedInUser;
		String query = "select * from user where userName = '"+ username+ "'";
		Person person1 = new Person();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs1 = stmt.executeQuery(query);
			if(rs1.next()){
				person1.setFirstName(rs1.getString(1));
				person1.setLastName(rs1.getString(2));
				person1.setPhone(rs1.getString(3));
				person1.setEmail(rs1.getString(4));
				person1.setStreet(rs1.getString(5));
				person1.setcity(rs1.getString(6));
				person1.setState(rs1.getString(7));
				person1.setZip(rs1.getString(8));
				person1.setUserName(rs1.getString(9));
				person1.setPassword(rs1.getString(10));
				person1.setDOB(rs1.getDate(11));
				person1.setSSN(rs1.getString(12));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return person1;
	}
	
	// Register action
	public void register(Customer cus) {
		// Will take in a customer object and create a prepared statement
		String query = "insert into user (firstName, lastName, phone, email, street, city, state, zip, userName, password, DOB, ssn) values (?,?,?,?,?,?,?,?,?,?,?,?);";
		// Prepare the statement by setting the strings equal to the various getter methods
		try {
			
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, cus.getFirstName());
			preparedStatement.setString(2, cus.getLastName());
			preparedStatement.setString(3, cus.getPhone());
			preparedStatement.setString(4, cus.getEmail());
			preparedStatement.setString(5, cus.getStreet());
			preparedStatement.setString(6, cus.getcity());
			preparedStatement.setString(7, cus.getState());
			preparedStatement.setString(8, cus.getZip());
			preparedStatement.setString(9, cus.getUserName());
			preparedStatement.setString(10, cus.getPassword());
			preparedStatement.setDate(11, cus.getDOB(), new GregorianCalendar() );
			preparedStatement.setString(12, cus.getSSN());
			

			// Execute the query
			preparedStatement.execute();
			// This only prints out when a customer is fully added.  Delete this line later
			System.out.println("Customer added");
		} catch (SQLException e) {
			// This exception will only happen if a SQL error occurs
			e.printStackTrace();
		}
	}
	
	//Update User action
	public void updateUser(Customer person1) {
		// Prepare the statement by setting the strings equal to the various getter methods
		try {

			String query = "UPDATE user SET firstName = ?, lastName = ?, phone = ?, email = ?, street = ?, city = ?, state = ?, zip = ?, password  = ?, DOB = ?, ssn = ? "
								+ "WHERE userName = ?";

			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			
			System.out.print(person1);
			preparedStatement.setString(1, person1.getFirstName());
			preparedStatement.setString(2, person1.getLastName());
			preparedStatement.setString(3, person1.getPhone());
			preparedStatement.setString(4, person1.getEmail());
			preparedStatement.setString(5, person1.getStreet());
			preparedStatement.setString(6, person1.getcity());
			preparedStatement.setString(7, person1.getState());
			preparedStatement.setString(8, person1.getZip());
			preparedStatement.setString(12, person1.getUserName());
			preparedStatement.setString(9, person1.getPassword());
			preparedStatement.setDate(10, person1.getDOB(), new GregorianCalendar() );
			preparedStatement.setString(11, person1.getSSN());
			

			// Execute the query
			preparedStatement.execute();
			// This only prints out when a customer is fully added.  Delete this line later
			System.out.println("Customer Updated");
		} catch (SQLException e) {
			// This exception will only happen if a SQL error occurs
			e.printStackTrace();
		}
	}			
	// Add a transaction to the database
	public void addTransaction(Transaction transaction) {
		// Will take in a customer object and create a prepared statement
		String query = "insert into transaction (name, model, submodel, color, date_bought, price) values (?,?,?,?,?,?);";
		// Prepare the statement by setting the strings equal to the various getter methods
		try {
			
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, transaction.getCust_name());
			preparedStatement.setString(2, transaction.getCustomized_car().getModel());
			preparedStatement.setString(3, transaction.getCustomized_car().getSubModel());
			preparedStatement.setString(4, transaction.getCustomized_car().getColor());
			preparedStatement.setDate(5, transaction.getDate_bought(), new GregorianCalendar());
			preparedStatement.setDouble(6, transaction.getCustomized_car().getPrice());
			
			// Execute the query
			preparedStatement.execute();
			// This only prints out when a customer is fully added.  Delete this line later
			System.out.println("Transaction added");
		} catch (SQLException e) {
			// This exception will only happen if a SQL error occurs
			e.printStackTrace();
		}
	}
	public ObservableList<TransactionTable> getTableData() {
		ObservableList<TransactionTable> data = FXCollections.observableArrayList();
		
		//SQL FOR SELECTING ALL OF CUSTOMER
         String SQL = "SELECT * from transaction WHERE name = '" + UserSceneController.loggedInUser.getFirstName()+ " " 
        					+ UserSceneController.loggedInUser.getLastName() + "'";
        //ResultSet
        try {
			ResultSet rs = connection.createStatement().executeQuery(SQL);
			while(rs.next()){
				TransactionTable transaction = new TransactionTable();

                //Iterate Column
            	transaction.id.set(rs.getInt("id"));
                transaction.name.set(rs.getString("name"));
                transaction.model.set(rs.getString("model"));
                transaction.submodel.set(rs.getString("submodel"));
                transaction.color.set(rs.getString("color"));
                transaction.date_bought.set(rs.getDate("date_bought"));
                transaction.price.set(rs.getDouble("price"));
                System.out.println("Row added "+ transaction );
                data.add(transaction);
                
				//List (ArrayList)
				list.add(transaction);
				
				//Stack (Stack)
				stack.push(transaction);
				
				//Queue (PriorityQueue)
				queue.add(transaction);
				
				
            }
			
		//Quick sorting	
		TeslaQuickSort.quickSort(data);
		
		//Print List
		System.out.println("\nPrinting the list");
		for(TransactionTable tt: list)
			System.out.println(tt.toString());
		
		//Print Stack
		System.out.println("\nPrinting the stack");
		while(!stack.isEmpty()){
			System.out.println(stack.pop().toString());
		}
		
		
		System.out.println("\nPrinting the PriorityQueue");
		for(int i = 0; i < queue.size(); i++){
			System.out.println(queue.poll().toString());
		}
		
		
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return data;
	}
	
	public ObservableList<UserTable> getUserData() {
		ObservableList<UserTable> user = FXCollections.observableArrayList();
		
		//SQL FOR SELECTING ALL OF CUSTOMER
        String SQL = "sELECT * from user";
        //ResultSet
        try {
		ResultSet rs = connection.createStatement().executeQuery(SQL);
		while(rs.next()){
			UserTable userData = new UserTable();
               
                //Iterate Column
		userData.firstName.set(rs.getString("firstName"));
		userData.lastName.set(rs.getString("lastName"));
                userData.phone.set(rs.getString("phone"));
                userData.email.set(rs.getString("email"));
                userData.street.set(rs.getString("Street"));
                userData.city.set(rs.getString("city"));
                userData.state.set(rs.getString("state"));
                userData.zip.set(rs.getInt("zip"));
                userData.userName.set(rs.getString("userName"));
                userData.SSN.set(rs.getString("ssn"));
                userData.DOB.set(rs.getString("DOB"));
               
                
                System.out.println("User Displayed");
                user.add(userData);
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}
	
	//getting the email of the user
	public String getUserEmail() {
		System.out.println("Called getUserEmail() method"); 
		StringBuilder email = new StringBuilder();
		
		//SQL for getting the email of the logged in user
        String SQL = "select email from user where userName = '" + UserSceneController.loggedInUser.getUserName() + "';";
        //ResultSet
        try {
        	ResultSet rs = connection.createStatement().executeQuery(SQL);
        	if(rs.next()){
        		email.append(rs.getString(1));
                System.out.println("Email retrieved: " + email.toString());
            }
        	else{
        		System.out.println("Email not retrieved");
        	}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return email.toString();
	}
	

	
	//getting the email of the user
		public TransactionTable getUserTransaction() {
        	System.out.println("Called getUserTransacton() method");
			TransactionTable trans = new TransactionTable();
			
			//SQL for getting the email of the logged in user
	        String SQL = "select * from transaction where name = '" + UserSceneController.loggedInUser.getFirstName() + " " 
	        		+ UserSceneController.loggedInUser.getLastName() + "';";
	        //ResultSet
	        try {
	        	System.out.println("Before execute query");
	        	ResultSet rs = connection.createStatement().executeQuery(SQL);
	        	System.out.println("After execute query");
	        	if(rs.next()){
	        		trans.id.set(rs.getInt("id"));
	        		trans.name.set(rs.getString("name"));
	        		trans.model.set(rs.getString("model"));
	        		trans.submodel.set(rs.getString("submodel"));
	        		trans.color.set(rs.getString("color"));
	        		trans.date_bought.set(rs.getDate("date_bought"));
	        		trans.price.set(rs.getDouble("price"));
	                System.out.println("Got the transaction");
	            }
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return trans;
		}
	
	//admin
	//Update User password action
		public void updateUserPassword(Customer person1) {
			// Prepare the statement by setting the strings equal to the various getter methods
			try {

				String query = "UPDATE user SET password  = ?"
									+ "WHERE userName = ?";

				PreparedStatement preparedStatement = connection.prepareStatement(query);
				System.out.print(person1);
			
				preparedStatement.setString(2, person1.getUserName());
				preparedStatement.setString(1, person1.getPassword());

				// Execute the query
				preparedStatement.execute();
				// This only prints out when a customer is fully added.  Delete this line later
				System.out.println("Customer Updated");
			} catch (SQLException e) {
				// This exception will only happen if a SQL error occurs
				e.printStackTrace();
			}
		}	
		
		//Delete User action
		public void deleteUser(Customer person1) {
			// Prepare the statement by setting the strings equal to the various getter methods
				try {
					String query = "DELETE FROM user WHERE userName = ?";

					PreparedStatement preparedStatement = connection.prepareStatement(query);
					System.out.print(person1);
					preparedStatement.setString(1, person1.getUserName());

					// Execute the query
					preparedStatement.execute();
					// This only prints out when a customer is fully added.  Delete this line later
					System.out.println("Customer Updated");
		}
				
				catch (SQLException e) {
					// This exception will only happen if a SQL error occurs
					e.printStackTrace();
				}
			}	

	// Close the database
	public void closeDB() {
		try {
			connection.close();
			System.out.println("Database closed");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
