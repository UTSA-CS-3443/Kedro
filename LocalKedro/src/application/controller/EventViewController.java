package application.controller;

import java.util.ResourceBundle;

import javax.annotation.Resources;
import javax.print.DocFlavor.URL;

import application.Main;
import application.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
/**
 * This class handles the event view page and shows the current events information
 * @author SpaceHawks
 *
 */
public class EventViewController implements Initializable, EventHandler<ActionEvent> {
	/**
	 * fxml labels to hold event information
	 */
	public Label date;
	public Label name;
	public Label zip;
	public Label type;

	@Override
	/**
	 * blank needed for ActionEvent
	 */
	public void handle(ActionEvent event) {

	}
	/**
	 * changes scene to homepage
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
	}
	/**
	 * initializes the labels setting them to be the event information
	 * @param arg0, arg1 - enables initialization
	 */
	@Override
	public void initialize(java.net.URL arg0, ResourceBundle arg1) {
		date.setText("Date: " + Main.event.getDate());
		name.setText("Name : " + Main.event.getName());
		zip.setText("Location : " + Main.event.getLocation().toString());
		type.setText("Type : " + Main.event.getType().toString());
	}
}
