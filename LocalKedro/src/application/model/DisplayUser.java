package application.model;

import java.util.ArrayList;

public class DisplayUser {

	private String name;
	private ArrayList<RSVP> rsvp;
	public DisplayUser(String name) {
		this.setName(name);
		rsvp = new ArrayList<RSVP>();
	}
	
	public void signIn(String event) {
		RSVP rp = new RSVP(event);
		this.rsvp.add(rp);
	}

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
}
