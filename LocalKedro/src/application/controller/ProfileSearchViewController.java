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
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
/**
 * This class displays the searched user information through labels
 * @author SpaceHawks
 *
 */
public class ProfileSearchViewController implements Initializable, EventHandler<ActionEvent> {
	/**
	 * fxml labels that hold the user information
	 */
	public Label name;
	public Label user;
	public Label zip;

	@Override
	/**
	 * blank needed for EventHandler
	 */
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	/**
	 * initializes the labels to display the searched users information
	 */
	public void initialize(URL location, ResourceBundle resources) {
		name.setText("Name: " + Main.otherUser.getFName());
		user.setText("Username: " + Main.otherUser.getName());
		zip.setText("Location: " + Main.otherUser.getLoc());

	}
	/**
	 * changes scene to home page
	 * @param event - enables use through fxml
	 */
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
