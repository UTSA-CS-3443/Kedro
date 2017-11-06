package application.controller;

import application.model.User;
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

	public TextField USERNAME;
	public TextField PASSWORD;
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
	// opens up the Events Page when you click on Login for now
	// after Home Page is made, logging in will lead to the Home Page
	public void handleButtonAction(ActionEvent arg0){
		u=USERNAME.getText().toString();
		p=PASSWORD.getText().toString();
		User user = new User(u,p);
		System.out.println(u + "\n" + p);
		try {
			   Parent root = FXMLLoader.load(getClass().getResource("EventsPage.fxml")); 
			   Main.stage.setScene(new Scene(root, 600, 400)); 
			   Main.stage.show(); 
			} catch(Exception e) { 
			   e.printStackTrace(); 
			}
	}
	
	public void handleEvent(ActionEvent event) {
		//name
		//type
		//date
		//location
		//compare emails to each other and password
		try {
			   Parent root = FXMLLoader.load(getClass().getResource("IdkIguess.fxml"));
			   Main.stage.setScene(new Scene(root, 600, 400));
			   Main.stage.show();
			   //Event event = new Event(name, type, date, location);
			} catch(Exception e) {
			   e.printStackTrace();
			}
		System.out.println("event");
	}
}
