package application.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import application.Main;
import application.model.Location;
import application.model.DisplayEvent;
import application.model.Event;
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
import javafx.scene.control.Hyperlink;
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

	public Hyperlink event1, event2, event3, event4, event5;

	private String name = "YOU ARE HERE";

	EventSearch es = new EventSearch(null, null, null);
	DisplayEvent[] noSearch = es.returnAllEvts();
	
	private int iEventCount = 1;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// Creation of a JavaFX map view
		// final MapView mapView = new MapView();

		// Setting of a ready handler to MapView object. onMapReady will be
		// called when map initialization is done and
		// the map object is ready to use. Current implementation of onMapReady
		// customizes the map object.
			switch (noSearch.length) {
			case 0:
				event1.setText("No Recent Events click to make one");
				event2.setText("");
				event3.setText("");
				event4.setText("");
				event5.setText("");
				iEventCount = 0;
				break;
			case 1:
				event1.setText(noSearch[0].getName());
				event2.setText("");
				event3.setText("");
				event4.setText("");
				event5.setText("");
				break;
			case 2:
				event1.setText(noSearch[0].getName());
				event2.setText(noSearch[1].getName());
				event3.setText("");
				event4.setText("");
				event5.setText("");
				break;
			case 3:
				event1.setText(noSearch[0].getName());
				event2.setText(noSearch[1].getName());
				event3.setText(noSearch[2].getName());
				event4.setText("");
				event5.setText("");
				break;
			case 4:
				event1.setText(noSearch[0].getName());
				event2.setText(noSearch[1].getName());
				event3.setText(noSearch[2].getName());
				event4.setText(noSearch[3].getName());
				event5.setText("");
				break;
			case 5:
				event1.setText(noSearch[0].getName());
				event2.setText(noSearch[1].getName());
				event3.setText(noSearch[2].getName());
				event4.setText(noSearch[3].getName());
				event5.setText(noSearch[4].getName());
				break;
			default:
				event1.setText(noSearch[0].getName());
				event2.setText(noSearch[1].getName());
				event3.setText(noSearch[2].getName());
				event4.setText(noSearch[3].getName());
				event5.setText(noSearch[4].getName());
				break;
			}
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

					performGeocode(Main.user.getLoc(), "Your Location");
					for (int i = 0; i < noSearch.length; i++) {
						performGeocode(noSearch[i].getLocation(),
								noSearch[i].getName());
					}
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
					// Putting the address and location to the content of the
					// information window
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

	public void eventOne(ActionEvent arg0) {
		if (iEventCount == 0){
			try {
				   Parent root = FXMLLoader.load(getClass().getResource("CreateEventPage.fxml"));
				   Main.stage.setScene(new Scene(root, 600, 400));
				   Main.stage.show();
				   //Event event = new Event(name, type, date, location);
				} catch(Exception e) {
				   e.printStackTrace();
				}
		}
		else{
		Event ev = new Event(noSearch[0].getName(), noSearch[0].getType(), noSearch[0].getDate(),
				noSearch[0].getLocation());
		Main.event = ev;
		try {
			Parent root = FXMLLoader.load(getClass().getResource("EventViewPage.fxml"));
			Main.stage.setScene(new Scene(root, 600, 400));
			Main.stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
	}

	public void eventTwo(ActionEvent arg0) {
		Event ev = new Event(noSearch[1].getName(), noSearch[1].getType(), noSearch[1].getDate(),
				noSearch[1].getLocation());
		Main.event = ev;
		try {
			Parent root = FXMLLoader.load(getClass().getResource("EventViewPage.fxml"));
			Main.stage.setScene(new Scene(root, 600, 400));
			Main.stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void eventThree(ActionEvent arg0) {
		Event ev = new Event(noSearch[2].getName(), noSearch[2].getType(), noSearch[2].getDate(),
				noSearch[2].getLocation());
		Main.event = ev;
		try {
			Parent root = FXMLLoader.load(getClass().getResource("EventViewPage.fxml"));
			Main.stage.setScene(new Scene(root, 600, 400));
			Main.stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void eventFour(ActionEvent arg0) {
		Event ev = new Event(noSearch[3].getName(), noSearch[3].getType(), noSearch[3].getDate(),
				noSearch[3].getLocation());
		Main.event = ev;
		try {
			Parent root = FXMLLoader.load(getClass().getResource("EventViewPage.fxml"));
			Main.stage.setScene(new Scene(root, 600, 400));
			Main.stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void eventFive(ActionEvent arg0) {
		Event ev = new Event(noSearch[4].getName(), noSearch[4].getType(), noSearch[4].getDate(),
				noSearch[4].getLocation());
		Main.event = ev;
		try {
			Parent root = FXMLLoader.load(getClass().getResource("EventViewPage.fxml"));
			Main.stage.setScene(new Scene(root, 600, 400));
			Main.stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
