package application.model;

import java.io.*;

public class EventSearch {

	private String searchName;
	private Type searchType;
	private Location searchLocal;
	
	public EventSearch(String name) {
		this.searchName = name;
		searchAll(name, null, null); //can search name only right now
	}
	
	public EventSearch(Type type) {
		this.searchType = type;
	}
	
	public EventSearch(Location location) {
		this.searchLocal = location;
	}
	
	public Event[] searchAll(String name, Type type, Location location) {
		String filePath = new File("").getAbsolutePath();
		filePath += "\\EventFolder";
		BufferedReader br;
		File folder = new File(filePath);
		File[] listOfFiles = folder.listFiles();
		Event[] eventList = new Event[listOfFiles.length-1];
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
					Event event = new Event(evtNm, tp, time, lo);
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
		return null;
	}
}
