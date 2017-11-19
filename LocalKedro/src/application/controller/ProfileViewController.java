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
import javafx.scene.control.Label;

public class ProfileViewController implements Initializable,EventHandler<ActionEvent>{
	
	public Label user;
	public Label name;
	public Label zip;
	public Label events;
	
	@Override
	public void handle(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("EditProfilePage.fxml"));
			Main.stage.setScene(new Scene(root, 600, 400));
			Main.stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Editing Profile");
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
		if (Main.user.getName() == null){
			user.setText("Username : ");
		}
		else{
			user.setText("Username: " + Main.user.getName());
		}
		if (Main.user.getFName() == null){
			name.setText("Name :");
		}
		else{
			name.setText("Name : " + Main.user.getFName());
		}
		if(Main.user.getLoc() == null){
			zip.setText("Zip Code : ");
		}
		else{
			zip.setText("Zip Code : " + Main.user.getLoc());
		}
		events.setText("Recent Events : TEST");
	}
}