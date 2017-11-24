package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import application.model.DisplayEvent;
import application.model.Event;
import application.model.EventSearch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import application.controller.EventController;

public class EventSearchController implements Initializable,EventHandler<ActionEvent> {
	private String s;
	
	public Hyperlink event1;
	public Hyperlink event2;
	public Hyperlink event3;

	EventSearch es = new EventSearch(Main.ss.getText(), null, null);
	DisplayEvent[] de = es.searchAll();
	

	@Override
	public void handle(ActionEvent arg0) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("EventViewPage.fxml"));
			Main.stage.setScene(new Scene(root, 600, 400));
			Main.stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("event view Page");
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
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println(de.length);
		// this is an array of event names. Set the text in the fxml to this in a for
		// loop
		if (de.length > 2) {
			event1.setText(de[0].getName());
			event2.setText(de[1].getName());
			event3.setText(de[2].getName());
		} else if (de.length > 1 && de.length < 3) {
			event1.setText(de[0].getName());
			event2.setText(de[1].getName());
			event3.setText("");
		} else if (de.length > 0 && de.length < 2) {
			event1.setText(de[0].getName());
			event2.setText("");
			event3.setText("");
		} else if (de.length == 0) {
			event1.setText("");
			event2.setText("");
			event3.setText("");
		}
	}
	public void eventOne(ActionEvent arg0){
		Event ev = new Event(de[0].getName(), de[0].getType(), de[0].getDate(), de[0].getLocation());
		Main.event = ev;
		try {
			Parent root = FXMLLoader.load(getClass().getResource("EventViewPage.fxml"));
			Main.stage.setScene(new Scene(root, 600, 400));
			Main.stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void eventTwo(ActionEvent arg0){
		Event ev = new Event(de[1].getName(), de[1].getType(), de[1].getDate(), de[1].getLocation());
		Main.event = ev;
		try {
			Parent root = FXMLLoader.load(getClass().getResource("EventViewPage.fxml"));
			Main.stage.setScene(new Scene(root, 600, 400));
			Main.stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void eventThree(ActionEvent arg0){
		Event ev = new Event(de[2].getName(), de[2].getType(), de[2].getDate(), de[2].getLocation());
		Main.event = ev;
		try {
			Parent root = FXMLLoader.load(getClass().getResource("EventViewPage.fxml"));
			Main.stage.setScene(new Scene(root, 600, 400));
			Main.stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}