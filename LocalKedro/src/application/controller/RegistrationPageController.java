package application.controller;

import application.model.Location;
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

public class RegistrationPageController implements EventHandler<ActionEvent> {
	public TextField USERNAME;
	public TextField PASSWORD;
	public TextField EMAIL;
	public TextField ECONFIRM;
	public TextField PCONFIRM;
	public TextField ZIP;
	public TextField FULLNAME;

	public CheckBox CHECK;

	String z = "zip";
	String p = "password";
	String u = "user";
	String e = "email";
	String econfirm = "email";
	String pconfirm = "password";
	String fname = "full name";

	public void back(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("RegisterLoginPage.fxml"));
			Main.stage.setScene(new Scene(root, 600, 400));
			Main.stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Back");
	}

	@Override
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
						Main.user = user; //added an overall user object
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
					|| PCONFIRM.getText().isEmpty() || ZIP.getText() == null || ZIP.getText().isEmpty() || FULLNAME.getText() == null || FULLNAME.getText().isEmpty()) {
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
