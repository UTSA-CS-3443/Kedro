package application.model;

public class RSVP {
	
	private String eventName;
	public RSVP(String rsvp) {
		this.setName(rsvp);
	}
	public String getName() {
		return eventName;
	}
	public void setName(String name) {
		this.eventName = name;
	}
}
