package Coursework2;

public class Seats {

	private String seatNum;
	private String seatClass;
	private boolean isWindow;
	private boolean isAisle;
	private boolean isTable;
	private double seatPrice;
	private String email;

	public Seats(String seatNum, String seatClass, boolean isWindow, boolean isAisle, boolean isTable, double seatPrice,
			String email) {
		this.seatNum = seatNum;
		this.seatClass = seatClass;
		this.isWindow = isWindow;
		this.isAisle = isAisle;
		this.isTable = isTable;
		this.seatPrice = seatPrice;
		this.email = email;
	}

	public String toString() {
		String result;
		// This code give each variable in the file a name and bullet point so it is
		// easier to read.
		result = "Seat: " + seatNum + " Class: " + seatClass + " Window: " + isWindow + " Aisle: " + isAisle
				+ " Table: " + isTable + " Price: " + seatPrice + " Email: " + email;
		return result;
	}

	// The next bit of code is the get and set for each variable.
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSeatNum() {
		return seatNum;
	}

	public void setSeatNum(String seatNum) {

	}

	public String getSeatClass() {
		return seatClass;
	}

	public void setSeatClass(String seatClass) {

	}

	public boolean getIsWindow() {
		return isWindow;
	}

	public void setIsWindow(boolean isWindow) {

	}

	public boolean getIsAisle() {
		return isAisle;
	}

	public void setIsAilse(boolean isAisle) {

	}

	public boolean getIsTable() {
		return isTable;
	}

	public void setIsTable(boolean isTable) {

	}

}
