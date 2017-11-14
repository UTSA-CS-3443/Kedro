package application.controller;

import application.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class ProfileController implements EventHandler<ActionEvent>{
	
	@Override
	public void handle(ActionEvent event) {
		try {
			   Parent root = FXMLLoader.load(getClass().getResource("EventsPage.fxml"));
			   Main.stage.setScene(new Scene(root, 600, 400));
			   Main.stage.show();
			} catch(Exception e) {
			   e.printStackTrace();
			}
		System.out.println("Events Page");
	}
	
	public void viewYourProfile(ActionEvent event) {
		try {
			   Parent root = FXMLLoader.load(getClass().getResource("ProfileViewPage.fxml"));
			   Main.stage.setScene(new Scene(root, 600, 400));
			   Main.stage.show();
			} catch(Exception e) {
			   e.printStackTrace();
			}
		System.out.print("Viewing Personal Profile");
	}
}
