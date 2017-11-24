package application.model;

import java.util.ArrayList;

public class OtherUser {
	private String name, password, email, fname;
	private Location loc;
	
	public OtherUser(String name, String email, Location location, String fname) {
		this.setName(name);
		this.setEmail(email);
		this.setLoc(location);
		this.setFName(fname);
		System.out.println(this.getName() + " " + this.getPassword() + " " + this.getEmail() +" in user");
	}
	
	public String toString() {
		String line = "" + this.getName() + this.getEmail();
		return line;
	}

	public String getFName(){
		return fname;
	}
	
	public void setFName(String fname){
		this.fname = fname;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Location getLoc() {
		return loc;
	}
	public void setLoc(Location loc) {
		this.loc = loc;
	}
}
