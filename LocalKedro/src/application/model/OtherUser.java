package application.model;

/**
 * This class creates the other user object which is used when searching profiles
 * @author SpaceHawks
 *
 */
public class OtherUser {
	/**
	 * class constant strings for user name email password and full name
	 */
	private String name, password, email, fname;
	private String loc;
	/**
	 * constructor creates OtherUser
	 * @param name - username
	 * @param email - user email
	 * @param fname - user full name
	 * @param location - user location
	 */
	public OtherUser(String name, String email, String fname, String location) {
		this.setName(name);
		this.setEmail(email);
		this.setLoc(location);
		this.setFName(fname);
	}
	/**
	 * to string method returns username and email
	 */
	public String toString() {
		String line = "" + this.getName() + this.getEmail();
		return line;
	}
	/**
	 * returns users full name
	 * @return fname - users full name
	 */
	public String getFName() {
		return fname;
	}
	/**
	 * sets users full name
	 * @param fname - users full name
	 */
	public void setFName(String fname) {
		this.fname = fname;
	}
	/**
	 * returns username
	 * @return name - username
	 */
	public String getName() {
		return name;
	}
	/**
	 * sets username
	 * @param name - username
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * returns user password
	 * @return password - user password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * sets user password 
	 * @param password - user password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * returns users email
	 * @return email - users email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * sets users email
	 * @param email - users email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * returns users location
	 * @return loc - users location
	 */
	public String getLoc() {
		return loc;
	}
	/**
	 * sets users location
	 * @param loc - users location
	 */
	public void setLoc(String loc) {
		this.loc = loc;
	}
}
