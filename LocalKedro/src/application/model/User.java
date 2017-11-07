package application.model;

import java.io.*;
import application.controller.MainController;

public class User {

	private String name,password,email;
	private boolean proceed = false;
	
	public User(String name, String password, String email) {
		this.setName(name);
		this.setPassword(password);
		this.setEmail(email);
		userWrite();
	}
	/**
	 * Creates the current user object and loads all of their info into the application
	 * also if you guys get tired of logging in then just comment out this.setProceed(userCheck());
	 * and uncomment this.setProceed(true); and it'll let you log in regardless
	 * @param name
	 * @param password
	 */
	public User(String name, String password) {
		this.setName(name);
		this.setPassword(password);
		//this.setProceed(true);
		this.setProceed(userCheck());
	}
	
	public boolean userCheck() {
		try (BufferedReader br = new BufferedReader(new FileReader("Users.txt"))){
			String line = null;
		    while ((line = br.readLine()) != null) {
		        if(line.equals(this.getName())) {
		        	line = br.readLine();
		        	if(line != null && line.equals(this.getPassword())) {
		        		System.out.println("Welcome!");	
		        		return true;
		        	}
		        	else {
		        		return false;
		        	}
		        }
		    }
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
	public void userWrite() {
		try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("Users.txt")))){
			pw.println(this.getName());
			pw.println(this.getPassword());
			pw.println(this.getEmail());
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("you done goofed");
		}
	}
	
	/////GETTERS AND SETTERS//////
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
}
