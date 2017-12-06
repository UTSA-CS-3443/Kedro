package application.model;

import java.util.ArrayList;

/**
 * this class is created to display events so duplicate events aren't created in
 * the searching or on accident. Just displays the event
 * 
 * @author SpaceHawks
 *
 */
public class DisplayEvent {
	/**
	 * class constants
	 * string variables that hold the display event information
	 */
	private String name;
	private String type;
	private String date;
	private String location;// make this a string
	
	/**
	 * constructor to set all the class constants and create an arraylist
	 * 
	 * @param name - name of the event
	 * @param type - type of the event
	 * @param date - date of the event
	 * @param location - location of the event
	 */
	public DisplayEvent(String name, String type, String date, String location) {
		this.setName(name);
		this.setType(type);
		this.setDate(date);
		this.setLocation(location);
		

	}


	/**
	 * prints all the event info and the list of users attending
	 */
	public String toString() {
		String line = "" + this.getName() + " " + this.getType() + " " + this.getDate() + " " + this.getLocation()
				+ "\n";
		return line;
	}

	///// GETTERS AND SETTERS/////
	/**
	 * returns the event name
	 * @return name - event name
	 */
	public String getName() {
		return name;
	}
	/**
	 * sets the event name
	 * @param name - event name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * returns the type of event
	 * @return type - type of event
	 */
	public String getType() {
		return type;
	}
	/**
	 * sets the event type
	 * @param type - event type
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * returns date of the event
	 * @return date - date of the event
	 */
	public String getDate() {
		return date;
	}
	/**
	 * sets the date of the event
	 * @param date - date of the event
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * returns the location of the event
	 * @return location - location of the event
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * sets the location of the event
	 * @param location - location of the event
	 */
	public void setLocation(String location) {
		this.location = location;
	}
}
