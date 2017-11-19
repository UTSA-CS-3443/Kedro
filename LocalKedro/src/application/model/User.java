package application.model;

import java.io.*;
import java.util.*;
import application.controller.MainController;

public class User {
	
	private static String OS = System.getProperty("os.name").toLowerCase();
	private String name, password, email, fname;
	private Location loc;
	private boolean proceed = false;
	private ArrayList<RSVP> rsvp;

	public User(String name, String password, String email, Location location, String fname) {
		this.setName(name);
		this.setPassword(password);
		this.setEmail(email);
		this.setLoc(location);
		this.setFName(fname);
		this.setProceed(userCheck());
		System.out.println(this.isProceed() + " " + this.getName() + " " + this.getPassword() + " " + this.getEmail() +" in user");
		this.rsvp = new ArrayList<RSVP>();
	}
	/**
	 * Creates the current user object and loads all of their info into the
	 * application also if you guys get tired of logging in then just comment out
	 * this.setProceed(userCheck()); and uncomment this.setProceed(true); and it'll
	 * let you log in regardless
	 * 
	 * @param name
	 * @param password
	 */
	public User(String name, String password) {
		this.setName(name);
		this.setPassword(password);
		// this.setProceed(true);
		this.rsvp = new ArrayList<RSVP>();
		this.setProceed(userCheck());
	}

	/**
	 * this function checks if the user exists and if they do it reads in all of their
	 * rsvped events and other attributes that I have yet to add
	 * @return true if the user exists
	 */
	public boolean userCheck() {
		String filePath = new File("").getAbsolutePath();
		if(OS.equals("mac os x")) {
			filePath += "/UserFolder";
		}
		else {
			filePath += "\\UserFolder";
		}
		File folder = new File(filePath);
		File[] listOfFiles = folder.listFiles();
		for (File file : listOfFiles) {
			if (file.isFile() && file.getName().equals(this.getName())) {
				try (BufferedReader br = new BufferedReader(new FileReader(file))) {
					String line = null;
					line = br.readLine(); // user name
					if (line.equals(this.getName())) {
						line = br.readLine(); // password
						if (line != null && line.equals(this.getPassword())) {
							System.out.println("Welcome!");
							this.setEmail(br.readLine()); // email
							while ((line = br.readLine()) != null) { // reads in events to arrayList
								if (!(line.equals("*"))) {
									RSVP loadIn = new RSVP(line);
									this.rsvp.add(loadIn);
								} else if (line.equals("*")) {
									break;
								}
							}
							// System.out.println(toString() + "\n");
							return true;
						} else {
							return false;
						}
					}
					br.close();
				} catch (Exception e) {
					e.printStackTrace();
					return false;
				}
			}
		}
		return false;
	}

	public void userWrite() {
		String filePath = new File("").getAbsolutePath();
		filePath += "\\UserFolder\\";
		File file = new File(filePath + this.getName());
		System.out.println(file.getAbsolutePath());
		try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)))) {
			pw.println(this.getName());
			pw.println(this.getFName());
			pw.println(this.getPassword());
			pw.println(this.getEmail());
			pw.println(this.getLoc());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("you done goofed");
		}
	}

	public void signIn(Event event) {
		RSVP rp = new RSVP(event.getName());
		this.rsvp.add(rp);
	}

	public String toString() {
		String line = "" + this.getName() + this.getEmail();
		for (RSVP r : this.rsvp) {
			line += r.getName() + "\n";
		}
		return line;
	}

	///// GETTERS AND SETTERS//////
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

	public boolean isProceed() {
		return proceed;
	}

	public void setProceed(boolean proceed) {
		this.proceed = proceed;
	}
	public Location getLoc() {
		return loc;
	}
	public void setLoc(Location loc) {
		this.loc = loc;
	}
}
