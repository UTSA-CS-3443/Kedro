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
 * This class handles the first view of the application the login and register page
 * register takes the user to the registration page
 * login checks inputed information and checks for validity if not valid shows an error message
 * if valid changes user to the home page and sets the main user object to the user object logged in
 * shows an error if any fields are left blank
 * @author SpaceHawks
 *
 */
public class MainController implements EventHandler<ActionEvent> {
	/**
	 * fxml text field which handle username and password
	 */
	public TextField USERNAME;
	public TextField PASSWORD;
	/**
	 * strings that hold user information
	 */
	String u = null;
	String p = null;
	String name = null;
	String zip = null;
	String email = null;
	/**
	 * changes scene to registration page
	 */
	public void handle(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("RegistrationPage.fxml"));
			Main.stage.setScene(new Scene(root, 600, 400));
			Main.stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * grabs input from user and checks validity
	 * if not valid shows an error message
	 * if valid changes scene to the home page and sets main user object to the current user object
	 * if any field is left blank shows an error message
	 * @param arg0 - enables use through fxml
	 */
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
