package application.controller;

import application.Main;
import application.model.DisplayEvent;
import application.model.EventSearch;
import application.model.SearchString;
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
 * This class controls the event page
 * changes the scene to the create event page
 * changes the scene to the profiles page
 * changes the scene to the home page
 * search grabs user inputed data and creates a searchString object used to search and changes the scene to the events result page
 * @author SpaceHawks
 *
 */
public class EventController implements EventHandler<ActionEvent> {
	/**
	 * fxml text field that holds user inputed data
	 */
	public TextField search;
	/**
	 * string variable to hold text field data
	 */
	String s;
	
	/**
	 * changes scene to create event page
	 * @parm event - enables use through fxml
	 */
	@Override
	public void handle(ActionEvent event) { // press on the create event page
		// name
		// type
		// date
		// location
		// compare emails to each other and password
		try {
			Parent root = FXMLLoader.load(getClass().getResource("CreateEventPage.fxml"));
			Main.stage.setScene(new Scene(root, 600, 400));
			Main.stage.show();
			// Event event = new Event(name, type, date, location);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * changes scene to the profile page
	 * @param event - enables use through fxml
	 */
	public void openProfilesPage(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("ProfilesPage.fxml"));
			Main.stage.setScene(new Scene(root, 600, 400));
			Main.stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * this method grabs a string from the user inputed data and creates a searchString object and sets the main searchString to the current object
	 * displays an error if the search text field is left blank
	 * changes scene to events result page
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
				Parent root = FXMLLoader.load(getClass().getResource("EventResultsPage.fxml"));
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
