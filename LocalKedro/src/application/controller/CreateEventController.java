package application.controller;

import application.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

public class CreateEventController implements EventHandler<ActionEvent>{

	//this class handles all of the Event controllers within each individual event page
	//as in creating the event but also when the user interacts with an already created event page
	//when join event is pressed it creates an rsvp object for the user
	
	public TextField ENAME;
	public TextField ETYPE;
	public TextField EDATE;
	public TextField ELOC;
	
	String eName = "event name";
	String eType = "event type";
	String eDate = "event date";
	String eLoc = "event location";
	
	@Override
	public void handle(ActionEvent event) {
		//takes info from the user and puts into event object in the try
		eName = ENAME.getText().toString();
		eType = ETYPE.getText().toString();
		eDate = EDATE.getText().toString();
		eLoc = ELOC.getText().toString();
		try {
			   Parent root = FXMLLoader.load(getClass().getResource("EventsPage.fxml"));
			   Main.stage.setScene(new Scene(root, 600, 400));
			   Main.stage.show();
			   //Event event = new Event(eName, eType, eDate, eLoc);
		} 
		catch(Exception e) {
			   e.printStackTrace();
		}
		System.out.println(eName + "\n" + eType + "\n" + eDate + "\n" + eLoc + "\n");
		System.out.println("Event Created");
	}

	public void cancel(ActionEvent event) {
		try {
			   Parent root = FXMLLoader.load(getClass().getResource("EventsPage.fxml"));
			   Main.stage.setScene(new Scene(root, 600, 400));
			   Main.stage.show();
		}
		catch(Exception e) {
			   e.printStackTrace();
		}
		System.out.println("Create Event Cancelled");
    }
}
