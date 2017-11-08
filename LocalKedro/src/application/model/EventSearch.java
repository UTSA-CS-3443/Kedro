package application.model;

import java.io.*;

public class EventSearch {

	private String searchName;
	private Type searchType;
	private Location searchLocal;
	
	public EventSearch(String name) {
		this.searchName = name;
	}
	
	public EventSearch(Type type) {
		this.searchType = type;
	}
	
	public EventSearch(Location location) {
		this.searchLocal = location;
	}
	
	public Event searchAll() {
		String filePath = new File("").getAbsolutePath();
		filePath += "\\EventFolder";
		File folder = new File(filePath);
		return null;
	}
}
