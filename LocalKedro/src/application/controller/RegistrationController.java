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

public class RegistrationController implements EventHandler<ActionEvent>{
	
	public TextField USERNAME;
	public TextField PASSWORD;
	public TextField EMAIL;
	public TextField ECONFIRM;
	public TextField PCONFIRM;
	
	String p = "password";
	String u = "username";
	String e = "email";
	String econfirm = "confirm email";
	String pconfirm = "confirm password";
	
	public void handleButtonRegistration(ActionEvent arg0){
		u = USERNAME.getText().toString();
		p = PASSWORD.getText().toString();
		e = EMAIL.getText().toString();
		econfirm = ECONFIRM.getText().toString();
		pconfirm = PCONFIRM.getText().toString();
		
		if (p.equals(pconfirm)){
			if(e.equals(econfirm)){
				User user = new User(u, p, e);
				if (user.isProceed()){
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Invalid Username");
					alert.setHeaderText("Username is already in use");
					alert.setContentText("Sorry that Username is already taken please use a different Username");
					alert.showAndWait();
				}
				try {
					Parent root = FXMLLoader.load(getClass().getResource("Travis'HomePageVersion.fxml"));
					Main.stage.setScene(new Scene(root, 600, 400));
					Main.stage.show();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			else{
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Emails do not match");
				alert.setHeaderText("The emails entered do not match");
				alert.setContentText("The emails you entered do not match");
				alert.showAndWait();
			}
		}
		else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Passwords do not match");
			alert.setHeaderText("The passwords entered do not match");
			alert.setContentText("The passwords you entered do not match");
			alert.showAndWait();
		}
		System.out.println(u + "\n" + p + "\n" + e + "\n" + econfirm + "\n" + pconfirm + "\n");
	}

	@Override
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
