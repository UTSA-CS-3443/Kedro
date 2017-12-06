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
import javafx.scene.input.MouseEvent;
/**
 * This class displays the current users information through labels and changes scene to the edit profile page
 * @author SpaceHawks
 *
 */
public class ProfileViewController implements Initializable, EventHandler<ActionEvent> {
	/**
	 * fxml labels that display user information
	 */
	public Label user;
	public Label name;
	public Label zip;

	@Override
	/**
	 * changes scene to edit profile page
	 * @param event - enables use through fxml
	 */
	public void handle(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("EditProfilePage.fxml"));
			Main.stage.setScene(new Scene(root, 600, 400));
			Main.stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * changes scene to home page
	 * @param event - enables use through fxml
	 */
	public void home(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
			Main.stage.setScene(new Scene(root, 600, 400));
			Main.stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	/**
	 * initializes labels to display the logged in users information
	 * @param arg0, arg1 - enables initialization
	 */
	public void initialize(java.net.URL arg0, ResourceBundle arg1) {
		if (Main.user.getName() == null) {
			user.setText("Username : ");
		} else {
			user.setText("Username: " + Main.user.getName());
		}
		if (Main.user.getFName() == null) {
			name.setText("Name :");
		} else {
			name.setText("Name : " + Main.user.getFName());
		}
		if (Main.user.getLoc() == null) {
			zip.setText("Location : ");
		} else {
			zip.setText("Location : " + Main.user.getLoc());
		}
	}
	/**
	 * changes scene to home page
	 * @param event - enables use through fxml
	 */
	public void home(MouseEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
			Main.stage.setScene(new Scene(root, 600, 400));
			Main.stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
