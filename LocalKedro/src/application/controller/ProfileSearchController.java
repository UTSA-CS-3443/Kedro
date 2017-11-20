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

public class ProfileSearch implements Initializable,EventHandler<ActionEvent> {
	
	public Hyperlink profile1;
	public Hyperlink profile2;
	public Hyperlink profile3;

	@Override
	public void handle(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("ProfileSearchViewPage.fxml"));
			Main.stage.setScene(new Scene(root, 600, 400));
			Main.stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Profiles Page");
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		profile1.setText("Travis80");
		profile2.setText("Brusnak89");
		profile3.setText("Jmeow12");
		
	}

}