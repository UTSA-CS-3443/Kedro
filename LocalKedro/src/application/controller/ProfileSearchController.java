package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import application.model.DisplayUser;
import application.model.Event;
import application.model.OtherUser;
import application.model.UserSearch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;

/**
 * this class is the controller that updates the view and calls search functions
 * to search for the user by name and displays search results
 * 
 * @author SpaceHawks
 *
 */
public class ProfileSearchController implements Initializable, EventHandler<ActionEvent> {

	public Hyperlink profile1, profile2, profile3, profile4, profile5, profile6, profile7, profile8, profile9,
			profile10;

	private int checkResult = 1;

	UserSearch us = new UserSearch(Main.ss.getText());
	DisplayUser[] du = us.searchAll();

	// this is an array of user names. Set the text in the fxml to this in a for
	// loop
	@Override
	public void handle(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("ProfileSearchViewPage.fxml"));
			Main.stage.setScene(new Scene(root, 600, 400));
			Main.stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		if (du[0] == null) {
			profile1.setText("Return to profile page");
			profile2.setText("");
			profile3.setText("");
			profile4.setText("");
			profile5.setText("");
			profile6.setText("");
			profile7.setText("");
			profile8.setText("");
			profile9.setText("");
			profile10.setText("");
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("NO RESULTS");
			alert.setHeaderText("NO RESULTS");
			alert.setContentText("no results found");
			alert.showAndWait();
			checkResult = 0;
		} else if (du[1] == null) {
			profile1.setText(du[0].getName());
			profile2.setText("");
			profile3.setText("");
			profile4.setText("");
			profile5.setText("");
			profile6.setText("");
			profile7.setText("");
			profile8.setText("");
			profile9.setText("");
			profile10.setText("");
		} else if (du[2] == null) {
			profile1.setText(du[0].getName());
			profile2.setText(du[1].getName());
			profile3.setText("");
			profile4.setText("");
			profile5.setText("");
			profile6.setText("");
			profile7.setText("");
			profile8.setText("");
			profile9.setText("");
			profile10.setText("");
		} else if (du[3] == null) {
			profile1.setText(du[0].getName());
			profile2.setText(du[1].getName());
			profile3.setText(du[2].getName());
			profile4.setText("");
			profile5.setText("");
			profile6.setText("");
			profile7.setText("");
			profile8.setText("");
			profile9.setText("");
			profile10.setText("");
		} else if (du[4] == null) {
			profile1.setText(du[0].getName());
			profile2.setText(du[1].getName());
			profile3.setText(du[2].getName());
			profile4.setText(du[3].getName());
			profile5.setText("");
			profile6.setText("");
			profile7.setText("");
			profile8.setText("");
			profile9.setText("");
			profile10.setText("");
		} else if (du[5] == null) {
			profile1.setText(du[0].getName());
			profile2.setText(du[1].getName());
			profile3.setText(du[2].getName());
			profile4.setText(du[3].getName());
			profile5.setText(du[4].getName());
			profile6.setText("");
			profile7.setText("");
			profile8.setText("");
			profile9.setText("");
			profile10.setText("");
		} else if (du[6] == null) {
			profile1.setText(du[0].getName());
			profile2.setText(du[1].getName());
			profile3.setText(du[2].getName());
			profile4.setText(du[3].getName());
			profile5.setText(du[4].getName());
			profile6.setText(du[5].getName());
			profile7.setText("");
			profile8.setText("");
			profile9.setText("");
			profile10.setText("");
		} else if (du[7] == null) {
			profile1.setText(du[0].getName());
			profile2.setText(du[1].getName());
			profile3.setText(du[2].getName());
			profile4.setText(du[3].getName());
			profile5.setText(du[4].getName());
			profile6.setText(du[5].getName());
			profile7.setText(du[6].getName());
			profile8.setText("");
			profile9.setText("");
			profile10.setText("");
		} else if (du[8] == null) {
			profile1.setText(du[0].getName());
			profile2.setText(du[1].getName());
			profile3.setText(du[2].getName());
			profile4.setText(du[3].getName());
			profile5.setText(du[4].getName());
			profile6.setText(du[5].getName());
			profile7.setText(du[6].getName());
			profile8.setText(du[7].getName());
			profile9.setText("");
			profile10.setText("");
		} else if (du[9] == null) {
			profile1.setText(du[0].getName());
			profile2.setText(du[1].getName());
			profile3.setText(du[2].getName());
			profile4.setText(du[3].getName());
			profile5.setText(du[4].getName());
			profile6.setText(du[5].getName());
			profile7.setText(du[6].getName());
			profile8.setText(du[7].getName());
			profile9.setText(du[8].getName());
			profile10.setText("");
		} else {
			switch (du.length) {
			case 1:
				profile1.setText(du[0].getName());
				profile2.setText("");
				profile3.setText("");
				profile4.setText("");
				profile5.setText("");
				profile6.setText("");
				profile7.setText("");
				profile8.setText("");
				profile9.setText("");
				profile10.setText("");
				break;
			case 2:
				profile1.setText(du[0].getName());
				profile2.setText(du[1].getName());
				profile3.setText("");
				profile4.setText("");
				profile5.setText("");
				profile6.setText("");
				profile7.setText("");
				profile8.setText("");
				profile9.setText("");
				profile10.setText("");
				break;
			case 3:
				profile1.setText(du[0].getName());
				profile2.setText(du[1].getName());
				profile3.setText(du[2].getName());
				profile4.setText("");
				profile5.setText("");
				profile6.setText("");
				profile7.setText("");
				profile8.setText("");
				profile9.setText("");
				profile10.setText("");
				break;
			case 4:
				profile1.setText(du[0].getName());
				profile2.setText(du[1].getName());
				profile3.setText(du[2].getName());
				profile4.setText(du[3].getName());
				profile5.setText("");
				profile6.setText("");
				profile7.setText("");
				profile8.setText("");
				profile9.setText("");
				profile10.setText("");
				break;
			case 5:
				profile1.setText(du[0].getName());
				profile2.setText(du[1].getName());
				profile3.setText(du[2].getName());
				profile4.setText(du[3].getName());
				profile5.setText(du[4].getName());
				profile6.setText("");
				profile7.setText("");
				profile8.setText("");
				profile9.setText("");
				profile10.setText("");
				break;
			case 6:
				profile1.setText(du[0].getName());
				profile2.setText(du[1].getName());
				profile3.setText(du[2].getName());
				profile4.setText(du[3].getName());
				profile5.setText(du[4].getName());
				profile6.setText(du[5].getName());
				profile7.setText("");
				profile8.setText("");
				profile9.setText("");
				profile10.setText("");
				break;
			case 7:
				profile1.setText(du[0].getName());
				profile2.setText(du[1].getName());
				profile3.setText(du[2].getName());
				profile4.setText(du[3].getName());
				profile5.setText(du[4].getName());
				profile6.setText(du[5].getName());
				profile7.setText(du[6].getName());
				profile8.setText("");
				profile9.setText("");
				profile10.setText("");
				break;
			case 8:
				profile1.setText(du[0].getName());
				profile2.setText(du[1].getName());
				profile3.setText(du[2].getName());
				profile4.setText(du[3].getName());
				profile5.setText(du[4].getName());
				profile6.setText(du[5].getName());
				profile7.setText(du[6].getName());
				profile8.setText(du[7].getName());
				profile9.setText("");
				profile10.setText("");
				break;
			case 9:
				profile1.setText(du[0].getName());
				profile2.setText(du[1].getName());
				profile3.setText(du[2].getName());
				profile4.setText(du[3].getName());
				profile5.setText(du[4].getName());
				profile6.setText(du[5].getName());
				profile7.setText(du[6].getName());
				profile8.setText(du[7].getName());
				profile9.setText(du[8].getName());
				profile10.setText("");
				break;
			case 10:
				profile1.setText(du[0].getName());
				profile2.setText(du[1].getName());
				profile3.setText(du[2].getName());
				profile4.setText(du[3].getName());
				profile5.setText(du[4].getName());
				profile6.setText(du[5].getName());
				profile7.setText(du[6].getName());
				profile8.setText(du[7].getName());
				profile9.setText(du[8].getName());
				profile10.setText(du[9].getName());
				break;
			default:
				profile1.setText(du[0].getName());
				profile2.setText(du[1].getName());
				profile3.setText(du[2].getName());
				profile4.setText(du[3].getName());
				profile5.setText(du[4].getName());
				profile6.setText(du[5].getName());
				profile7.setText(du[6].getName());
				profile8.setText(du[7].getName());
				profile9.setText(du[8].getName());
				profile10.setText(du[9].getName());
				break;
			}
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

	public void profileOne(ActionEvent arg0) {
		if (checkResult == 0) {
			try {
				Parent root = FXMLLoader.load(getClass().getResource("ProfilesPage.fxml"));
				Main.stage.setScene(new Scene(root, 600, 400));
				Main.stage.show();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			OtherUser u = new OtherUser(du[0].getName(), du[0].getEmail(), du[0].getFName(), du[0].getLoc());
			Main.otherUser = u;
			try {
				Parent root = FXMLLoader.load(getClass().getResource("ProfileSearchViewPage.fxml"));
				Main.stage.setScene(new Scene(root, 600, 400));
				Main.stage.show();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void profileTwo(ActionEvent arg0) {
		OtherUser u = new OtherUser(du[1].getName(), du[1].getEmail(), du[1].getFName(), du[1].getLoc());
		Main.otherUser = u;
		try {
			Parent root = FXMLLoader.load(getClass().getResource("ProfileSearchViewPage.fxml"));
			Main.stage.setScene(new Scene(root, 600, 400));
			Main.stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void profileThree(ActionEvent arg0) {
		OtherUser u = new OtherUser(du[2].getName(), du[2].getEmail(), du[2].getFName(), du[2].getLoc());
		Main.otherUser = u;
		try {
			Parent root = FXMLLoader.load(getClass().getResource("ProfileSearchViewPage.fxml"));
			Main.stage.setScene(new Scene(root, 600, 400));
			Main.stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void profileFour(ActionEvent arg0) {
		OtherUser u = new OtherUser(du[3].getName(), du[3].getEmail(), du[3].getFName(), du[3].getLoc());
		Main.otherUser = u;
		try {
			Parent root = FXMLLoader.load(getClass().getResource("ProfileSearchViewPage.fxml"));
			Main.stage.setScene(new Scene(root, 600, 400));
			Main.stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void profileFive(ActionEvent arg0) {
		OtherUser u = new OtherUser(du[4].getName(), du[4].getEmail(), du[4].getFName(), du[4].getLoc());
		Main.otherUser = u;
		try {
			Parent root = FXMLLoader.load(getClass().getResource("ProfileSearchViewPage.fxml"));
			Main.stage.setScene(new Scene(root, 600, 400));
			Main.stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void profileSix(ActionEvent arg0) {
		OtherUser u = new OtherUser(du[5].getName(), du[5].getEmail(), du[5].getFName(), du[5].getLoc());
		Main.otherUser = u;
		try {
			Parent root = FXMLLoader.load(getClass().getResource("ProfileSearchViewPage.fxml"));
			Main.stage.setScene(new Scene(root, 600, 400));
			Main.stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void profileSeven(ActionEvent arg0) {
		OtherUser u = new OtherUser(du[6].getName(), du[6].getEmail(), du[6].getFName(), du[6].getLoc());
		Main.otherUser = u;
		try {
			Parent root = FXMLLoader.load(getClass().getResource("ProfileSearchViewPage.fxml"));
			Main.stage.setScene(new Scene(root, 600, 400));
			Main.stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void profileEight(ActionEvent arg0) {
		OtherUser u = new OtherUser(du[7].getName(), du[7].getEmail(), du[7].getFName(), du[7].getLoc());
		Main.otherUser = u;
		try {
			Parent root = FXMLLoader.load(getClass().getResource("ProfileSearchViewPage.fxml"));
			Main.stage.setScene(new Scene(root, 600, 400));
			Main.stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void profileNine(ActionEvent arg0) {
		OtherUser u = new OtherUser(du[8].getName(), du[8].getEmail(), du[8].getFName(), du[8].getLoc());
		Main.otherUser = u;
		try {
			Parent root = FXMLLoader.load(getClass().getResource("ProfileSearchViewPage.fxml"));
			Main.stage.setScene(new Scene(root, 600, 400));
			Main.stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void profileTen(ActionEvent arg0) {
		OtherUser u = new OtherUser(du[9].getName(), du[9].getEmail(), du[9].getFName(), du[9].getLoc());
		Main.otherUser = u;
		try {
			Parent root = FXMLLoader.load(getClass().getResource("ProfileSearchViewPage.fxml"));
			Main.stage.setScene(new Scene(root, 600, 400));
			Main.stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}