package application.model;

public class Type {

	private String name;
	//types will be put in a titled pane
	public Type(String name) {
		this.name = name;
		checkValid(name);
	}
	
	public boolean checkValid(String name) {
		switch(name) {
			case "party":
				System.out.println("This is a party and valid");
				return true;
			case "concert":
				System.out.println("This is a concert and is valid");
				return true;
			default:
				System.out.println("Invalid type, try again");
				return false;
		}
	}
}
