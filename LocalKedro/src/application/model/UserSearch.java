package application.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class UserSearch {

	private String name;
	public UserSearch(String name) {
		this.name = name;
		searchAll(name);
	}
	
	public User[] searchAll(String name) {
		String filePath = new File("").getAbsolutePath();
		filePath += "\\EventFolder";
		BufferedReader br;
		File folder = new File(filePath);
		File[] listOfFiles = folder.listFiles();
		User[] userList = new User[listOfFiles.length-1];
		int i = 0;
		for(File rd : listOfFiles) {
			if(i > listOfFiles.length) {
				return userList;
			}
			if(rd.getName().equals(name)) {
				try {
					br = new BufferedReader(new FileReader("rd"));
					User user = new User(evtNm, tp, time, lo);
					String line;
					while((line = br.readLine()) != null) {
						event.addGuest(line);
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}
	}
}
