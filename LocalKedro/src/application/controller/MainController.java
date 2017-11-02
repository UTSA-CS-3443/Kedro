package application.controller;

import application.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;


public class MainController implements EventHandler<ActionEvent> {
	
	AnchorPane aPane = new AnchorPane();
	public TextField USERNAME;
	public TextField PASSWORD;
	Button LOGIN = new Button();
	String u = "username";
	String p = "password";
	
	
	public void handle(ActionEvent event) {
		//compare emails to each other and password
		try {
			   Parent root = FXMLLoader.load(getClass().getResource("RegistrationPage.fxml")); 
			   Main.stage.setScene(new Scene(root, 600, 400)); 
			   Main.stage.show(); 
			} catch(Exception e) { 
			   e.printStackTrace(); 
			}
		System.out.println("Register");
	}
	
	public void handleButtonAction(ActionEvent arg0){
		u=USERNAME.getText().toString();
		p=PASSWORD.getText().toString();
		System.out.println(u + "\n" + p);
		try {
			   Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml")); 
			   Main.stage.setScene(new Scene(root, 600, 400)); 
			   Main.stage.show(); 
			} catch(Exception e) { 
			   e.printStackTrace(); 
			}
	}

	
}
