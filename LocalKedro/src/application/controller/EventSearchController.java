package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;

public class EventSearch implements Initializable,EventHandler<ActionEvent> {
	
	public Hyperlink event1;
	public Hyperlink event2;
	public Hyperlink event3;

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

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		event1.setText("Car Auction");
		event2.setText("House Warming");
		event3.setText("Metallica concert");
		
	}

}
