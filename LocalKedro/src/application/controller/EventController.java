package application.controller;

import application.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
/**
 * This class is going to control the event page button presses and user input
 * @author Travis
 *
 */
public class EventController implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) { //press on the create event page
				//name
				//type
				//date
				//location
				//compare emails to each other and password
				try {
					   Parent root = FXMLLoader.load(getClass().getResource("CreateEventPage.fxml"));
					   Main.stage.setScene(new Scene(root, 600, 400));
					   Main.stage.show();
					   //Event event = new Event(name, type, date, location);
					} catch(Exception e) {
					   e.printStackTrace();
					}
				System.out.println("Creating Event");		
	}

}
