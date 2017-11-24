package application;

import com.teamdev.jxmaps.javafx.MapView;

import application.model.DisplayEvent;
import application.model.Event;
import application.model.SearchString;
import application.model.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class Main extends Application {

	public static Stage stage;
	public static User user;
	public static SearchString ss;
	public static Event event;
	
	@Override
	    public void init() throws Exception {
	        // Initializing of JavaFX engine
	        MapView.InitJavaFX();
	    }

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

	public static void main(String[] args) {
		launch(args);
	}
}
