package application.model;

import java.io.*;

public class User {

	private String name,password,email;
	
	public User(String name, String password, String email) {
		this.setName(name);
		this.setPassword(password);
		this.setEmail(email);
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
	public void userWrite() {
		try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("User.txt")))){
			pw.println("gysdhkjsa");
		}
		catch(Exception e) {
			System.out.println("you done goofed");
		}
	}
}
