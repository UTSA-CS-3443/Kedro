package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MainController implements EventHandler<ActionEvent> {
	
	public void handle(ActionEvent event) {
		System.out.println("Register");
	}

	public void logIn(ActionEvent event) {
		System.out.println("Log in");
	}
}
