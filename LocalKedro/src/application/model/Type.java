package application.model;

/**
 * this sets the type to only 5 valid types
 * 
 * @author Travis Woods
 *
 */
public class Type {

	// class constant
	private String name;

	// types will be put in a titled pane
	public Type(String name) {
		this.name = name;
		// checkValid(name); call this in the controller
	}

	/**
	 * this function checks if the name given is valid
	 * 
	 * @param name
	 * @return
	 */
	public boolean checkValid() {
		switch (this.name) {
		case "party":
			System.out.println("Party");
			return true;
		case "concert":
			System.out.println("Concert");
			return true;
		case "other":
			System.out.println("Other");
			return true;
		case "conference":
			System.out.println("Conference");
			return true;
		case "Meet and greet":
			System.out.println("Meet and great");
			return true;
		default:
			return false;
		}
	}

	/**
	 * this returns a string of the type name
	 */
	public String toString() {
		return "" + this.name;
	}
}
