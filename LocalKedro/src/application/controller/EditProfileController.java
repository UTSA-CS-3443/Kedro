package application.controller;

import application.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class EditProfileController implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("ProfileViewPage.fxml"));
			Main.stage.setScene(new Scene(root, 600, 400));
			Main.stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Edit Profile Saved");
	}
	
	public void cancel(ActionEvent event) {
		try {
			   Parent root = FXMLLoader.load(getClass().getResource("ProfileViewPage.fxml"));
			   Main.stage.setScene(new Scene(root, 600, 400));
			   Main.stage.show();
		}
		catch(Exception e) {
			   e.printStackTrace();
		}
		System.out.println("Edit Profile Cancelled");
    }

}
