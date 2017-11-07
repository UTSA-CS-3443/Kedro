package application.model;

public class RSVP {
	
	private String name;
	public RSVP(String rsvp) {
		this.setName(rsvp);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
