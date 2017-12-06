package application.controller;

import application.Main;
import application.model.Event;
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
 * This class handles the create event page
 * this controller creates the event by calling eventCheck and eventWrite from the event model
 * @author SpaceHawks
 *
 */
public class CreateEventController implements EventHandler<ActionEvent> {

	// this class handles all of the Event controllers within each individual
	// event page
	// as in creating the event but also when the user interacts with an already
	// created event page
	// when join event is pressed it creates an rsvp object for the user
	/**
	 * fxml textfields which hold entered information
	 */
	public TextField ENAME;
	public TextField ETYPE;
	public TextField EDATE;
	public TextField ELOC;
	
	/**
	 * strings to hold textfield data
	 */
	String eName = "event name";
	String eType = "event type";
	String eDate = "event date";
	String eLoc = "event location";
	
	/**
	 * the handle method grabs the text inputed and stores them in the string variables
	 * it shows an alert if a field is left blank
	 * it writes the vent to a file after a check
	 * changes scene to the events page
	 * @param ActionEvent event - enables use through fxml
	 */
	@Override
	public void handle(ActionEvent event) {
		// takes info from the user and puts into event object in the try
		eName = ENAME.getText().toString();
		eType = ETYPE.getText().toString();
		eDate = EDATE.getText().toString();
		eLoc = ELOC.getText().toString();
		if (ENAME.getText() == null || ENAME.getText().isEmpty() || ETYPE.getText() == null || ETYPE.getText().isEmpty()
				|| EDATE.getText() == null || EDATE.getText().isEmpty() || ELOC.getText() == null
				|| ELOC.getText().isEmpty()) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Empty");
			alert.setHeaderText("Empty");
			alert.setContentText("You left a field blank");
			alert.showAndWait();
		} else {
			try {
				Parent root = FXMLLoader.load(getClass().getResource("EventsPage.fxml"));
				Main.stage.setScene(new Scene(root, 600, 400));
				Main.stage.show();
				Event event1 = new Event(eName, eType, eDate, eLoc);
				event1.eventCheck();
				event1.eventWrite();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * this method cancels the creation and sends the user back to the events page
	 * @param event - enables use through fxml
	 */
	public void cancel(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("EventsPage.fxml"));
			Main.stage.setScene(new Scene(root, 600, 400));
			Main.stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * this method takes the user to the home page
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
