package application.controller;

import application.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class EditProfileController implements EventHandler<ActionEvent> {

	public TextField Yname;
	public TextField Yemail;
	public TextField Yzip;
	public TextField PASS;

	String n = null;
	String z = null;
	String e = null;
	String p = null;

	@Override
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
			try {
				
				Parent root = FXMLLoader.load(getClass().getResource("ProfileViewPage.fxml"));
				Main.stage.setScene(new Scene(root, 600, 400));
				Main.stage.show();
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Edit Profile Saved");
		}
	}

	public void cancel(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("ProfileViewPage.fxml"));
			Main.stage.setScene(new Scene(root, 600, 400));
			Main.stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Edit Profile Cancelled");
	}

}
