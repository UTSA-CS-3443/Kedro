package application.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class UserSearch {

	private static String OS = System.getProperty("os.name").toLowerCase();
	private String name;

	public UserSearch(String name) {
		this.name = name;
		searchAll(name);
	}

	public DisplayUser[] searchAll(String name) {
		String filePath = new File("").getAbsolutePath();
		if(OS.equals("mac os x")) {
			filePath += "/UserFolder";
		}
		else {
			filePath += "\\UserFolder";
		}
		BufferedReader br;
		File folder = new File(filePath);
		File[] listOfFiles = folder.listFiles();
		DisplayUser[] userList = new DisplayUser[listOfFiles.length - 1];
		int i = 0;
		for (File rd : listOfFiles) {
			if (i > listOfFiles.length) {
				return userList;
			}
			if (rd.getName().equals(name)) {
				try {
					br = new BufferedReader(new FileReader("rd"));
					String dsf = br.readLine();
					br.readLine();
					br.readLine();
					//reads lines into garbage to skip past the personal info
					//goes down to events they are registered to go to
					DisplayUser user = new DisplayUser(dsf);
					String line;
					while ((line = br.readLine()) != null) {
						user.signIn(line);
					}
					br.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return null;
	}
}
