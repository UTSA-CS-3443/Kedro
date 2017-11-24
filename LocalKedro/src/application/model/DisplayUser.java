package application.model;

import java.util.ArrayList;
/**
 * this class is used to display the user so a duplicate user object
 * doesn't need to be created and conflict with other files
 * @author Travis Woods
 *
 */
public class DisplayUser {
	//string and array list to help display the user
	private String name, email, fName;
	private Location location;
	private ArrayList<RSVP> rsvp;
	
	/**
	 * sets the class constants and initalizes the array list
	 * @param name
	 */
	public DisplayUser(String name, String email, String fName, Location location) {
		this.setName(name);
		this.setEmail(email);
		this.setFName(fName);
		this.setLoc(location);
		rsvp = new ArrayList<RSVP>();
	}
	
	/**
	 * this adds an event name to the rsvp array list
	 * @param event
	 */
	public void signIn(String event) {
		RSVP rp = new RSVP(event);
		this.rsvp.add(rp);
	}

	/**
	 * this prints the user name and then the events they're rsvped to go to
	 */
	public String toString() {
		String line = "" + this.getName();
		for (RSVP r : this.rsvp) {
			line += r.getName() + "\n";
		}
		return line;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email){
		this.email = email;
	}
	
	public String getFName(){
		return fName;
	}
	public void setFName(String fName){
		this.fName = fName;
	}
	public Location getLoc() {
		return location;
	}
	public void setLoc(Location loc) {
		this.location = loc;
	}
}
