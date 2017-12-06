package application.controller;

import java.io.IOException;

import application.Main;
import application.model.DisplayUser;
import application.model.SearchString;
import application.model.UserSearch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
/**
 * This class handles the profile page
 * changes scene to events page view profile and home page
 * search grabs user inputed data and creates a search string object it sets the main search string object to that search string object and changes scene to profile results page
 * if search field is left blank shows an error message
 * @author SpaceHawks
 *
 */
public class ProfileController implements EventHandler<ActionEvent> {
	/**
	 * fxml text field holds search data
	 */
	public TextField search;
	/**
	 * string variable hold search data
	 */
	String s;
	/**
	 * changes scene to events page
	 * @param event - enables use through fxml
	 */
	@Override
	public void handle(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("EventsPage.fxml"));
			Main.stage.setScene(new Scene(root, 600, 400));
			Main.stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * changes scene to view profile
	 * sets main user to the current user information
	 * @param event - enables use thorugh fxml
	 */
	public void viewYourProfile(ActionEvent event) {
		try {
			Main.user.getEmail();
			Main.user.getLoc();
			Main.user.getName();
			Main.user.getPassword();
			Parent root = FXMLLoader.load(getClass().getResource("ProfileViewPage.fxml"));
			Main.stage.setScene(new Scene(root, 600, 400));
			Main.stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * creates search string object
	 * sets main search string to current search string object
	 * changes scene to profile results page
	 * if field is left blank displays an error message
	 * @param event - enables use through fxml
	 */
	public void search(ActionEvent event) {
		s = search.getText().toString();
		if (search.getText() == null || search.getText().isEmpty()) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Empty");
			alert.setHeaderText("Empty");
			alert.setContentText("You left a field blank");
			alert.showAndWait();
		} else {
			SearchString strings = new SearchString(s);
			Main.ss = strings;
			try {
				Parent root = FXMLLoader.load(getClass().getResource("ProfileResultsPage.fxml"));
				Main.stage.setScene(new Scene(root, 600, 400));
				Main.stage.show();
			} catch (Exception e) {
				e.printStackTrace();
			}
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
