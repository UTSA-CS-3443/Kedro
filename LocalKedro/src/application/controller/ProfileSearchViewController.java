package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class ProfileSearchViewController implements Initializable,EventHandler<ActionEvent> {
	
	public Label name;
	public Label user;
	public Label zip;

	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		name.setText("Name: Jackie Rowe");
		user.setText("Username: Jmeow12");
		zip.setText("Location: 78028");
		
	}

}
