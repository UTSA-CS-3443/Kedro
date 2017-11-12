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
				while (user.isProceed()){
					//error message user already exists
					//reset text
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
				//error message pop up to user
			}
		}
		else {
			//error message pop up to user
		}
		System.out.println(u + "\n" + p + "\n" + e + "\n" + econfirm + "\n" + pconfirm + "\n");
	}

	@Override
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
