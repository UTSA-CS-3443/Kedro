package application.controller;

import application.model.User;
import application.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
/**
 * This class handles the registration of the user it creates a new user file and writes the information grabbed from the text fields
 * if a text field is left empty shows an error message
 * if username already being used displays an error message
 * checks to see if passwords match if not displays an error message
 * checks to see if emails match if not displays an error message
 * checkbox to ensure user is above 13 years of age if not checked shows an error message
 * @author SpaceHawks
 *
 */
public class RegistrationPageController implements EventHandler<ActionEvent> {
	/**
	 * fxml text fields which hold registration user information
	 */
	public TextField USERNAME;
	public TextField PASSWORD;
	public TextField EMAIL;
	public TextField ECONFIRM;
	public TextField PCONFIRM;
	public TextField ZIP;
	public TextField FULLNAME;
	/**
	 * fxml checkbox to ensure user is above 13 years of age
	 */
	public CheckBox CHECK;
	/**
	 * strings that hold text field information
	 */
	String z = "zip";
	String p = "password";
	String u = "user";
	String e = "email";
	String econfirm = "email";
	String pconfirm = "password";
	String fname = "full name";
	/**
	 * changes scene back to the login/register page
	 * @param event - enables use through fxml
	 */
	public void back(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("RegisterLoginPage.fxml"));
			Main.stage.setScene(new Scene(root, 600, 400));
			Main.stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	/**
	 * grabs information from the text fields and creates a user object sets the main user object to be the current user object
	 * writes the user information to a file
	 * checks if user exists if so shows an error message
	 * checks if passwords match if not shows an error message
	 * checks if emails match if not shows an error message
	 * if a field is left blank shows an error message
	 * has a checkbox to ensure user is 13 years or older if not checked displays an error message
	 * changes scene to the hompeage 
	 * @param event - enables user through the fxml
	 */
	public void handle(ActionEvent event) {
		u = USERNAME.getText().toString();
		p = PASSWORD.getText().toString();
		e = EMAIL.getText().toString();
		econfirm = ECONFIRM.getText().toString();
		pconfirm = PCONFIRM.getText().toString();
		z = ZIP.getText().toString();
		fname = FULLNAME.getText().toString();

		if (p.equals(pconfirm)) {
			if (e.equals(econfirm)) {
				User user = new User(u, p, e, z, fname);
				if (user.isProceed()) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Invalid Username");
					alert.setHeaderText("Username is already in use");
					alert.setContentText("Sorry that Username is already taken please use a different Username");
					alert.showAndWait();
				} else {
					try {
						user.userWrite();
						Main.user = user; // added an overall user object
						Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
						Main.stage.setScene(new Scene(root, 600, 400));
						Main.stage.show();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			} else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Emails do not match");
				alert.setHeaderText("The emails entered do not match");
				alert.setContentText("The emails you entered do not match");
				alert.showAndWait();
			}
		} else {
			if (!(CHECK.isSelected())) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Empty");
				alert.setHeaderText("Empty");
				alert.setContentText("unchecked");
				alert.showAndWait();
			} else {
				if (USERNAME.getText() == null || USERNAME.getText().isEmpty() || PASSWORD.getText() == null
						|| PASSWORD.getText().isEmpty() || EMAIL.getText() == null || EMAIL.getText().isEmpty()
						|| ECONFIRM.getText() == null || ECONFIRM.getText().isEmpty() || PCONFIRM.getText() == null
						|| PCONFIRM.getText().isEmpty() || ZIP.getText() == null || ZIP.getText().isEmpty()
						|| FULLNAME.getText() == null || FULLNAME.getText().isEmpty()) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Empty");
					alert.setHeaderText("Empty");
					alert.setContentText("You left a field blank");
					alert.showAndWait();
				} else {
					if (p.equals(pconfirm)) {
						if (e.equals(econfirm)) {
							User user = new User(u, p, e, z, fname);
							if (!(user.isProceed())) {
								Alert alert = new Alert(AlertType.ERROR);
								alert.setTitle("Invalid Username");
								alert.setHeaderText("Username is already in use");
								alert.setContentText(
										"Sorry that Username is already taken please use a different Username");
								alert.showAndWait();
							} else {
								try {
									Main.user = user;
									user.userWrite();
									Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
									Main.stage.setScene(new Scene(root, 600, 400));
									Main.stage.show();
								} catch (Exception ex) {
									ex.printStackTrace();
								}
							}
						} else {
							Alert alert = new Alert(AlertType.ERROR);
							alert.setTitle("Emails do not match");
							alert.setHeaderText("The emails entered do not match");
							alert.setContentText("The emails you entered do not match");
							alert.showAndWait();
						}
					} else {
						Alert alert = new Alert(AlertType.ERROR);
						alert.setTitle("Passwords do not match");
						alert.setHeaderText("The passwords entered do not match");
						alert.setContentText("The passwords you entered do not match");
						alert.showAndWait();
					}
				}
			}
		}
	}
}
