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
				System.out.println("Party");
				return true;
			case "concert":
				System.out.println("Concert");
				return true;
			default:
				return false;
		}
	}
}
