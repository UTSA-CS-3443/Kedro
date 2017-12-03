package application.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * this class searches through the list of files and returns an array of users
 * that match
 * 
 * @author Travis Woods
 *
 */
public class UserSearch {
	// class constants
	private static String OS = System.getProperty("os.name").toLowerCase();
	private String name;

	/**
	 * this sets the class constant to the object name
	 * 
	 * @param name
	 */
	public UserSearch(String name) {
		this.name = name;
	}

	/**
	 * this is the search function the searches by username and doesn't display
	 * anything except their name and the events they rsvped to go to
	 * 
	 * @param name
	 * @return
	 */
	public DisplayUser[] searchAll() {
		System.out.println(this.name);
		String filePath = new File("").getAbsolutePath();
		if (OS.equals("mac os x")) {
			filePath += "/UserFolder";
		} else {
			filePath += "\\UserFolder";
		}
		BufferedReader br;
		File folder = new File(filePath);
		File[] listOfFiles = folder.listFiles();
		DisplayUser[] userList = new DisplayUser[listOfFiles.length-1];
		System.out.println(listOfFiles.length);
		int i = 0;
		for (File rd : listOfFiles) {
			if (i > listOfFiles.length) {
				return userList;
			}
			if (rd.getName().contains(this.name)) {
				try {
					br = new BufferedReader(new FileReader(rd));
					String dsf = br.readLine();
					br.readLine(); //password
					String fn = br.readLine(); //full name
					String em = br.readLine(); // email address
					String ll = br.readLine(); //location
					// reads lines into garbage to skip past the personal info
					// goes down to events they are registered to go to
					if(ll.isEmpty()){
						DisplayUser user = new DisplayUser(dsf, fn, em, new Location(Integer.parseInt(ll)));
					String line;
					while ((line = br.readLine()) != null) {
						user.signIn(line);
					}
					userList[i] = user;
					br.close();
					}
					else{
						DisplayUser user = new DisplayUser(dsf, fn, em);
						userList[i] = user;
						br.close();
					}
				} catch (FileNotFoundException e) {
					System.out.println("file not found");
					return null;
				} catch (IOException e) {
					System.out.println("io exception");
					return null;
				}
				i++;
			}
		}
		return userList;
	}
}
