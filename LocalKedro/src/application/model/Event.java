package application.model;

import java.io.*;
import java.util.ArrayList;

//import application.Location;
//import application.RSVP;
/**
 * this class creates an event object and writes it to the file folder
 * @author Travis Woods
 *
 */
public class Event {
	
	private static String OS = System.getProperty("os.name").toLowerCase();
	private String name;
	private Type type;
	private Date date;
	private Location location;//make this a string
	private ArrayList<RSVP> rsvp;

	public Event(String name, Type type, Date date, Location location) {
		//objects need to be created for each of these and maybe add some more info to this
		this.setName(name);
		this.setType(type);
		this.setDate(date);
		this.setLocation(location);
		this.rsvp = new ArrayList<RSVP>();
	}
	
	public void addGuest(String string) {
		RSVP rp = new RSVP(string);
		this.rsvp.add(rp);
	}
	
	public int getGuests() {
		return this.rsvp.size();
	}
	
	public void eventWrite() {
		String filePath = new File("").getAbsolutePath();
		if(OS.equals("mac os x")) {
			filePath += "/EventFolder/";
		}
		else {
			filePath += "\\EventFolder\\";
		}
		File file = new File(filePath + this.getName());
		System.out.println(file.getAbsolutePath());
		try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)))) {
			pw.println(this.getName());
			pw.println(this.getDate().toString());
			pw.println(this.getLocation().toString());
			pw.println(this.getType().toString());
			//print out the guest list too I think
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("you done goofed");
		}
	}
	//doesn't work right yet. Need event pages finished
	//false returns if the name exists
	public boolean eventCheck() {
		String filePath = new File("").getAbsolutePath();
		filePath += "\\EventFolder";
		File folder = new File(filePath); //add filepath
		File[] listOfFiles = folder.listFiles();

		for (File file : listOfFiles) {
			if (file.isFile() && file.getName().equals(this.getName())) {
				return false;
			}
			else if(!(file.isFile()) || !(file.getName().equals(this.getName())))
				try (BufferedReader br = new BufferedReader(new FileReader(file))) {
					return true;
					//because the name doesn't exist
				} catch (Exception e) {
					System.out.println("Something doesn't exist");
				}
		}
		return false;
	}
	
	public String toString() {
		String line = "" + this.getName() + this.getType() + this.getDate() + this.getLocation() + "\n";
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

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
}
