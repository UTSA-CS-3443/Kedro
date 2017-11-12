package application.model;

import java.util.ArrayList;

public class DisplayEvent {

	private String name;
	private Type type;
	private Date date;
	private Location location;//make this a string
	private ArrayList<RSVP> rsvp;
	
	public DisplayEvent(String name, Type type, Date date, Location location) {
		this.setName(name);
		this.setType(type);
		this.setDate(date);
		this.setLocation(location);
		this.rsvp = new ArrayList<RSVP>();
		
	}

	public void addGuest(String line) {
		RSVP rp = new RSVP(line);
		this.rsvp.add(rp);
		
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
