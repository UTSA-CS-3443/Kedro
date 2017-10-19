package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
	public Stage stage;
	public AnchorPane layout;
	public AnchorPane layingout;
	@Override
	public void start(Stage primaryStage) {
		try
		{
			this.stage = primaryStage;
			this.stage.setTitle( "" );
			initLayout();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void initLayout() {
		try
		{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation( Main.class.getResource("IdkIguess.fxml") );
			this.layout = (AnchorPane)loader.load();
			Scene scene = new Scene(layout);
			this.stage.setScene(scene);
			this.stage.show();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
}

