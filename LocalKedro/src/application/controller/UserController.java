package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.teamdev.jxmaps.ControlPosition;
import com.teamdev.jxmaps.LatLng;
import com.teamdev.jxmaps.Map;
import com.teamdev.jxmaps.MapOptions;
import com.teamdev.jxmaps.MapReadyHandler;
import com.teamdev.jxmaps.MapStatus;
import com.teamdev.jxmaps.MapTypeControlOptions;
import com.teamdev.jxmaps.javafx.MapView;
import com.teamdev.jxmaps.MapViewOptions;
import com.teamdev.jxmaps.MapComponentType;


import application.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.Initializable;

/**
 * This will handle everything that does with the profile and user page
 * 
 * @author Spacehawks
 *
 */
public class UserController implements Initializable {
	
	@FXML
	private MapView mapView; 
	
	 @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Creation of a JavaFX map view
		 //final MapView mapView = new MapView();

        // Setting of a ready handler to MapView object. onMapReady will be called when map initialization is done and
        // the map object is ready to use. Current implementation of onMapReady customizes the map object.
        mapView.setOnMapReadyHandler(new MapReadyHandler() {
            @Override
            public void onMapReady(MapStatus status) {
                // Check if the map is loaded correctly
                if (status == MapStatus.MAP_STATUS_OK) {
                    // Getting the associated map object
                    final Map map = mapView.getMap();
                    // Creating a map options object
                    MapOptions options = new MapOptions();
                    // Creating a map type control options object
                    MapTypeControlOptions controlOptions = new MapTypeControlOptions();
                    // Changing position of the map type control
                    controlOptions.setPosition(ControlPosition.TOP_RIGHT);
                    // Setting map type control options
                    options.setMapTypeControlOptions(controlOptions);
                    // Setting map options
                    map.setOptions(options);
                    // Setting the map center
                    map.setCenter(new LatLng(35.91466, 10.312499));
                    // Setting initial zoom value
                    map.setZoom(10.0);
                }
            }
        });
    }
    
    @FXML
	protected void handle() {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("EventsPage.fxml"));
			Main.stage.setScene(new Scene(root, 600, 400));
			Main.stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		System.out.println("Events Page"); 
    	
	}
	
    @FXML
	protected void openProfilesPage() {   
		 try {
			Parent root = FXMLLoader.load(getClass().getResource("ProfilesPage.fxml"));
			Main.stage.setScene(new Scene(root, 600, 400));
			Main.stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		System.out.println("Profiles Page");
	}
	
    public void logout() {
    	  try {
    		  Main.user = null;
    	 	  Parent root = FXMLLoader.load(getClass().getResource("RegisterLoginPage.fxml"));
    	 	  Main.stage.setScene(new Scene(root, 600, 400));
    	 	  Main.stage.show();
    	 	} catch (Exception e) {
    	 			e.printStackTrace();
    	 	} 
    	 		System.out.println("Logout");

    }
}
