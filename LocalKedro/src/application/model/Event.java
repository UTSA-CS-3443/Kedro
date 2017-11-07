package application.model;

import java.io.*;

public class Event {
	
	private String name;
	private Type type;
	private Date date;
	private Location location;//make this a string

	public Event(String name, Type type, Date date, Location location) {
		//objects need to be created for each of these and maybe add some more info to this
		this.setName(name);
		this.setType(type);
		this.setDate(date);
		this.setLocation(location);
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
	
	public boolean eventCheck() {
		try (BufferedReader br = new BufferedReader(new FileReader("Event.txt"))){
			String line = null;
		    while ((line = br.readLine()) != null) {
		        if(line.equals(this.getName())) {
		        	line = br.readLine();
		        	return true;
		        }
		        else {
		        	System.out.println("Event not here");
		        	return false;
		        }
		    }
		}
		catch(Exception e) {
			System.out.println("Something doesn't exist");
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
