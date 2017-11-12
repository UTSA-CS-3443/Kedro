package application.controller;

import application.model.User;
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
 * This will handle the user input and button presses on the register login page and
 * the registration page
 * @author SpaceHawkksssssss
 *
 */
public class MainController implements EventHandler<ActionEvent> {

	public TextField USERNAME;
	public TextField PASSWORD;
	String u = "username";
	String p = "password";
	
	
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
	// opens up HomePage with successful login
	public void handleButtonAction(ActionEvent arg0) {
		u = USERNAME.getText().toString();
		p = PASSWORD.getText().toString();
		User user = new User(u, p);
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
				alert.setTitle("Username not found");
				alert.setHeaderText("Username not found");
				alert.setContentText("That was username does not exist");
				alert.showAndWait();
		}
			System.out.println("Logged In");
	}
}
