package application;

import java.net.URL;

import com.teamdev.jxmaps.javafx.MapView;

import application.model.DisplayEvent;
import application.model.Event;
import application.model.OtherUser;
import application.model.SearchString;
import application.model.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
/**
 * 
 * @author Space hawks
 * this is the main method for our application
 *
 */
public class Main extends Application {

	public static Stage stage;
	public static User user;
	public static SearchString ss;
	public static Event event;
	public static OtherUser otherUser;
	
	@Override
	    public void init() throws Exception {
	        // Initializing of JavaFX engine
	        MapView.InitJavaFX();
	    }
	
	/**
	 * this is the start that loads the first page and sends the control over to a new controller
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("view/RegisterLoginPage.fxml"));
			primaryStage.setScene(new Scene(root, 600, 400));
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
		this.stage = primaryStage;
	}

	/**
	 * this launches our application
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
