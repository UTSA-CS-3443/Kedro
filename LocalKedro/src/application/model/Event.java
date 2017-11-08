package application.model;

import java.io.*;
import java.util.ArrayList;

public class Event {
	
	private String name;
	private Type type;
	private Date date;
	private Location location;//make this a string
	private ArrayList<User> rsvp;

	public Event(String name, Type type, Date date, Location location) {
		//objects need to be created for each of these and maybe add some more info to this
		this.setName(name);
		this.setType(type);
		this.setDate(date);
		this.setLocation(location);
		this.rsvp = new ArrayList<User>();
	}
	
	public void addGuest(User user) {
		this.rsvp.add(user);
	}
	
	public int getGuests() {
		return this.rsvp.size();
	}
	
	public void eventWrite() {
		try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("Event.txt")))){
			pw.println(this.getName());
			pw.println(this.getType());
			pw.println(this.getDate());
			pw.println(this.getLocation());
		}
		catch(Exception e) {
			System.out.println("you done goofed");
		}
	}
	//doesn't work right yet. Need event pages finished
	public boolean eventCheck() {
		File folder = new File("/Users/Travis/git/Kedro/EventFolder");
		File[] listOfFiles = folder.listFiles();

		for (File file : listOfFiles) {
			if (file.isFile() && file.getName().equals(this.getName())) {
				return false;
			}
			else if(!(file.isFile()) && !(file.getName().equals(this.getName())))
				try (BufferedReader br = new BufferedReader(new FileReader(file))) {
				} catch (Exception e) {
					System.out.println("Something doesn't exist");
				}
		}
		return false;
	}

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
