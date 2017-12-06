package application.controller;

import application.model.User;

import java.io.FileNotFoundException;
import java.io.IOException;

import application.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * This will handle the user input and button presses on the register login page
 * and the registration page
 * 
 * @author SpaceHawkksssssss
 *
 */
public class MainController implements EventHandler<ActionEvent> {

	public TextField USERNAME;
	public TextField PASSWORD;
	String u = null;
	String p = null;
	String name = null;
	String zip = null;
	String email = null;

	public void handle(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("RegistrationPage.fxml"));
			Main.stage.setScene(new Scene(root, 600, 400));
			Main.stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// opens up HomePage with successful login
	public void handleButtonAction(ActionEvent arg0) {
		u = USERNAME.getText().toString();
		p = PASSWORD.getText().toString();
		if (USERNAME.getText() == null || USERNAME.getText().isEmpty() || PASSWORD.getText() == null
				|| PASSWORD.getText().isEmpty()) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Empty");
			alert.setHeaderText("Empty");
			alert.setContentText("You left a field blank");
			alert.showAndWait();
		} else {
			User user = new User(u, p);
			Main.user = user;
			System.out.println(u + "\n" + p);
			// added error checking so need name and abc123 to log in
			if (user.isProceed()) {
				try {
					Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
					Main.stage.setScene(new Scene(root, 600, 400));
					Main.stage.show();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Invalid Username or Password");
				alert.setHeaderText("Invalid Username or Passowrd");
				alert.setContentText("Sorry you entered an invalid username or password");
				alert.showAndWait();
			}
		}
		Main.user.setCurrentUser();
	}
}
