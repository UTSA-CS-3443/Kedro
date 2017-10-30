package application.model;

public interface Location {
	
	public int zipCode();
	
	public String streetAddress1();
	
	public String streetAddress2();
	
	//maybe google cities
	public String city();
	
	public String state();
	
	//maybe add this later
	//public String country();
}
