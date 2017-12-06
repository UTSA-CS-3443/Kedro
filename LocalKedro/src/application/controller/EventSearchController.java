package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import application.model.DisplayEvent;
import application.model.Event;
import application.model.EventSearch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import application.controller.EventController;

public class EventSearchController implements Initializable, EventHandler<ActionEvent> {
	private String s;

	public Hyperlink event1, event2, event3, event4, event5, event6, event7, event8, event9, event10;
	int i;
	int j;
	int k;

	private int checkResult = 1;

	EventSearch es = new EventSearch(Main.ss.getText(), null, null);
	DisplayEvent[] de = es.searchAll();
	DisplayEvent[] noSearch = es.returnAllEvts();

	@Override
	public void handle(ActionEvent arg0) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("EventViewPage.fxml"));
			Main.stage.setScene(new Scene(root, 600, 400));
			Main.stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void home(MouseEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
			Main.stage.setScene(new Scene(root, 600, 400));
			Main.stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println(de.length);
		// this is an array of event names. Set the text in the fxml to this in
		// a for
		// switch
		if (de[0] == null) {
			Alert alert = new Alert(AlertType.ERROR);
			event1.setText("Return to event page");
			event2.setText("");
			event3.setText("");
			event4.setText("");
			event5.setText("");
			event6.setText("");
			event7.setText("");
			event8.setText("");
			event9.setText("");
			event10.setText("");
			alert.setTitle("NO RESULTS");
			alert.setHeaderText("NO RESULTS");
			alert.setContentText("no results found");
			alert.showAndWait();
			checkResult = 0;
		} else {
			switch (de.length) {
			case 0:
				Alert alert = new Alert(AlertType.ERROR);
				event1.setText("Return to event page");
				event2.setText("");
				event3.setText("");
				event4.setText("");
				event5.setText("");
				event6.setText("");
				event7.setText("");
				event8.setText("");
				event9.setText("");
				event10.setText("");
				alert.setTitle("NO RESULTS");
				alert.setHeaderText("NO RESULTS");
				alert.setContentText("no results found");
				alert.showAndWait();
				checkResult = 0;
				break;
			case 1:
				event1.setText(de[0].getName());
				event2.setText("");
				event3.setText("");
				event4.setText("");
				event5.setText("");
				event6.setText("");
				event7.setText("");
				event8.setText("");
				event9.setText("");
				event10.setText("");
				break;
			case 2:
				event1.setText(de[0].getName());
				event2.setText(de[1].getName());
				event3.setText("");
				event4.setText("");
				event5.setText("");
				event6.setText("");
				event7.setText("");
				event8.setText("");
				event9.setText("");
				event10.setText("");
				break;
			case 3:
				event1.setText(de[0].getName());
				event2.setText(de[1].getName());
				event3.setText(de[2].getName());
				event4.setText("");
				event5.setText("");
				event6.setText("");
				event7.setText("");
				event8.setText("");
				event9.setText("");
				event10.setText("");
				break;
			case 4:
				event1.setText(de[0].getName());
				event2.setText(de[1].getName());
				event3.setText(de[2].getName());
				event4.setText(de[3].getName());
				event5.setText("");
				event6.setText("");
				event7.setText("");
				event8.setText("");
				event9.setText("");
				event10.setText("");
				break;
			case 5:
				event1.setText(de[0].getName());
				event2.setText(de[1].getName());
				event3.setText(de[2].getName());
				event4.setText(de[3].getName());
				event5.setText(de[4].getName());
				event6.setText("");
				event7.setText("");
				event8.setText("");
				event9.setText("");
				event10.setText("");
				break;
			case 6:
				event1.setText(de[0].getName());
				event2.setText(de[1].getName());
				event3.setText(de[2].getName());
				event4.setText(de[3].getName());
				event5.setText(de[4].getName());
				event6.setText(de[5].getName());
				event7.setText("");
				event8.setText("");
				event9.setText("");
				event10.setText("");
				break;
			case 7:
				event1.setText(de[0].getName());
				event2.setText(de[1].getName());
				event3.setText(de[2].getName());
				event4.setText(de[3].getName());
				event5.setText(de[4].getName());
				event6.setText(de[5].getName());
				event7.setText(de[6].getName());
				event8.setText("");
				event9.setText("");
				event10.setText("");
				break;
			case 8:
				event1.setText(de[0].getName());
				event2.setText(de[1].getName());
				event3.setText(de[2].getName());
				event4.setText(de[3].getName());
				event5.setText(de[4].getName());
				event6.setText(de[5].getName());
				event7.setText(de[6].getName());
				event8.setText(de[7].getName());
				event9.setText("");
				event10.setText("");
				break;
			case 9:
				event1.setText(de[0].getName());
				event2.setText(de[1].getName());
				event3.setText(de[2].getName());
				event4.setText(de[3].getName());
				event5.setText(de[4].getName());
				event6.setText(de[5].getName());
				event7.setText(de[6].getName());
				event8.setText(de[7].getName());
				event9.setText(de[8].getName());
				event10.setText("");
				break;
			case 10:
				event1.setText(de[0].getName());
				event2.setText(de[1].getName());
				event3.setText(de[2].getName());
				event4.setText(de[3].getName());
				event5.setText(de[4].getName());
				event6.setText(de[5].getName());
				event7.setText(de[6].getName());
				event8.setText(de[7].getName());
				event9.setText(de[8].getName());
				event10.setText(de[9].getName());
				break;
			default:
				event1.setText(de[0].getName());
				event2.setText(de[1].getName());
				event3.setText(de[2].getName());
				event4.setText(de[3].getName());
				event5.setText(de[4].getName());
				event6.setText(de[5].getName());
				event7.setText(de[6].getName());
				event8.setText(de[7].getName());
				event9.setText(de[8].getName());
				event10.setText(de[9].getName());
				break;
			}
		}

	}

	public void eventOne(ActionEvent arg0) {
		if (checkResult == 0) {
			try {
				Parent root = FXMLLoader.load(getClass().getResource("EventsPage.fxml"));
				Main.stage.setScene(new Scene(root, 600, 400));
				Main.stage.show();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			Event ev = new Event(de[0].getName(), de[0].getType(), de[0].getDate(), de[0].getLocation());
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
		Event ev = new Event(de[1].getName(), de[1].getType(), de[1].getDate(), de[1].getLocation());
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
		Event ev = new Event(de[2].getName(), de[2].getType(), de[2].getDate(), de[2].getLocation());
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
		Event ev = new Event(de[3].getName(), de[3].getType(), de[3].getDate(), de[3].getLocation());
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
		Event ev = new Event(de[4].getName(), de[4].getType(), de[4].getDate(), de[4].getLocation());
		Main.event = ev;
		try {
			Parent root = FXMLLoader.load(getClass().getResource("EventViewPage.fxml"));
			Main.stage.setScene(new Scene(root, 600, 400));
			Main.stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void eventSix(ActionEvent arg0) {
		Event ev = new Event(de[5].getName(), de[5].getType(), de[5].getDate(), de[5].getLocation());
		Main.event = ev;
		try {
			Parent root = FXMLLoader.load(getClass().getResource("EventViewPage.fxml"));
			Main.stage.setScene(new Scene(root, 600, 400));
			Main.stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void eventSeven(ActionEvent arg0) {
		Event ev = new Event(de[6].getName(), de[6].getType(), de[6].getDate(), de[6].getLocation());
		Main.event = ev;
		try {
			Parent root = FXMLLoader.load(getClass().getResource("EventViewPage.fxml"));
			Main.stage.setScene(new Scene(root, 600, 400));
			Main.stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void eventEight(ActionEvent arg0) {
		Event ev = new Event(de[7].getName(), de[7].getType(), de[7].getDate(), de[7].getLocation());
		Main.event = ev;
		try {
			Parent root = FXMLLoader.load(getClass().getResource("EventViewPage.fxml"));
			Main.stage.setScene(new Scene(root, 600, 400));
			Main.stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void eventNine(ActionEvent arg0) {
		Event ev = new Event(de[8].getName(), de[8].getType(), de[8].getDate(), de[8].getLocation());
		Main.event = ev;
		try {
			Parent root = FXMLLoader.load(getClass().getResource("EventViewPage.fxml"));
			Main.stage.setScene(new Scene(root, 600, 400));
			Main.stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void eventTen(ActionEvent arg0) {
		Event ev = new Event(de[9].getName(), de[9].getType(), de[9].getDate(), de[9].getLocation());
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