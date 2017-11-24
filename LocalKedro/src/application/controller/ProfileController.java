package application.controller;

import java.io.IOException;

import application.Main;
import application.model.DisplayUser;
import application.model.UserSearch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
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
		System.out.println("Events Page");
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
		System.out.print("Viewing Personal Profile");
	}
	public void search(ActionEvent event){
		s = search.getText().toString();
		try {
			UserSearch us = new UserSearch(s);
			DisplayUser[] du = us.searchAll();
			// this is an array of user names. Set the text in the fxml to this in a for
			// loop
			for (DisplayUser d : du) {
				if(d == null) {
					break;
				}
				else {
					System.out.println(d.getName());
				}
				// set the hyperlink values or put this somewhere else. idk
				// maybe iteratively create new hyperlinks
			}
			Parent root = FXMLLoader.load(getClass().getResource("ProfileResultsPage.fxml"));
			Main.stage.setScene(new Scene(root, 600, 400));
			Main.stage.show();
		} catch (NullPointerException e) {
			System.out.println("search didn't work");
		} catch (IOException e) {
			System.out.println("Page didn't load");
		}
		System.out.println("profile search");
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
}
