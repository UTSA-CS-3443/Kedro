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
 * This class is going to control the event page button presses and user input
 * 
 * @author Travis
 *
 */
public class EventController implements EventHandler<ActionEvent> {

	public TextField search;
	String s;

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

	public void openProfilesPage(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("ProfilesPage.fxml"));
			Main.stage.setScene(new Scene(root, 600, 400));
			Main.stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

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
				/*
				 * EventSearch es = new EventSearch(s, null, null);
				 * DisplayEvent[] de = es.searchAll();
				 * System.out.println(de.length); // this is an array of event
				 * names. Set the text in the fxml to this in a for // loop
				 * /*for (DisplayEvent d : de) { if(d == null) { break; } else {
				 * System.out.println(d.toString()); } // set the hyperlink
				 * values or put this somewhere else. idk // maybe iteratively
				 * create new hyperlinks }
				 */
				Parent root = FXMLLoader.load(getClass().getResource("EventResultsPage.fxml"));
				Main.stage.setScene(new Scene(root, 600, 400));
				Main.stage.show();
			} catch (Exception e) {
				e.printStackTrace();
			}
			/*
			 * } catch (NullPointerException e) { System.out.println(
			 * "search didn't work"); } catch (IOException e) {
			 * System.out.println("Page didn't load"); } catch
			 * (ArrayIndexOutOfBoundsException e) { System.out.println(
			 * "out of bounds here"); } System.out.println("Events search");
			 */
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
	}

}
