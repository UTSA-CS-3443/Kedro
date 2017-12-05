package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import application.model.DisplayUser;
import application.model.Event;
import application.model.OtherUser;
import application.model.UserSearch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
/**
 * this class is the controller that updates the view and calls search functions
 * to search for the user by name and displays search results
 * @author SpaceHawks
 *
 */
public class ProfileSearchController implements Initializable, EventHandler<ActionEvent> {

	public Hyperlink profile1;
	public Hyperlink profile2;
	public Hyperlink profile3;

	UserSearch us = new UserSearch(Main.ss.getText());
	DisplayUser[] du = us.searchAll();

	// this is an array of user names. Set the text in the fxml to this in a for
	// loop
	@Override
	public void handle(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("ProfileSearchViewPage.fxml"));
			Main.stage.setScene(new Scene(root, 600, 400));
			Main.stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Profiles Page");

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		if (du[0] == null) {
			profile1.setText("");
			profile2.setText("");
			profile3.setText("");
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("NO RESULTS");
			alert.setHeaderText("NO RESULTS");
			alert.setContentText("no results found");
			alert.showAndWait();
		} else if (du[1] == null) {
			profile1.setText(du[0].getName());
			profile2.setText("");
			profile3.setText("");
		} else if (du[2] == null) {
			profile1.setText(du[0].getName());
			profile2.setText(du[1].getName());
			profile3.setText("");
		} else {
			switch (du.length) {
			case 1:
				profile1.setText(du[0].getName());
				profile2.setText("");
				profile3.setText("");
				break;
			case 2:
				profile1.setText(du[0].getName());
				profile2.setText(du[1].getName());
				profile3.setText("");
				break;
			case 3:
				profile1.setText(du[0].getName());
				profile2.setText(du[1].getName());
				profile3.setText(du[2].getName());
				break;
			default:
				profile1.setText(du[0].getName());
				profile2.setText(du[1].getName());
				profile3.setText(du[2].getName());
				break;
			}
		}
	}

	public void home(MouseEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
			Main.stage.setScene(new Scene(root, 600, 400));
			Main.stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Home Button");
	}

	public void profileOne(ActionEvent arg0) {
		OtherUser u = new OtherUser(du[0].getName(), du[0].getEmail(), du[0].getLoc(), du[0].getFName());
		Main.otherUser = u;
		try {
			Parent root = FXMLLoader.load(getClass().getResource("ProfileSearchViewPage.fxml"));
			Main.stage.setScene(new Scene(root, 600, 400));
			Main.stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void profileTwo(ActionEvent arg0) {
		OtherUser u = new OtherUser(du[1].getName(), du[1].getEmail(), du[1].getLoc(), du[1].getFName());
		Main.otherUser = u;
		try {
			Parent root = FXMLLoader.load(getClass().getResource("ProfileSearchViewPage.fxml"));
			Main.stage.setScene(new Scene(root, 600, 400));
			Main.stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void profileThree(ActionEvent arg0) {
		OtherUser u = new OtherUser(du[2].getName(), du[2].getEmail(), du[2].getLoc(), du[2].getFName());
		Main.otherUser = u;
		try {
			Parent root = FXMLLoader.load(getClass().getResource("ProfileSearchViewPage.fxml"));
			Main.stage.setScene(new Scene(root, 600, 400));
			Main.stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
