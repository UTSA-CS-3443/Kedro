package application.controller;

import application.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class MainController implements EventHandler<ActionEvent> {
	
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

	public void logIn(ActionEvent event) {
		//check if both the fields are filled
		//then search for username and if password is associated with it
		try {
			   Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml")); 
			   Main.stage.setScene(new Scene(root, 600, 400)); 
			   Main.stage.show(); 
			} catch(Exception e) { 
			   e.printStackTrace(); 
			}
		System.out.println("Log in");
	}
}
