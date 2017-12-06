package application.model;

import java.io.*;
import java.util.ArrayList;

//import application.RSVP;
/**
 * this class creates an event object and writes it to the file folder
 * 
 * @author SpaceHawks
 *
 */
public class Event {
	/**
	 * class constant strings holds the users Operating system and event information
	 */
	private static String OS = System.getProperty("os.name").toLowerCase();
	private String name;
	private String type;
	private String date;
	private String location;// make this a string
	
	/**
	 * Constructor creates event object
	 * @param name - event name
	 * @param type - event type
	 * @param date - event date
	 * @param location - event location
	 */
	public Event(String name, String type, String date, String location) {
		this.setName(name);
		this.setType(type);
		this.setDate(date);
		this.setLocation(location);
	}
	/**
	 * writes the event information to a file in the event folder
	 */
	public void eventWrite() {
		String filePath = new File("").getAbsolutePath();
		if (OS.equals("mac os x")) {
			filePath += "/EventFolder/";
		} else {
			filePath += "\\EventFolder\\";
		}
		File file = new File(filePath + this.getName());
		System.out.println(file.getAbsolutePath());
		try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)))) {
			pw.println(this.getName());
			pw.println(this.getDate().toString());
			pw.println(this.getLocation());
			pw.println(this.getType());
			// print out the guest list too I think
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("you done goofed");
		}
	}

	/**
	 * checks if the event exists
	 * @return false if succesful
	 */
	public boolean eventCheck() {
		String filePath = new File("").getAbsolutePath();
		filePath += "\\EventFolder";
		File folder = new File(filePath); // add filepath
		File[] listOfFiles = folder.listFiles();

		for (File file : listOfFiles) {
			if (file.isFile() && file.getName().equals(this.getName())) {
				return false;
			} else if (!(file.isFile()) || !(file.getName().equals(this.getName())))
				try (BufferedReader br = new BufferedReader(new FileReader(file))) {
					return true;
					// because the name doesn't exist
				} catch (Exception e) {
					System.out.println("Something doesn't exist");
				}
		}
		return false;
	}
	/**
	 * to string method for the event information
	 */
	public String toString() {
		String line = "" + this.getName() + this.getType() + this.getDate() + this.getLocation() + "\n";
		return line;
	}

	/**
	 * returns event name
	 * @return name - event name
	 */
	public String getName() {
		return name;
	}
	/**
	 * sets event name
	 * @param name - event name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * returns event type
	 * @return type - event type
	 */
	public String getType() {
		return type;
	}
	/**
	 * set event type
	 * @param type - event type
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * returns event date
	 * @return date - date event
	 */
	public String getDate() {
		return date;
	}
	/**
	 * sets event date
	 * @param date - event date
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * returns event location
	 * @return location - event location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * sets event location
	 * @param location - event location
	 */
	public void setLocation(String location) {
		this.location = location;
	}
}
