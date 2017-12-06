package application.model;

import java.util.ArrayList;
/**
 * this class is created to display events so duplicate events 
 * aren't created in the searching or on accident. Just displays
 * the event
 * @author Travis Woods
 *
 */
public class DisplayEvent {
	//class constants
	private String name;
	private Type type;
	private Date date;
	private String location;//make this a string
	private ArrayList<RSVP> rsvp;
	
	/**
	 * constructor to set all the class constants and create an
	 * arraylist
	 * @param name
	 * @param type
	 * @param date
	 * @param location
	 */
	public DisplayEvent(String name, Type type, Date date, String location) {
		this.setName(name);
		this.setType(type);
		this.setDate(date);
		this.setLocation(location);
		this.rsvp = new ArrayList<RSVP>();
		
	}

	/**
	 * adds a guest to this events list of people
	 * @param line
	 */
	public void addGuest(String line) {
		RSVP rp = new RSVP(line);
		this.rsvp.add(rp);
		
	}
	
	/**
	 * prints all the event info and the list of users attending
	 */
	public String toString() {
		String line = "" + this.getName() + " " + this.getType() + " " + this.getDate() + " " + this.getLocation() + "\n";
		for (RSVP r : this.rsvp) {
			line += r.getName() + "\n";
		}
		return line;
	}

	/////GETTERS AND SETTERS/////
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}
