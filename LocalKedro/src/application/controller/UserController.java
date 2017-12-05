package application.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import application.Main;
import application.model.Location;
import application.model.DisplayEvent;
import application.model.EventList;
import application.model.EventSearch;

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
import com.teamdev.jxmaps.ControlPosition;
import com.teamdev.jxmaps.GeocoderCallback;
import com.teamdev.jxmaps.GeocoderRequest;
import com.teamdev.jxmaps.GeocoderResult;
import com.teamdev.jxmaps.GeocoderStatus;
import com.teamdev.jxmaps.InfoWindow;
import com.teamdev.jxmaps.LatLng;
import com.teamdev.jxmaps.Map;
import com.teamdev.jxmaps.Marker;



import application.Main;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.fxml.Initializable;
import java.awt.*;
import java.awt.Point;


/**
 * This will handle everything that does with the profile and user page
 * 
 * @author Spacehawks
 *
 */
public class UserController implements Initializable {
	
	@FXML
	private MapView mapView; 
	@FXML
    private TableColumn<DisplayEvent, String> tableColName, tableColZip; 
	
	private Location loc = Main.user.getLoc(); // TO-DO: returns NULL	
	private String name = "YOU ARE HERE";
	String INITIAL_LOCATION = "78254";
	
	String EVENT1_LOCATION = "78249";
	String event1Name = "bill may";
	
	String EVENT2_LOCATION = "78250";
	String event2Name = "bill nye";
	
	String EVENT3_LOCATION = "78251";
	String event3Name = "bop";
	
	EventSearch es = new EventSearch(null, null, null);
	DisplayEvent[] noSearch = es.returnAllEvts();
	
	private ArrayList<EventList> data;
			
	
	 @Override
    public void initialize(URL location, ResourceBundle resources) {
		 tableColName.setCellValueFactory(cellData -> new ReadOnlyStringWrapper("Hi"));
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
                    
                    performGeocode(INITIAL_LOCATION, name );
                    performGeocode(EVENT1_LOCATION, event1Name);
                    performGeocode(EVENT2_LOCATION, event2Name);
                    performGeocode(EVENT3_LOCATION, event3Name);
                    
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
    
    private void performGeocode(String text, String MakerName) {
        // Getting the associated map object
        final Map map = mapView.getMap();
        // Creating a geocode request
        GeocoderRequest request = new GeocoderRequest();
        // Setting address to the geocode request
        request.setAddress(text);

        // Geocoding position by the entered address
        mapView.getServices().getGeocoder().geocode(request, new GeocoderCallback(map) {
            @Override
            public void onComplete(GeocoderResult[] results, GeocoderStatus status) {
                // Checking operation status
                if ((status == GeocoderStatus.OK) && (results.length > 0)) {
                    // Getting the first result
                    GeocoderResult result = results[0];
                    // Getting a location of the result
                    LatLng location = result.getGeometry().getLocation();
                    // Setting the map center to result location
                    map.setCenter(location);
                    // Creating a marker object
                    Marker marker = new Marker(map);
                    // Setting position of the marker to the result location
                    marker.setPosition(location);
                    // Creating an information window
                    InfoWindow infoWindow = new InfoWindow(map);
                    // Putting the address and location to the content of the information window
                    infoWindow.setContent("<b>" + MakerName);
                    // Moving the information window to the result location
                    infoWindow.setPosition(location);
                    // Showing of the information window
                    infoWindow.open(map, marker);
                }
            }
        });
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
