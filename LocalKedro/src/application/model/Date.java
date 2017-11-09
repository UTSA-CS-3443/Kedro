package application.model;

public class Date {

	private int iDay;
	private int iMonth;
	private int iYear;
	private String[] dateArray;
	
	public Date(String string) {
		dateArray = string.split("/", 3);
		this.setiDay(Integer.parseInt(dateArray[1]));
		this.setiMonth(Integer.parseInt(dateArray[0]));
		this.setiYear(Integer.parseInt(dateArray[2]));
	}
	
	/////GETTERS AND SETTERS/////
	public int getiDay() {
		return iDay;
	}
	public void setiDay(int iDay) {
		this.iDay = iDay;
	}
	public int getiMonth() {
		return iMonth;
	}
	public void setiMonth(int iMonth) {
		this.iMonth = iMonth;
	}
	public int getiYear() {
		return iYear;
	}
	public void setiYear(int iYear) {
		this.iYear = iYear;
	}
}
