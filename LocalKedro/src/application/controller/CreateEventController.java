package application.controller;

import application.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class CreateEventController implements EventHandler<ActionEvent>{

	//this class handles all of the Event controllers within each individual event page
	//as in creating the event but also when the user interacts with an already created event page
	//when join event is pressed it creates an rsvp object for the user
	@Override
	public void handle(ActionEvent event) {
		//takes info from the user and puts into event object in the try
		try {
			   Parent root = FXMLLoader.load(getClass().getResource("")); //replace this pls
			   Main.stage.setScene(new Scene(root, 600, 400));
			   Main.stage.show();
			   //Event event = new Event(name, type, date, location);
			} catch(Exception e) {
			   e.printStackTrace();
			}		
	}

}
