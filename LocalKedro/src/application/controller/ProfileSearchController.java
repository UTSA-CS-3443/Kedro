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
import javafx.scene.input.MouseEvent;
/**
 * this class is the controller that updates the view and calls search functions
 * to search for the user by name and displays search results
 * @author SpaceHawks
 *
 */
public class ProfileSearchController implements Initializable,EventHandler<ActionEvent> {
	
	public Hyperlink profile1;
	public Hyperlink profile2;
	public Hyperlink profile3;

	/**
	 * this method handles and loads 
	 */
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
