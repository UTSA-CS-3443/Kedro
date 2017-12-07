package application.model;

import java.io.*;

//import application.Location;
/**
 * this class searchs by event name
 * 
 * @author SpaceHawks
 *
 */
public class EventSearch {
	/**
	 * class constant strings for operating system of user and the searchName for the event
	 */
	private static String OS = System.getProperty("os.name").toLowerCase();
	private String searchName;
	/**
	 * constructor for eventSearch
	 * @param name - name of event
	 * @param type - type of event
	 * @param location - location of event
	 */
	public EventSearch(String name, String type, String location) {
		this.searchName = name;
	}

	/**
	 * this method searches the list of files and returns an array of display
	 * events that can be printed
	 * @return searchName(this.searchName, filePath) - the event being searched for and the file path for the operating system
	 */
	public DisplayEvent[] searchAll() {
		String filePath = new File("").getAbsolutePath();
		// filepath is different for mac and windows
		if (OS.equals("mac os x")) {
			filePath += "/EventFolder";
		} else {
			filePath += "\\EventFolder";
		}
		return searchName(this.searchName, filePath);
	}

	/**
	 *	returns all events
	 *	@return - list of all events
	 */
	public DisplayEvent[] returnAllEvts() {
		BufferedReader br;
		String filePath = new File("").getAbsolutePath();
		// filepath is different for mac and windows
		if (OS.equals("mac os x")) {
			filePath += "/EventFolder";
		} else {
			filePath += "\\EventFolder";
		}
		File folder = new File(filePath);
		File[] listOfFiles = folder.listFiles();
		DisplayEvent[] eventList = new DisplayEvent[listOfFiles.length];
		int i = 0;
		for (File rd : listOfFiles) {
			if (i > listOfFiles.length) {
				return eventList;
			}
			try {
				// uses the strings in the file to make a new object
				br = new BufferedReader(new FileReader(rd));
				String evtNm = br.readLine();
				String dt = br.readLine();
				String ll = br.readLine();
				String tpNm = br.readLine();
				// put new object into an array
				DisplayEvent event = new DisplayEvent(evtNm, tpNm, dt, ll);
				eventList[i] = event;
				br.close();
			} catch (FileNotFoundException e) {
				System.out.println("no file");
				return eventList;
			} catch (IOException e) {
				System.out.println("no file");
				return null;
			}
			i++;
		}
		return eventList;
	}

	/**
	 * this function searches with name parameter only
	 * returns all events matching
	 * @param name - search name
	 * @param filePath - operating system
	 * @return eventList - list of events
	 */
	public DisplayEvent[] searchName(String name, String filePath) {
		BufferedReader br;
		// reads in a folder of files
		File folder = new File(filePath);
		File[] listOfFiles = folder.listFiles();
		int i = 0;
		int iSize = 0;
		for(File rd : listOfFiles) {
			if(rd.getName().contains(name)){
				iSize++;
			}
		}
		DisplayEvent[] eventList = new DisplayEvent[iSize];
		// goes through all the files and searches their names
		for (File rd : listOfFiles) {
			if (i > iSize-1) {
				return eventList;
			}
			if (rd.getName().contains(name)) {
				try {
					// uses the strings in the file to make a new object
					br = new BufferedReader(new FileReader(rd));
					String evtNm = br.readLine();
					String dt = br.readLine();
					String ll = br.readLine();
					String tpNm = br.readLine();
					// put new object into an array
					DisplayEvent event = new DisplayEvent(evtNm, tpNm, dt, ll);
					eventList[i] = event;
					br.close();
				} catch (FileNotFoundException e) {
					System.out.println("no file");
					return eventList;
				} catch (IOException e) {
					System.out.println("no file");
					return null;
				} catch (NullPointerException e) {
					System.out.println("it was here");
					return null;
				}
				i++;

			}
		}
		return eventList;
	}
}
