package application.model;

import java.io.*;
import java.util.*;
import application.controller.MainController;
/**
 * This class creates the user object and writes the user information to a file in userfolder
 * sets current user
 * checks if user is valid
 * @author SpaceHawks
 *
 */
public class User {

	private static String OS = System.getProperty("os.name").toLowerCase();
	private String name, password, email, fname;
	private String loc;
	private boolean proceed = false;
	String z;

	public User(String name, String password, String email, String location, String fname) {
		this.setName(name);
		this.setPassword(password);
		this.setEmail(email);
		this.setLoc(location);
		this.setFName(fname);
		this.setProceed(userCheck());
		System.out.println(this.isProceed() + " " + this.getName() + " " + this.getPassword() + " " + this.getEmail()
				+ " in user");
	}

	/**
	 * Creates the current user object and loads all of their info into the
	 * application also if you guys get tired of logging in then just comment
	 * out this.setProceed(userCheck()); and uncomment this.setProceed(true);
	 * and it'll let you log in regardless
	 * 
	 * @param name - username
	 * @param password - user password
	 */
	public User(String name, String password) {
		this.setName(name);
		this.setPassword(password);
		// this.setProceed(true);
		this.setProceed(userCheck());
	}

	/**
	 * this function checks if the user exists and if they do it reads in all of
	 * their rsvped events and other attributes that I have yet to add
	 * 
	 * @return true if the user exists
	 */
	public boolean userCheck() {
		String filePath = new File("").getAbsolutePath();
		if (OS.equals("mac os x")) {
			filePath += "/UserFolder";
		} else {
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
							while ((line = br.readLine()) != null) { // reads in
																		// events
																		// to
																		// arrayList
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
	/**
	 * sets the main user object to the current user
	 */
	public void setCurrentUser() {
		String filePath = new File("").getAbsolutePath();
		if (OS.equals("mac os x")) {
			filePath += "/UserFolder";
		} else {
			filePath += "\\UserFolder";
		}
		File folder = new File(filePath);
		File[] listOfFiles = folder.listFiles();
		for (File file : listOfFiles) {
			if (file.isFile() && file.getName().equals(this.getName())) {
				try (BufferedReader br = new BufferedReader(new FileReader(file))) {
					String line = null;
					line = br.readLine(); // user name
					setName(line);
					line = br.readLine(); // password
					setPassword(line);
					line = br.readLine(); // full name
					setFName(line);
					line = br.readLine(); // email
					setEmail(line);
					line = br.readLine(); // location
					setLoc(line);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * writes user information to a file in user folder
	 */
	public void userWrite() {
		String filePath = new File("").getAbsolutePath();
		if (OS.equals("mac os x")) {
			filePath += "/UserFolder/";
		} else {
			filePath += "\\UserFolder\\";
		}
		File file = new File(filePath + this.getName());
		System.out.println(file.getAbsolutePath());
		try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)))) {
			pw.println(this.getName());
			pw.println(this.getPassword());
			pw.println(this.getFName());
			pw.println(this.getEmail());
			pw.println(this.getLoc());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("you done goofed");
		}
	}
	/**
	 * to string for username and email
	 * @return returns username and email
	 */
	public String toString() {
		String line = "" + this.getName() + this.getEmail();
		return line;
	}

	///// GETTERS AND SETTERS//////
	/**
	 * returns users full name
	 * @return fname - users full name
	 */
	public String getFName() {
		return fname;
	}
	/**
	 * sets users full name
	 * @param fname - users full name
	 */
	public void setFName(String fname) {
		this.fname = fname;
	}
	/**
	 * returns username
	 * @return name - username
	 */
	public String getName() {
		return name;
	}
	/**
	 * sets username
	 * @param name - username
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * returns user password
	 * @return passwordd - user password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * sets user password
	 * @param password - users password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * returns users email
	 * @return email - users email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * sets users email
	 * @param email - users email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * checks if user is valid
	 * @return proceed - boolean value
	 */
	public boolean isProceed() {
		return proceed;
	}
	/**
	 * sets proceed for if user is valid
	 * @param proceed - boolean value
	 */
	public void setProceed(boolean proceed) {
		this.proceed = proceed;
	}
	/**
	 * returns user location
	 * @return loc - users location
	 */
	public String getLoc() {
		return loc;
	}
	/**
	 * sets users location
	 * @param loc - users location
	 */
	public void setLoc(String loc) {
		this.loc = loc;
	}
}
