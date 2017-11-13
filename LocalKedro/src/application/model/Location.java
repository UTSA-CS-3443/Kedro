package application.model;

public class Location {
	
	private int zipcode;
	public Location(int zipcode) {
		this.setZipcode(zipcode);
	}
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	
	public String toString() {
		return "" + this.zipcode + "\n";
	}
}
