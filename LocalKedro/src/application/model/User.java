package application.model;

import java.io.*;
import application.controller.MainController;

public class User {

	private String name,password,email;
	
	public User(String name, String password, String email) {
		this.setName(name);
		this.setPassword(password);
		this.setEmail(email);
		userWrite();
	}
	
	public User(String name, String password) {
		this.setName(name);
		this.setPassword(password);
		userCheck();
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
	public void userCheck() {
		try (BufferedReader br = new BufferedReader(new FileReader("Users.txt"))){
			String line = null;
		    while ((line = br.readLine()) != null) {
		        if(line.equals(this.getName())) {
		        	line = br.readLine();
		        	if(line != null && line.equals(this.getPassword())) {
		        		System.out.println("You exist with password!");	
		        	}
		        	else {
		        		System.out.println("Incorrect password");
		        		//controller error call
		        	}
		        }
		        else {
		        	System.out.println("Incorrect username");
		        }
		    }
		}
		catch(Exception e) {
			e.printStackTrace();
		}
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
}
