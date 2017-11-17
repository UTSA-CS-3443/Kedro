package application.model;

import java.io.*;

//import application.Location;

public class EventSearch {

	private static String OS = System.getProperty("os.name").toLowerCase();
	private String searchName;
	private Type searchType;
	private Location searchLocal;
	
	public EventSearch(String name, Type type, Location location) {
		this.searchName = name;
		this.searchType = type;
		this.searchLocal = location;
		searchAll(name, type, location); //can search name only right now
	}
	//creates new objects based on the search specified
	//major search function
	public DisplayEvent[] searchAll(String name, Type type, Location location) {
		String filePath = new File("").getAbsolutePath();
		if(OS.equals("mac os x")) {
			filePath += "/EventFolder";
		}
		else {
			filePath += "\\EventFolder";
		}
		BufferedReader br;
		File folder = new File(filePath);
		File[] listOfFiles = folder.listFiles();
		DisplayEvent[] eventList = new DisplayEvent[listOfFiles.length-1];
		int i = 0;
		for(File rd : listOfFiles) {
			if(i > listOfFiles.length) {
				return eventList;
			}
			if(rd.getName().equals(name)) {
				try {
					br = new BufferedReader(new FileReader("rd"));
					String evtNm = br.readLine();
					String tpNm = br.readLine();
					String dt = br.readLine();
					String ll = br.readLine();
					Date time = new Date(dt);
					Type tp = new Type(tpNm);
					Location lo = new Location(Integer.parseInt(ll));
					DisplayEvent event = new DisplayEvent(evtNm, tp, time, lo);
					String line;
					while((line = br.readLine()) != null) {
						event.addGuest(line);
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
