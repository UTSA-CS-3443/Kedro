package application.controller;

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
			/*UserSearch us = new UserSearch(s);
			DisplayUser[] du = us.searchAll();
			//this is an array of user names. Set the text in the fxml to this in a for loop
			if(du.length > 0 && du[0] != null) {
				for(int i = 0; i <= du.length-1; i++) {
					System.out.println(du[i].getName());
					//set the hyperlink values or put this somewhere else. idk
					//maybe iteratively create new hyperlinks
				}
			}*/
			Parent root = FXMLLoader.load(getClass().getResource("ProfileResultsPage.fxml"));
			Main.stage.setScene(new Scene(root, 600, 400));
			Main.stage.show();
		} catch (Exception e) {
			System.out.println("search didn't work");
			e.printStackTrace();
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
