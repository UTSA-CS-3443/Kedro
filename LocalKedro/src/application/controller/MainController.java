package application.controller;

import application.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class MainController implements EventHandler<ActionEvent> {
	
	public void handle(ActionEvent event) {
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
		System.out.println("Log in");
	}
}
