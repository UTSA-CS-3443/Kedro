package application.controller;

import java.util.ResourceBundle;

import javax.annotation.Resources;
import javax.print.DocFlavor.URL;

import application.Main;
import application.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;

public class EventViewController implements Initializable,EventHandler<ActionEvent>{
	
	public Label date;
	public Label name;
	public Label zip;
	public Label type;
	
	@Override
	public void handle(ActionEvent event) {

	}
	
	public void home(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
			Main.stage.setScene(new Scene(root, 600, 400));
			Main.stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Home Button");
	}
	

	@Override
	public void initialize(java.net.URL arg0, ResourceBundle arg1) {
		date.setText("Date: 11/30/17");
		name.setText("Name: Car Auction");
		zip.setText("Location: 78259");
		type.setText("Type: Other");
	}
}