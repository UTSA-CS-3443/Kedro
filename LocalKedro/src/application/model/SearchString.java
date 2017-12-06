package application.model;
/**
 * This class creates the SearchString object used in all searches
 * @author SpaceHawks
 *
 */
public class SearchString {
	/**
	 * class constant string to hold search text
	 */
	private String text;
	/**
	 * constructor creates searchString object
	 * @param text - search text
	 */
	public SearchString(String text) {
		this.text = text;
	}
	/**
	 * returns search text
	 * @return text - search text
	 */
	public String getText() {
		return this.text;
	}
	/**
	 * sets search text
	 * @param text - search text
	 */
	public void setText(String text) {
		this.text = text;
	}

}
