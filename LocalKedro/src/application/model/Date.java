package application.model;

public class Date {

	private int iDay;
	private int iMonth;
	private int iYear;
	
	public Date(int day, int month, int year) {
		this.setiDay(day);
		this.setiMonth(month);
		this.setiYear(year);
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
