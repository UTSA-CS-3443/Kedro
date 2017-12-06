package application.controller;

import java.io.IOException;

import application.Main;
import application.model.DisplayUser;
import application.model.SearchString;
import application.model.UserSearch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;

public class ProfileController implements EventHandler<ActionEvent> {

	public TextField search;
	String s;

	@Override
	public void handle(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("EventsPage.fxml"));
			Main.stage.setScene(new Scene(root, 600, 400));
			Main.stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void viewYourProfile(ActionEvent event) {
		try {
			Main.user.getEmail();
			Main.user.getLoc();
			Main.user.getName();
			Main.user.getPassword();
			Parent root = FXMLLoader.load(getClass().getResource("ProfileViewPage.fxml"));
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
				Parent root = FXMLLoader.load(getClass().getResource("ProfileResultsPage.fxml"));
				Main.stage.setScene(new Scene(root, 600, 400));
				Main.stage.show();
			} catch (Exception e) {
				e.printStackTrace();
			}
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
