package application.model;

import java.util.ArrayList;

/**
 * this class is used to display the user so a duplicate user object doesn't
 * need to be created and conflict with other files
 * 
 * @author SpaceHawks
 *
 */
public class DisplayUser {
	/**
	 * class constant strings holds user information
	 */
	private String name, email, fName;
	private String location;
	

	/**
	 * sets the class constants and initalizes the array list
	 * 
	 * @param name - username
	 * @param email - user email
	 * @param fName - user full name
	 * @param location - users location
	 */
	public DisplayUser(String name, String email, String fName, String location) {
		this.setName(name);
		this.setEmail(email);
		this.setFName(fName);
		this.setLoc(location);
		
	}

	/**
	 * this adds an event name to the rsvp array list
	 * 
	 * @param event
	 */
	
	/**
	 * this prints the user name and then the events they're rsvped to go to
	 */
	public String toString() {
		String line = "" + this.getName();
		return line;
	}
	/**
	 * returns the username
	 * @return name - username
	 */
	public String getName() {
		return name;
	}
	/**
	 * sets the username
	 * @param name - username
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * returns the user email
	 * @return email - user email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * sets the user email
	 * @param email - user email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * returns users full name
	 * @return fName - users full name
	 */
	public String getFName() {
		return fName;
	}
	/**
	 * sets the users full name
	 * @param fName - users full name
	 */
	public void setFName(String fName) {
		this.fName = fName;
	}
	/**
	 * returns the users location
	 * @return location - users location
	 */
	public String getLoc() {
		return location;
	}
	/**
	 * sets the users location
	 * @param loc - users location
	 */
	public void setLoc(String loc) {
		this.location = loc;
	}
}
