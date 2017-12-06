package application.controller;

import application.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.TextField;
/**
 * this class handles the editing of the users profile
 * it grabs text from text fields and writes the informationr recieved to the user file
 * @author SpaceHawks
 *
 */
public class EditProfileController implements EventHandler<ActionEvent> {
	/**
	 * fxml textfields which hold entered information 
	 */
	public TextField Yname;
	public TextField Yemail;
	public TextField Yzip;
	public TextField PASS;
	
	/**
	 * strings to hold text field information
	 */
	String n = null;
	String z = null;
	String e = null;
	String p = null;

	@Override
	/**
	 * this method grabs input from the user and writes the updated information to the user file
	 * it checks for empty text fields and throws an error
	 * it sets the main user to the information entered
	 * changes the scene to the profile view page
	 * @param event - enables use through fxml
	 */
	public void handle(ActionEvent event) {
		n = Yname.getText().toString();
		p = PASS.getText().toString();
		e = Yemail.getText().toString();
		z = Yzip.getText().toString();
		if (Yname.getText() == null || Yname.getText().isEmpty() || PASS.getText() == null || PASS.getText().isEmpty()
				|| Yemail.getText() == null || Yemail.getText().isEmpty() || Yzip.getText() == null
				|| Yzip.getText().isEmpty()) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Empty");
			alert.setHeaderText("Empty");
			alert.setContentText("You left a field blank");
			alert.showAndWait();
		} else {
			Main.user.setFName(n);
			Main.user.setLoc(z);
			Main.user.setEmail(e);
			Main.user.setPassword(p);
			Main.user.userWrite();
			try {

				Parent root = FXMLLoader.load(getClass().getResource("ProfileViewPage.fxml"));
				Main.stage.setScene(new Scene(root, 600, 400));
				Main.stage.show();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * this method cancels the edit and returns the user to the profile view page
	 * @param event - enables use through fxml
	 */
	public void cancel(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("ProfileViewPage.fxml"));
			Main.stage.setScene(new Scene(root, 600, 400));
			Main.stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * this method returns the user to the home page
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

}
