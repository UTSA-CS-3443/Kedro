package application.model;

import java.io.*;

//import application.Location;
/**
 * this class searchs by event name or type or location
 * @author Steve
 *
 */
public class EventSearch {

	private static String OS = System.getProperty("os.name").toLowerCase();
	private String searchName;
	private Type searchType;
	private Location searchLocal;

	
	public EventSearch(String name, Type type, Location location) {
		this.searchName = name;
		this.searchType = type;
		this.searchLocal = location;
		//searchAll(name, type, location); //can search name only
		//right now and should be called in controller
	}
	/**
	 * this method searches the list of files and returns an array
	 * of display events that can be printed
	 * @param name
	 * @param type
	 * @param location
	 * @return
	 */
	public DisplayEvent[] searchAll() {
		String filePath = new File("").getAbsolutePath();
		//filepath is different for mac and windows
		if(OS.equals("mac os x")) {
			filePath += "/EventFolder";
		}
		else {
			filePath += "\\EventFolder";
		}
		return searchName(this.searchName, filePath);
	}
	
	/**
	 * 
	 */
	public DisplayEvent[] returnAllEvts()
	{
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
				System.out.println("return all:" + evtNm + " return ended");
				String dt = br.readLine();
				String ll = br.readLine();
				String tpNm = br.readLine();
				Date time = new Date(dt);
				Type tp = new Type(tpNm);
				// put new object into an array
				DisplayEvent event = new DisplayEvent(evtNm, tp, time, ll);
				String line;
				while ((line = br.readLine()) != null) {
					event.addGuest(line);
				}
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
	 * @param name
	 * @param filePath
	 * @return
	 */
	public DisplayEvent[] searchName(String name, String filePath) {
		BufferedReader br;
		//reads in a folder of files
		File folder = new File(filePath);
		File[] listOfFiles = folder.listFiles();
		DisplayEvent[] eventList = new DisplayEvent[listOfFiles.length];
		int i = 0;
		//goes through all the files and searches their names
		for(File rd : listOfFiles) {
			if(i > listOfFiles.length) {
				return eventList;
			}
			if(rd.getName().contains(name)) {
				try {
					//uses the strings in the file to make a new object
					br = new BufferedReader(new FileReader(rd));
					String evtNm = br.readLine();
					System.out.println(evtNm);
					String dt = br.readLine();
					String ll = br.readLine();
					String tpNm = br.readLine();
					Date time = new Date(dt);
					Type tp = new Type(tpNm);
					//put new object into an array
					DisplayEvent event = new DisplayEvent(evtNm, tp, time, ll);
					String line;
					while((line = br.readLine()) != null) {
						event.addGuest(line);
					}
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
		}
			return eventList;
	}
}
